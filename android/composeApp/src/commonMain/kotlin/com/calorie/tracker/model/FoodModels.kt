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
    val fat: Double,
    // Micronutrients
    val fiber: Double = 0.0,
    val sugar: Double = 0.0,
    val sodium: Double = 0.0,
    val potassium: Double = 0.0,
    val calcium: Double = 0.0,
    val iron: Double = 0.0,
    val vitaminC: Double = 0.0,
    val vitaminD: Double = 0.0
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
    val fatGoal: Int,
    // Micronutrient totals
    val totalFiber: Double = 0.0,
    val totalSugar: Double = 0.0,
    val totalSodium: Double = 0.0,
    val totalPotassium: Double = 0.0,
    val totalCalcium: Double = 0.0,
    val totalIron: Double = 0.0,
    val totalVitaminC: Double = 0.0,
    val totalVitaminD: Double = 0.0
)
