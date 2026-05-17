package com.calorie.tracker.service;

import com.calorie.tracker.model.Meal;
import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.MealRepository;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.repository.WeightLogRepository;
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

    @Autowired
    private WeightLogRepository weightLogRepository;

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

    public Map<String, Object> getWeeklyAnalytics(Long userId) {
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(7);
        List<Meal> meals = mealRepository.findMealsByUserAndDate(userId, start, end);
        
        double avgCalories = meals.stream().mapToDouble(Meal::getTotalCalories).average().orElse(0.0);
        return Map.of("averageCalories", avgCalories, "mealCount", meals.size());
    }

    public Map<String, Object> getCalorieTrend(Long userId, int days) {
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(days);
        List<Meal> meals = mealRepository.findMealsByUserAndDate(userId, start, end);
        
        // Group by date and sum calories
        Map<String, Double> trend = meals.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                m -> m.getTimestamp().toLocalDate().toString(),
                java.util.stream.Collectors.summingDouble(Meal::getTotalCalories)
            ));
        return Map.of("trend", trend);
    }

    public Map<String, Object> getWeightTrend(Long userId) {
        List<com.calorie.tracker.model.WeightLog> logs = weightLogRepository.findByUserIdOrderByDateAsc(userId);
        return Map.of("trend", logs);
    }
}
