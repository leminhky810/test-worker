package com.minhky.testworker.di

import com.minhky.testworker.data.FruittieRepositoryImpl
import com.minhky.testworker.domain.repository.FruittieRepository
import com.minhky.testworker.network.dataSource.FruittieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    @ViewModelScoped
    fun providesFruitteRepository(
        fruittesRemoteDataSource: FruittieRemoteDataSource,
        appDatabaseFactory: AppDatabaseFactory
    ): FruittieRepository =
        FruittieRepositoryImpl(
            fruittesRemoteDataSource = fruittesRemoteDataSource,
            appDatabaseFactory = appDatabaseFactory
        )
}