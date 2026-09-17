package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

open class IosConfig {
    internal var isPresent = false
    var baseName: String = ""
}

fun Project.iosConfig(block: IosConfig.() -> Unit) {
    extensions.findByType<IosConfig>()!!.apply {
        isPresent = true
        block()
    }
}

