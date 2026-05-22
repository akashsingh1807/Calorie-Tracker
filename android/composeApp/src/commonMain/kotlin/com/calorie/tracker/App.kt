package com.calorie.tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calorie.tracker.core.network.CalorieApiClient
import com.calorie.tracker.feature_auth.domain.AuthRepository
import com.calorie.tracker.feature_auth.presentation.AuthScreen
import com.calorie.tracker.feature_auth.presentation.AuthViewModel
import com.calorie.tracker.feature_journal.domain.BookmarkRepository
import com.calorie.tracker.feature_journal.domain.MealRepository
import com.calorie.tracker.feature_journal.presentation.dashboard.DashboardScreen
import com.calorie.tracker.feature_journal.presentation.dashboard.DashboardViewModel
import com.calorie.tracker.feature_journal.presentation.dashboard.DailyGoalsScreen
import com.calorie.tracker.feature_journal.presentation.dashboard.StreakScreen
import com.calorie.tracker.feature_auth.presentation.OnboardingScreen
import com.calorie.tracker.ui.theme.CalorieTrackerTheme
import kotlinx.coroutines.launch

sealed class Screen {
    object Auth : Screen()
    object Dashboard : Screen()
    object DailyGoals : Screen()
    object Streak : Screen()
    object Onboarding : Screen()
}

@Composable
fun App(
    authRepository: AuthRepository,
    mealRepository: MealRepository,
    apiClient: CalorieApiClient? = null,
    bookmarkRepository: BookmarkRepository? = null,
    onGoogleSignInClick: (onTokenReceived: (String) -> Unit, onError: (String) -> Unit) -> Unit = { _, _ -> }
) {
    val authViewModel = remember { AuthViewModel(authRepository) }
    val dashboardViewModel = remember { DashboardViewModel(mealRepository, apiClient, bookmarkRepository) }

    var currentScreen by remember {
        mutableStateOf(
            if (authRepository.isLoggedIn()) Screen.Dashboard else Screen.Auth
        )
    }

    var calorieGoal by remember { mutableStateOf(1500) }
    var carbsGoalPct by remember { mutableStateOf(45) }
    var proteinGoalPct by remember { mutableStateOf(43) }
    var fatGoalPct by remember { mutableStateOf(12) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var hasCompletedOnboarding by remember { mutableStateOf(false) }

    LaunchedEffect(currentScreen) {
        if (currentScreen == Screen.Dashboard) {
            apiClient?.getProfile()?.onSuccess { profile ->
                if (profile.height <= 0.0 && !hasCompletedOnboarding) {
                    currentScreen = Screen.Onboarding
                } else {
                    calorieGoal = profile.dailyCalorieGoal
                    carbsGoalPct = profile.dailyCarbsGoal
                    proteinGoalPct = profile.dailyProteinGoal
                    fatGoalPct = profile.dailyFatGoal
                }
            }
        }
    }

    CalorieTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (currentScreen == Screen.Auth) {
                AuthScreen(
                    viewModel = authViewModel,
                    onAuthenticated = { currentScreen = Screen.Dashboard },
                    onGoogleSignInClick = {
                        onGoogleSignInClick(
                            { idToken -> authViewModel.loginWithGoogle(idToken) },
                            { error -> authViewModel.setError(error) }
                        )
                    }
                )
            } else {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = true,
                    drawerContent = {
                        ModalDrawerSheet(
                            modifier = Modifier.width(300.dp),
                            drawerContainerColor = Color.White
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(vertical = 24.dp, horizontal = 16.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 24.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .background(
                                                color = Color(0xFF1976D2),
                                                shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "J",
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 22.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = "Journable",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )
                                }

                                val menuItems = listOf(
                                    DrawerItem("Daily Goals", Icons.Default.Flag, Screen.DailyGoals),
                                    DrawerItem("Weekly Summary", Icons.Default.Assessment, Screen.Streak),
                                    DrawerItem("Weight Tracker", Icons.Default.TrendingUp, Screen.Streak),
                                    DrawerItem("Reminders", Icons.Default.Notifications, null),
                                    DrawerItem("Water Tracker", Icons.Default.Opacity, null),
                                    DrawerItem("Groups", Icons.Default.People, null),
                                    DrawerItem("Account", Icons.Default.Person, null),
                                    DrawerItem("Refer a Friend", Icons.Default.Share, null),
                                    DrawerItem("Feedback & Support", Icons.Default.Feedback, null),
                                    DrawerItem("Settings", Icons.Default.Settings, null)
                                )

                                menuItems.forEach { item ->
                                    NavigationDrawerItem(
                                        icon = { Icon(item.icon, contentDescription = item.label, tint = Color.DarkGray) },
                                        label = { Text(item.label, color = Color.Black, fontWeight = FontWeight.Medium) },
                                        selected = false,
                                        onClick = {
                                            scope.launch { drawerState.close() }
                                            item.screen?.let { currentScreen = it }
                                        },
                                        modifier = Modifier.padding(vertical = 2.dp),
                                        colors = NavigationDrawerItemDefaults.colors(
                                            unselectedContainerColor = Color.Transparent
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.weight(1f))

                                NavigationDrawerItem(
                                    icon = { Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = "Logout", tint = Color.DarkGray) },
                                    label = { Text("Logout", color = Color.Black, fontWeight = FontWeight.Medium) },
                                    selected = false,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        authRepository.clearToken()
                                        currentScreen = Screen.Auth
                                    },
                                    colors = NavigationDrawerItemDefaults.colors(
                                        unselectedContainerColor = Color.Transparent
                                    )
                                )
                            }
                        }
                    }
                ) {
                    when (currentScreen) {
                        is Screen.Onboarding -> {
                            OnboardingScreen(
                                onComplete = { age, height, weight, lifestyle, goal ->
                                    val bmr = 10 * weight + 6.25 * height - 5 * age + 5
                                    val lifestyleMultiplier = when (lifestyle) {
                                        "SEDENTARY" -> 1.2
                                        "LIGHTLY_ACTIVE" -> 1.375
                                        "MODERATELY_ACTIVE" -> 1.55
                                        "VERY_ACTIVE" -> 1.725
                                        "EXTRA_ACTIVE" -> 1.9
                                        else -> 1.2
                                    }
                                    val tdee = bmr * lifestyleMultiplier
                                    val targetCalories = when (goal) {
                                        "FAT_LOSS" -> tdee - 500
                                        "MUSCLE_GAIN" -> tdee + 500
                                        else -> tdee
                                    }.toInt()

                                    scope.launch {
                                        val result = apiClient?.updateProfile(com.calorie.tracker.model.UpdateProfileRequest(
                                            height = height,
                                            weight = weight,
                                            age = age,
                                            lifestyle = lifestyle,
                                            goal = goal,
                                            dailyCalorieGoal = targetCalories,
                                            dailyProteinGoal = 30,
                                            dailyCarbsGoal = 50,
                                            dailyFatGoal = 20
                                        ))
                                        
                                        if (result?.isSuccess == true || apiClient == null) {
                                            hasCompletedOnboarding = true
                                            calorieGoal = targetCalories
                                            carbsGoalPct = 50
                                            proteinGoalPct = 30
                                            fatGoalPct = 20
                                            currentScreen = Screen.Dashboard
                                        } else {
                                            // Fallback local navigation if backend fails
                                            hasCompletedOnboarding = true
                                            calorieGoal = targetCalories
                                            carbsGoalPct = 50
                                            proteinGoalPct = 30
                                            fatGoalPct = 20
                                            currentScreen = Screen.Dashboard
                                        }
                                    }
                                }
                            )
                        }
                        is Screen.Dashboard -> {
                            DashboardScreen(
                                viewModel = dashboardViewModel,
                                calorieGoal = calorieGoal,
                                carbsGoalPct = carbsGoalPct,
                                proteinGoalPct = proteinGoalPct,
                                fatGoalPct = fatGoalPct,
                                onMenuClick = {
                                    scope.launch { drawerState.open() }
                                },
                                onStreakClick = {
                                    currentScreen = Screen.Streak
                                },
                                onLogout = {
                                    authRepository.clearToken()
                                    currentScreen = Screen.Auth
                                }
                            )
                        }
                        is Screen.DailyGoals -> {
                            DailyGoalsScreen(
                                initialCalories = calorieGoal,
                                initialCarbsPct = carbsGoalPct,
                                initialProteinPct = proteinGoalPct,
                                initialFatPct = fatGoalPct,
                                onBackClick = {
                                    currentScreen = Screen.Dashboard
                                },
                                onGoalsSaved = { cal, carbs, prot, fat ->
                                    calorieGoal = cal
                                    carbsGoalPct = carbs
                                    proteinGoalPct = prot
                                    fatGoalPct = fat
                                }
                            )
                        }
                        is Screen.Streak -> {
                            StreakScreen(
                                onBackClick = {
                                    currentScreen = Screen.Dashboard
                                }
                            )
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}

private data class DrawerItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val screen: Screen?
)
