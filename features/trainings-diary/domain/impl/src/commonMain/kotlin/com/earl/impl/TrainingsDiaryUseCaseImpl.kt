package com.earl.impl

import com.earl.api.TrainingsDiaryRepository
import com.earl.api.TrainingsDiaryUseCase
import com.earl.api.models.TrainingSession

class TrainingsDiaryUseCaseImpl(
    private val repository: TrainingsDiaryRepository,
): TrainingsDiaryUseCase {
    override suspend fun getTrainings(): List<TrainingSession> {
        return repository.getTrainings()
    }
}