package com.calorie.tracker.controller;

import com.calorie.tracker.dto.FoodItemDto;
import com.calorie.tracker.dto.MealRequest;
import com.calorie.tracker.dto.MealResponse;
import com.calorie.tracker.security.CustomUserDetails;
import com.calorie.tracker.service.GeminiVisionService;
import com.calorie.tracker.service.MealService;
import com.calorie.tracker.service.NutritionService;
import com.calorie.tracker.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private GeminiVisionService geminiVisionService;

    @Autowired
    private NutritionService nutritionService;

    @PostMapping
    public ResponseEntity<MealResponse> addMeal(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                @RequestBody MealRequest request) {
        MealResponse response = mealService.saveMeal(userDetails.getId(), request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/daily")
    public ResponseEntity<List<MealResponse>> getDailyMeals(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        
        List<MealResponse> meals = mealService.getDailyMeals(userDetails.getId(), 
                date.atStartOfDay(), 
                date.plusDays(1).atStartOfDay());
        return ResponseEntity.ok(meals);
    }

}
