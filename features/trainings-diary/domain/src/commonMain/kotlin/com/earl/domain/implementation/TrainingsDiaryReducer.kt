package com.earl.domain.implementation

import com.arkivanov.mvikotlin.core.store.Reducer
import com.earl.common.ErrorModel
import com.earl.domain.api.TrainingsDiaryStore

internal class TrainingsDiaryReducer : Reducer<TrainingsDiaryStore.State, TrainingsDiaryStoreFactory.Message> {

    override fun TrainingsDiaryStore.State.reduce(
        msg: TrainingsDiaryStoreFactory.Message,
    ) = when (msg) {
        is TrainingsDiaryStoreFactory.Message.SetError -> copy(
            isLoading = false,
            errorModel = ErrorModel.Unknown
        )
        is TrainingsDiaryStoreFactory.Message.SetTrainingsSessionsList -> copy(
            trainingSessions = msg.list,
            isLoading = false,
        )
        is TrainingsDiaryStoreFactory.Message.SetLoading -> copy(
            isLoading = true,
            errorModel = ErrorModel.None
        )
    }
}