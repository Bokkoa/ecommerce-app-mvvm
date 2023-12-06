package com.bokkoa.ecommerceappmvvm.di

import com.bokkoa.ecommerceappmvvm.data.dataStore.AuthDataStore
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.bokkoa.ecommerceappmvvm.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataStore(authDataStore: AuthDataStore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDataStore)
}
