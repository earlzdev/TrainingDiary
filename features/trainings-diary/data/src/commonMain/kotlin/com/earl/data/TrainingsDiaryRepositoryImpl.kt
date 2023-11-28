package com.earl.data

import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.api.TrainingsDiaryRepository
import com.earl.api.models.TrainingSession
import com.earl.api.models.TrainingSessionResponse
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse
import com.earl.common.mappers.BaseApiResponseListMapper

class TrainingsDiaryRepositoryImpl(
    private val networkApi: TrainingsDiaryNetworkApi,
    private val trainingsDiaryMapper: BaseApiResponseListMapper<TrainingSessionResponse, TrainingSession>
): TrainingsDiaryRepository {

    override suspend fun getMockTrainingSessions(): ApiResponse<List<TrainingSession>, ErrorResponse> =
        trainingsDiaryMapper.map(networkApi.getTrainingSessions())
}