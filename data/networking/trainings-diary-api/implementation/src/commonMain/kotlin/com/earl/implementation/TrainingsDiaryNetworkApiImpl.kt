package com.earl.implementation

import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.api.models.TrainingSessionResponse
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse
import com.earl.networking_utils.NetworkClientProvider
import com.earl.networking_utils.safeRequest
import io.ktor.client.request.url

class TrainingsDiaryNetworkApiImpl(
    private val networkClientProvider: NetworkClientProvider
): TrainingsDiaryNetworkApi {

    private val httpClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        networkClientProvider.provideBaseHttpClient()
    }

    override suspend fun fetchTrainingSessions(): ApiResponse<List<TrainingSessionResponse>, ErrorResponse> =
        httpClient.safeRequest { url(trainingsSessions) }

    private companion object {
        const val trainingsSessions = "get-10-sessions"
    }
}