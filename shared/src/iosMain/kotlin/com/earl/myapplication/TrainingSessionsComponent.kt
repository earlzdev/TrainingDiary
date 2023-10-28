package com.earl.myapplication

import com.earl.api.TrainingSessionsNetworkApi
import com.earl.api.models.TrainingSessionApi
import com.earl.domain.TrainingsDiaryRepositoryImpl
import com.earl.domain.TrainingsDiaryUseCaseImpl
import com.earl.implementation.TrainingSessionsNetworkApiImpl
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class TrainingSessionsComponent: KoinComponent {

    private val trainingSessionsNetworkApi: TrainingSessionsNetworkApi = TrainingSessionsNetworkApiImpl(get())

    val trainingsDiaryRepository = TrainingsDiaryRepositoryImpl()
    val trainingsDiaryUseCase = TrainingsDiaryUseCaseImpl(trainingsDiaryRepository)
    val trainingsDiaryUseCaseiOS = TrainingsDiaryUseCaseiOS(trainingsDiaryUseCase)

    suspend fun doTestRequest(): List<TrainingSessionApi> = trainingSessionsNetworkApi.doRequest()

//    fun trainingsDiaryFlow() = trainingsDiaryUseCase.trainingsDiaryFlow
}