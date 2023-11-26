package com.earl.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.earl.api.TrainingsDiaryRouter
import com.earl.ui_android.scenes.AddNewTrainingDescriptionScene
import com.earl.ui_android.scenes.AddNewTrainingInfoScene
import com.earl.ui_android.scenes.TrainingsDiaryRootScene

class TrainingsDiaryRouterImpl: TrainingsDiaryRouter {

    @Composable
    override fun DiaryRoot(navController: NavController) {
        TrainingsDiaryRootScene(navController)
    }

    @Composable
    override fun AddNewTrainingInfo() {
        AddNewTrainingInfoScene()
    }

    @Composable
    override fun AddNewTrainingDescription() {
        AddNewTrainingDescriptionScene()
    }
}