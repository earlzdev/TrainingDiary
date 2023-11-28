package com.earl.impl

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.earl.api.TrainingsDiaryRepository
import com.earl.api.TrainingsDiaryStore
import com.earl.api.models.TrainingSession
import com.earl.common.ApiResponse
import com.earl.common.ErrorResponse

class TrainingsDiaryStoreFactory(
    private val storeFactory: StoreFactory,
    private val repository: TrainingsDiaryRepository
) {

    fun create(): TrainingsDiaryStore = object: TrainingsDiaryStore,
        Store<TrainingsDiaryStore.Intent, TrainingsDiaryStore.State, TrainingsDiaryStore.Label> by storeFactory.create(
            name = TrainingsDiaryStore::class.simpleName,
            initialState = TrainingsDiaryStore.State(),
            bootstrapper = null,
            executorFactory = {
                MainExecutor(repository)
            },
            reducer = TrainingsDiaryReducer(),
        ) {}


    sealed interface Message {

        object SetLoading: Message
        data class SetTrainingsSessionsList(val list: List<TrainingSession>): Message
        data class SetHttpError(val error: ApiResponse.Error.HttpError<ErrorResponse>): Message
        object SetNetworkError: Message
        object SetSerializationError: Message
    }
}