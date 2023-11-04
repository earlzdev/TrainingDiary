package com.earl.myapplication.usecases

import com.earl.common.BaseMapper
import com.earl.domain.api.TrainingsDiaryStatePublisher
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.myapplication.TrainingsDiaryUiStateiOS
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