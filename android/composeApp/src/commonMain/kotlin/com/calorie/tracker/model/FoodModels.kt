package com.calorie.tracker.model

import kotlinx.serialization.Serializable

@Serializable
data class FoodItem(
    val id: Long = 0,
    val name: String,
    val quantity: Double,
    val unit: String,
    val calories: Double,
    val protein: Double,
    val carbs: Double,
    val fat: Double
)

@Serializable
data class AddMealRequest(
    val mealType: String,
    val timestamp: String,
    val foodItems: List<FoodItem>
)

@Serializable
data class NutritionSummary(
    val totalCalories: Double,
    val totalProtein: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    val calorieGoal: Int,
    val proteinGoal: Int,
    val carbsGoal: Int,
    val fatGoal: Int
)
