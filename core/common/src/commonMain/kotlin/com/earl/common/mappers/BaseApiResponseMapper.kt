package com.earl.common.mappers

import com.earl.common.ApiResponse

interface BaseApiResponseMapper<T, V> {

    fun <E> map(from: ApiResponse<T, E>): ApiResponse<V, E>
}