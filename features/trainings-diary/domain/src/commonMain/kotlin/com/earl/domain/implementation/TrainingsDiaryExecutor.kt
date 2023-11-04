package com.earl.domain.implementation

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.earl.common.ApiResponse
import com.earl.domain.api.TrainingsDiaryRepository
import com.earl.domain.api.TrainingsDiaryStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal abstract class BaseExecutor<in Intent : Any, in Action : Any, in State : Any, Message : Any, Label : Any>(
    mainContext: CoroutineContext = Dispatchers.Main,
) : CoroutineExecutor<Intent, Action, State, Message, Label>(mainContext = mainContext) {

    final override fun executeIntent(intent: Intent, getState: () -> State) {
        scope.launch {
            suspendExecuteIntent(intent, getState)
        }
    }

    final override fun executeAction(action: Action, getState: () -> State) {
        scope.launch {
            suspendExecuteAction(action, getState)
        }
    }

    open suspend fun suspendExecuteIntent(intent: Intent, getState: () -> State) {}

    open suspend fun suspendExecuteAction(action: Action, getState: () -> State) {}
}

internal class MainExecutor(
    private val repository: TrainingsDiaryRepository,
) : BaseExecutor<TrainingsDiaryStore.Intent, Nothing, TrainingsDiaryStore.State, TrainingsDiaryStoreFactory.Message, Nothing>() {

    override suspend fun suspendExecuteIntent(
        intent: TrainingsDiaryStore.Intent,
        getState: () -> TrainingsDiaryStore.State,
    ) = when (intent) {
        is TrainingsDiaryStore.Intent.Load -> getTrainingSessions()
    }

    private suspend fun getTrainingSessions() {
        dispatch(TrainingsDiaryStoreFactory.Message.SetLoading)
        when(val response = repository.getMockTrainingSessions()) {
            is ApiResponse.Success -> dispatch(
                TrainingsDiaryStoreFactory.Message.SetTrainingsSessionsList(
                    response.data
                )
            )
            is ApiResponse.Failure -> dispatch(
                TrainingsDiaryStoreFactory.Message.SetError(
                    response.errorMessage
                )
            )
            is ApiResponse.Loading -> dispatch(TrainingsDiaryStoreFactory.Message.SetLoading)
            else -> throw IllegalStateException("No such response type")
        }
    }
}
