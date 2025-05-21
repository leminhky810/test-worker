package com.minhky.testworker.domain.usecase

import com.minhky.testworker.domain.model.Fruittie
import com.minhky.testworker.domain.repository.FruittieRepository
import kotlinx.coroutines.flow.Flow

class ObserverFruittesUseCase(private val repository: FruittieRepository) {
    operator fun invoke(): Flow<List<Fruittie>> {
        return repository.observeFruitties()
    }
} 