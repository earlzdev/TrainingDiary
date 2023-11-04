package com.earl.domain.api

import com.earl.common.ApiResponse
import com.earl.domain.api.models.TrainingSession

interface TrainingsDiaryRepository {

    suspend fun getTrainings(): List<TrainingSession>

    suspend fun getMockTrainingSessions(): ApiResponse<List<TrainingSession>>
}