package com.earl.ui_android

import androidx.lifecycle.ViewModel
import com.arkivanov.mvikotlin.core.binder.Binder
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.earl.api.TrainingsDiaryStore
import com.earl.common.BaseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class TrainingsDiaryViewModel(
    private val store: TrainingsDiaryStore,
    private val stateMapper: BaseMapper<TrainingsDiaryStore.State, UiState>
): ViewModel() {

    private val _screenState = MutableStateFlow(UiState())
    val screenState: StateFlow<UiState>
        get() = _screenState.asStateFlow()

    private val binder: Binder

    init {
        binder = bind(Dispatchers.Main.immediate) {
            store.states.map(stateMapper::map) bindTo (::acceptState)
        }
        binder.start()
        loadTrainingSessions()
    }

    private fun acceptState(state: UiState) {
        _screenState.tryEmit(state)
    }

    private fun loadTrainingSessions() = store.accept(TrainingsDiaryStore.Intent.Load)

    override fun onCleared() {
        super.onCleared()
        binder.stop()
        store.dispose()
    }
}
