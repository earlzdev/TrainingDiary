package com.earl.api.models

import kotlinx.serialization.Serializable

@Serializable
data class TrainingSessionApi(
    val id: String,
    val dateTime: String,
    val title: String,
    val type: String,
    val distance: Int,
    val description: String,
)
