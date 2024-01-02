package com.earl.ui_android.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.earl.api.models.ErrorModel
import com.earl.common.ErrorResponse
import com.earl.shared_resources.SharedResources

@Composable
fun TrainingDiaryLoadedFailed(
    error: ErrorModel<ErrorResponse>
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = "An error had occurred:",
                fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.semibold.fontResourceId)),
                fontSize = 18.sp
            )
            Text(
                text = parseErrorTextFromErrorModel(error),
                fontFamily = FontFamily(Font(SharedResources.fonts.Montserrat.semibold.fontResourceId)),
                fontSize = 16.sp
            )
        }
    }
}

private fun parseErrorTextFromErrorModel(error: ErrorModel<ErrorResponse>): String {
    return error.msg ?: error.code.toString() ?: error.body?.errorMsg ?: ""
}