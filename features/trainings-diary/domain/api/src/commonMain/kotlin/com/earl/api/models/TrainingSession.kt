package com.earl.api.models

data class TrainingSession(
    val id: String,
    val dateTime: Long,
    val title: String,
    val type: String,
    val distance: Int,
    val duration: Long,
    val description: String,
    val pulse: Int
)