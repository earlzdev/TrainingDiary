package com.earl.myapplication

import com.earl.api.TrainingsDiaryRepository
import com.earl.api.TrainingsDiaryStatePublisher
import com.earl.api.TrainingsDiaryStore
import com.earl.api.FetchTrainingsUseCase
import com.earl.common.mappers.BaseMapper
import com.earl.data.TrainingsDiaryRepositoryImpl
import com.earl.impl.TrainingsDiaryStatePublisherImpl
import com.earl.data.FetchTrainingsUseCaseImpl
import com.earl.myapplication.di.initKoin
import com.earl.myapplication.uiStates.mappers.TrainingsDiaryUiStateToIosStateMapper
import com.earl.myapplication.uiStates.trainingsDiary.TrainingsDiaryStatePublisheriOS
import com.earl.myapplication.uiStates.trainingsDiary.TrainingsDiaryUiStateiOS
import com.earl.myapplication.usecases.TrainingsDiaryUseCaseiOS
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module

fun initKoiniOS(): KoinApplication = initKoin(emptyList())

actual fun platformModule() = module {

    scope(named(TRAININGS_DIARY_SCOPE_NAME)) {

        scoped<TrainingsDiaryRepository> { TrainingsDiaryRepositoryImpl(get(), get()) }

        scoped<TrainingsDiaryStatePublisher> { TrainingsDiaryStatePublisherImpl(get()) }
        scoped<BaseMapper<TrainingsDiaryStore.State, TrainingsDiaryUiStateiOS>> { TrainingsDiaryUiStateToIosStateMapper() }
        scoped { TrainingsDiaryStatePublisheriOS(get(), get()) }

        scoped<FetchTrainingsUseCase> { FetchTrainingsUseCaseImpl(get()) }
        scoped { TrainingsDiaryUseCaseiOS(get()) }
    }
}

private const val TRAININGS_DIARY_SCOPE_NAME = "TRAININGS_DIARY_SCOPE_NAME"
private const val TRAININGS_DIARY_SCOPE_ID = "TRAININGS_DIARY_SCOPE_ID"

fun Koin.openKoinScope(): Scope {
//    Logger.d { "Opening Koin Scope" }
    return this.createScope(TRAININGS_DIARY_SCOPE_ID, named(TRAININGS_DIARY_SCOPE_NAME))
}

fun Koin.getScope(): Scope {
//    Logger.d { "Getting Koin Scope" }
    return this.getScope(TRAININGS_DIARY_SCOPE_ID)
}

fun Koin.closeScope() {
//    Logger.d { "Closing Koin Scope" }
    this.getScope().close()
}

fun Koin.get(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz)
}

fun Koin.getFromScope(objCClass: ObjCClass): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    val scope = getScope(TRAININGS_DIARY_SCOPE_ID)
    return scope.get(kClazz)
}