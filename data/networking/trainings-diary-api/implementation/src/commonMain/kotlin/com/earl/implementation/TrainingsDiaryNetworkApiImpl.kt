package com.earl.implementation

import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.api.models.TrainingSessionResponse
import com.earl.common.ApiResponse
import com.earl.common.ErrorModel
import com.earl.networking_utils.NetworkClientProvider
import io.ktor.client.call.body
import io.ktor.client.request.get

class TrainingsDiaryNetworkApiImpl(
    private val networkClientProvider: NetworkClientProvider
): TrainingsDiaryNetworkApi {

    private val httpClient = networkClientProvider.provideBaseHttpClient()

    override suspend fun doRequest(): List<TrainingSessionResponse> {
        val response = httpClient.get("get-10-sessions")
        val sessionsList = response.body<Array<TrainingSessionResponse>>()
        return sessionsList.toList()
    }

    override suspend fun getTrainingSessions(): ApiResponse<List<TrainingSessionResponse>> {
        return try {
            val response = httpClient.get("get-10-sessions")
            val sessionsList = response.body<Array<TrainingSessionResponse>>()
            ApiResponse.Success(sessionsList.toList())
        } catch (e: Exception) {
            ApiResponse.Failure(ErrorModel.NetworkError(500, e.message.toString()))
        }
    }
}