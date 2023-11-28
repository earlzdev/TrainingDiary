package com.earl.myapplication.uiStates.trainingsDiary

import com.earl.api.TrainingsDiaryStatePublisher
import com.earl.api.TrainingsDiaryStore
import com.earl.common.mappers.BaseMapper
import com.earl.myapplication.uiStates.BaseUiStatePublisheriOS
import com.earl.myapplication.utils.FlowWrapper
import kotlinx.coroutines.flow.map

class TrainingsDiaryStatePublisheriOS(
    private val publisher: TrainingsDiaryStatePublisher,
    private val uiStateMapper: BaseMapper<TrainingsDiaryStore.State, TrainingsDiaryUiStateiOS>
): BaseUiStatePublisheriOS() {

    fun publishState(): FlowWrapper<TrainingsDiaryUiStateiOS> {
        return FlowWrapper(scope, publisher.publishState().map(::mapUiStateToiOSState))
    }

    fun loadTrainingSessions() {
        publisher.loadTrainingSessions()
    }

    private fun mapUiStateToiOSState(state: TrainingsDiaryStore.State): TrainingsDiaryUiStateiOS =
        uiStateMapper.map(state)

}