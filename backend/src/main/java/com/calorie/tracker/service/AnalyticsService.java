package com.calorie.tracker.service;

import com.calorie.tracker.model.Meal;
import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.MealRepository;
import com.calorie.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> getDailyAnalytics(Long userId, LocalDateTime date) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDateTime startOfDay = date.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        List<Meal> dailyMeals = mealRepository.findMealsByUserAndDate(userId, startOfDay, endOfDay);

        double totalCalories = 0, totalProtein = 0, totalCarbs = 0, totalFats = 0;

        for (Meal meal : dailyMeals) {
            totalCalories += meal.getTotalCalories() != null ? meal.getTotalCalories() : 0;
            totalProtein += meal.getTotalProtein() != null ? meal.getTotalProtein() : 0;
            totalCarbs += meal.getTotalCarbs() != null ? meal.getTotalCarbs() : 0;
            totalFats += meal.getTotalFat() != null ? meal.getTotalFat() : 0;
        }

        return Map.of(
                "totalCalories", totalCalories,
                "goalCalories", user.getDailyCalorieGoal() != null ? user.getDailyCalorieGoal() : 2000,
                "protein", totalProtein,
                "carbs", totalCarbs,
                "fats", totalFats
        );
    }
}
