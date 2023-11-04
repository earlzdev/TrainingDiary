package com.earl.myapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.earl.api.Screen
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.ui_android.scenes.TrainingsDiaryMainScene

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                RootScene()
            }
        }
    }
}

@Composable
fun RootScene() {
    val navController = rememberNavController()
    val bottomTabScreens = listOf(
        Screen.TrainingsDiary,
        Screen.Profile
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomTabScreens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.TrainingsDiary.route, Modifier.padding(innerPadding)) {
            composable(Screen.TrainingsDiary.route) { TrainingsDiaryMainScene(navController) }
            composable(Screen.Profile.route) { ProfileScreenStub() }
        }
    }
}

@Preview
@Composable
fun RootScene_Preview_Light_Theme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        RootScene()
    }
}


@Preview
@Composable
fun RootScene_Preview_Dark_Theme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        RootScene()
    }
}

@Composable
fun ProfileScreenStub() {
    MyApplicationTheme {
        Scaffold {
            Column(
                modifier = Modifier.padding(it)
            ) {
                Text(text = "No ready yet")
            }
        }
    }
}