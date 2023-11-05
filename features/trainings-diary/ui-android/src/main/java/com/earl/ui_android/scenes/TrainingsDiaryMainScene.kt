package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.ui_android.TrainingsDiaryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrainingsDiaryMainScene(
    navController: NavController,
) {
    val trainingSessionsViewModel = koinViewModel<TrainingsDiaryViewModel>()
    val state = trainingSessionsViewModel.screenState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            MainScreenStatisticsScene(state.value)
//            TrainingSessionsListScene(state.value)
            TrainingSessionsListScene(MockObjects.successfulLoadedState)
        }
    }
}

@Preview
@Composable
fun MainScreenScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
//        TrainingsDiaryMainScene()
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
//        TrainingsDiaryMainScene()
    }
}