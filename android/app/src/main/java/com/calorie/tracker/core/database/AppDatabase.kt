package com.calorie.tracker.core.database

import com.calorie.tracker.feature_journal.data.local.MealDao
import com.calorie.tracker.feature_journal.data.local.MealEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MealEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}
