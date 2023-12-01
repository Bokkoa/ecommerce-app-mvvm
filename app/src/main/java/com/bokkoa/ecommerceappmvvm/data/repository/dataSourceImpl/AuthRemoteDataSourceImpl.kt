package com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl

import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.data.service.AuthService
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {
    // explicit return
    override suspend fun login(email: String, password: String): Response<AuthResponse> {
        return authService.login(email, password)
    }

    // implicit return with equal "=" symbol
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)
}
