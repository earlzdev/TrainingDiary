package com.earl.ui_android.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.earl.api.models.TrainingSession
import com.earl.ui_android.LoadedTrainingSessionContent

@Composable
fun TrainingsDiaryContentScene(
    content: LoadedTrainingSessionContent,
    onTrainingClick: (TrainingSession) -> Unit,
    onAddNewTrainingIconClick: () -> Unit,
) {
    Surface {
        LazyColumn {
            item {
                QuickStatsBlockHeader()
            }
            item {
                QuickStatsBlock()
            }
            item {
                TrainingsListHeader(onAddNewTrainingIconClick = onAddNewTrainingIconClick)
            }
            items(content.trainingsList.trainings) { session: TrainingSession ->
                TrainingSessionListItem(session = session, onTrainingClick = onTrainingClick)
            }
        }
    }
}