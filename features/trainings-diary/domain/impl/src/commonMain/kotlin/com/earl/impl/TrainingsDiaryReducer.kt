package com.earl.impl

import com.arkivanov.mvikotlin.core.store.Reducer
import com.earl.api.TrainingsDiaryStore
import com.earl.api.models.ErrorModel

internal class TrainingsDiaryReducer : Reducer<TrainingsDiaryStore.State, TrainingsDiaryStoreFactory.Message> {

    override fun TrainingsDiaryStore.State.reduce(
        msg: TrainingsDiaryStoreFactory.Message,
    ) = when (msg) {
        is TrainingsDiaryStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            error = null
        )
        is TrainingsDiaryStoreFactory.Message.SetTrainingsSessionsList -> copy(
            trainingSessions = msg.list,
            isLoading = false,
            error = null
        )
        is TrainingsDiaryStoreFactory.Message.SetHttpError -> copy(
            isLoading = false,
            trainingSessions = emptyList(),
            error = ErrorModel(msg.error.code, msg.error.errorBody, "Http exception")
        )
        is TrainingsDiaryStoreFactory.Message.SetNetworkError -> copy(
            isLoading = false,
            trainingSessions = emptyList(),
            error = ErrorModel(msg = "Network exception")
        )
        is TrainingsDiaryStoreFactory.Message.SetSerializationError -> copy(
            isLoading = false,
            error = ErrorModel(msg = "Serialization exception")
        )
    }
}