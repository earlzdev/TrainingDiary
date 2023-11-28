package com.earl.ui_android

import com.earl.api.models.StatisticsInfoBlock
import com.earl.api.models.TrainingSessionsBlock

data class LoadedTrainingSessionContent(
    val statistics: StatisticsInfoBlock? = StatisticsInfoBlock(),
    val trainingsList: TrainingSessionsBlock = TrainingSessionsBlock()
)

fun LoadedTrainingSessionContent.successfullyLoaded(): Boolean =
    this.trainingsList.trainings.isNotEmpty() && this.statistics != null