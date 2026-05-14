package com.calorie.tracker.core.database

import com.calorie.tracker.feature_journal.data.local.MealDao
import com.calorie.tracker.feature_journal.data.local.MealEntity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.calorie.tracker.model.MealType

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val mealType: String,
    val imageUrl: String?,
    val timestamp: Long,
    val totalCalories: Double,
    val totalProtein: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    val isSynced: Boolean = false
)
