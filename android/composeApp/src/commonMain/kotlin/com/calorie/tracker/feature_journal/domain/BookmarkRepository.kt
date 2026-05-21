package com.calorie.tracker.feature_journal.domain

import com.calorie.tracker.model.BookmarkedMeal
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {
    fun getAllBookmarks(): Flow<List<BookmarkedMeal>>
    suspend fun insertBookmark(meal: BookmarkedMeal): Long
    suspend fun deleteBookmark(id: Long)
}
