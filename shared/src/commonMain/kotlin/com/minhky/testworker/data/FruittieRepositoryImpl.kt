package com.minhky.testworker.data

import com.minhky.testworker.data.mapper.toDomain
import com.minhky.testworker.data.mapper.toEntity
import com.minhky.testworker.database.dao.FruitteDao
import com.minhky.testworker.domain.model.Fruittie
import com.minhky.testworker.domain.repository.FruittieRepository
import com.minhky.testworker.network.dataSource.FruittieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FruittieRepositoryImpl(
    private val fruittesRemoteDataSource: FruittieRemoteDataSource,
    private val fruitteDao: FruitteDao
) : FruittieRepository {
    override suspend fun getFruitties(page: Int): List<Fruittie> {
        return try {
            // Get from remote
            val fruittes = fruittesRemoteDataSource.getFruitties(page).feed
            // Store in local
            val ids = fruitteDao.insertFruittes(fruittes.toEntity())
            fruittes.toDomain(ids)
        } catch (e: Exception) {
            // If remote fails, get from local
            fruitteDao.getAllFruittes().toDomain()
        }
    }

    override fun observeFruitties(): Flow<List<Fruittie>> {
        CoroutineScope(Dispatchers.IO).launch {
            if (fruitteDao.count() < 1) {
                getFruitties(0)
            }
        }
        return fruitteDao.observeFruittes().map { it.toDomain() }
    }

    override suspend fun deleteFruittie(id: String) {
        fruitteDao.deleteFruitte(id)
    }

    override suspend fun clearFruitties() {
        fruitteDao.deleteAllFruittes()
    }

}