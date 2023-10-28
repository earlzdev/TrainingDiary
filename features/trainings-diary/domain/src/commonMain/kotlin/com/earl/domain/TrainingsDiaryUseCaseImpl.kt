package com.earl.domain

import com.earl.domain.TrainingsDiaryModel
import com.earl.domain.TrainingsDiaryRepository
import com.earl.domain.TrainingsDiaryUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TrainingsDiaryUseCaseImpl(
    private val repository: TrainingsDiaryRepository,
    private val viewUpdate: ((TrainingsDiaryModel) -> Unit)? = null
): TrainingsDiaryUseCase {
    override fun observeTrainingsDiaryModel(): Flow<TrainingsDiaryModel> {
        return repository.getActualData().map {
            TrainingsDiaryModel(title = it)
        }
    }

    override suspend fun testFoo(): TrainingsDiaryModel {
        return TrainingsDiaryModel()
//        return repository.testFoo().map {
//            TrainingsDiaryModel(title = it.toString())
//        }
    }

    //    val coroutineScope = MainScope()
//
//    val trainingsDiaryFlow = MutableStateFlow<TrainingsDiaryModel>(TrainingsDiaryModel())
//
//    override fun observeTrainingDiary(): StateFlow<TrainingsDiaryModel> {
//        return trainingsDiaryFlow
//    }
//
//    override fun fetchActualTrainingDiaryModel() {
//        coroutineScope.launch {
//            fetchActualTrainingDiaryModelSuspendable()
//        }
//    }
//
//    override suspend fun fetchActualTrainingDiaryModelSuspendable() {
//        repository.getActualData().collect {
//            val actualData = TrainingsDiaryModel(title = it)
//            trainingsDiaryFlow.tryEmit(actualData)
//            viewUpdate?.invoke(actualData)
//        }
//    }
//
//    fun onDestroy() {
//        coroutineScope.cancel()
//    }
}