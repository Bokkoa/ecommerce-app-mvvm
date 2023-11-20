package com.bokkoa.ecommerceappmvvm.di

import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.bokkoa.ecommerceappmvvm.data.service.AuthService
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
    )
}
