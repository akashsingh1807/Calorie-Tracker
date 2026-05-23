package com.calorie.tracker.feature_journal.domain

import kotlinx.coroutines.flow.Flow

interface WeightRepository {
    fun getAllWeights(): Flow<List<WeightEntry>>
    suspend fun getLatestWeight(): WeightEntry?
    suspend fun getWeightByDate(dateStr: String): WeightEntry?
    suspend fun insertWeight(weightKg: Double, dateStr: String, timestamp: Long)
    suspend fun deleteWeight(id: Long)
}

data class WeightEntry(
    val id: Long,
    val weightKg: Double,
    val dateStr: String,
    val timestamp: Long
)
