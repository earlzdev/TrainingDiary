package com.earl.myapplication

import com.earl.api.TrainingSessionsNetworkApi
import com.earl.api.models.TrainingSessionApi
import com.earl.implementation.TrainingSessionsNetworkApiImpl
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class TrainingSessionsComponent: KoinComponent {

    private val trainingSessionsNetworkApi: TrainingSessionsNetworkApi = TrainingSessionsNetworkApiImpl(get())
    suspend fun doTestRequest(): List<TrainingSessionApi> = trainingSessionsNetworkApi.doRequest()
}