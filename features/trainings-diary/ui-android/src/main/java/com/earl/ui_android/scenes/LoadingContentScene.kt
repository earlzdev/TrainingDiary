package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.android_design_system.theme.MyApplicationTheme

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
    MyApplicationTheme(
        darkTheme = false
    ) {
        LoadingContentScene()
    }
}

@Preview
@Composable
fun LoadingContentScene_Preview_Dark_Theme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        LoadingContentScene()
    }
}