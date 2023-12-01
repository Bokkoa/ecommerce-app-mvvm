package com.bokkoa.ecommerceappmvvm.domain.usecase.auth

class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase
)
