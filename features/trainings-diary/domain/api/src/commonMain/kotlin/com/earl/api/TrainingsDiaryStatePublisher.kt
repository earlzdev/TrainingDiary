package com.earl.api

import kotlinx.coroutines.flow.Flow

interface TrainingsDiaryStatePublisher {

    fun publishState(): Flow<TrainingsDiaryStore.State>

    fun loadTrainingSessions()
}