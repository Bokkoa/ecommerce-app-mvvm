package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set // just modifiable by this viewmodel

    var errorMessage by mutableStateOf("")

    // LOGIN RESPONSE
    var loginReponse by mutableStateOf<ResourceResponse<AuthResponse>?>(null)
        private set
    fun login() = viewModelScope.launch {
        if (isValidForm()) {
            loginReponse = ResourceResponse.Loading
            val result = authUseCase.login(state.email, state.password)
            loginReponse = result
            Log.d("LoginViewModel", "Response: $loginReponse")
        }
    }
    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    // launch is for coroutines
    fun isValidForm(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "The email has an invalid format."
            return false
        }

        if (state.password.length < 6) {
            errorMessage = "Password must be at least 6 characters"
            return false
        }
        return true
    }
}
