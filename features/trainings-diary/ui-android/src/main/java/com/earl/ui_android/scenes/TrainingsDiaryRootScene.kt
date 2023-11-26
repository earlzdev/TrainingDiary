package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.common.ErrorModel
import com.earl.api.Screen
import com.earl.ui_android.TrainingsDiaryViewModel
import com.earl.ui_android.successfullyLoaded
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrainingsDiaryRootScene(
    navController: NavController,
) {
    val trainingSessionsViewModel = koinViewModel<TrainingsDiaryViewModel>()
    val uiState = trainingSessionsViewModel.screenState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when {
            uiState.value.isLoading -> LoadingContentScene()
            uiState.value.error != ErrorModel.None -> {}
            uiState.value.content.successfullyLoaded() -> TrainingsDiaryContentScene(
                content = uiState.value.content,
                onTrainingClick = {},
                onAddNewTrainingIconClick = { navController.navigate(Screen.AddNewTrainingInfo.route) }
            )
        }
    }
}

@Preview
@Composable
fun MainScreenScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        TrainingsDiaryRootScene(rememberNavController())
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        TrainingsDiaryRootScene(rememberNavController())
    }
}