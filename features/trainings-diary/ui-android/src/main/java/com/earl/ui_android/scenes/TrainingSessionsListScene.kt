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
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.common.ErrorModel
import com.earl.domain.api.models.TrainingSession
import com.earl.ui_android.UiState

@Composable
fun TrainingSessionsListScene(
    uiState: UiState
) {
    when {
        uiState.isLoading -> LoadingContentScene(Modifier)
        uiState.trainingSessionsList.isNotEmpty() ->
            TrainingsSessionsList(uiState.trainingSessionsList)
        uiState.error != ErrorModel.None -> {

        }
    }
}

@Composable
private fun TrainingsSessionsList(
    listItems: List<TrainingSession>
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
            items(listItems) { session ->
                TrainingSessionListItem(session = session)
            }
        }
    }
}

@Preview
@Composable
private fun TrainingSessionsListScene_LightTheme() {
    MyApplicationTheme(darkTheme = false) {
        TrainingSessionsListScene(MockObjects.loadingState)
    }
}

@Preview
@Composable
private fun TrainingSessionsListScene_DarkTheme() {
    MyApplicationTheme(darkTheme = true) {
        TrainingSessionsListScene(uiState = MockObjects.successfulLoadedState)
    }
}



