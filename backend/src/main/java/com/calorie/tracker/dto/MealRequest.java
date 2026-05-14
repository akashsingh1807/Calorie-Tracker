package com.calorie.tracker.dto;

import com.calorie.tracker.model.MealType;
import lombok.Data;
import java.util.List;

@Data
public class MealRequest {
    private MealType mealType;
    private String imageUrl; // Optional, if uploaded beforehand or not at all
    private List<FoodItemDto> foodItems;
}
