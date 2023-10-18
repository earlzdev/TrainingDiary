package com.earl.networking_utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform