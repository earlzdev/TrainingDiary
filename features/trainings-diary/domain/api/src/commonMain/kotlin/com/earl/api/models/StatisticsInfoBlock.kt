package com.earl.api.models

data class StatisticsInfoBlock(
    val weekly: WeeklyStats? = WeeklyStats()
): TrainingsDiaryContentItem()
