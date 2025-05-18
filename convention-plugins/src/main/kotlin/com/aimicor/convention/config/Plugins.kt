package com.aimicor.convention.config

import com.aimicor.convention.extension.TypePlugin

enum class Plugins(override val key: String): TypePlugin {
    KOTLIN_MULTIPLATFORM("kotlin-multiplatform"),
    ANDROID_LIBRARY("android-library"),
    COMPOSE_COMPILER("compose-compiler"),
    JETBRAINS_COMPOSE("jetbrains-compose")
}