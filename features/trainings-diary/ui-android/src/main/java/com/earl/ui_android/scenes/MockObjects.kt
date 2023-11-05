package com.earl.ui_android.scenes

import com.earl.common.ErrorModel
import com.earl.domain.api.models.TrainingSession
import com.earl.ui_android.UiState

internal object MockObjects {

    private val trainingSessionsList = listOf(
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L, "Test", 164),
        TrainingSession("test", 1L, "Test title", "Gym", 10, 1L,"Test", 132),
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L,"Test", 145),
        TrainingSession("test", 1L, "Test title", "Swimming", 10, 1L,"Test", 126),
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L,"Test", 154),
        TrainingSession("test", 1L, "Test title", "Gym", 10, 1L,"Test", 165),
        TrainingSession("test", 1L, "Test title", "Swimming", 10, 1L,"Test", 134),
        TrainingSession("test", 1L, "Test title", "Gym", 10, 1L,"Test", 176),
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L,"Test", 104),
        TrainingSession("test", 1L, "Test title", "Gym", 10, 1L,"Test", 166),
        TrainingSession("test", 1L, "Test title", "Running", 10, 1L,"Test", 159),
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