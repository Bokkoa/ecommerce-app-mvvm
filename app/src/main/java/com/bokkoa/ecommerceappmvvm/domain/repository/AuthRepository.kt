package com.bokkoa.ecommerceappmvvm.domain.repository

import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse

interface AuthRepository {
    suspend fun login(email: String, password: String): ResourceResponse<AuthResponse>

    suspend fun register(user: User): ResourceResponse<AuthResponse>
}
