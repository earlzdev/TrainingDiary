package com.earl.training_sessions.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.earl.api.TrainingSessionsNetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrainingSessionsViewModel(
    private val trainingSessionsApi: TrainingSessionsNetworkApi
): ViewModel(){

    fun test(l: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            trainingSessionsApi.doRequest()
        }
    }
}