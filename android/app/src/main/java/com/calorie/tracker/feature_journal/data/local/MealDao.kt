package com.calorie.tracker.core.database

import com.calorie.tracker.feature_journal.data.local.MealDao
import com.calorie.tracker.feature_journal.data.local.MealEntity
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: MealEntity): Long

    @Query("SELECT * FROM meals WHERE timestamp >= :startOfDay AND timestamp < :endOfDay")
    fun getMealsForDate(startOfDay: Long, endOfDay: Long): Flow<List<MealEntity>>

    @Query("SELECT * FROM meals WHERE isSynced = 0")
    suspend fun getUnsyncedMeals(): List<MealEntity>

    @Update
    suspend fun updateMeal(meal: MealEntity)
}
