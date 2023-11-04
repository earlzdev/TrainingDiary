package com.earl.domain.implementation

import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.domain.api.TrainingsDiaryStatePublisher
import kotlinx.coroutines.flow.Flow

class TrainingsDiaryStatePublisherImpl(
    private val store: TrainingsDiaryStore,
): TrainingsDiaryStatePublisher {

    override fun publishState(): Flow<TrainingsDiaryStore.State> = store.states

    override fun loadTrainingSessions() = store.accept(TrainingsDiaryStore.Intent.Load)
}