package com.calorie.tracker.dto;

import lombok.Data;
import java.util.List;

@Data
public class FoodItemDto {
    private String name;
    private String servingSize;
    private Double calories;
    private Double protein;
    private Double carbs;
    private Double fat;

    // Micronutrients
    private Double fiber;
    private Double sugar;
    private Double sodium;
    private Double potassium;
    private Double calcium;
    private Double iron;
    private Double vitaminC;
    private Double vitaminD;
}
