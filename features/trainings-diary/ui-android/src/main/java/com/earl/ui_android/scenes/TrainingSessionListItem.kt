package com.earl.ui_android.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.domain.api.models.TrainingSession
import java.text.DateFormat.getDateTimeInstance
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun TrainingSessionListItem(
    session: TrainingSession
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colors.onBackground),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Text(text = "1 oct")
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        text = "15:45"
                    )
                }
                Text(text = session.duration.toString())
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = session.type)
                Row {
                    Text(text = session.distance.toString())
                    Text(text = session.pulse.toString())
                }
            }
        }
    }
}

@Composable
fun RunningCard(
    session: TrainingSession
) {

}

@Preview
@Composable
fun TrainingSessionListItem_LightTheme() {
    MyApplicationTheme(darkTheme = false) {
        TrainingSessionListItem(MockObjects.trainingSession)
    }
}

@Preview
@Composable
fun TrainingSessionListItem_DarkTheme() {
    MyApplicationTheme(darkTheme = true) {
        TrainingSessionListItem(MockObjects.trainingSession)
    }
}