package com.calorie.tracker.feature_auth.data

import android.content.Context
import com.calorie.tracker.core.network.CalorieApiClient
import com.calorie.tracker.feature_auth.domain.AuthRepository
import com.calorie.tracker.model.LoginRequest
import com.calorie.tracker.model.RegisterRequest

class AndroidAuthRepository(
    private val context: Context,
    private val apiClient: CalorieApiClient
) : AuthRepository {

    private val prefs by lazy {
        context.getSharedPreferences("calorie_tracker_prefs", Context.MODE_PRIVATE)
    }

    companion object {
        private const val KEY_TOKEN = "auth_token"
    }

    override suspend fun login(email: String, password: String): Result<String> {
        return apiClient.login(LoginRequest(email, password)).map { it.token }.also { result ->
            result.getOrNull()?.let { token ->
                apiClient.setAuthToken(token)
            }
        }
    }

    override suspend fun register(name: String, email: String, password: String): Result<String> {
        return apiClient.register(RegisterRequest(name, email, password)).map { it.token }.also { result ->
            result.getOrNull()?.let { token ->
                apiClient.setAuthToken(token)
            }
        }
    }

    override fun saveToken(token: String) {
        prefs.edit().putString(KEY_TOKEN, token).apply()
        apiClient.setAuthToken(token)
    }

    override fun getToken(): String? {
        return prefs.getString(KEY_TOKEN, null)
    }

    override fun clearToken() {
        prefs.edit().remove(KEY_TOKEN).apply()
        apiClient.clearAuthToken()
    }

    override fun isLoggedIn(): Boolean {
        val token = getToken()
        if (token != null) {
            apiClient.setAuthToken(token)
            return true
        }
        return false
    }
}
