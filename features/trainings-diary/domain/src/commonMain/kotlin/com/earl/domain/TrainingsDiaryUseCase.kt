package com.earl.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface TrainingsDiaryUseCase {

//    fun observeTrainingDiary(): StateFlow<TrainingsDiaryModel>
//
//    fun fetchActualTrainingDiaryModel()
//
//    suspend fun fetchActualTrainingDiaryModelSuspendable()

    fun observeTrainingsDiaryModel(): Flow<TrainingsDiaryModel>

    suspend fun testFoo(): TrainingsDiaryModel
}