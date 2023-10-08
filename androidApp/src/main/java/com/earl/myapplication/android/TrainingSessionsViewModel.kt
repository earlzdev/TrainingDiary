package com.earl.myapplication.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.earl.myapplication.networking.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrainingSessionsViewModel(
    private val networkClient: NetworkClient
): ViewModel() {

    fun test(l: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            networkClient.doTestRequest()
        }
    }
}