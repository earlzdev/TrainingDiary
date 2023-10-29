package com.earl.myapplication.android

import android.app.Application
import android.content.Context
import com.earl.myapplication.android.di.androidModule
import com.earl.myapplication.di.appModule
import com.earl.myapplication.di.initKoin
import com.earl.training_sessions.di.trainingSessionsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TrainingDiaryAndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()

//        startKoin {
//            androidContext(this@TrainingDiaryAndroidApp)
//            androidLogger()
//            modules(
//                appModule() + androidModule + trainingSessionsModule()
//            )
//        }

//        initKoin(emptyList())

        initKoin(
            module {
                single<Context> { this@TrainingDiaryAndroidApp }
            } + trainingSessionsModule(),
        )
    }
}