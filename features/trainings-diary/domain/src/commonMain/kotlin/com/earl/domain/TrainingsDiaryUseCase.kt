package com.earl.domain

import com.earl.domain.models.TrainingSession

interface TrainingsDiaryUseCase {

    suspend fun getTrainings(): List<TrainingSession>
}