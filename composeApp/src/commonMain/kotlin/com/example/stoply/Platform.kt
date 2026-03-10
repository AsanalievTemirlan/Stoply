package com.example.stoply

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform