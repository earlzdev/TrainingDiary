package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.common.ErrorModel
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.ui_android.UiState
import com.earl.ui_android.utils.MockObjects

@Composable
fun MainScreenStatisticsScene(
    state: UiState
) {
    when {
        state.isLoading -> LoadingContentScene()
        state.error != ErrorModel.None -> StatisticsLoadingError()
        state.trainingSessionsList.isNotEmpty() -> StatisticsCard()
    }
}

@Composable
private fun StatisticsLoadingError() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "An unknown error occured"
            )
        }
    }
}

@Composable
private fun StatisticsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Weekly kilometers: %s"
            )
            Text(
                text = "Monthly kilometers: %s"
            )
            Text(
                text = "Sessions count: %s"
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenStatisticsScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        MainScreenStatisticsScene(MockObjects.successfulLoadedState)
    }
}

@Preview
@Composable
private fun MainScreenStatisticsScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        MainScreenStatisticsScene(MockObjects.loadingState)
    }
}

@Preview
@Composable
private fun MainScreenStatisticsScene_Error_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        MainScreenStatisticsScene(UiState(error = ErrorModel.Unknown))
    }
}