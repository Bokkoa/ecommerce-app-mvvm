package com.bokkoa.ecommerceappmvvm.domain.usecase.auth

import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}