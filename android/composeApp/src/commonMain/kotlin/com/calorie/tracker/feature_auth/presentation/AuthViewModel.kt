package com.calorie.tracker.feature_auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calorie.tracker.feature_auth.domain.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val isAuthenticated: Boolean = false
)

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = _uiState.value.copy(error = "Please fill all fields")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            authRepository.login(email.trim(), password)
                .onSuccess { token ->
                    authRepository.saveToken(token)
                    _uiState.value = AuthUiState(isAuthenticated = true)
                }
                .onFailure { e ->
                    _uiState.value = AuthUiState(error = e.message ?: "Login failed")
                }
        }
    }

    fun loginWithGoogle(idToken: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            authRepository.loginWithGoogle(idToken)
                .onSuccess { token ->
                    authRepository.saveToken(token)
                    _uiState.value = AuthUiState(isAuthenticated = true)
                }
                .onFailure { e ->
                    _uiState.value = AuthUiState(error = e.message ?: "Google login failed")
                }
        }
    }

    fun register(name: String, email: String, password: String) {
        if (name.isBlank() || email.isBlank() || password.isBlank()) {
            _uiState.value = _uiState.value.copy(error = "Please fill all fields")
            return
        }
        if (password.length < 6) {
            _uiState.value = _uiState.value.copy(error = "Password must be at least 6 characters")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            authRepository.register(name.trim(), email.trim(), password)
                .onSuccess { token ->
                    authRepository.saveToken(token)
                    _uiState.value = AuthUiState(isAuthenticated = true)
                }
                .onFailure { e ->
                    _uiState.value = AuthUiState(error = e.message ?: "Registration failed")
                }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    fun setError(error: String) {
        _uiState.value = _uiState.value.copy(error = error, isLoading = false)
    }
}
