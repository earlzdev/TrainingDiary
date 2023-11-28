package com.earl.ui_android.scenes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.api.models.TrainingSession
import com.earl.ui_android.utils.IntExtensions.getAsDistanceInKm
import com.earl.ui_android.utils.LongExtensions.getDateAsStringFromMillis
import com.earl.ui_android.utils.LongExtensions.getDurationAsStringFromMillis
import com.earl.ui_android.utils.LongExtensions.getTimeAsStringFromMillis
import com.earl.ui_android.utils.MockObjects

@Composable
fun TrainingSessionListItem(
    session: TrainingSession,
    onTrainingClick: (TrainingSession) -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp)
            .clickable {
                onTrainingClick(session)
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(7.dp),
    ) {
        Row(
            modifier = Modifier
                .background(
                    Color(
                        com.earl.shared_resources.SharedResources.colors.cardBgColor.getColor(LocalContext.current)
                    ).copy(alpha = 0.7f)
                )
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                TrainingSessionTimeLabel(sessionDate = session.dateTime)
                TrainingTypeLabel(sessionType = session.type)
            }
            TrainingShortInfoLabel(session = session)
        }
    }
}

@Composable
private fun TrainingSessionTimeLabel(
    sessionDate: Long
) {
    Row {
        Text(
            text = sessionDate.getDateAsStringFromMillis(),
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.semibold.fontResourceId)),
            fontSize = 14.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            text = sessionDate.getTimeAsStringFromMillis(),
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.semibold.fontResourceId)),
            fontSize = 14.sp
        )
    }
}

@Composable
private fun TrainingTypeLabel(
    sessionType: String
) {
    Row(
        modifier = Modifier
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sessionType,
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.bold.fontResourceId)),
            fontSize = 18.sp
        )
    }
}

@Composable
private fun TrainingShortInfoLabel(
    session: TrainingSession
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TrainingShortInfoBlock(
            iconId = getIconForTraining(sessionType = session.type),
            label = session.distance.getAsDistanceInKm()
        )
        TrainingShortInfoBlock(
            iconId = com.earl.shared_resources.SharedResources.images.ic_round_heart_rate.drawableResId,
            label = session.pulse.toString()
        )
        TrainingShortInfoBlock(
            iconId = com.earl.shared_resources.SharedResources.images.ic_round_timer.drawableResId,
            label = session.duration.getDurationAsStringFromMillis()
        )
    }
}

@Composable
private fun TrainingShortInfoBlock(
    @DrawableRes iconId: Int,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .padding(start = 3.dp),
            painter = painterResource(
                id = iconId
            ),
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(top = 5.dp),
            text = label,
            fontFamily = FontFamily(Font(com.earl.shared_resources.SharedResources.fonts.Montserrat.medium.fontResourceId)),
        )
    }
}

private fun getIconForTraining(
    sessionType: String
): Int = when(sessionType) {
    "Running" -> com.earl.shared_resources.SharedResources.images.ic_round_run.drawableResId
    "Swimming" -> com.earl.shared_resources.SharedResources.images.ic_round_swim.drawableResId
    "Gym" -> com.earl.shared_resources.SharedResources.images.ic_round_gym.drawableResId
    else -> throw IllegalStateException("No such training type! $sessionType")
}

@Preview
@Composable
fun TrainingSessionListItem_LightTheme() {
    MyApplicationTheme(darkTheme = false) {
        TrainingSessionListItem(MockObjects.trainingSession, {})
    }
}

@Preview
@Composable
fun TrainingSessionListItem_DarkTheme() {
    MyApplicationTheme(darkTheme = true) {
        TrainingSessionListItem(MockObjects.trainingSession, {})
    }
}