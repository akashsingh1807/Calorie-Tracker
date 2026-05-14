package com.calorie.tracker.service;

import com.calorie.tracker.dto.FoodItemDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class NutritionService {

    @Value("${nutrition.api.url}")
    private String apiUrl;

    @Value("${nutrition.api.appId}")
    private String appId;

    @Value("${nutrition.api.appKey}")
    private String appKey;

    private final WebClient webClient;

    public NutritionService() {
        this.webClient = WebClient.create();
    }

    public List<FoodItemDto> getNutritionForFoods(List<String> foods) {
        // Real implementation would call Nutritionix /v2/natural/nutrients POST API
        // For now, returning mocked data.
        
        List<FoodItemDto> items = new ArrayList<>();
        
        for (String food : foods) {
            FoodItemDto item = new FoodItemDto();
            item.setName(food);
            item.setServingSize("1 serving");
            item.setCalories(150.0);
            item.setProtein(10.0);
            item.setCarbs(15.0);
            item.setFat(5.0);
            items.add(item);
        }
        
        return items;
    }
}
