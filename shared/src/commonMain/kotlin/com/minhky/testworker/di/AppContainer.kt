package com.minhky.testworker.di

import com.minhky.testworker.data.FruittieRepositoryImpl
import com.minhky.testworker.database.dao.FruitteDao
import com.minhky.testworker.domain.repository.FruittieRepository
import com.minhky.testworker.domain.usecase.ObserverFruittesUseCase
import com.minhky.testworker.network.dataSource.FruittieRemoteDataSource

class AppContainer(
    private val fruittesRemoteDataSource: FruittieRemoteDataSource,
    private val fruitteDao: FruitteDao,
) {
    val fruittieRepository: FruittieRepository by lazy {
        FruittieRepositoryImpl(
            fruittesRemoteDataSource = fruittesRemoteDataSource,
            fruitteDao = fruitteDao
        )
    }
    val observerFruittesUseCase: ObserverFruittesUseCase by lazy {
        ObserverFruittesUseCase(fruittieRepository)
    }
}
