package com.minhky.testworker.di

import com.minhky.testworker.database.dao.FruitteDao
import com.minhky.testworker.network.dataSource.FruittieRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAppContainer(
        fruittesRemoteDataSource: FruittieRemoteDataSource,
        fruitteDao: FruitteDao
    ) = AppContainer(
        fruittesRemoteDataSource = fruittesRemoteDataSource,
        fruitteDao = fruitteDao
    )
}