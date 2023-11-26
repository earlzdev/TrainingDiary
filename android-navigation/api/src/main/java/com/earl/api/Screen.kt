package com.earl.api

sealed class Screen(
    val route: String,
    val title: String
) {

    object TrainingsDiary: Screen("trainingsDiary", "Trainings Diary")
    object Profile: Screen("profile", "Profile")
    object AddNewTrainingInfo: Screen("add_new_training_info", "Add Training Info")
    object AddNewTrainingDescription: Screen("add_new_training_description", "Add Description")
}


object NavigationRoutes {

    const val TRAINING_DIARY = "Diary"
    const val PROFILE = "Profile"
}