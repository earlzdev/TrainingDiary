package com.earl.myapplication.usecases

import com.earl.api.FetchTrainingsUseCase
import com.earl.api.models.TrainingSession
import kotlinx.coroutines.launch

class TrainingsDiaryUseCaseiOS(
    private val trainingsDiaryUseCase: FetchTrainingsUseCase
): BaseUseCaseIos() {

    fun getTrainingSessions(
        onSuccess: (List<TrainingSession>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        scope.launch {
            try {
//                onSuccess(trainingsDiaryUseCase.fetch())
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}