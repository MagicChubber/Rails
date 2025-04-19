package com.aimicor.convention.config

enum class TypeVersion(val key: String) {
    NAMESPACE("namespace"),
    COMPILE_SDK("android-compileSdk"),
    MIN_SDK("android-minSdk"),
    TARGET_SDK("android-targetSdk"),
    JVM_TARGET("jvm-target"),
    JAVA("java"),
    ANDROID_KOTLIN_JVM("android-kotlin-jvm")
}
