package com.earl.api

import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

interface TrainingsDiaryRepository {

    suspend fun fetchDiaryContent(): ApiResponse<List<TrainingSession>, ErrorResponse>
}