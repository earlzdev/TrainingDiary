package com.earl.ui_android.scenes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.domain.api.models.TrainingSession
import com.earl.ui_android.utils.IntExtensions.getAsDistanceInKm
import com.earl.ui_android.utils.LongExtensions.getDateAsStringFromMillis
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
            .padding(8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp), 
        border = BorderStroke(2.dp, MaterialTheme.colors.onSurface)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 13.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TrainingSessionTimeLabel()
                Text(
                    text = session.duration.toString(),
                    fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.semibold.fontResourceId)),
                    fontSize = 15.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TrainingTypeLabel(sessionType = session.type)
                TrainingShortInfoLabel(session)
            }
        }
    }
}

@Composable
private fun TrainingSessionTimeLabel(

) {
    Row {
        Text(
            text = "1 oct",
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.bold.fontResourceId)),
            fontSize = 14.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = "15:45",
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.bold.fontResourceId)),
            fontSize = 14.sp
        )
    }
}

@Composable
private fun TrainingTypeLabel(
    sessionType: String
) {
    val trainingTypeIconId = when(sessionType) {
        "Running" -> com.earl.shared_resources.SharedResources.images.ic_run.drawableResId
        "Swimming" -> com.earl.shared_resources.SharedResources.images.ic_swim.drawableResId
        "Gym" -> com.earl.shared_resources.SharedResources.images.ic_gym.drawableResId
        else -> throw IllegalStateException("No such training type! $sessionType")
    }
    Row(
        modifier = Modifier
            .padding(top = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sessionType,
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.bold.fontResourceId)),
            fontSize = 17.sp
        )
        Image(
            modifier = Modifier
                .size(32.dp)
                .padding(start = 8.dp),
            painter = painterResource(id = trainingTypeIconId),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
}

@Composable
private fun TrainingShortInfoLabel(
    session: TrainingSession
) {
    Row(
        modifier = Modifier
            .padding(top = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = session.distance.getAsDistanceInKm(),
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.semibold.fontResourceId)),
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 9.dp),
            text = session.pulse.toString(),
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.semibold.fontResourceId)),
            fontSize = 15.sp
        )
        Image(
            modifier = Modifier
                .size(24.dp)
                .padding(start = 3.dp),
            painter = painterResource(
                id = com.earl.shared_resources.SharedResources.images.ic_heart_rate.drawableResId
            ),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
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