package com.minhky.testworker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform