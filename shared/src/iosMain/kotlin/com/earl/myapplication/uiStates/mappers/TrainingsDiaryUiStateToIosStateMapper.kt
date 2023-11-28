package com.earl.myapplication.uiStates.mappers

import com.earl.api.TrainingsDiaryStore
import com.earl.common.mappers.BaseMapper
import com.earl.myapplication.uiStates.trainingsDiary.TrainingsDiaryUiStateiOS

class TrainingsDiaryUiStateToIosStateMapper:
    BaseMapper<TrainingsDiaryStore.State, TrainingsDiaryUiStateiOS> {

    override fun map(from: TrainingsDiaryStore.State): TrainingsDiaryUiStateiOS {
        return TrainingsDiaryUiStateiOS(
            from.trainingSessions,
            from.isLoading,
            from.error?.msg.toString()
        )
    }
}