package com.minhky.testworker.di

import com.minhky.testworker.data.FruittieRepositoryImpl
import com.minhky.testworker.domain.repository.FruittieRepository
import com.minhky.testworker.domain.usecase.ObserverFruittesUseCase
import com.minhky.testworker.network.dataSource.FruittieRemoteDataSource

class AppContainer(
    private val fruittesRemoteDataSource: FruittieRemoteDataSource,
    private val appDatabaseFactory: AppDatabaseFactory
) {
    val fruittieRepository: FruittieRepository by lazy {
        FruittieRepositoryImpl(
            fruittesRemoteDataSource = fruittesRemoteDataSource,
            appDatabaseFactory = appDatabaseFactory
        )
    }
    val observerFruittesUseCase: ObserverFruittesUseCase by lazy {
        ObserverFruittesUseCase(fruittieRepository)
    }
}
