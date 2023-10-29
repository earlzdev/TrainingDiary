package com.earl.myapplication.di

import com.earl.api.TrainingSessionsNetworkApi
import com.earl.domain.TrainingsDiaryRepository
import com.earl.domain.TrainingsDiaryRepositoryImpl
import com.earl.domain.TrainingsDiaryUseCase
import com.earl.domain.TrainingsDiaryUseCaseImpl
import com.earl.implementation.TrainingSessionsNetworkApiImpl
import com.earl.myapplication.platformModule
import com.earl.networking_utils.BaseNetworkHttpClient
import com.earl.networking_utils.NetworkClientProvider
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(additionalModules: List<Module>): KoinApplication {
    return startKoin {
        modules(additionalModules + platformModule() + coreModule())
    }
}

fun coreModule() = module {

    single { BaseNetworkHttpClient() as NetworkClientProvider }
    single { TrainingSessionsNetworkApiImpl(get()) as TrainingSessionsNetworkApi }

    factory { TrainingsDiaryRepositoryImpl() as TrainingsDiaryRepository }
    factory { TrainingsDiaryUseCaseImpl(get()) as TrainingsDiaryUseCase }
}
