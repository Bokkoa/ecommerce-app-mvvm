package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var errorMessage by mutableStateOf("")

    var state by mutableStateOf(RegisterState())
        private set

    var registerResponse by mutableStateOf<ResourceResponse<AuthResponse>?>(null)
        private set

    fun register() = viewModelScope.launch {
        if (isValidForm()) {
            val user = User(
                name = state.name,
                lastName = state.lastName,
                phone = state.phone,
                email = state.email,
                password = state.password,
            )
            registerResponse = ResourceResponse.Loading
            val result = authUseCase.register(user)
            registerResponse = result // DATA OR ERROR
        }
    }
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
    fun isValidForm(): Boolean  {
        if (state.name == "") {
            errorMessage = "Name required."
            return false
        }

        if (state.lastName == "") {
            errorMessage = "Last Name required."
            return false
        }

        if (state.phone == "") {
            errorMessage = "Phone required."
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "The email has an invalid format."
            return false
        }

        if (state.password.length < 6) {
            errorMessage = "Password must be at least 6 characters"
            return false
        }

        if (state.confirmPassword == "") {
            errorMessage = "confirm password needed"
            return false
        }

        if (state.confirmPassword != state.password) {
            errorMessage = "Password mismatch"
            return false
        }

        return true
    }
}
