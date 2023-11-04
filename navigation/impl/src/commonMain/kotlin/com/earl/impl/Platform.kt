package com.earl.impl

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform