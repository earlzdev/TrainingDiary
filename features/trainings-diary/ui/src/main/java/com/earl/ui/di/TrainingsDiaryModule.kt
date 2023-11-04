package com.earl.ui.di

import com.earl.common.BaseMapper
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.ui.TrainingsDiaryStateUiMapper
import com.earl.ui.TrainingsDiaryViewModel
import com.earl.ui.UiState
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun trainingsDiaryModule() = module {

    single<BaseMapper<TrainingsDiaryStore.State, UiState>> { TrainingsDiaryStateUiMapper() }

    viewModel { TrainingsDiaryViewModel(get(), get()) }
}