package com.earl.domain.api.models

data class TrainingSessionsBlock(
    val trainings: List<TrainingSession> = emptyList()
): TrainingsDiaryContentItem()
