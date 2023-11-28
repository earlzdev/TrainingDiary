package com.earl.myapplication.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.logger.Logger
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.api.TrainingsDiaryRepository
import com.earl.api.TrainingsDiaryStore
import com.earl.api.TrainingsDiaryUseCase
import com.earl.api.models.TrainingSession
import com.earl.api.models.TrainingSessionResponse
import com.earl.common.mappers.BaseApiResponseListMapper
import com.earl.data.TrainingSessionsRemoteToApiResponseMapper
import com.earl.data.TrainingsDiaryRepositoryImpl
import com.earl.impl.TrainingsDiaryStoreFactory
import com.earl.impl.TrainingsDiaryUseCaseImpl
import com.earl.implementation.TrainingsDiaryNetworkApiImpl
import com.earl.myapplication.platformModule
import com.earl.networking_utils.BaseNetworkHttpClientProvider
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

private fun coreModule() = module {

    single<NetworkClientProvider> { BaseNetworkHttpClientProvider() }
    single<TrainingsDiaryNetworkApi> { TrainingsDiaryNetworkApiImpl(get()) }

    factory<TrainingsDiaryRepository> { TrainingsDiaryRepositoryImpl(get(), get()) }
    factory<TrainingsDiaryUseCase> { TrainingsDiaryUseCaseImpl(get()) }

    /**
     * Trainings Diary Feature Dependencies
     */

    factory<TrainingsDiaryStore> {
        TrainingsDiaryStoreFactory(
            storeFactory = get(),
            repository = get(),
        ).create()
    }

    factory<StoreFactory> {
        val logger = object : Logger {
            override fun log(text: String) {
                // TODO: logger mb Timber
            }
        }
        LoggingStoreFactory(DefaultStoreFactory(), logger = logger)
    }

    single<BaseApiResponseListMapper<TrainingSessionResponse, TrainingSession>> {
        TrainingSessionsRemoteToApiResponseMapper()
    }
}
