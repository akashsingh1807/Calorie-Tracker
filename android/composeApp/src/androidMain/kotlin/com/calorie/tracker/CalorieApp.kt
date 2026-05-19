package com.calorie.tracker

import android.app.Application
import androidx.room.Room
import com.calorie.tracker.core.database.AppDatabase
import com.calorie.tracker.core.network.CalorieApiClient
import com.calorie.tracker.feature_auth.data.AndroidAuthRepository
import com.calorie.tracker.feature_auth.domain.AuthRepository
import com.calorie.tracker.feature_journal.data.local.AndroidMealRepository
import com.calorie.tracker.feature_journal.domain.MealRepository

class CalorieApp : Application() {

    // ── Backend URL — change to your deployed URL for prod ──
    private val BASE_URL = "http://10.0.2.2:8080"   // Android emulator → localhost

    val apiClient: CalorieApiClient by lazy {
        CalorieApiClient(baseUrl = BASE_URL)
    }

    val authRepository: AuthRepository by lazy {
        AndroidAuthRepository(context = applicationContext, apiClient = apiClient)
    }

    val mealRepository: MealRepository by lazy {
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "calorie_tracker_db"
        ).build()
        AndroidMealRepository(database.mealDao())
    }
}
