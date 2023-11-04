package com.earl.domain.api

import com.earl.domain.api.models.TrainingSession

interface TrainingsDiaryUseCase {

    suspend fun getTrainings(): List<TrainingSession>
}