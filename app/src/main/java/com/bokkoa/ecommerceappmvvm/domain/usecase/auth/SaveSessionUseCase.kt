package com.bokkoa.ecommerceappmvvm.domain.usecase.auth

import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}
