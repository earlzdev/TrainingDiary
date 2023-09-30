package com.earl.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform