package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

open class JsConfig {
    internal var isPresent = false
}

fun Project.jsConfig(block: JsConfig.() -> Unit = {}) {
    extensions.findByType<JsConfig>()!!.apply {
        isPresent = true
        block()
    }
}
