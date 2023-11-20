package com.bokkoa.ecommerceappmvvm.data.repository

import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import com.bokkoa.ecommerceappmvvm.domain.util.Response
import java.lang.Exception

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): Response<User> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Response.Success(result.body()!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}