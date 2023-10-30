package com.earl.ui.scenes

import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.common.BaseMapper
import com.earl.design_system.theme.MyApplicationTheme
import com.earl.domain.api.TrainingsDiaryStore
import com.earl.domain.api.TrainingsDiaryUseCase
import com.earl.domain.api.models.TrainingSession
import com.earl.ui.TrainingsDiaryStateUiMapper
import com.earl.ui.TrainingsDiaryViewModel
import com.earl.ui.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrainingSessionsScene() {
    var showToast by remember { mutableStateOf(false) }
    val trainingSessionsViewModel = koinViewModel<TrainingsDiaryViewModel>()
    var state = trainingSessionsViewModel.screenState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            when {
                state.value.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                        color = androidx.compose.ui.graphics.Color.Blue,
                        strokeWidth = 5.dp
                    )
                }
                state.value.trainingSessionsList.isNotEmpty() -> {
                    MainScreenStatisticsScene()
                    TrainingSessionsListScene(state.value.trainingSessionsList)
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                            .padding(top = 30.dp),
                        onClick = {

                        }
                    ) {
                        Text(text = "Add new training")
                    }
                }
                }
            }
        if (showToast) {
            Toast.makeText(
                LocalContext.current,
                "TEST",
                Toast.LENGTH_SHORT).show()
            showToast = false
        }
    }
}

@Preview
@Composable
fun MainScreenScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        TrainingSessionsScene()
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        TrainingSessionsScene()
    }
}