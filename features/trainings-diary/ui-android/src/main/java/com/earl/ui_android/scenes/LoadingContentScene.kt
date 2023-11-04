package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.android_design_system.theme.MyApplicationTheme

@Composable
fun LoadingContentScene(
    modifier: Modifier
) {
    Surface(
        modifier = modifier,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            strokeWidth = 5.dp
        )
    }
}

@Preview
@Composable
fun LoadingContentScene_Preview_Light_Theme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        LoadingContentScene(Modifier)
    }
}

@Preview
@Composable
fun LoadingContentScene_Preview_Dark_Theme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        LoadingContentScene(Modifier)
    }
}