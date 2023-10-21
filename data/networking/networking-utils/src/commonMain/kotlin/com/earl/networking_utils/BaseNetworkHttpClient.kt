package com.earl.networking_utils

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class BaseNetworkHttpClient: NetworkClientProvider {

    private val baseHttpClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTP
                host = MOCK_URL
                port = MOCK_PORT
            }
        }
    }

    override fun provideBaseHttpClient(): HttpClient = baseHttpClient

    // FIXME: Need to refactor and move mock build flag to BuildConfig
    private companion object {

        const val MOCK_URL = "10.0.2.2"
        const val MOCK_PORT = 8000
    }
}