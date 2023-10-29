package com.earl.domain

import com.earl.domain.models.TrainingSession

class TrainingsDiaryUseCaseImpl(
    private val repository: TrainingsDiaryRepository,
): TrainingsDiaryUseCase {
    override suspend fun getTrainings(): List<TrainingSession> {
        return repository.getTrainings()
    }
}