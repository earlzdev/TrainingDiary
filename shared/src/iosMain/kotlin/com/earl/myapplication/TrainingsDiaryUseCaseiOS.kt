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
}