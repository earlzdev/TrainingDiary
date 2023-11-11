package com.earl.myapplication.uiStates.trainingsDiary

import com.earl.domain.api.models.TrainingSession

data class TrainingsDiaryUiStateiOS(
    val trainingSessionsList: List<TrainingSession> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
