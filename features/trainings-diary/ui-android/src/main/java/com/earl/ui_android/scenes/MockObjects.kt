package com.earl.ui_android.scenes

import com.earl.common.ErrorModel
import com.earl.domain.api.models.TrainingSession
import com.earl.ui_android.UiState

internal object MockObjects {

    private val trainingSessionsList = listOf(
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L, "Test", 154),
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L,"Test", 154),
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L,"Test", 154),
    )

    val loadingState = UiState(isLoading = true)
    val errorState = UiState(error = ErrorModel.NetworkError(404, "Not found"))
    val successfulLoadedState = UiState(trainingSessionsList = trainingSessionsList)
    val trainingSession = TrainingSession(
        "test",
        1L,
        "Title",
        "Running",
        10,
        1L,
        "Test",
        154
    )
}