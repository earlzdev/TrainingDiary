package com.earl.training_sessions.di

import com.earl.training_sessions.ui.TrainingSessionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun trainingSessionsModule() = module {

    viewModel { TrainingSessionsViewModel(get()) }

}