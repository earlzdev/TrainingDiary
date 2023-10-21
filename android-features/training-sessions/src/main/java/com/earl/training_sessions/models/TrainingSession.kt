package com.earl.training_sessions.models

data class TrainingSession(
    val id: String,
    val dateTime: String,
    val title: String,
    val type: String,
    val distance: Int,
    val description: String,
)