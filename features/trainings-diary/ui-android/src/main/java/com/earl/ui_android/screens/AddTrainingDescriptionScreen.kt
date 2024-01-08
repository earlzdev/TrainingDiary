package com.earl.ui_android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.ThemeConstants.horizontalPadding
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme
import com.earl.shared_resources.SharedResources

@Composable
fun AddNewTrainingDescriptionScreen(
    onSaveBtnClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        var descriptionText by rememberSaveable {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
        ) {
            Text(
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 18.dp),
                text = SharedResources.strings.description.getString(context),
                fontFamily = FontFamily(Font(SharedResources.fonts.Inter.semiBold.fontResourceId)),
                fontSize = 18.sp
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(start = horizontalPadding, top = 8.dp, end = horizontalPadding)
                    .background(
                        Color(
                            SharedResources.colors.tv_bg.getColor(context)
                        ),
                        RoundedCornerShape(10.dp)
                    ),
                shape = RoundedCornerShape(10.dp),
                value = descriptionText,
                onValueChange = { descriptionText = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(SharedResources.fonts.Inter.semiBold.fontResourceId)),
                    fontSize = 18.sp
                ),
                placeholder = {
                    Text(SharedResources.strings.enter_description_here.getString(context))
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color(
                        SharedResources.colors.primary.getColor(context)
                    ),
                    focusedIndicatorColor = Color(
                        SharedResources.colors.primary.getColor(context)
                    )
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 30.dp),
                onClick = {
                    onSaveBtnClicked()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    ),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = SharedResources.strings.save.getString(context),
                    fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.semibold.fontResourceId)),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun AddNewDescriptionScreen_Light_Theme_Preview() {
    TrainingsDiaryAppTheme(
        darkTheme = false
    ) {
        AddNewTrainingDescriptionScreen({})
    }
}

@Preview
@Composable
private fun AddNewDescriptionScreen_Dark_Theme_Preview() {
    TrainingsDiaryAppTheme(
        darkTheme = true
    ) {
        AddNewTrainingDescriptionScreen({})
    }
}