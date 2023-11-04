package com.earl.common

sealed class ErrorModel {

    object Unknown: ErrorModel()

    object None: ErrorModel()

    data class NetworkError(
        val code: Int = -1,
        val message: String = ""
    ): ErrorModel()
}

