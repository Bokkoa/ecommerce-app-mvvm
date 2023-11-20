package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set // just modifiable by this viewmodel

    var isValidForm by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf("")
        private set
    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    // launch is for coroutines
    fun validateForm() = viewModelScope.launch {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "The email has an invalid format."
        }

        if (state.password.length < 6) {
            errorMessage = "Password must be at least 6 characters"
        }

        delay(3000)
        errorMessage = ""
    }
}