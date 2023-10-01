package com.earl.myapplication.android.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.myapplication.android.MyApplicationTheme

@Composable
fun MainScreenScene() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            MainScreenStatisticsScene()
            TrainingSessionsListScene(MockData.trainingSessionsList)
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(top = 30.dp),
                onClick = {

                }
            ) {
                Text(text = "Add new training")
            }
        }
    }
}

@Preview
@Composable
fun MainScreenScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        MainScreenScene()
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        MainScreenScene()
    }
}