package com.earl.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.api.NavigationRoutes
import com.earl.api.Screen
import com.earl.api.TrainingsDiaryRouter
import org.koin.androidx.compose.get

@Composable
fun RootScene() {
    val navController = rememberNavController()
    val trainingsDiaryRouter = get<TrainingsDiaryRouter>()
    val bottomTabScreens = listOf(
        NavigationRoutes.TRAINING_DIARY,
        NavigationRoutes.PROFILE
    )
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(com.earl.shared_resources.SharedResources.colors.primary.getColor(
                    LocalContext.current)),
                title = {
                    Text("Trainings Diary")
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(com.earl.shared_resources.SharedResources.colors.bottom_navbar_bg.getColor(
                    LocalContext.current))
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomTabScreens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(painter = painterResource(id = getBottomNavTabIconForScreen(screen)), contentDescription = null) },
                        label = { Text(screen) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen } == true,
                        onClick = {
                            navController.navigate(screen) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        selectedContentColor = Color(com.earl.shared_resources.SharedResources.colors.primary.getColor(
                            LocalContext.current)),
                        unselectedContentColor = Color(com.earl.shared_resources.SharedResources.colors.bottom_navbar_bg_unselected_item_color.getColor(
                            LocalContext.current))
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = NavigationRoutes.TRAINING_DIARY, Modifier.padding(innerPadding)) {

            composable(NavigationRoutes.TRAINING_DIARY) {
                val trainingsDiaryFeatureNavController = rememberNavController()
                NavHost(
                    navController = trainingsDiaryFeatureNavController,
                    startDestination = Screen.TrainingsDiary.route
                ) {
                    composable(Screen.TrainingsDiary.route) { trainingsDiaryRouter.DiaryRoot(trainingsDiaryFeatureNavController) }
                    composable(Screen.AddNewTrainingInfo.route) { trainingsDiaryRouter.AddNewTrainingInfo() }
                }
            }

            composable(NavigationRoutes.PROFILE) { ProfileScreenStub() }
        }
    }
}

private fun getBottomNavTabIconForScreen(screenName: String): Int = when(screenName) {
    NavigationRoutes.TRAINING_DIARY -> com.earl.shared_resources.SharedResources.images.ic_diary_bottomnavbar.drawableResId
    NavigationRoutes.PROFILE -> com.earl.shared_resources.SharedResources.images.ic_profile_bottomnavbar.drawableResId
    else -> throw IllegalStateException("Can not get icon for screen $screenName")
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