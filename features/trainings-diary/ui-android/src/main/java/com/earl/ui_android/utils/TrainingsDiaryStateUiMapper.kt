package com.earl.ui_android.utils

import com.earl.api.TrainingsDiaryStore
import com.earl.api.models.StatisticsInfoBlock
import com.earl.api.models.TrainingSessionsBlock
import com.earl.common.mappers.BaseMapper
import com.earl.ui_android.LoadedTrainingSessionContent
import com.earl.ui_android.UiState

class TrainingsDiaryStateUiMapper: BaseMapper<TrainingsDiaryStore.State, UiState> {

    override fun map(from: TrainingsDiaryStore.State): UiState {
        return UiState(
            LoadedTrainingSessionContent(
                statistics = StatisticsInfoBlock(),
                trainingsList = TrainingSessionsBlock(from.trainingSessions)
            ),
            from.isLoading,
            from.error
        )
    }
}