package com.calorie.tracker

import androidx.compose.ui.window.ComposeUIViewController
import com.calorie.tracker.core.network.CalorieApiClient
import com.calorie.tracker.feature_auth.data.IosAuthRepository
import platform.UIKit.UIViewController

// Use your deployed URL for prod
private const val BASE_URL = "https://calorie-tracker-backend-878280965690.us-central1.run.app"

fun MainViewController(): UIViewController {
    val apiClient = CalorieApiClient(baseUrl = BASE_URL)
    val authRepository = IosAuthRepository(apiClient = apiClient)
    val mealRepository = IosMealRepository()

    return ComposeUIViewController {
        App(
            authRepository = authRepository,
            mealRepository = mealRepository
        )
    }
}
