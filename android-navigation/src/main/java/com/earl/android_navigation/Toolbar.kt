package com.earl.android_navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme
import com.earl.shared_resources.SharedResources

enum class ToolbarState {
    EMPTY, NEXT
}

@Composable
fun Toolbar(
    title: String,
    showBackNavIcon: Boolean,
    action: ToolbarState,
    onBackIconClick: () -> Unit,
    onActionClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color(
            SharedResources.colors.primary.getColor(LocalContext.current)
        ),
        title = {
            Text(
                text = title,
                color = Color.White
            )
        },
        navigationIcon = if (showBackNavIcon) {
            @Composable {
                IconButton(onClick = { onBackIconClick() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        null
                    )
                }
            }
        } else null,
        actions = {
            when(action) {
                ToolbarState.NEXT -> NextButton(
                    onActionClick = onActionClick
                )
                ToolbarState.EMPTY -> {}
            }
        }
    )
}

private @Composable
fun NextButton(
    onActionClick: () -> Unit
) {
    Text(
        modifier = Modifier
            .padding(end = 15.dp)
            .clickable { onActionClick() },
        text = "Next"
    )
}

@Preview
@Composable
fun Toolbar_Preview_Light_Theme() {
    TrainingsDiaryAppTheme(
        darkTheme = false
    ) {
        Toolbar(
            title = "Diary",
            showBackNavIcon = true,
            action = ToolbarState.EMPTY,
            onBackIconClick = {},
            onActionClick = {}
        )
    }
}

@Preview
@Composable
fun Toolbar_Preview_Dark_Theme() {
    TrainingsDiaryAppTheme(
        darkTheme = true
    ) {
        Toolbar(
            title = "Training Info",
            showBackNavIcon = false,
            action = ToolbarState.NEXT,
            onBackIconClick = {},
            onActionClick = {}
        )
    }
}