package com.earl.impl

import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.earl.api.TrainingsDiaryStatePublisher
import com.earl.api.TrainingsDiaryStore
import kotlinx.coroutines.flow.Flow

class TrainingsDiaryStatePublisherImpl(
    private val store: TrainingsDiaryStore,
): TrainingsDiaryStatePublisher {

    override fun publishState(): Flow<TrainingsDiaryStore.State> = store.states

    override fun loadTrainingSessions() = store.accept(TrainingsDiaryStore.Intent.Load)
}