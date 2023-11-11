package com.earl.ui_android.scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.common.ErrorModel
import com.earl.domain.api.models.TrainingSession
import com.earl.ui_android.UiState
import com.earl.ui_android.utils.MockObjects

@Composable
fun TrainingSessionsListScene(
    uiState: UiState,
    onAddNewTrainingIconClick: () -> Unit,
    onTrainingSessionClick: (TrainingSession) -> Unit
) {
    when {
        uiState.isLoading -> LoadingContentScene()
        uiState.trainingSessionsList.isNotEmpty() ->
            TrainingsSessionsList(
                listItems = uiState.trainingSessionsList,
                onAddNewTrainingIconClick = onAddNewTrainingIconClick,
                onTrainingSessionClick = onTrainingSessionClick
            )
        uiState.error != ErrorModel.None -> {

        }
    }
}

@Composable
private fun TrainingsSessionsList(
    listItems: List<TrainingSession>,
    onAddNewTrainingIconClick: () -> Unit,
    onTrainingSessionClick: (TrainingSession) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Diary:"
            )
            IconButton(
                modifier = Modifier,
                onClick = { onAddNewTrainingIconClick() }
            ) {
                Image(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Training Session",
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
                )
            }
        }
        LazyColumn {
            items(listItems) { session ->
                TrainingSessionListItem(
                    session = session, 
                    onTrainingClick = onTrainingSessionClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun TrainingSessionsListScene_LightTheme() {
    MyApplicationTheme(darkTheme = false) {
        TrainingSessionsListScene(MockObjects.loadingState, {}, {})
    }
}

@Preview
@Composable
private fun TrainingSessionsListScene_DarkTheme() {
    MyApplicationTheme(darkTheme = true) {
        TrainingSessionsListScene(uiState = MockObjects.successfulLoadedState, {}, {})
    }
}



