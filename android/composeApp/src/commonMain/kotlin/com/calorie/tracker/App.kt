package com.calorie.tracker

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import com.calorie.tracker.feature_auth.domain.AuthRepository
import com.calorie.tracker.feature_auth.presentation.AuthScreen
import com.calorie.tracker.feature_auth.presentation.AuthViewModel
import com.calorie.tracker.feature_journal.domain.MealRepository
import com.calorie.tracker.feature_journal.presentation.dashboard.DashboardScreen
import com.calorie.tracker.feature_journal.presentation.dashboard.DashboardViewModel
import com.calorie.tracker.ui.theme.CalorieTrackerTheme

sealed class Screen {
    object Auth : Screen()
    object Dashboard : Screen()
}

@Composable
fun App(
    authRepository: AuthRepository,
    mealRepository: MealRepository
) {
    val authViewModel = remember { AuthViewModel(authRepository) }
    val dashboardViewModel = remember { DashboardViewModel(mealRepository) }

    // Check if already logged in
    var currentScreen by remember {
        mutableStateOf(
            if (authRepository.isLoggedIn()) Screen.Dashboard else Screen.Auth
        )
    }

    CalorieTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentScreen) {
                is Screen.Auth -> {
                    AuthScreen(
                        viewModel = authViewModel,
                        onAuthenticated = { currentScreen = Screen.Dashboard }
                    )
                }
                is Screen.Dashboard -> {
                    DashboardScreen(
                        viewModel = dashboardViewModel,
                        onAddMealClick = { /* TODO: navigate to add meal */ },
                        onLogout = {
                            authRepository.clearToken()
                            currentScreen = Screen.Auth
                        }
                    )
                }
            }
        }
    }
}
