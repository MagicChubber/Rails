package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

open class DesktopConfig {
    internal var isPresent = false
    var mainClass: String = ""
    var packageName: String = ""
    var packageVersion: String = ""
}

fun Project.desktopConfig(block: DesktopConfig.() -> Unit) {
    extensions.findByType<DesktopConfig>()!!.apply {
        isPresent = true
        block()
    }
}

