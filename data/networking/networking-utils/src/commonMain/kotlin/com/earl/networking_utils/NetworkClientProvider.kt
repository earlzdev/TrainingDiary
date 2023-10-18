package com.earl.networking_utils

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface NetworkClientProvider {

    fun provideClient(): HttpClient

    class NetworkClientProviderImpl: NetworkClientProvider {

        private val baseHttpClient: HttpClient = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }

        override fun provideClient(): HttpClient = baseHttpClient
    }
}