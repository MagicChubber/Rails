package com.aimicor.convention.config

import com.aimicor.convention.extension.TypePlugin

enum class Plugins(override val key: String): TypePlugin {
    KOTLIN_MULTIPLATFORM("kotlin-multiplatform"),
    ANDROID_APPLICATION("android-application"),
    ANDROID_LIBRARY("android-kotlin-multiplatform-library"),
    COMPOSE_COMPILER("compose-compiler"),
    JETBRAINS_COMPOSE("jetbrains-compose"),
    COMPOSE_HOT_RELOAD("compose-hot-reload"),
}