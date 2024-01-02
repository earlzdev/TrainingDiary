package com.earl.ui_android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme

@Composable
fun LoadingContentScene() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview
@Composable
fun LoadingContentScene_Preview_Light_Theme() {
    TrainingsDiaryAppTheme(
        darkTheme = false
    ) {
        LoadingContentScene()
    }
}

@Preview
@Composable
fun LoadingContentScene_Preview_Dark_Theme() {
    TrainingsDiaryAppTheme(
        darkTheme = true
    ) {
        LoadingContentScene()
    }
}