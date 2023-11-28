package com.earl.impl

import com.earl.api.TrainingsDiaryRepository
import com.earl.api.TrainingsDiaryStore
import com.earl.common.ApiResponse
import com.earl.common.BaseExecutor

internal class MainExecutor(
    private val repository: TrainingsDiaryRepository,
) : BaseExecutor<TrainingsDiaryStore.Intent, Nothing, TrainingsDiaryStore.State, TrainingsDiaryStoreFactory.Message, Nothing>() {

    override suspend fun suspendExecuteIntent(
        intent: TrainingsDiaryStore.Intent,
        getState: () -> TrainingsDiaryStore.State,
    ) = when (intent) {
        is TrainingsDiaryStore.Intent.Load -> getTrainingSessions()
    }

    private suspend fun getTrainingSessions() {
        dispatch(TrainingsDiaryStoreFactory.Message.SetLoading)
        when(val response = repository.getMockTrainingSessions()) {
            is ApiResponse.Success -> dispatch(
                TrainingsDiaryStoreFactory.Message.SetTrainingsSessionsList(
                    response.body
                )
            )
            is ApiResponse.Error.HttpError -> {
                dispatch(TrainingsDiaryStoreFactory.Message.SetHttpError(response))
            }
            is ApiResponse.Error.NetworkError -> {
                dispatch(TrainingsDiaryStoreFactory.Message.SetNetworkError)
            }
            is ApiResponse.Error.SerializationError -> {
                dispatch(TrainingsDiaryStoreFactory.Message.SetSerializationError)
            }
            else -> throw IllegalStateException("No such response type")
        }
    }
}
