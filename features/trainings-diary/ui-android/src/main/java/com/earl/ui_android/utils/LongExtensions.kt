package com.earl.ui_android.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

object LongExtensions {

    fun Long.getTimeAsStringFromMillis(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = this
        val sdf = SimpleDateFormat("hh:mm", Locale.US)
        return sdf.format(calendar.time)
    }

    fun Long.getDateAsStringFromMillis(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = this
        val trainingSessionYear = calendar.get(Calendar.YEAR)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return if (trainingSessionYear == currentYear) {
            val sdf = SimpleDateFormat("dd MMMM", Locale.US)
            sdf.format(calendar.time)
        } else {
            val sdf = SimpleDateFormat("dd MMM yyyy", Locale.US)
            sdf.format(calendar.time)
        }
    }

    fun Long.getDurationAsStringFromMillis(): String {
        val hours = TimeUnit.MILLISECONDS.toHours(this)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(this) % 60
        return "${hours}h ${minutes}min"
    }
}