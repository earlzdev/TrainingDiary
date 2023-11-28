package com.earl.api.models

data class ErrorModel<T>(
    val code: Int? = null,
    val body: T? = null,
    val msg: String? = null
)
