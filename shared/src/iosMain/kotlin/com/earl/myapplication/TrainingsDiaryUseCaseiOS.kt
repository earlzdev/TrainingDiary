package com.earl.myapplication

import com.earl.domain.TrainingsDiaryModel
import com.earl.domain.TrainingsDiaryUseCase
import kotlinx.coroutines.launch

class TrainingsDiaryUseCaseiOS(
    private val trainingsDiaryUseCase: TrainingsDiaryUseCase
): BaseUseCaseIos() {

    fun observeTrainingsDiaryModel(): FlowWrapper<TrainingsDiaryModel> =
        FlowWrapper(scope, trainingsDiaryUseCase.observeTrainingsDiaryModel())

    fun testFooAsync(onError: () -> Unit) {
        scope.launch {
            val res = trainingsDiaryUseCase.testFoo()
        }
    }

//    fun getMoneySummary(): FlowWrapper<HomeModel> =
//        FlowWrapper(scope, homeUseCase.observeHomeModel())
//
//    fun deleteTransaction(transactionId: Long, onError: (UIErrorMessage) -> Unit) {
//        scope.launch {
//            val result = homeUseCase.deleteTransaction(transactionId)
//            result.doOnError { onError(it) }
//        }
//    }
}