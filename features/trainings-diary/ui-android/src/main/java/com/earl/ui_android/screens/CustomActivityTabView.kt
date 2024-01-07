package com.earl.ui_android.screens

import android.content.Context
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme
import com.earl.shared_resources.SharedResources

private fun ContentDrawScope.drawWithLayer(block: ContentDrawScope.() -> Unit) {
    with(drawContext.canvas.nativeCanvas) {
        val checkPoint = saveLayer(null, null)
        block()
        restoreToCount(checkPoint)
    }
}

@Composable
fun TextSwitch(
    context: Context,
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    items: List<String>,
    onSelectionChange: (Int) -> Unit
) {

    var ind by remember {
        mutableStateOf(selectedIndex)
    }

    BoxWithConstraints(
        modifier
            .padding(8.dp)
            .padding(top = 5.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xfff3f3f2))
            .padding(8.dp)
    ) {
        if (items.isNotEmpty()) {

            val maxWidth = this.maxWidth
            val tabWidth = maxWidth / items.size

            val indicatorOffset by animateDpAsState(
                targetValue = tabWidth * selectedIndex,
                animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
                label = "indicator offset"
            )

            // This is for shadow layer matching white background
            Box(
                modifier = Modifier
                    .offset(x = indicatorOffset)
                    .shadow(4.dp, RoundedCornerShape(15.dp))
                    .width(tabWidth)
                    .fillMaxHeight()
            )

            Row(modifier = Modifier
                .fillMaxWidth()

                .drawWithContent {

                    // This is for setting black tex while drawing on white background
                    val padding = 8.dp.toPx()
                    drawRoundRect(
                        topLeft = Offset(x = indicatorOffset.toPx() + padding, padding),
                        size = Size(size.width / 3 - padding * 2, size.height - padding * 2),
                        color = Color(
                            SharedResources.colors.primary.getColor(context)
                        ),
                        cornerRadius = CornerRadius(x = 8.dp.toPx(), y = 8.dp.toPx()),
                    )

                    drawWithLayer {
                        drawContent()

                        // This is white top rounded rectangle
                        drawRoundRect(
                            topLeft = Offset(x = indicatorOffset.toPx(), 0f),
                            size = Size(size.width / items.size, size.height),
                            color = Color.White,
                            cornerRadius = CornerRadius(x = 15.dp.toPx(), y = 15.dp.toPx()),
                            blendMode = BlendMode.SrcOut
                        )
                    }

                }
            ) {
                items.forEachIndexed { index, text ->
                    Box(
                        modifier = Modifier
                            .width(tabWidth)
                            .fillMaxHeight()
                            .clickable(
                                interactionSource = remember {
                                    MutableInteractionSource()
                                },
                                indication = null,
                                onClick = {
                                    onSelectionChange(index)
                                    ind = index
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = text,
                            fontSize = 16.sp,
                            color = Color.Gray,
                            fontFamily = if (selectedIndex == index) {
                                FontFamily(Font(SharedResources.fonts.Inter.bold.fontResourceId))
                            } else {
                                FontFamily(Font(SharedResources.fonts.Inter.medium.fontResourceId))
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TextSwitch_Light_Theme_Preview() {
    TrainingsDiaryAppTheme(
        darkTheme = false
    ) {
        val activities = remember {
            listOf("Running", "Swimming", "Gym")
        }
        var selectedActivityIndex by remember {
            mutableStateOf(1)
        }


        Column {
            TextSwitch(
                LocalContext.current,
                selectedIndex = selectedActivityIndex,
                items = activities,
                onSelectionChange = {
                    selectedActivityIndex = it
                }
            )
        }
    }
}

@Preview
@Composable
private fun TextSwitch_Dark_Theme_Preview() {
    TrainingsDiaryAppTheme(
        darkTheme = true
    ) {
        val activities = remember {
            listOf("Running", "Swimming", "Gym")
        }
        var selectedActivityIndex by remember {
            mutableStateOf(1)
        }


        Column {
            TextSwitch(
                LocalContext.current,
                selectedIndex = selectedActivityIndex,
                items = activities,
                onSelectionChange = {
                    selectedActivityIndex = it
                }
            )
        }
    }
}