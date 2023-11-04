package com.earl.domain.implementation

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.earl.common.ErrorModel
import com.earl.domain.api.TrainingsDiaryRepository
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.domain.api.models.TrainingSession

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
        data class SetError(val errorModel: ErrorModel): Message
    }
}