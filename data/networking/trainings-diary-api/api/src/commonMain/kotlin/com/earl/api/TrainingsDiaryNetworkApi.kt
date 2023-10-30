package com.earl.api

import com.earl.api.models.TrainingSessionResponse
import com.earl.common.ApiResponse

interface TrainingsDiaryNetworkApi {

    suspend fun doRequest(): List<TrainingSessionResponse>

    suspend fun getTrainingSessions(): ApiResponse<List<TrainingSessionResponse>>
}