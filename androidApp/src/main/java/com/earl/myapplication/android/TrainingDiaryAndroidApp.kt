package com.earl.myapplication.android

import android.app.Application
import com.earl.myapplication.android.di.androidModule
import com.earl.myapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TrainingDiaryAndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TrainingDiaryAndroidApp)
            androidLogger()
            modules(appModule() + androidModule)
        }
    }
}