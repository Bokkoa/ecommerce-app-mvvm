package com.bokkoa.ecommerceappmvvm.di

import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.AuthUseCase
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.GetSessionDataUseCase
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.LoginUseCase
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.RegisterUseCase
import com.bokkoa.ecommerceappmvvm.domain.usecase.auth.SaveSessionUseCase
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
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
    )
}
