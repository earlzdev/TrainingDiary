package com.earl.myapplication.android.di

import com.earl.myapplication.android.TrainingSessionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {

    viewModel { TrainingSessionsViewModel(get()) }
}