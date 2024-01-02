package com.earl.ui_android.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme
import com.earl.ui_android.TrainingsDiaryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrainingsDiaryRootScreen(
    onTrainingCardClick: () -> Unit,
    onAddNewTrainingIconClick: () -> Unit
) {
    val trainingSessionsViewModel = koinViewModel<TrainingsDiaryViewModel>()
    val uiState = trainingSessionsViewModel.screenState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when {
            uiState.value.isLoading -> LoadingContentScene()
            uiState.value.errorOccurred() -> TrainingDiaryLoadedFailed(error = uiState.value.error!!)
            uiState.value.isSuccessfullyLoaded() -> TrainingsDiaryContentScene(
                content = uiState.value.content,
                onTrainingClick = { onTrainingCardClick.invoke() } ,
                onAddNewTrainingIconClick = onAddNewTrainingIconClick
            )
        }
    }
}

@Preview
@Composable
fun MainScreenScene_LightTheme() {
    TrainingsDiaryAppTheme(
        darkTheme = false
    ) {
        TrainingsDiaryRootScreen({}, {})
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    TrainingsDiaryAppTheme(
        darkTheme = true
    ) {
        TrainingsDiaryRootScreen({}, {})
    }
}