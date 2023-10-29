package com.earl.myapplication

import com.earl.data.TrainingsDiaryRepositoryImpl
import com.earl.domain.TrainingsDiaryRepository
import com.earl.domain.TrainingsDiaryUseCase
import com.earl.domain.TrainingsDiaryUseCaseImpl
import com.earl.myapplication.di.initKoin
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

//        scoped<TrainingsDiaryNetworkApi> { TrainingsDiaryNetworkApiImpl(get()) }
        scoped<TrainingsDiaryRepository> { TrainingsDiaryRepositoryImpl(get()) }

        scoped<TrainingsDiaryUseCase> { TrainingsDiaryUseCaseImpl(get()) }
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