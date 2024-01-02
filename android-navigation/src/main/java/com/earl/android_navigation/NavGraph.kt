package com.earl.android_navigation

import com.earl.ui_android.navigation.TrainingsDiaryGraphPattern

sealed class NavGraph(
    val route: String,
    val title: String
) {

    object TrainingsDiaryNavGraph: NavGraph(TrainingsDiaryGraphPattern, DIARY_TITLE)
    object ProfileNavGraph: NavGraph(ProfileGraphPattern, PROFILE_TITLE)

    private companion object {

        const val DIARY_TITLE = "Diary"
        const val PROFILE_TITLE = "Profile"
    }
}