package com.earl.myapplication.di

import com.earl.api.TrainingsDiaryNetworkApi
import com.earl.data.TrainingsDiaryRepositoryImpl
import com.earl.domain.TrainingsDiaryRepository
import com.earl.domain.TrainingsDiaryUseCase
import com.earl.domain.TrainingsDiaryUseCaseImpl
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

    factory<TrainingsDiaryRepository> { TrainingsDiaryRepositoryImpl(get()) }
    factory<TrainingsDiaryUseCase> { TrainingsDiaryUseCaseImpl(get()) }
}
