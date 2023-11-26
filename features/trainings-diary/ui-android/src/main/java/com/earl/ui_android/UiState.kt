package com.earl.ui_android

import com.earl.common.ErrorModel

data class UiState(
    val content: LoadedTrainingSessionContent = LoadedTrainingSessionContent(),
    val isLoading: Boolean = false,
    val error: ErrorModel = ErrorModel.None
)