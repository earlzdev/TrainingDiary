package com.earl.common

interface BaseMapper<T, V> {

    fun map(from: T): V
}