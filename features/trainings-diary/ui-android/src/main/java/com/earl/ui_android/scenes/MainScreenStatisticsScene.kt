package com.earl.ui_android.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.shared_resources.SharedResources

@Composable
fun QuickStatsBlock() {
    LazyRow {
        items(2) {
            StatisticsCard(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun QuickStatsBlockHeader() {
    Text(
        modifier = Modifier
            .padding(start = 12.dp, top = 15.dp),
        text = "Quick stats:",
        fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.bold.fontResourceId)),
        fontSize = 20.sp
    )
}

@Composable
fun StatisticsCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .height(170.dp)
            .padding(top = 12.dp),
        shape = RoundedCornerShape(7.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .background(
                    Color(
                        SharedResources.colors.primary.getColor(
                            LocalContext.current
                        )
                    ).copy(alpha = 0.6f)
                )
                .padding(horizontal = 12.dp),
        ) {
            QuickStatsPeriodHeader()
            StatisticsFields()
        }
    }
}

@Composable
fun QuickStatsPeriodHeader() {
    Text(
        modifier = Modifier
            .padding(top = 12.dp)
            .drawBehind {
                val strokeWidthPx = 1.dp.toPx()
                val verticalOffset = size.height - 2.sp.toPx()
                drawLine(
                    color = Color.Black,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, verticalOffset),
                    end = Offset(size.width, verticalOffset)
                )
            },
        text = "Weekly 01 - 07.12.2023",
        fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.semibold.fontResourceId)),
        fontSize = 18.sp
    )
}

@Composable
fun StatisticsFields() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        StatisticsRow(field = "Running", value = "34 km")
        StatisticsRow(field = "Swimming", value = "12 km")
        StatisticsRow(field = "Gym", value = "2h 35min")
    }
}

@Composable
private fun StatisticsRow(
    field: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = field,
            fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.semibold.fontResourceId)),
            fontSize = 16.sp
        )
        Text(
            text = value,
            fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.bold.fontResourceId)),
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun StatisticsCard_Preview_Light_Theme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        StatisticsCard(Modifier)
    }
}

@Preview
@Composable
fun StatisticsCard_Preview_Dark_Theme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        StatisticsCard(Modifier)
    }
}