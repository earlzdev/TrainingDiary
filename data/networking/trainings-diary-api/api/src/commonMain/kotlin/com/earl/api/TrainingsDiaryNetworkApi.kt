package com.earl.api

import com.earl.api.models.TrainingSessionResponse
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

interface TrainingsDiaryNetworkApi {

    suspend fun getTrainingSessions(): ApiResponse<List<TrainingSessionResponse>, ErrorResponse>
}