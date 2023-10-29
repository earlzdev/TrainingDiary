package com.earl.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrainingsDiaryUseCaseImpl(
    private val repository: TrainingsDiaryRepository,
): TrainingsDiaryUseCase {
    override fun observeTrainingsDiaryModel(): Flow<TrainingsDiaryModel> {
        return repository.getActualData().map {
            TrainingsDiaryModel(title = it)
        }
    }

    override suspend fun testFoo(): TrainingsDiaryModel {
        return TrainingsDiaryModel()
    }
}