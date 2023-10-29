package com.earl.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.earl.domain.TrainingsDiaryUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class TrainingsDiaryViewModel(
    private val trainingsDiaryUseCase: TrainingsDiaryUseCase
): ViewModel() {

    val trainings = flow {
        try {
            emit(trainingsDiaryUseCase.getTrainings())
        } catch (e: Exception) {
            Log.d("TAG1", "trainings exc -> $e")
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}