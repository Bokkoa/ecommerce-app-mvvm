package com.bokkoa.ecommerceappmvvm.data.repository.dataSource

import com.bokkoa.ecommerceappmvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Response<User>
}