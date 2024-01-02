package com.earl.data

import com.earl.api.FetchTrainingsUseCase
import com.earl.api.TrainingsDiaryRepository
import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

class TrainingsDiaryRepositoryImpl(
    private val fetchTrainingsUseCase: FetchTrainingsUseCase
): TrainingsDiaryRepository {

    override suspend fun fetchDiaryContent(): ApiResponse<List<TrainingSession>, ErrorResponse> =
        fetchTrainingsUseCase.fetch()
}