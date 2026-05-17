package com.calorie.tracker.service;

import com.calorie.tracker.dto.FoodItemDto;
import com.calorie.tracker.model.AiRequest;
import com.calorie.tracker.repository.AiRequestRepository;
import com.calorie.tracker.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class GeminiVisionService {

    private static final Logger logger = LoggerFactory.getLogger(GeminiVisionService.class);

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent}")
    private String apiUrl;

    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    
    @Autowired
    private AiRequestRepository aiRequestRepository;
    
    @Autowired
    private UserRepository userRepository;

    public GeminiVisionService() {
        this.webClient = WebClient.builder()
                .exchangeStrategies(org.springframework.web.reactive.function.client.ExchangeStrategies.builder()
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                        .build())
                .build();
        this.objectMapper = new ObjectMapper();
    }

    private void logAiRequest(Long userId, String requestType, int estimatedTokens) {
        if (userId != null) {
            userRepository.findById(userId).ifPresent(user -> {
                AiRequest request = AiRequest.builder()
                        .user(user)
                        .requestType(requestType)
                        .tokensUsed(estimatedTokens)
                        .createdAt(LocalDateTime.now())
                        .build();
                aiRequestRepository.save(request);
            });
        }
    }

    private List<FoodItemDto> callGeminiApi(String requestBody) {
        logger.info("Calling Gemini API. URL: {}, API Key length: {}", apiUrl, apiKey != null ? apiKey.length() : 0);
        try {
            String response = webClient.post()
                    .uri(apiUrl + "?key=" + apiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JsonNode rootNode = objectMapper.readTree(response);
            
            // Handle API errors in response body
            if (rootNode.has("error")) {
                logger.error("Gemini API returned error: {}", rootNode.path("error").path("message").asText());
                return new ArrayList<>();
            }

            JsonNode candidates = rootNode.path("candidates");
            if (candidates.isArray() && candidates.size() > 0) {
                JsonNode parts = candidates.get(0).path("content").path("parts");
                if (parts.isArray() && parts.size() > 0) {
                    String textResponse = parts.get(0).path("text").asText();
                    
                    // Clean up markdown block if present
                    textResponse = textResponse.replaceAll("```json", "").replaceAll("```", "").trim();
                    
                    try {
                        // Parse the JSON array of objects into List<FoodItemDto>
                        return objectMapper.readValue(textResponse, new TypeReference<List<FoodItemDto>>() {});
                    } catch (Exception e) {
                        logger.warn("Failed to parse Gemini response as JSON array of objects, trying as strings: {}", e.getMessage());
                        // Fallback: If it's just a list of strings, convert to DTOs
                        List<String> foodNames = objectMapper.readValue(textResponse, new TypeReference<List<String>>() {});
                        List<FoodItemDto> items = new ArrayList<>();
                        for (String name : foodNames) {
                            FoodItemDto dto = new FoodItemDto();
                            dto.setName(name);
                            dto.setCalories(0.0); // Will be filled by NutritionService if needed
                            items.add(dto);
                        }
                        return items;
                    }
                }
            }
        } catch (WebClientResponseException e) {
            logger.error("WebClientResponseException calling Gemini API: Status: {}, Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
        } catch (Exception e) {
            logger.error("Error calling or parsing Gemini API: {}", e.getMessage(), e);
        }
        return new ArrayList<>();
    }

    public List<FoodItemDto> identifyFoodFromImage(Long userId, String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) {
            logger.warn("identifyFoodFromImage called with empty imageUrl");
            return new ArrayList<>();
        }

        logAiRequest(userId, "IMAGE_DETECTION", 1000);
        
        String promptText = "Analyze this image and identify all food items. " +
                "For each item, estimate the nutritional values (calories, protein, carbs, fat) and a typical serving size. " +
                "Pay special attention to Indian cuisine accuracy. " +
                "Return ONLY a JSON array of objects with the following keys: 'name', 'servingSize', 'calories', 'protein', 'carbs', 'fat'. " +
                "Return NOTHING else but the raw JSON array.";

        try {
            String base64Image = "";
            String mimeType = "image/jpeg";

            if (imageUrl.startsWith("data:") && imageUrl.contains(";base64,")) {
                mimeType = imageUrl.substring(imageUrl.indexOf(":") + 1, imageUrl.indexOf(";"));
                base64Image = imageUrl.substring(imageUrl.indexOf(",") + 1);
            } else if (imageUrl.startsWith("http")) {
                logger.info("Downloading image for AI analysis: {}", imageUrl);
                byte[] imageBytes = webClient.get()
                        .uri(java.net.URI.create(imageUrl))
                        .retrieve()
                        .bodyToMono(byte[].class)
                        .block();
                
                if (imageBytes != null) {
                    base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    if (imageUrl.toLowerCase().contains(".png")) mimeType = "image/png";
                    else if (imageUrl.toLowerCase().contains(".webp")) mimeType = "image/webp";
                }
            } else {
                // Try treating as raw base64
                base64Image = imageUrl.contains(",") ? imageUrl.substring(imageUrl.indexOf(",") + 1) : imageUrl;
            }

            if (base64Image.isEmpty()) {
                logger.error("Failed to extract image data from: {}", imageUrl);
                return new ArrayList<>();
            }

            var textPart = Map.of("text", promptText);
            var imagePart = Map.of(
                "inlineData", Map.of(
                    "mimeType", mimeType,
                    "data", base64Image
                )
            );
            
            var contents = List.of(Map.of("parts", List.of(textPart, imagePart)));
            String requestBody = objectMapper.writeValueAsString(Map.of("contents", contents));

            return callGeminiApi(requestBody);
            
        } catch (Exception e) {
            logger.error("Gemini Image API preparation failed: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<FoodItemDto> analyzeText(Long userId, String text) {
        if (text == null || text.trim().isEmpty()) return new ArrayList<>();

        logAiRequest(userId, "TEXT_ANALYSIS", text.length() / 2);
        
        String promptText = "Extract food items from this text: '" + text + "'. " +
                "For each item, estimate the nutritional values (calories, protein, carbs, fat) and serving size. " +
                "Return ONLY a JSON array of objects with keys: 'name', 'servingSize', 'calories', 'protein', 'carbs', 'fat'.";

        try {
            var contents = List.of(Map.of("parts", List.of(Map.of("text", promptText))));
            String requestBody = objectMapper.writeValueAsString(Map.of("contents", contents));

            return callGeminiApi(requestBody);
        } catch (Exception e) {
            logger.error("Gemini Text API preparation failed: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<String> getMealSuggestions(Long userId, String goal) {
        logAiRequest(userId, "MEAL_SUGGESTION", 300);
        
        String promptText = "Provide 3 healthy meal suggestions for a user whose fitness goal is " + goal + ". " +
                "Return ONLY a JSON list of strings.";

        logger.info("Calling Gemini getMealSuggestions. URL: {}, API Key length: {}", apiUrl, apiKey != null ? apiKey.length() : 0);
        try {
            var contents = List.of(Map.of("parts", List.of(Map.of("text", promptText))));
            String requestBody = objectMapper.writeValueAsString(Map.of("contents", contents));

            String response = webClient.post()
                    .uri(apiUrl + "?key=" + apiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JsonNode rootNode = objectMapper.readTree(response);
            String textResponse = rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
            textResponse = textResponse.replaceAll("```json", "").replaceAll("```", "").trim();
            
            return objectMapper.readValue(textResponse, new TypeReference<List<String>>() {});
        } catch (WebClientResponseException e) {
            logger.error("WebClientResponseException in getMealSuggestions: Status: {}, Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
            return List.of("Grilled Chicken Salad", "Oats with Berries", "Quinoa Bowl");
        } catch (Exception e) {
            logger.error("Gemini Suggestion API failed: {}", e.getMessage(), e);
            return List.of("Grilled Chicken Salad", "Oats with Berries", "Quinoa Bowl");
        }
    }
}
