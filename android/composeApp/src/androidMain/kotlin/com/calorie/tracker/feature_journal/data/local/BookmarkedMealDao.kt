package com.calorie.tracker.feature_journal.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkedMealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(meal: BookmarkedMealEntity): Long

    @Query("SELECT * FROM bookmarked_meals ORDER BY createdAt DESC")
    fun getAllBookmarks(): Flow<List<BookmarkedMealEntity>>

    @Query("DELETE FROM bookmarked_meals WHERE id = :id")
    suspend fun deleteBookmark(id: Long)

    @Query("SELECT COUNT(*) FROM bookmarked_meals WHERE name = :name")
    suspend fun countByName(name: String): Int
}
