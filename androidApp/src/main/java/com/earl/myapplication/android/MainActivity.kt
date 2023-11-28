package com.earl.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.api.RootRouter
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rootRouter = get<RootRouter>()
            MyApplicationTheme(
                darkTheme = false
            ) {
                rootRouter.Root()
            }
        }
    }
}