package com.earl.myapplication.android.scenes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.myapplication.android.MyApplicationTheme

@Composable
fun MainScreenStatisticsScene() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            text = "Statistics block"
        )
    }
}

@Preview
@Composable
private fun MainScreenStatisticsScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        MainScreenStatisticsScene()
    }
}

@Preview
@Composable
private fun MainScreenStatisticsScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        MainScreenStatisticsScene()
    }
}