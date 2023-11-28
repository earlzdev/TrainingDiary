package com.earl.api.models

data class TrainingSessionsBlock(
    val trainings: List<TrainingSession> = emptyList()
): TrainingsDiaryContentItem()
