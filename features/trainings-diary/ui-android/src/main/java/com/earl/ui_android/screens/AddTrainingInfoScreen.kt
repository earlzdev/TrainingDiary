package com.earl.ui_android.screens

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.ThemeConstants.horizontalPadding
import com.earl.android_design_system.theme.ThemeConstants.topFromToolbarPadding
import com.earl.android_design_system.theme.TrainingsDiaryAppTheme
import com.earl.shared_resources.SharedResources
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

@Composable
fun AddNewTrainingInfoScreen() {
    val context = LocalContext.current
    var titleText by rememberSaveable {
        mutableStateOf("")
    }
    var duration by rememberSaveable {
        mutableStateOf("")
    }
    var pulse by rememberSaveable {
        mutableStateOf("")
    }
    val activities = remember {
        listOf("Running", "Swimming", "Gym")
    }
    var selectedActivityIndex by rememberSaveable {
        mutableStateOf(1)
    }
    var selectedDate by rememberSaveable {
        mutableStateOf(getCurrentDateAsString())
    }
    var selectedTime by rememberSaveable {
        mutableStateOf(getCurrentTimeAsString())
    }
    val date = LocalDate.now()
    val time = LocalTime.NOON
    val dateDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            val day = if (dayOfMonth < 9) {
                "0$dayOfMonth"
            } else "$dayOfMonth"
            val monthString = if (month < 9) {
                "0${month + 1}"
            } else "${month + 1}"
            selectedDate = "$day-$monthString-$year"
        },
        date.year,
        date.monthValue - 1,
        date.dayOfMonth,
    )
    val timeDialog = TimePickerDialog(
        LocalContext.current,
        { _, hourOfDay, minute ->
            val hour = if (hourOfDay < 9) {
                "0$hourOfDay"
            } else "$hourOfDay"
            val min = if (minute < 9) {
                "0$minute"
            } else "$minute"
            selectedTime = "$hour:$min" },
        time.hour,
        time.minute,
        true
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color.White)
        ) {
            Text(
                modifier = Modifier
                    .padding(start = horizontalPadding, top = topFromToolbarPadding),
                text = SharedResources.strings.title.getString(context),
                fontFamily = FontFamily(Font(SharedResources.fonts.Inter.semiBold.fontResourceId)),
                fontSize = 18.sp
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = horizontalPadding,
                        top = 16.dp,
                        end = horizontalPadding
                    ),
                value = titleText,
                maxLines = 1,
                onValueChange = {
                    titleText = it
                },
                placeholder = {
                    Text(SharedResources.strings.training_title_hint.getString(context))
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    ),
                    focusedIndicatorColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    )
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 18.dp),
                text = SharedResources.strings.activity.getString(context),
                fontFamily = FontFamily(Font(SharedResources.fonts.Inter.semiBold.fontResourceId)),
                fontSize = 18.sp
            )
            TextSwitch(
                context = LocalContext.current,
                selectedIndex = selectedActivityIndex,
                items = activities,
                onSelectionChange = {
                    selectedActivityIndex = it
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = SharedResources.strings.date.getString(context),
                        fontFamily = FontFamily(Font(SharedResources.fonts.Inter.semiBold.fontResourceId)),
                        fontSize = 14.sp
                    )
                    TextField(
                        modifier = Modifier
                            .width(200.dp)
                            .padding(horizontal = horizontalPadding),
                        value = selectedDate,
                        onValueChange = {
                            selectedDate = it
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                dateDialog.show()
                            }) {
                                Icon(
                                    Icons.Outlined.DateRange,
                                    null
                                )
                            }
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            cursorColor = Color(
                                SharedResources.colors.primary.getColor(LocalContext.current)
                            ),
                            focusedIndicatorColor = Color(
                                SharedResources.colors.primary.getColor(LocalContext.current)
                            )
                        ),
                        enabled = false,
                        readOnly = true
                    )
                }
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = SharedResources.strings.time.getString(context),
                        fontFamily = FontFamily(Font(SharedResources.fonts.Inter.semiBold.fontResourceId)),
                        fontSize = 14.sp
                    )
                    TextField(
                        modifier = Modifier
                            .width(200.dp)
                            .padding(horizontal = horizontalPadding),
                        value = selectedTime,
                        onValueChange = {
                            selectedTime = it
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                timeDialog.show()
                            }) {
                                Icon(
                                    Icons.Outlined.Edit,
                                    null
                                )
                            }
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            cursorColor = Color(
                                SharedResources.colors.primary.getColor(LocalContext.current)
                            ),
                            focusedIndicatorColor = Color(
                                SharedResources.colors.primary.getColor(LocalContext.current)
                            )
                        ),
                        enabled = false,
                        readOnly = true
                    )
                }
            }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 8.dp),
                value = duration,
                onValueChange = {
                    duration = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    ),
                    focusedIndicatorColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    ),
                    focusedLabelColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    )
                ),
                label = {
                    Text(SharedResources.strings.duration_min.getString(context))
                }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(top = 8.dp),
                value = pulse,
                onValueChange = {
                    pulse = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    ),
                    focusedIndicatorColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    ),
                    focusedLabelColor = Color(
                        SharedResources.colors.primary.getColor(LocalContext.current)
                    )
                ),
                label = {
                    Text(SharedResources.strings.average_pulse.getString(context))
                }
            )
        }
    }
}

@SuppressLint("SimpleDateFormat")
private fun getCurrentDateAsString(): String {
    val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    return simpleDateFormat.format(Date())
}

@SuppressLint("SimpleDateFormat")
private fun getCurrentTimeAsString(): String {
    val simpleDateFormat = SimpleDateFormat("hh:mm")
    return simpleDateFormat.format(Date())
}

@Preview
@Composable
fun AddNewTrainingInfoScene_Preview_Light_Theme() {
    TrainingsDiaryAppTheme(
        darkTheme = false
    ) {
        AddNewTrainingInfoScreen()
    }
}

@Preview
@Composable
fun AddNewTrainingInfoScene_Preview_Dark_Theme() {
    TrainingsDiaryAppTheme(
        darkTheme = true
    ) {
        AddNewTrainingInfoScreen()
    }
}