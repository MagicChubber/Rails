package com.aimicor.convention.ext

import com.aimicor.convention.config.TypePlugin
import org.gradle.api.artifacts.VersionCatalog

fun VersionCatalog.plugin(plugin: TypePlugin): String =
    findPlugin(plugin.key).get().get().pluginId