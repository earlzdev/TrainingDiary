package com.earl.myapplication.usecases

import com.earl.domain.TrainingsDiaryUseCase
import com.earl.domain.models.TrainingSession
import kotlinx.coroutines.launch

class TrainingsDiaryUseCaseiOS(
    private val trainingsDiaryUseCase: TrainingsDiaryUseCase
): BaseUseCaseIos() {

    fun getTrainingSessions(
        onSuccess: (List<TrainingSession>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        scope.launch {
            try {
                onSuccess(trainingsDiaryUseCase.getTrainings())
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}