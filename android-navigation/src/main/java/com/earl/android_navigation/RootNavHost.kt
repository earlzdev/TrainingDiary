package com.earl.android_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.earl.shared_resources.SharedResources
import com.earl.ui_android.navigation.AddTrainingDescriptionPattern
import com.earl.ui_android.navigation.AddTrainingInfoScreenPattern
import com.earl.ui_android.navigation.RootTrainingsDiaryScreenPattern
import com.earl.ui_android.navigation.TrainingsDiaryGraphPattern
import com.earl.ui_android.navigation.trainingsDiaryGraph

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    var topAppBarTitle by remember { mutableStateOf(NavGraph.TrainingsDiaryNavGraph.title) }
    var toolbarState by remember { mutableStateOf(ToolbarState.EMPTY) }
    var shouldShowBackArrow by remember { mutableStateOf(false) }
    var toolbarOnBackIconClick: (() -> Unit)? by remember { mutableStateOf({}) }
    var toolBarOnActionClick: (() -> Unit)? by remember { mutableStateOf({}) }
    val bottomTabNavGraphs = listOf(NavGraph.TrainingsDiaryNavGraph, NavGraph.ProfileNavGraph)
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            val currentRoute = backStackEntry.destination.route
            topAppBarTitle = getTitleByRootRoute(currentRoute)
            toolbarState = getToolbarActionForRoute(currentRoute)
            shouldShowBackArrow = shouldShowBackBtnInToolbarForRoute(currentRoute)
            toolbarOnBackIconClick = getOnToolbarBackButtonClickAction(currentRoute, navController)
            toolBarOnActionClick = getOnToolbarActionButtonClickAction(currentRoute, navController)
        }
    }
    Scaffold(
        topBar = {
            Toolbar(
                title = topAppBarTitle,
                showBackNavIcon = shouldShowBackArrow,
                action = toolbarState,
                onBackIconClick = { toolbarOnBackIconClick?.invoke() },
                onActionClick = { toolBarOnActionClick?.invoke() }
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(SharedResources.colors.bottom_navbar_bg.getColor(
                    LocalContext.current))
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomTabNavGraphs.forEach { navGraph ->
                    BottomNavigationItem(
                        icon = { Icon(painter = painterResource(id = getBottomNavTabIconForScreen(navGraph.route)), contentDescription = null) },
                        label = { Text(navGraph.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == navGraph.route } == true,
                        onClick = {
                            navController.navigate(navGraph.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                    inclusive = true
                                }
                            }
                        },
                        selectedContentColor = Color(SharedResources.colors.primary.getColor(LocalContext.current)),
                        unselectedContentColor = Color(SharedResources.colors.bottom_navbar_bg_unselected_item_color.getColor(LocalContext.current))
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = TrainingsDiaryGraphPattern, Modifier.padding(innerPadding)) {
            trainingsDiaryGraph(navController)
            profileGraph(navController)
        }
    }
}

private fun getTitleByRootRoute(route:String?): String {
    return when (route) {
        RootTrainingsDiaryScreenPattern -> NavGraph.TrainingsDiaryNavGraph.title
        ProfileScreenPattern -> NavGraph.ProfileNavGraph.title
        AddTrainingInfoScreenPattern -> "Training Information"
        AddTrainingDescriptionPattern -> "Description"
        else -> throw IllegalStateException("No such root route $route for title")
    }
}

private fun getToolbarActionForRoute(route: String?): ToolbarState {
    return when(route) {
        RootTrainingsDiaryScreenPattern -> ToolbarState.EMPTY
        ProfileScreenPattern -> ToolbarState.EMPTY
        AddTrainingInfoScreenPattern -> ToolbarState.NEXT
        AddTrainingDescriptionPattern -> ToolbarState.EMPTY
        else -> throw IllegalStateException("No such ToolbarState for $route")
    }
}

private fun shouldShowBackBtnInToolbarForRoute(route: String?): Boolean {
    return when(route) {
        RootTrainingsDiaryScreenPattern -> false
        ProfileScreenPattern -> false
        AddTrainingInfoScreenPattern -> true
        AddTrainingDescriptionPattern -> true
        else -> throw IllegalStateException("Not specified showing back btn in toolbar for route - $route")
    }
}

private fun getBottomNavTabIconForScreen(screenName: String): Int = when(screenName) {
    TrainingsDiaryGraphPattern -> SharedResources.images.ic_diary_bottomnavbar.drawableResId
    ProfileGraphPattern -> SharedResources.images.ic_profile_bottomnavbar.drawableResId
    else -> throw IllegalStateException("Can not get icon for screen $screenName")
}

private fun getOnToolbarActionButtonClickAction(
    route: String?,
    navController: NavController
): (() -> Unit)? {
    return when(route) {
        RootTrainingsDiaryScreenPattern -> null
        ProfileScreenPattern -> null
        AddTrainingInfoScreenPattern -> { { navController.navigate(AddTrainingDescriptionPattern) } }
        AddTrainingDescriptionPattern -> null
        else -> throw IllegalStateException("Toolbar action not specified for route - $route")
    }
}

private fun getOnToolbarBackButtonClickAction(
    route: String?,
    navController: NavController
): (() -> Unit)? {
    return when(route) {
        RootTrainingsDiaryScreenPattern -> null
        ProfileScreenPattern -> null
        AddTrainingInfoScreenPattern -> { { navController.popBackStack() } }
        AddTrainingDescriptionPattern -> { { navController.popBackStack() } }
        else -> throw IllegalStateException("Toolbar back button action not specified for route - $route")
    }
}

// todo: remove after profile feature would be ready
const val ProfileScreenPattern = "ProfileScreen"
const val ProfileGraphPattern = "ProfileGraphPattern"

fun NavGraphBuilder.profileGraph(
    navController: NavController
) {
    navigation(
        startDestination = ProfileScreenPattern,
        route = ProfileGraphPattern
    ) {
        profileScreen()
    }
}

internal fun NavGraphBuilder.profileScreen() {
    composable(ProfileScreenPattern) {
        ProfileScreenStub()
    }
}

@Composable
fun ProfileScreenStub() {
    Scaffold {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "No ready yet")
        }
    }
}