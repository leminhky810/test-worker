package com.minhky.testworker.di

import com.minhky.testworker.data.FruittieRepositoryImpl
import com.minhky.testworker.domain.repository.FruittieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsFruitteRepository(
        fruittieRepositoryImpl: FruittieRepositoryImpl
    ): FruittieRepository
}