package com.minhky.testworker.network.dataSource

import com.minhky.testworker.API_URL
import com.minhky.testworker.network.model.FruittiesResponse
import com.minhky.testworker.network.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class FruittieRemoteDataSource(private val client: KtorClient) {
    private val baseUrl = API_URL

    suspend fun getFruitties(page: Int): FruittiesResponse {
        return client.httpClient.get("$baseUrl/$page.json").body<FruittiesResponse>()
    }

} 