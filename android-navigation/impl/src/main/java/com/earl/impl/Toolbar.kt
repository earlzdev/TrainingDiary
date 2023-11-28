package com.earl.impl

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
import androidx.compose.ui.unit.dp
import com.earl.shared_resources.SharedResources

@Composable
fun Toolbar(
    title: String,
    showBackNavIcon: Boolean,
    action: TopAppBarAction,
    onBackIconClick: () -> Unit,
    onActionClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color(
            SharedResources.colors.primary.getColor(LocalContext.current)
        ),
        title = {
            Text(text = title)
        },
        navigationIcon = if (showBackNavIcon) {
            @Composable {
                IconButton(onClick = { onBackIconClick() }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }
        } else null,
        actions = {
            when(action) {
                TopAppBarAction.NEXT -> { Text(
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .clickable { onActionClick() },
                    text = "Next"
                ) }
                TopAppBarAction.EMPTY -> {}
            }
        }
    )
}