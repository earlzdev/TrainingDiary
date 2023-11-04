package com.earl.ui_android

import com.earl.common.BaseMapper
import com.earl.domain.api.TrainingsDiaryStore

class TrainingsDiaryStateUiMapper: BaseMapper<TrainingsDiaryStore.State, UiState> {

    override fun map(from: TrainingsDiaryStore.State): UiState {
        return UiState(
            from.trainingSessions,
            from.isLoading,
            from.errorModel
        )
    }
}