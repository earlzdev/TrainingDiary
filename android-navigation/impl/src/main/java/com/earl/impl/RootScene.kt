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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.api.NavigationRoutes.PROFILE
import com.earl.api.NavigationRoutes.TRAINING_DIARY
import com.earl.api.Screen
import com.earl.api.TrainingsDiaryRouter
import org.koin.androidx.compose.get

@Composable
fun RootScene() {
    val navController = rememberNavController()
    var topAppBarTitle by remember {
        mutableStateOf(Screen.TrainingsDiary.title)
    }
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            topAppBarTitle = getTitleByRootRoute(backStackEntry.destination.route)
        }
    }
    val trainingsDiaryRouter = get<TrainingsDiaryRouter>()
    val bottomTabScreens = listOf(TRAINING_DIARY, PROFILE)
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(com.earl.shared_resources.SharedResources.colors.primary.getColor(
                    LocalContext.current)),
                title = {
                    Text( text = topAppBarTitle)
                },
                actions = {

                },
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
        NavHost(navController, startDestination = TRAINING_DIARY, Modifier.padding(innerPadding)) {

            composable(TRAINING_DIARY) {
                val diaryNavController = rememberNavController()
                LaunchedEffect(diaryNavController) {
                    diaryNavController.currentBackStackEntryFlow.collect { backStackEntry ->
                        topAppBarTitle = getTitleByDiaryRoute(backStackEntry.destination.route)
                    }
                }
                NavHost(
                    navController = diaryNavController,
                    startDestination = Screen.TrainingsDiary.route
                ) {
                    composable(Screen.TrainingsDiary.route) { trainingsDiaryRouter.DiaryRoot(diaryNavController) }
                    composable(Screen.AddNewTrainingInfo.route) { trainingsDiaryRouter.AddNewTrainingInfo() }
                }
            }

            composable(PROFILE) { ProfileScreenStub() }
        }
    }
}

fun getTitleByDiaryRoute(route:String?): String {
    return when (route) {
        Screen.TrainingsDiary.route -> Screen.TrainingsDiary.title
        Screen.AddNewTrainingInfo.route -> Screen.AddNewTrainingInfo.title
        Screen.AddNewTrainingDescription.route -> Screen.AddNewTrainingDescription.title
        else -> throw IllegalStateException("No such diary route $route for title")
    }
}

fun getTitleByRootRoute(route:String?): String {
    return when (route) {
        TRAINING_DIARY -> Screen.TrainingsDiary.title
        PROFILE -> Screen.Profile.title
        else -> throw IllegalStateException("No such root route $route for title")
    }
}

private fun getBottomNavTabIconForScreen(screenName: String): Int = when(screenName) {
    TRAINING_DIARY -> com.earl.shared_resources.SharedResources.images.ic_diary_bottomnavbar.drawableResId
    PROFILE -> com.earl.shared_resources.SharedResources.images.ic_profile_bottomnavbar.drawableResId
    else -> throw IllegalStateException("Can not get icon for screen $screenName")
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