package com.earl.api

import com.earl.api.models.TrainingSession

interface TrainingsDiaryUseCase {

    suspend fun getTrainings(): List<TrainingSession>
}