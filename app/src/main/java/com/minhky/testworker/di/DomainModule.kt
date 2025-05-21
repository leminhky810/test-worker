package com.minhky.testworker.di

import com.minhky.testworker.domain.repository.FruittieRepository
import com.minhky.testworker.domain.usecase.ObserverFruittesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun providesObserveFruitteUseCase(
        fruittieRepository: FruittieRepository
    ) = ObserverFruittesUseCase(fruittieRepository)

}