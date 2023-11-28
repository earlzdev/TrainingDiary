package com.earl.data

import com.earl.api.models.TrainingSession
import com.earl.api.models.TrainingSessionResponse
import com.earl.common.ApiResponse
import com.earl.common.mappers.BaseApiResponseListMapper

class TrainingSessionsRemoteToApiResponseMapper:
    BaseApiResponseListMapper<TrainingSessionResponse, TrainingSession> {
    override fun <E> map(from: ApiResponse<List<TrainingSessionResponse>, E>): ApiResponse<List<TrainingSession>, E> {
        return when(from) {
            is ApiResponse.Success -> {
                ApiResponse.Success(from.body.map { trainingResponse ->
                    TrainingSession(
                        trainingResponse.id,
                        trainingResponse.dateTime,
                        trainingResponse.title,
                        trainingResponse.type,
                        trainingResponse.distance,
                        trainingResponse.duration,
                        trainingResponse.description,
                        trainingResponse.pulse?.average ?: -1
                    )
                })
            }
            is ApiResponse.Error.HttpError -> ApiResponse.Error.HttpError(from.code, from.errorBody)
            is ApiResponse.Error.NetworkError -> ApiResponse.Error.NetworkError
            is ApiResponse.Error.SerializationError -> ApiResponse.Error.SerializationError
            is ApiResponse.Error.TimeoutError -> ApiResponse.Error.TimeoutError
        }
    }
}