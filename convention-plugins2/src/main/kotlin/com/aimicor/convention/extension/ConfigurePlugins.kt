package com.aimicor.convention.extension

import org.gradle.api.plugins.PluginContainer

operator fun PluginContainer.invoke(
    block: PluginContainer.() -> Unit
) = apply(block)
