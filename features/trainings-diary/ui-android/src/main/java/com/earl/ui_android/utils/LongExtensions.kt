package com.earl.ui_android.utils

import java.text.DateFormat.getDateTimeInstance
import java.util.Calendar
import java.util.concurrent.TimeUnit

object LongExtensions {

    fun Long.getTimeAsStringFromMillis(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = this
        val formatter = getDateTimeInstance().format("hh:mm")
        return formatter.format(calendar.time)
    }

    fun Long.getDateAsStringFromMillis(): String {
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = this
        val trainingSessionYear = calendar.get(Calendar.YEAR)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return if (trainingSessionYear == currentYear) {
            val formatter = getDateTimeInstance().format("dd MM")
            formatter.format(calendar.time)
        } else {
            val formatter = getDateTimeInstance().format("dd MM yyyy")
            formatter.format(calendar.time)
        }
    }

    fun Long.getDurationAsStringFromMillis(): String {
        val hours = TimeUnit.MILLISECONDS.toHours(this)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(this) % 60
        return "${hours}h ${minutes}min"
    }
}