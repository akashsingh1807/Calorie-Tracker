package com.calorie.tracker.controller;

import com.calorie.tracker.dto.FoodItemDto;
import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.GeminiVisionService;
import com.calorie.tracker.service.NutritionService;
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
public class AIController {

    @Autowired
    private GeminiVisionService geminiVisionService;

    @Autowired
    private NutritionService nutritionService;

    @PostMapping("/detect-food")
    public ResponseEntity<Map<String, Object>> detectFoodFromImage(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                                   @RequestBody Map<String, String> request) {
        String imageUrl = request.get("imageUrl");
        List<String> foodNames = geminiVisionService.identifyFoodFromImage(userDetails.getId(), imageUrl);
        List<FoodItemDto> foods = nutritionService.getNutritionForFoods(foodNames);
        
        return ResponseEntity.ok(Map.of("foods", foods));
    }

    @PostMapping("/analyze-text")
    public ResponseEntity<Map<String, Object>> analyzeText(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                           @RequestBody Map<String, String> request) {
        String text = request.get("text");
        List<String> foodNames = geminiVisionService.analyzeText(userDetails.getId(), text);
        List<FoodItemDto> foods = nutritionService.getNutritionForFoods(foodNames);
        
        double totalCalories = foods.stream().mapToDouble(FoodItemDto::getCalories).sum();

        return ResponseEntity.ok(Map.of(
                "foods", foods,
                "totalCalories", totalCalories
        ));
    }

    @PostMapping("/meal-suggestions")
    public ResponseEntity<Map<String, Object>> mealSuggestions(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                               @RequestBody Map<String, Object> request) {
        String goal = (String) request.getOrDefault("goal", "MAINTENANCE");
        List<String> suggestions = geminiVisionService.getMealSuggestions(userDetails.getId(), goal);
        
        return ResponseEntity.ok(Map.of("suggestions", suggestions));
    }
}
