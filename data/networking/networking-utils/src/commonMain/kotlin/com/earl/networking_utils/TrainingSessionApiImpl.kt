package com.earl.networking_utils

import io.ktor.client.HttpClient

class TrainingSessionApiImpl(
    private val httpClientProvider: NetworkClientProvider
): TrainingSessionsApi {

    private val httpClient: HttpClient = httpClientProvider.provideClient()

    override suspend fun doSomething() {

    }

    private companion object {

        const val BASE_URL = ""
    }
}