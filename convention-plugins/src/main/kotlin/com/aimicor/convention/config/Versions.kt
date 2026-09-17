package com.aimicor.convention.config

import com.aimicor.convention.extension.TypeVersion

enum class Versions(override val key: String): TypeVersion {
    COMPILE_SDK("android-compileSdk"),
    MIN_SDK("android-minSdk"),
    JVM_TARGET("jvm-target"),
    JAVA("java"),
    TARGET_SDK("android-targetSdk"),
    LIBRARY_GROUP("library-group"),
    LIBRARY_VERSION("library-version"),
}
