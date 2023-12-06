package com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl

import com.bokkoa.ecommerceappmvvm.data.dataStore.AuthDataStore
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore) : AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.save(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}