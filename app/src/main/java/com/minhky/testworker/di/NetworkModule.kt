package com.minhky.testworker.di

import com.minhky.testworker.network.KtorClient
import com.minhky.testworker.network.dataSource.FruittieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesKtorClient() = KtorClient()

    @Provides
    @Singleton
    fun providesFruittieRemoteDataSource(
        ktorClient: KtorClient
    ) = FruittieRemoteDataSource(ktorClient)
}