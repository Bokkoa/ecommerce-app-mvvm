package com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl

import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.data.service.AuthService
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {
    override suspend fun login(email: String, password: String): Response<AuthResponse> {
        return authService.login(email, password)
    }
}