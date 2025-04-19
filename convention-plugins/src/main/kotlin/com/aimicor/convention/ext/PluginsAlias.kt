package com.aimicor.convention.ext

import org.gradle.api.Plugin
import org.gradle.api.plugins.PluginContainer

fun PluginContainer.alias(plugin: String): Plugin<*> = apply(plugin)