package com.bokkoa.ecommerceappmvvm.di

import android.annotation.SuppressLint
import com.bokkoa.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @SuppressLint("NewApi")
    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository = AuthRepositoryImpl(authRemoteDataSource)
}
