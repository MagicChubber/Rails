package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.COMPOSE_COMPONENTS_RESOURCES
import com.aimicor.convention.config.Libraries.COMPOSE_FOUNDATION
import com.aimicor.convention.config.Libraries.COMPOSE_MATERIAL3
import com.aimicor.convention.config.Libraries.COMPOSE_RUNTIME
import com.aimicor.convention.config.Libraries.COMPOSE_UI
import com.aimicor.convention.config.Libraries.COMPOSE_UI_TOOLING_PREVIEW
import com.aimicor.convention.config.Libraries.PREVIEW
import com.aimicor.convention.config.Libraries.PREVIEW_DESKTOP
import com.aimicor.convention.extension.compose
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.kotlin
import com.aimicor.convention.extension.libs
import org.gradle.api.Project

fun Project.composeUiMultiplatformPluginComposition() {
    kotlin {
        sourceSets {
            val jvmMain = getByName("jvmMain")

            androidMain.dependencies {
                implementation(libs(PREVIEW))
            }
            commonMain.dependencies {
                implementation(libs(COMPOSE_RUNTIME))
                implementation(libs(COMPOSE_FOUNDATION))
                implementation(libs(COMPOSE_MATERIAL3))
                implementation(libs(COMPOSE_UI))
                implementation(libs(COMPOSE_COMPONENTS_RESOURCES))
                implementation(libs(COMPOSE_UI_TOOLING_PREVIEW))
            }
            jvmMain.dependencies {
                implementation(libs(PREVIEW_DESKTOP))
                implementation(compose.desktop.currentOs)
            }
        }
    }
}
