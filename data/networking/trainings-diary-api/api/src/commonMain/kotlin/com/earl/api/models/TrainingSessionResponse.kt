package com.earl.api.models

import kotlinx.serialization.Serializable

@Serializable
data class TrainingSessionResponse(
    val id: String,
    val dateTime: Long,
    val title: String,
    val type: String,
    val distance: Int,
    val duration: Long,
    val description: String,
    val pulse: PulseResponse?,
    val fragments: List<TrainingFragmentResponse>
)

@Serializable
data class TrainingFragmentResponse(
    val title: String,
    val description: String,
    val pulse: PulseResponse,
    val type: String
)

@Serializable
data class PulseResponse(
    val min: Int = -1,
    val average: Int = -1,
    val max: Int = -1
)

enum class TrainingFragmentType {

    WARM_UP, MAIN, COOL_DOWN
}