package com.earl.implementation

import com.earl.api.TrainingSessionsNetworkApi
import com.earl.api.models.TrainingSessionApi
import com.earl.networking_utils.NetworkClientProvider
import io.ktor.client.call.body
import io.ktor.client.request.get

class TrainingSessionsNetworkApiImpl(
    private val networkClientProvider: NetworkClientProvider
): TrainingSessionsNetworkApi {

    private val httpClient = networkClientProvider.provideBaseHttpClient()

    override suspend fun doRequest(): List<TrainingSessionApi> {
        val response = httpClient.get("get-10-sessions")
        val sessionsList = response.body<Array<TrainingSessionApi>>()
//        android.util.Log.d("TAG", "doRequest: ${sessionsList.size}")
        return sessionsList.toList()
    }
}