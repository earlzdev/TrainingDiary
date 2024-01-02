package com.earl.ui_android.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.earl.ui_android.screens.AddNewTrainingDescriptionScreen
import com.earl.ui_android.screens.AddNewTrainingInfoScreen
import com.earl.ui_android.screens.TrainingsDiaryRootScreen

const val TrainingsDiaryGraphPattern = "trainingsDiaryNavGraph"
const val AddTrainingInfoScreenPattern = "addTrainingInfo"
const val AddTrainingDescriptionPattern = "addTrainingDescription"
const val RootTrainingsDiaryScreenPattern = "trainingsDiaryRoot"

fun NavGraphBuilder.trainingsDiaryGraph(
    navController: NavController
) {
    navigation(
        startDestination = RootTrainingsDiaryScreenPattern,
        route = TrainingsDiaryGraphPattern
    ) {
        rootTrainingsDiaryScreen(
            onTrainingCardClick = {
                // TODO: Screen not ready yet
            },
            onAddNewTrainingIconClick = {
                navController.navigate(AddTrainingInfoScreenPattern)
            }
        )
        addTrainingsInfoScreen()
        addTrainingDescriptionScreen()
    }
}

internal fun NavGraphBuilder.rootTrainingsDiaryScreen(
    onTrainingCardClick: () -> Unit,
    onAddNewTrainingIconClick: () -> Unit
) {
    composable(RootTrainingsDiaryScreenPattern) {
        TrainingsDiaryRootScreen(
            onTrainingCardClick,
            onAddNewTrainingIconClick
        )
    }
}

internal fun NavGraphBuilder.addTrainingsInfoScreen(

) {
    composable(AddTrainingInfoScreenPattern) {
        AddNewTrainingInfoScreen()
    }
}

internal fun NavGraphBuilder.addTrainingDescriptionScreen(

) {
    composable(AddTrainingDescriptionPattern) {
        AddNewTrainingDescriptionScreen()
    }
}