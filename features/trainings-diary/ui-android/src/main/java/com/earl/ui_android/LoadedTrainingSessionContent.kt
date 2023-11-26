package com.earl.ui_android

import com.earl.domain.api.models.StatisticsInfoBlock
import com.earl.domain.api.models.TrainingSessionsBlock
import com.earl.domain.api.models.TrainingsDiaryContentItem

data class LoadedTrainingSessionContent(
    val statistics: StatisticsInfoBlock? = StatisticsInfoBlock(),
    val trainingsList: TrainingSessionsBlock = TrainingSessionsBlock()
)

fun LoadedTrainingSessionContent.successfullyLoaded(): Boolean =
    this.trainingsList.trainings.isNotEmpty() && this.statistics != null