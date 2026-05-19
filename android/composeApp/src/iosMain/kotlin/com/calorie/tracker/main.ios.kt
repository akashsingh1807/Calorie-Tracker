package com.calorie.tracker

import androidx.compose.ui.window.ComposeUIViewController
import com.calorie.tracker.core.network.CalorieApiClient
import com.calorie.tracker.feature_auth.data.IosAuthRepository
import platform.UIKit.UIViewController

// Change this to your server URL for device testing
private const val BASE_URL = "http://localhost:8080"

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
