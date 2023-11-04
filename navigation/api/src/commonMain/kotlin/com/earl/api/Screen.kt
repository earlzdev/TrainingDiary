package com.earl.api

sealed class Screen(
    val route: String,
    val title: String
) {

    object TrainingsDiary: Screen("trainingsDiary", "Trainings Diary")
    object Profile: Screen("profile", "Profile")
}
