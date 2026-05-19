package com.calorie.tracker.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String,
    val password: String
)

@Serializable
data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)

@Serializable
data class AuthResponse(
    val token: String,
    val userId: Long,
    val name: String,
    val email: String
)

@Serializable
data class UserProfile(
    val id: Long,
    val name: String,
    val email: String,
    val dailyCalorieGoal: Int = 2000,
    val dailyProteinGoal: Int = 150,
    val dailyCarbsGoal: Int = 200,
    val dailyFatGoal: Int = 65
)
