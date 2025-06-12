package com.aimicor.convention.plugin

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
            val desktopMain = getByName("desktopMain")

            androidMain.dependencies {
                implementation(compose.preview)
                implementation(libs(PREVIEW))
            }
            commonMain.dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
            }
            desktopMain.dependencies {
                implementation(libs(PREVIEW_DESKTOP))
                implementation(compose.desktop.currentOs)
            }
        }
    }
}
