package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set
    var errorMessage by mutableStateOf("")
        private set
    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onLastNameInput(input: String) {
        state = state.copy(lastName = input)
    }

    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String) {
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String) {
        state = state.copy(confirmPassword = input)
    }

    // launch is for coroutines
    fun validateForm() = viewModelScope.launch {
        if (state.name == "") {
            errorMessage = "Name required."
        }

        if (state.lastName == "") {
            errorMessage = "Last Name required."
        }

        if (state.phone == "") {
            errorMessage = "Phone required."
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "The email has an invalid format."
        }

        if (state.password.length < 6) {
            errorMessage = "Password must be at least 6 characters"
        }

        if (state.confirmPassword == "") {
            errorMessage = "confirm password needed"
        }

        if (state.confirmPassword != state.password) {
            errorMessage = "Password mismatch"
        }

        delay(3000)
        errorMessage = ""
    }
}