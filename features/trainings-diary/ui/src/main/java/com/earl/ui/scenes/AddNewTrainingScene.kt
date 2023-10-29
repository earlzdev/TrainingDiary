package com.earl.ui.scenes

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.earl.design_system.theme.MyApplicationTheme
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar

@Composable
fun AddNewTrainingScene() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                text = "Добавить новую тренировку"
            )
            Spacer(modifier = Modifier.height(16.dp))
            SetTrainingSessionDate()
            Spacer(modifier = Modifier.height(16.dp))
            SetTrainingSessionTime()
            Spacer(modifier = Modifier.height(16.dp))
            AddTrainingParameter(title = "Description")
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                onClick = {

            }) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
private fun SetTrainingSessionDate() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        var selectedDate by remember { mutableStateOf(LocalDate.now()) }
        val context = LocalContext.current
        Text(text = "Session date: $selectedDate")
        Button(
            onClick = {
                val datePickerDialog = DatePickerDialog(
                    context,
                    { _, year, month, dayOfMonth ->
                        selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                    },
                    selectedDate.year,
                    selectedDate.monthValue - 1,
                    selectedDate.dayOfMonth
                )
                datePickerDialog.show()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Select date")
        }
    }
}

@Composable
private fun SetTrainingSessionTime() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val currentTime = LocalTime.now()
        val startTime = remember { mutableStateOf("${currentTime.hour}:${currentTime.minute}") }
        val context = LocalContext.current
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]
        val timePickerDialog = TimePickerDialog(
            context,
            {_, Hour : Int, Minute: Int ->
                val selectedHour = if (Hour <= 9) {
                    "0$Hour"
                } else {
                    Hour
                }
                val selectedMinute = if (Minute <= 9) {
                    "0$Minute"
                } else {
                    Minute
                }
                startTime.value = "$selectedHour:$selectedMinute"
            }, hour, minute, true
        )
        Text(text = "Session start time: ${startTime.value}")
        Button(onClick = {
            timePickerDialog.show()
        }) {
            Text("Select time")
        }
    }
}

@Composable
private fun AddTrainingParameter(
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(10.dp),
    ) {
        var text by remember { mutableStateOf("") }
        Text(text = title)
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your text") },
            maxLines = 10,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 10.dp)
        )
    }
}

@Preview
@Composable
private fun AddNewTrainingScene_Preview_LightTheme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        AddNewTrainingScene()
    }
}

@Preview
@Composable
private fun AddNewTrainingScene_Preview_DarkTheme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        AddNewTrainingScene()
    }
}