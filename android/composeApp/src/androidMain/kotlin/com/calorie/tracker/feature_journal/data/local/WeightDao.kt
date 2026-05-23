package com.calorie.tracker.feature_journal.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeightDao {
    @Query("SELECT * FROM weight_logs ORDER BY timestamp DESC")
    fun getAllWeights(): Flow<List<WeightEntity>>

    @Query("SELECT * FROM weight_logs ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatestWeight(): WeightEntity?

    @Query("SELECT * FROM weight_logs WHERE dateStr = :dateStr LIMIT 1")
    suspend fun getWeightByDate(dateStr: String): WeightEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeight(weightEntity: WeightEntity)

    @Query("DELETE FROM weight_logs WHERE id = :id")
    suspend fun deleteWeight(id: Long)
}
