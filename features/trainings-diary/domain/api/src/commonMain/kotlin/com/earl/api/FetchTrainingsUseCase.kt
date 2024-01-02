package com.earl.api

import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

interface FetchTrainingsUseCase {

    suspend fun fetch(): ApiResponse<List<TrainingSession>, ErrorResponse>
}