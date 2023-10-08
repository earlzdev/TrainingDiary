package com.earl.myapplication.android.scenes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.myapplication.android.MyApplicationTheme
import com.earl.myapplication.android.TrainingSessionsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TrainingSessionsScene(
    trainingSessionViewModel: TrainingSessionsViewModel = koinViewModel()
) {
    var showToast by remember { mutableStateOf(false) }
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
                    trainingSessionViewModel.test {
                        showToast = true
                    }
                }
            ) {
                Text(text = "Add new training")
            }
        }
        if (showToast) {
            Toast.makeText(
                LocalContext.current,
                "TEST",
                Toast.LENGTH_SHORT).show()
            showToast = false
        }
    }
}

@Preview
@Composable
fun MainScreenScene_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        TrainingSessionsScene()
    }
}

@Preview
@Composable
fun MainScreenScene_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        TrainingSessionsScene()
    }
}