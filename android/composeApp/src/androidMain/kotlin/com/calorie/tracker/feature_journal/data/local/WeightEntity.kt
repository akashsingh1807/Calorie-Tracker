package com.calorie.tracker.feature_journal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weight_logs")
data class WeightEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val weightKg: Double,
    val dateStr: String, // e.g., "2024-05-23"
    val timestamp: Long
)
