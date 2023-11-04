package com.earl.data

import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.common.ApiResponse
import com.earl.domain.api.TrainingsDiaryRepository
import com.earl.domain.api.models.TrainingSession

class TrainingsDiaryRepositoryImpl(
    private val networkApi: TrainingsDiaryNetworkApi
): TrainingsDiaryRepository {

    override suspend fun getTrainings(): List<TrainingSession> {
        return networkApi.doRequest().map {
            TrainingSession(
                it.id,
                it.dateTime,
                it.title,
                it.type,
                it.distance,
                it.description
            )
        }
    }

    override suspend fun getMockTrainingSessions(): ApiResponse<List<TrainingSession>> {
        return when(val response = networkApi.getTrainingSessions()) {
            is ApiResponse.Success -> {
                ApiResponse.Success(response.data.map {
                    TrainingSession(
                        it.id,
                        it.dateTime,
                        it.title,
                        it.type,
                        it.distance,
                        it.description
                    )
                })
            }
            is ApiResponse.Failure -> {
                ApiResponse.Failure(response.errorMessage)
            }
            else -> ApiResponse.Loading
        }
    }
}