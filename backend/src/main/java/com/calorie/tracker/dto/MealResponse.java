package com.calorie.tracker.dto;

import com.calorie.tracker.model.MealType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MealResponse {
    private Long id;
    private MealType mealType;
    private String imageUrl;
    private LocalDateTime timestamp;
    private Double totalCalories;
    private Double totalProtein;
    private Double totalCarbs;
    private Double totalFat;
    private List<FoodItemDto> foodItems;
}
