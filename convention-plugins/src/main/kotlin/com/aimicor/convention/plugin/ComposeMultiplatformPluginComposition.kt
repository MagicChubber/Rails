package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.PREVIEW
import com.aimicor.convention.config.Libraries.PREVIEW_DESKTOP
import com.aimicor.convention.config.Plugins.COMPOSE_COMPILER
import com.aimicor.convention.config.Plugins.JETBRAINS_COMPOSE
import com.aimicor.convention.extension.android
import com.aimicor.convention.extension.compose
import com.aimicor.convention.extension.debugImplementation
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.kotlin
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.plugins
import com.aimicor.convention.extension.resources
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.composeMultiplatformPluginComposition() {

    plugins {
        apply(libs.plugins(COMPOSE_COMPILER))
        apply(libs.plugins(JETBRAINS_COMPOSE))
    }

    compose.resources {
        publicResClass = false
        generateResClass = auto
    }

    android {
        buildFeatures {
            compose = true
        }
        dependencies {
            debugImplementation(compose.uiTooling)
        }
    }
}
