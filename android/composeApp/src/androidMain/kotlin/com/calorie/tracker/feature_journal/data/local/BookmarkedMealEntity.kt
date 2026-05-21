package com.calorie.tracker.feature_journal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.calorie.tracker.model.BookmarkedMeal

/**
 * Room entity for bookmarked/saved meals (Android-specific).
 * Maps to/from the common [BookmarkedMeal] model.
 */
@Entity(tableName = "bookmarked_meals")
data class BookmarkedMealEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val totalCalories: Double,
    val totalProtein: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    /** Serialised food items — see [BookmarkedMeal.serialiseItems] */
    val itemsData: String,
    val createdAt: Long = System.currentTimeMillis()
) {
    fun toDomain(): BookmarkedMeal = BookmarkedMeal(
        id = id,
        name = name,
        totalCalories = totalCalories,
        totalProtein = totalProtein,
        totalCarbs = totalCarbs,
        totalFat = totalFat,
        itemsData = itemsData,
        createdAt = createdAt
    )

    companion object {
        fun fromDomain(meal: BookmarkedMeal): BookmarkedMealEntity = BookmarkedMealEntity(
            id = meal.id,
            name = meal.name,
            totalCalories = meal.totalCalories,
            totalProtein = meal.totalProtein,
            totalCarbs = meal.totalCarbs,
            totalFat = meal.totalFat,
            itemsData = meal.itemsData,
            createdAt = meal.createdAt
        )
    }
}
