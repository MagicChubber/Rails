package com.aimicor.convention.ext

import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer

fun Project.plugins(
    block: PluginContainer.() -> Unit
): PluginContainer = plugins.apply(block)
