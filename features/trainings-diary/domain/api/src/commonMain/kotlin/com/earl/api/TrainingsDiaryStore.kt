package com.earl.api

import com.arkivanov.mvikotlin.core.store.Store
import com.earl.api.models.TrainingSession
import com.earl.common.ErrorModel

interface TrainingsDiaryStore: Store<TrainingsDiaryStore.Intent, TrainingsDiaryStore.State, TrainingsDiaryStore.Label> {

    data class State(
        val trainingSessions: List<TrainingSession> = emptyList(),
        val isLoading: Boolean = false,
        val errorModel: ErrorModel = ErrorModel.None
    )

    data class Label(
        val toastString: String
    )

    sealed interface Intent {
        object Load: Intent
    }
}