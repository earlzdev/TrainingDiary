package com.earl.domain.implementation

import com.earl.domain.api.TrainingsDiaryRepository
import com.earl.domain.api.TrainingsDiaryUseCase
import com.earl.domain.api.models.TrainingSession

class TrainingsDiaryUseCaseImpl(
    private val repository: TrainingsDiaryRepository,
): TrainingsDiaryUseCase {
    override suspend fun getTrainings(): List<TrainingSession> {
        return repository.getTrainings()
    }
}