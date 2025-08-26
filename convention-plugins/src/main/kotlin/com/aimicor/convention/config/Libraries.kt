package com.aimicor.convention.config

import com.aimicor.convention.extension.TypeLibrary

enum class Libraries(override val key: String): TypeLibrary {
    KOTLIN_TEST("kotlin-test"),
    KOTLIN_COROUTINES_TEST("kotlinx-coroutines-test"),
    TURBINE("turbine"),
    PREVIEW_DESKTOP("ui-tooling-preview-desktop"),
    PREVIEW("ui-tooling-preview")
}