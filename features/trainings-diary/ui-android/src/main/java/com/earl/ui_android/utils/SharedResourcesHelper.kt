package com.earl.ui_android.utils

import android.content.Context
import androidx.compose.ui.text.font.FontFamily
import dev.icerock.moko.resources.FontResource


fun getFont(font: FontResource, context: Context): FontFamily {
    val typeFace = font.getTypeface(context)
    return FontFamily(typeFace!!)
}