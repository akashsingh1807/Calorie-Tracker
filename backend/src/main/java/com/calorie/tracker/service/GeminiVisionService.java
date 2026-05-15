package com.calorie.tracker.service;

import com.calorie.tracker.model.AiRequest;
import com.calorie.tracker.repository.AiRequestRepository;
import com.calorie.tracker.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeminiVisionService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent}")
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

    private List<String> callGeminiApi(String requestBody) throws Exception {
        String response = webClient.post()
                .uri(apiUrl + "?key=" + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode candidates = rootNode.path("candidates");
        if (candidates.isArray() && candidates.size() > 0) {
            JsonNode parts = candidates.get(0).path("content").path("parts");
            if (parts.isArray() && parts.size() > 0) {
                String textResponse = parts.get(0).path("text").asText();
                
                // Clean up markdown block if present
                textResponse = textResponse.replace("```json", "").replace("```", "").trim();
                
                // Parse the JSON array string into a List of Strings
                return objectMapper.readValue(textResponse, new TypeReference<List<String>>() {});
            }
        }
        return new ArrayList<>();
    }

    public List<String> identifyFoodFromImage(Long userId, String imageUrl) {
        logAiRequest(userId, "IMAGE_DETECTION", 500);
        
        String promptText = "Analyze this image and identify the food items. Pay special attention to Indian cuisine. " +
                "Distinguish between regional breads (Roti, Naan, Paratha) and specify the type of curry. " +
                "Break down complex thalis into individual items. " +
                "Return ONLY a raw JSON list of strings representing the identified food items, nothing else. " +
                "Example: [\"Dal Tadka\", \"Jeera Rice\", \"Roti\"]";

        String requestBody = "";
        try {
            // Extract base64 data and mime type from data URI if present
            if (imageUrl.startsWith("data:") && imageUrl.contains(";base64,")) {
                // Handle Data URI
                mimeType = imageUrl.substring(imageUrl.indexOf(":") + 1, imageUrl.indexOf(";"));
                base64Image = imageUrl.substring(imageUrl.indexOf(",") + 1);
            } else if (imageUrl.startsWith("http")) {
                // Handle public URL - Download image
                System.out.println("Downloading image from URL: " + imageUrl);
                byte[] imageBytes = webClient.get()
                        .uri(java.net.URI.create(imageUrl))
                        .retrieve()
                        .bodyToMono(byte[].class)
                        .block();
                
                if (imageBytes != null) {
                    System.out.println("Image downloaded successfully, size: " + imageBytes.length);
                    base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
                    // Try to infer mime type from URL extension or just use jpeg
                    if (imageUrl.toLowerCase().contains(".png")) mimeType = "image/png";
                    else if (imageUrl.toLowerCase().contains(".webp")) mimeType = "image/webp";
                } else {
                    System.err.println("Image download returned null body");
                }
            } else if (imageUrl.contains(",")) {
                // Handle raw base64 if comma is present
                base64Image = imageUrl.substring(imageUrl.indexOf(",") + 1);
            } else {
                // Assume it's raw base64
                base64Image = imageUrl;
            }

            var textPart = java.util.Map.of("text", promptText);
            var imagePart = java.util.Map.of(
                "inlineData", java.util.Map.of(
                    "mimeType", mimeType,
                    "data", base64Image
                )
            );
            
            var parts = List.of(textPart, imagePart);
            var contents = List.of(java.util.Map.of("parts", parts));
            requestBody = objectMapper.writeValueAsString(java.util.Map.of("contents", contents));

            return callGeminiApi(requestBody);
            
        } catch (org.springframework.web.reactive.function.client.WebClientResponseException e) {
            String errorBody = e.getResponseBodyAsString();
            System.err.println("Gemini Image API call failed with status " + e.getStatusCode() + ": " + errorBody);
            return List.of("Error Status: " + e.getStatusCode() + " | Body: " + errorBody + " | URL: " + imageUrl);
        } catch (Exception e) {
            System.err.println("Gemini Image API call failed at: " + e.getClass().getName() + " - " + e.getMessage());
            e.printStackTrace();
            return List.of("Error: " + e.getMessage());
        }
    }

    public List<String> analyzeText(Long userId, String text) {
        logAiRequest(userId, "TEXT_ANALYSIS", text.length() / 4);
        
        String promptText = "Extract the food items from the following text: '" + text + "'. " +
                "Return ONLY a raw JSON list of strings representing the identified food items, nothing else. " +
                "Example: [\"Roti\", \"Dal\"]";

        try {
            var parts = List.of(java.util.Map.of("text", promptText));
            var contents = List.of(java.util.Map.of("parts", parts));
            String requestBody = objectMapper.writeValueAsString(java.util.Map.of("contents", contents));

            return callGeminiApi(requestBody);
            
        } catch (Exception e) {
            System.err.println("Gemini Text API call failed: " + e.getMessage());
            return List.of("Error parsing text");
        }
    }

    public List<String> getMealSuggestions(Long userId, String goal) {
        logAiRequest(userId, "MEAL_SUGGESTION", 300);
        
        String promptText = "Provide 3 healthy meal suggestions for a user whose fitness goal is " + goal + ". " +
                "Return ONLY a raw JSON list of strings representing the meal names, nothing else. " +
                "Example: [\"Grilled Chicken Salad\", \"Oats with Berries\", \"Quinoa Bowl\"]";

        try {
            var parts = List.of(java.util.Map.of("text", promptText));
            var contents = List.of(java.util.Map.of("parts", parts));
            String requestBody = objectMapper.writeValueAsString(java.util.Map.of("contents", contents));

            return callGeminiApi(requestBody);
            
        } catch (Exception e) {
            System.err.println("Gemini Suggestion API call failed: " + e.getMessage());
            return List.of("Error generating suggestions");
        }
    }
}
