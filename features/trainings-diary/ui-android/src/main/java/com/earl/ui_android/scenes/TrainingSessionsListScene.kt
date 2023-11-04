package com.earl.ui_android.scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.earl.design_system.theme.MyApplicationTheme
import com.earl.domain.api.models.TrainingSession

@Composable
fun TrainingSessionsListScene(
    sessionsList: List<TrainingSession>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            modifier = Modifier,
            onClick = {  }
        ) {
            Image(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Training Session"
            )
        }
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
        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
//        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
//        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
//        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
//        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
//        TrainingSession("test", "01.10.2023 16:42", "Test title", "Running", 10, "Test"),
    )
}


