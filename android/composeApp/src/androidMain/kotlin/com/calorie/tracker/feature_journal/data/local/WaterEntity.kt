package com.calorie.tracker.feature_journal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_logs")
data class WaterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val glasses: Int,
    val dateStr: String, // e.g., "2024-05-23"
    val timestamp: Long
)
