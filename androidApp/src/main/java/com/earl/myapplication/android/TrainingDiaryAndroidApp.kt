package com.earl.myapplication.android

import android.app.Application
import android.content.Context
import com.earl.myapplication.android.di.androidNavigationModule
import com.earl.myapplication.di.initKoin
import com.earl.ui_android.di.trainingsDiaryModule
import org.koin.dsl.module

class TrainingDiaryAndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            module {
                single<Context> { this@TrainingDiaryAndroidApp }
            } + trainingsDiaryModule() + androidNavigationModule,
        )
    }
}