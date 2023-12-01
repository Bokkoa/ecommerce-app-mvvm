package com.bokkoa.ecommerceappmvvm.domain.usecase.auth

import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository

data class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.register(user)
}
