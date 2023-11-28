package com.earl.common.mappers

import com.earl.common.ApiResponse

interface BaseApiResponseListMapper<T, V> {

    fun <E> map(from: ApiResponse<List<T>, E>): ApiResponse<List<V>, E>
}