package com.earl.domain

import com.earl.domain.models.TrainingSession

interface TrainingsDiaryRepository {

    suspend fun getTrainings(): List<TrainingSession>
}