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
}
