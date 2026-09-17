package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

open class WasmJsConfig {
    internal var isPresent = false
}

fun Project.wasmJsConfig(block: WasmJsConfig.() -> Unit = {}) {
    extensions.findByType<WasmJsConfig>()!!.apply {
        isPresent = true
        block()
    }
}
