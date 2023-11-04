package com.earl.ui

import com.earl.common.ErrorModel
import com.earl.domain.api.models.TrainingSession

data class UiState(
    val trainingSessionsList: List<TrainingSession> = emptyList(),
    val isLoading: Boolean = false,
    val error: ErrorModel = ErrorModel.None
)