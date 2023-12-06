package com.bokkoa.ecommerceappmvvm.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import com.bokkoa.ecommerceappmvvm.domain.util.Resource
import com.bokkoa.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource,
) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password),
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user),
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()
}
