package com.earl.api

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

interface TrainingsDiaryRouter {

    @Composable
    fun DiaryRoot(navController: NavController)

    @Composable
    fun AddNewTrainingInfo()

    @Composable
    fun AddNewTrainingDescription()
}