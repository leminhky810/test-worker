package com.minhky.testworker.domain.usecase

import com.minhky.testworker.domain.model.Fruittie
import com.minhky.testworker.domain.repository.FruittieRepository

class GetFruittesUseCase(private val repository: FruittieRepository) {
    suspend operator fun invoke(page: Int): List<Fruittie> {
        return repository.getFruitties(page)
    }
} 