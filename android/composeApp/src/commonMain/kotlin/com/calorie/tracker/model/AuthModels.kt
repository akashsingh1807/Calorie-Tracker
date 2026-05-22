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

// Matches backend's AuthResponse (login endpoint)
@Serializable
data class AuthResponse(
    val token: String,
    val refreshToken: String? = null,
    val expiresIn: Int = 0
)

// Matches backend's SignupResponse (register endpoint)
@Serializable
data class SignupResponse(
    val success: Boolean,
    val message: String? = null,
    val token: String? = null,
    val user: SignupUser? = null
)

@Serializable
data class SignupUser(
    val id: Long,
    val name: String
)

@Serializable
data class UserProfile(
    val id: Long,
    val name: String,
    val email: String,
    val height: Double = 0.0,
    val weight: Double = 0.0,
    val age: Int = 0,
    val lifestyle: String = "SEDENTARY",
    val goal: String = "MAINTENANCE",
    val dailyCalorieGoal: Int = 2000,
    val dailyProteinGoal: Int = 150,
    val dailyCarbsGoal: Int = 200,
    val dailyFatGoal: Int = 65
)

@Serializable
data class UpdateProfileRequest(
    val height: Double? = null,
    val weight: Double? = null,
    val age: Int? = null,
    val lifestyle: String? = null,
    val goal: String? = null,
    val dailyCalorieGoal: Int? = null,
    val dailyProteinGoal: Int? = null,
    val dailyCarbsGoal: Int? = null,
    val dailyFatGoal: Int? = null
)
