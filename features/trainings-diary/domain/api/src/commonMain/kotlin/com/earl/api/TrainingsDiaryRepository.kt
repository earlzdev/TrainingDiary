package com.earl.api

import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse

interface TrainingsDiaryRepository {

    suspend fun getTrainings(): List<TrainingSession>

    suspend fun getMockTrainingSessions(): ApiResponse<List<TrainingSession>>
}