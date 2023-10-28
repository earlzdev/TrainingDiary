package com.earl.myapplication

import com.earl.myapplication.di.appModule
import org.koin.core.context.startKoin

class KoinHelper {

    fun initKoin(){
        startKoin {
            modules(appModule())
        }
    }
}