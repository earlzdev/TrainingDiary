package com.earl.myapplication.uiStates.mappers

import com.earl.common.BaseMapper
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.myapplication.uiStates.trainingsDiary.TrainingsDiaryUiStateiOS

class TrainingsDiaryUiStateToIosStateMapper: BaseMapper<TrainingsDiaryStore.State, TrainingsDiaryUiStateiOS> {

    override fun map(from: TrainingsDiaryStore.State): TrainingsDiaryUiStateiOS {
        return TrainingsDiaryUiStateiOS(
            from.trainingSessions,
            from.isLoading,
            from.errorModel.toString()
        )
    }
}