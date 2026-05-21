package com.calorie.tracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    val id: Long = 0,
    val mealType: String,
    val imageUrl: String?,
    val timestamp: Long,
    val totalCalories: Double,
    val totalProtein: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    val isSynced: Boolean = false,
    // Micronutrients
    val totalFiber: Double = 0.0,
    val totalSugar: Double = 0.0,
    val totalSodium: Double = 0.0,
    val totalPotassium: Double = 0.0,
    val totalCalcium: Double = 0.0,
    val totalIron: Double = 0.0,
    val totalVitaminC: Double = 0.0,
    val totalVitaminD: Double = 0.0
)
