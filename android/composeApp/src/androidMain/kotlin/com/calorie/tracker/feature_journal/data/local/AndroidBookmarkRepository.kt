package com.calorie.tracker.feature_journal.data.local

import com.calorie.tracker.feature_journal.domain.BookmarkRepository
import com.calorie.tracker.model.BookmarkedMeal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AndroidBookmarkRepository(
    private val dao: BookmarkedMealDao
) : BookmarkRepository {

    override fun getAllBookmarks(): Flow<List<BookmarkedMeal>> =
        dao.getAllBookmarks().map { entities -> entities.map { it.toDomain() } }

    override suspend fun insertBookmark(meal: BookmarkedMeal): Long =
        dao.insertBookmark(BookmarkedMealEntity.fromDomain(meal))

    override suspend fun deleteBookmark(id: Long) =
        dao.deleteBookmark(id)
}
