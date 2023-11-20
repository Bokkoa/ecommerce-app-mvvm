package com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl

import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.data.service.AuthService
import com.bokkoa.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(email: String, password: String): Response<User> {
        return authService.login(email, password)
    }
}