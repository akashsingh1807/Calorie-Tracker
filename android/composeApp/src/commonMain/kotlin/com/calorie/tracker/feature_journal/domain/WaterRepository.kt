package com.calorie.tracker.feature_journal.domain

import kotlinx.coroutines.flow.Flow

interface WaterRepository {
    fun getAllWaterLogs(): Flow<List<WaterEntry>>
    fun getWaterLogByDate(dateStr: String): Flow<WaterEntry?>
    suspend fun addGlasses(glasses: Int, dateStr: String, timestamp: Long)
    suspend fun deleteWaterLog(id: Long)
}

data class WaterEntry(
    val id: Long,
    val glasses: Int,
    val dateStr: String,
    val timestamp: Long
)
