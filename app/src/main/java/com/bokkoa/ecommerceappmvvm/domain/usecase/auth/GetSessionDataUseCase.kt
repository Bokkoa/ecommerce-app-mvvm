package com.bokkoa.ecommerceappmvvm.domain.usecase.auth

import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}
