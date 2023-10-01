package com.earl.myapplication.models

data class TrainingSession(
    val id: String,
    val dateTime: String,
    val type: String,
    val distance: Int,
    val description: String,
)
