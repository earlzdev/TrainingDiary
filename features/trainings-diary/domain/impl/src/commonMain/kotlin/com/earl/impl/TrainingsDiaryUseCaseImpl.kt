package com.earl.impl

import com.earl.api.TrainingsDiaryRepository
import com.earl.api.TrainingsDiaryUseCase
import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

class TrainingsDiaryUseCaseImpl(
    private val repository: TrainingsDiaryRepository,
): TrainingsDiaryUseCase {

    override suspend fun getTrainings(): ApiResponse<List<TrainingSession>, ErrorResponse> =
        repository.getMockTrainingSessions()
}