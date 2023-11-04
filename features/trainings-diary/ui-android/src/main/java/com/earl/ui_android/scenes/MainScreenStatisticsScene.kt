package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

@Composable
fun MainScreenStatisticsScene(
    state: UiState
) {
    val modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
    when {
        state.isLoading -> LoadingContentScene(modifier)
        state.error != ErrorModel.None -> {

        }
        state.trainingSessionsList.isNotEmpty() -> {
            Card(
                modifier = modifier
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