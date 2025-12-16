package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.example.project.dto.LoginRequest
import org.example.project.network.ApiClient

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            try {
                val token = ApiClient.login(
                    LoginRequest(username, password)
                )
                _uiState.value = LoginUiState.Success(token)
            } catch (e: Exception) {
                _uiState.value =
                    LoginUiState.Error("Usuario o contraseña incorrectos")
            }
        }
    }
}