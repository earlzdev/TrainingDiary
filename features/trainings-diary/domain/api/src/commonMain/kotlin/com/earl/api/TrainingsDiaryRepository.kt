package com.earl.api

import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

interface TrainingsDiaryRepository {

    suspend fun getMockTrainingSessions(): ApiResponse<List<TrainingSession>, ErrorResponse>
}