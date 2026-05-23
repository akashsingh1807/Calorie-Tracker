package com.calorie.tracker.feature_journal.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterDao {
    @Query("SELECT * FROM water_logs ORDER BY timestamp DESC")
    fun getAllWaterLogs(): Flow<List<WaterEntity>>

    @Query("SELECT * FROM water_logs WHERE dateStr = :dateStr LIMIT 1")
    fun getWaterLogByDate(dateStr: String): Flow<WaterEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWaterLog(waterEntity: WaterEntity)

    @Query("DELETE FROM water_logs WHERE id = :id")
    suspend fun deleteWaterLog(id: Long)
}
