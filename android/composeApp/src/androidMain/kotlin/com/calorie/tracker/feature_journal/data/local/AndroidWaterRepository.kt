package com.calorie.tracker.feature_journal.data.local

import com.calorie.tracker.feature_journal.domain.WaterEntry
import com.calorie.tracker.feature_journal.domain.WaterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class AndroidWaterRepository(
    private val dao: WaterDao
) : WaterRepository {

    override fun getAllWaterLogs(): Flow<List<WaterEntry>> {
        return dao.getAllWaterLogs().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getWaterLogByDate(dateStr: String): Flow<WaterEntry?> {
        return dao.getWaterLogByDate(dateStr).map { it?.toDomain() }
    }

    override suspend fun addGlasses(glasses: Int, dateStr: String, timestamp: Long) {
        val existing = dao.getWaterLogByDate(dateStr).firstOrNull()
        val currentGlasses = existing?.glasses ?: 0
        val newGlasses = (currentGlasses + glasses).coerceAtLeast(0) // Don't go below 0
        
        val entity = if (existing != null) {
            WaterEntity(
                id = existing.id,
                glasses = newGlasses,
                dateStr = dateStr,
                timestamp = timestamp
            )
        } else {
            WaterEntity(
                glasses = newGlasses,
                dateStr = dateStr,
                timestamp = timestamp
            )
        }
        dao.insertWaterLog(entity)
    }

    override suspend fun deleteWaterLog(id: Long) {
        dao.deleteWaterLog(id)
    }

    private fun WaterEntity.toDomain(): WaterEntry {
        return WaterEntry(
            id = id,
            glasses = glasses,
            dateStr = dateStr,
            timestamp = timestamp
        )
    }
}
