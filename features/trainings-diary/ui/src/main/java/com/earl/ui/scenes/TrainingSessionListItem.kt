package com.earl.ui.scenes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.design_system.theme.MyApplicationTheme
import com.earl.domain.models.TrainingSession

@Composable
fun TrainingSessionListItem(
    session: TrainingSession
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(end = 100.dp)
            ) {
                Text(text = session.dateTime)
                Text(text = session.type)
            }
            Text(text = session.distance.toString())
        }
    }
}

@Preview
@Composable
fun TrainingSessionListItem_LightTheme() {
    MyApplicationTheme(darkTheme = false) {
        TrainingSessionListItem(
            TrainingSession(
                "test",
                "01.10.2023 16:42",
                "Title",
                "Running",
                10,
                "Test"
            )
        )
    }
}

@Preview
@Composable
fun TrainingSessionListItem_DarkTheme() {
    MyApplicationTheme(darkTheme = true) {
        TrainingSessionListItem(
            TrainingSession(
                "test",
                "01.10.2023 16:42",
                "Title",
                "Running",
                10,
                "Test"
            )
        )
    }
}