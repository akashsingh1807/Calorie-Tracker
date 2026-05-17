package com.calorie.tracker.controller;

import com.calorie.tracker.dto.FoodItemDto;
import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.GeminiVisionService;
import com.calorie.tracker.service.NutritionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ai")
@Tag(name = "AI Tools", description = "Endpoints for AI-powered food identification, raw text analysis, and healthy meal recommendations")
public class AIController {

    @Autowired
    private GeminiVisionService geminiVisionService;

    @Autowired
    private NutritionService nutritionService;

    @PostMapping("/detect-food")
    @Operation(summary = "Detect food items from an image URL or Data URI", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Map<String, Object>> detectFoodFromImage(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                                   @RequestBody Map<String, String> request) {
        String imageUrl = request.get("imageUrl");
        List<FoodItemDto> detectedItems = geminiVisionService.identifyFoodFromImage(userDetails.getId(), imageUrl);
        List<String> foodNames = detectedItems.stream().map(FoodItemDto::getName).toList();
        List<FoodItemDto> foods = nutritionService.getNutritionForFoods(foodNames);
        double totalCalories = foods.stream().mapToDouble(FoodItemDto::getCalories).sum();
        
        return ResponseEntity.ok(Map.of(
                "foodItems", foods,
                "totalCalories", totalCalories
        ));
    }

    @PostMapping("/analyze-text")
    @Operation(summary = "Analyze food items from a natural language text description", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Map<String, Object>> analyzeText(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                           @RequestBody Map<String, String> request) {
        String text = request.get("text");
        List<FoodItemDto> detectedItems = geminiVisionService.analyzeText(userDetails.getId(), text);
        List<String> foodNames = detectedItems.stream().map(FoodItemDto::getName).toList();
        List<FoodItemDto> foods = nutritionService.getNutritionForFoods(foodNames);
        double totalCalories = foods.stream().mapToDouble(FoodItemDto::getCalories).sum();

        return ResponseEntity.ok(Map.of(
                "foodItems", foods,
                "totalCalories", totalCalories
        ));
    }

    @PostMapping("/meal-suggestions")
    @Operation(summary = "Get personalized healthy meal suggestions based on fitness goal", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Map<String, Object>> mealSuggestions(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                               @RequestBody Map<String, Object> request) {
        String goal = (String) request.getOrDefault("goal", "MAINTENANCE");
        List<String> suggestions = geminiVisionService.getMealSuggestions(userDetails.getId(), goal);
        
        return ResponseEntity.ok(Map.of("suggestions", suggestions));
    }
}
