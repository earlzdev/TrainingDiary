package com.earl.ui_android

import com.earl.api.models.ErrorModel
import com.earl.common.ErrorResponse

data class UiState(
    val content: LoadedTrainingSessionContent = LoadedTrainingSessionContent(),
    val isLoading: Boolean = false,
    val error: ErrorModel<ErrorResponse>? = null
) {

    fun errorOccurred(): Boolean = error != null

    fun isSuccessfullyLoaded(): Boolean = with(content) {
        trainingsList.trainings.isNotEmpty() && statistics != null
    }
}