package com.earl.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme
import com.earl.android_navigation.RootNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingsDiaryAppTheme(
                darkTheme = false
            ) {
                RootNavHost()
            }
        }
    }
}