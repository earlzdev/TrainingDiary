package com.earl.myapplication

import com.earl.common.BaseMapper
import com.earl.domain.api.TrainingsDiaryStore

class TrainingsDiaryUiStateToIosStateMapper: BaseMapper<TrainingsDiaryStore.State, TrainingsDiaryUiStateiOS> {

    override fun map(from: TrainingsDiaryStore.State): TrainingsDiaryUiStateiOS {
        return TrainingsDiaryUiStateiOS(
            from.trainingSessions,
            from.isLoading,
            from.errorModel.toString()
        )
    }
}