package com.earl.ui.scenes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
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
import com.earl.design_system.theme.MyApplicationTheme
import com.earl.domain.TrainingsDiaryUseCase
import com.earl.domain.models.TrainingSession
import com.earl.ui.TrainingsDiaryViewModel

@Composable
fun TrainingSessionsScene(
    viewModel: TrainingsDiaryViewModel
) {
    var showToast by remember { mutableStateOf(false) }
    val trainingsList: List<TrainingSession> by viewModel.trainings.collectAsState(initial = emptyList())
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            MainScreenStatisticsScene()
            TrainingSessionsListScene(trainingsList)
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(top = 30.dp),
                onClick = {
//                    viewModel.test {
//                        showToast = true
//                    }
                }
            ) {
                Text(text = "Add new training")
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
        TrainingSessionsScene(mockViewModel())
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        TrainingSessionsScene(mockViewModel())
    }
}


private fun mockViewModel() = TrainingsDiaryViewModel(mockTrainingDiaryUseCase())

private fun mockTrainingDiaryUseCase() = object: TrainingsDiaryUseCase {
    override suspend fun getTrainings(): List<TrainingSession> {
        return emptyList()
    }
}