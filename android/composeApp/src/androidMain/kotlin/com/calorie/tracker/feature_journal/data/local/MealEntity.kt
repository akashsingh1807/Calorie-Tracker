package com.calorie.tracker.feature_journal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.calorie.tracker.model.Meal

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
) {
    fun toDomain(): Meal = Meal(
        id = id,
        mealType = mealType,
        imageUrl = imageUrl,
        timestamp = timestamp,
        totalCalories = totalCalories,
        totalProtein = totalProtein,
        totalCarbs = totalCarbs,
        totalFat = totalFat,
        isSynced = isSynced
    )

    companion object {
        fun fromDomain(meal: Meal): MealEntity = MealEntity(
            id = meal.id,
            mealType = meal.mealType,
            imageUrl = meal.imageUrl,
            timestamp = meal.timestamp,
            totalCalories = meal.totalCalories,
            totalProtein = meal.totalProtein,
            totalCarbs = meal.totalCarbs,
            totalFat = meal.totalFat,
            isSynced = meal.isSynced
        )
    }
}
