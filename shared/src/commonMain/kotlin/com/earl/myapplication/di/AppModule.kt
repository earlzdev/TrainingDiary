package com.earl.myapplication.di

import com.earl.api.TrainingSessionsNetworkApi
import com.earl.domain.TrainingsDiaryRepository
import com.earl.domain.TrainingsDiaryRepositoryImpl
import com.earl.domain.TrainingsDiaryUseCase
import com.earl.domain.TrainingsDiaryUseCaseImpl
import com.earl.implementation.TrainingSessionsNetworkApiImpl
import com.earl.networking_utils.BaseNetworkHttpClient
import com.earl.networking_utils.NetworkClientProvider
import org.koin.dsl.module

fun appModule() = module {
    single { BaseNetworkHttpClient() as NetworkClientProvider }
    single { TrainingSessionsNetworkApiImpl(get()) as TrainingSessionsNetworkApi }

    single { TrainingsDiaryRepositoryImpl() as TrainingsDiaryRepository }
    single { TrainingsDiaryUseCaseImpl(get()) as TrainingsDiaryUseCase }
}