package com.earl.ui_android.scenes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.android_design_system.theme.MyApplicationTheme
import com.earl.shared_resources.SharedResources
import com.earl.ui_android.utils.getFont

@Composable
fun AddNewTrainingInfoScene() {
    val context = LocalContext.current
    var titleText by rememberSaveable {
        mutableStateOf(SharedResources.strings.training_title_hint.getString(context))
    }
    var descriptionText by remember {
        mutableStateOf("")
    }
    Surface {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Add new training",
                fontFamily = getFont(SharedResources.fonts.Montserrat.semibold, LocalContext.current),
                fontSize = 18.sp
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                value = titleText,
                onValueChange = {
                    titleText = it
                },
                label = {
                    Text("Training title")
                }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Text(text = "Select training date: ")
                    Text(text = "Date")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Select date")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Text(text = "Select training time: ")
                    Text(text = "Time")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Select time")
                }
            }
            DropDownMenu()
            TrainingInfo()

            OutlinedTextField(
                value = descriptionText,
                onValueChange = { descriptionText = it },
                label = { Text ("Description") },
                minLines = 10,
                maxLines = 10,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            )
            Button(
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 15.dp, bottom = 40.dp),
                onClick = { /*TODO*/ }
            ) {
                Text("Next")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val coffeeDrinks = arrayOf("Running", "Swimming", "Gym")
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select training type:")

            Spacer(modifier = Modifier.width(30.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                TextField(
                    value = selectedText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    coffeeDrinks.forEach { item ->
                        DropdownMenuItem(onClick = {
                            selectedText = item
                            expanded = false
                        }) {
                            Text(text = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TrainingInfo() {
    Column(
        modifier = Modifier
            .padding(top = 15.dp)
    ) {
        TrainingInfoPiece(title = "Duration, min")
        TrainingInfoPiece(title = "Average pulse")
    }
}

@Composable
private fun TrainingInfoPiece(
    title: String,
) {
    var inputValue by remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = (title))
        OutlinedTextField(
            modifier = Modifier
                .width(100.dp),
            value = inputValue,
            label = { Text ("Value") },
            onValueChange = {
                inputValue = it
            },
            textStyle = TextStyle(fontSize = 16.sp)
        )
    }
}

@Preview
@Composable
fun AddNewTrainingInfoScene_Preview_Light_Theme() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        AddNewTrainingInfoScene()
    }
}

@Preview
@Composable
fun AddNewTrainingInfoScene_Preview_Dark_Theme() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        AddNewTrainingInfoScene()
    }
}