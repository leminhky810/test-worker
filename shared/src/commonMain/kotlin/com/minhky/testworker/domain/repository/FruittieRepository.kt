package com.minhky.testworker.domain.repository

import com.minhky.testworker.domain.model.Fruittie
import kotlinx.coroutines.flow.Flow

interface FruittieRepository {
    suspend fun getFruitties(page: Int): List<Fruittie>
    fun observeFruitties(): Flow<List<Fruittie>>
    suspend fun deleteFruittie(id: String)
    suspend fun clearFruitties()
} 