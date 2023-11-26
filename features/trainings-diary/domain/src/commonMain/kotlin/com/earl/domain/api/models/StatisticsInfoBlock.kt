package com.earl.domain.api.models

data class StatisticsInfoBlock(
    val weekly: WeeklyStats? = WeeklyStats()
): TrainingsDiaryContentItem()
