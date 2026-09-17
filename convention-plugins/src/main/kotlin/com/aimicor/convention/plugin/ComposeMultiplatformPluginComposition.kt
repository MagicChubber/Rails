package com.aimicor.convention.plugin

import com.aimicor.convention.config.Plugins.COMPOSE_COMPILER
import com.aimicor.convention.config.Plugins.JETBRAINS_COMPOSE
import com.aimicor.convention.extension.compose
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.plugins
import com.aimicor.convention.extension.resources
import org.gradle.api.Project

fun Project.composeMultiplatformPluginComposition() {

    plugins {
        apply(libs.plugins(COMPOSE_COMPILER))
        apply(libs.plugins(JETBRAINS_COMPOSE))
    }

    val resourcesPackage = "${rootProject.name.lowercase()}.${
        path.split(":").drop(1).joinToString(".") { it.lowercase() }
    }.generated.resources"

    compose.resources {
        publicResClass = false
        generateResClass = auto
        packageOfResClass = resourcesPackage
    }
}
