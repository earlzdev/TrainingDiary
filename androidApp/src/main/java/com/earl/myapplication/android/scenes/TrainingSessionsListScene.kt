package com.earl.myapplication.android.scenes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.earl.myapplication.android.MyApplicationTheme
import com.earl.myapplication.models.TrainingSession

@Composable
fun TrainingSessionsListScene(
    sessionsList: List<TrainingSession>
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn {
            items(sessionsList) { session ->
                TrainingSessionListItem(session = session)
            }
        }
    }
}

@Preview
@Composable
private fun TrainingSessionsListScene_LightTheme() {
    MyApplicationTheme(darkTheme = false) {
        TrainingSessionsListScene(MockData.trainingSessionsList)
    }
}

@Preview
@Composable
private fun TrainingSessionsListScene_DarkTheme() {
    MyApplicationTheme(darkTheme = true) {
        TrainingSessionsListScene(MockData.trainingSessionsList)
    }
}

internal object MockData {
    val trainingSessionsList = listOf(
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Running", 10, "Test"),
    )
}


