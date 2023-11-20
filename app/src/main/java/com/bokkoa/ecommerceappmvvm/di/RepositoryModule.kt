package com.bokkoa.ecommerceappmvvm.di

import com.bokkoa.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.bokkoa.ecommerceappmvvm.data.service.AuthService
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository = AuthRepositoryImpl(authRemoteDataSource)
}