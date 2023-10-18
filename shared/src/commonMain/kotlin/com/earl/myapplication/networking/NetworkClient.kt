package com.earl.myapplication.networking

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkClient {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun doTestRequest() {
        val smth = httpClient.get("http://45.12.19.184/airports?page_size=10")
    }

    private companion object {

        const val BASE_URL = ""
    }
}