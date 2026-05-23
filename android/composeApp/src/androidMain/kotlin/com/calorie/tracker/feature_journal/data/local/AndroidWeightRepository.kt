package com.calorie.tracker.feature_journal.data.local

import com.calorie.tracker.feature_journal.domain.WeightEntry
import com.calorie.tracker.feature_journal.domain.WeightRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AndroidWeightRepository(
    private val dao: WeightDao
) : WeightRepository {

    override fun getAllWeights(): Flow<List<WeightEntry>> {
        return dao.getAllWeights().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getLatestWeight(): WeightEntry? {
        return dao.getLatestWeight()?.toDomain()
    }

    override suspend fun getWeightByDate(dateStr: String): WeightEntry? {
        return dao.getWeightByDate(dateStr)?.toDomain()
    }

    override suspend fun insertWeight(weightKg: Double, dateStr: String, timestamp: Long) {
        val existing = dao.getWeightByDate(dateStr)
        val entity = if (existing != null) {
            existing.copy(weightKg = weightKg, timestamp = timestamp)
        } else {
            WeightEntity(weightKg = weightKg, dateStr = dateStr, timestamp = timestamp)
        }
        dao.insertWeight(entity)
    }

    override suspend fun deleteWeight(id: Long) {
        dao.deleteWeight(id)
    }

    private fun WeightEntity.toDomain(): WeightEntry {
        return WeightEntry(
            id = id,
            weightKg = weightKg,
            dateStr = dateStr,
            timestamp = timestamp
        )
    }
}
