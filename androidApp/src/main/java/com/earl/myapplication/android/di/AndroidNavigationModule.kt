package com.earl.myapplication.android.di

import com.earl.api.RootRouter
import com.earl.api.TrainingsDiaryRouter
import com.earl.impl.RootRouterImpl
import com.earl.impl.TrainingsDiaryRouterImpl
import org.koin.dsl.module

val androidNavigationModule = module {

    single<RootRouter> { RootRouterImpl() }
    single<TrainingsDiaryRouter> { TrainingsDiaryRouterImpl() }
}