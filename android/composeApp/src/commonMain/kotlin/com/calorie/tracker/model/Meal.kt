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
    val isSynced: Boolean = false
)
