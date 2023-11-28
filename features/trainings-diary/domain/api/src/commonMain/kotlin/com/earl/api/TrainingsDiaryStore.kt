package com.earl.api

import com.arkivanov.mvikotlin.core.store.Store
import com.earl.api.models.ErrorModel
import com.earl.api.models.TrainingSession
import com.earl.common.ErrorResponse

interface TrainingsDiaryStore: Store<TrainingsDiaryStore.Intent, TrainingsDiaryStore.State, TrainingsDiaryStore.Label> {

    data class State(
        val trainingSessions: List<TrainingSession> = emptyList(),
        val isLoading: Boolean = false,
        val error: ErrorModel<ErrorResponse>? = null
    )

    data class Label(
        val toastString: String
    )

    sealed interface Intent {
        object Load: Intent
    }
}