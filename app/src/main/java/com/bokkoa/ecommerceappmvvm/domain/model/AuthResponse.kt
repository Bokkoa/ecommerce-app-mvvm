package com.bokkoa.ecommerceappmvvm.domain.model

data class AuthResponse(
    val user: User,
    val token: String,
)
