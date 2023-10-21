package com.earl.networking_utils

import io.ktor.client.HttpClient

interface NetworkClientProvider {

    fun provideBaseHttpClient(): HttpClient
}