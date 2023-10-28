package com.earl.myapplication

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseUseCaseIos {

    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
    internal val scope = CoroutineScope(SupervisorJob() + dispatcher)

    fun onDestroy() {
        scope.cancel()
    }
}