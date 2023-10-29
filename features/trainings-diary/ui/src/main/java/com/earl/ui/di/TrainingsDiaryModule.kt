package com.earl.ui.di

import com.earl.ui.TrainingsDiaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun trainingsDiaryModule() = module {

    viewModel { TrainingsDiaryViewModel(get()) }
}