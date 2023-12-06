package com.bokkoa.ecommerceappmvvm.domain.repository

import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>

    suspend fun register(user: User): Resource<AuthResponse>

    suspend fun saveSession(authResponse: AuthResponse)

    fun getSessionData(): Flow<AuthResponse>
}
