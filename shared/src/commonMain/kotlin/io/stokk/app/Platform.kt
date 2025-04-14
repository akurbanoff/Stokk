package io.stokk.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform