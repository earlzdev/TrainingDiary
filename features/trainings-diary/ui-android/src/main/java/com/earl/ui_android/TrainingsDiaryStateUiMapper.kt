package com.earl.ui_android

import com.earl.common.BaseMapper
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.domain.api.models.StatisticsInfoBlock
import com.earl.domain.api.models.TrainingSessionsBlock

class TrainingsDiaryStateUiMapper: BaseMapper<TrainingsDiaryStore.State, UiState> {

    override fun map(from: TrainingsDiaryStore.State): UiState {
        return UiState(
            LoadedTrainingSessionContent(
                statistics = StatisticsInfoBlock(),
                trainingsList = TrainingSessionsBlock(from.trainingSessions)
            ),
            from.isLoading,
            from.errorModel
        )
    }
}