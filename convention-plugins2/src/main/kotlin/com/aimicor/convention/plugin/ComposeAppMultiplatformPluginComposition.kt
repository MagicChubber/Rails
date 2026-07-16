package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.ANDROIDX_ACTIVITY_COMPOSE
import com.aimicor.convention.config.Libraries.ANDROIDX_LIFECYCLE_RUNTIME_COMPOSE
import com.aimicor.convention.config.Libraries.ANDROIDX_LIFECYCLE_VIEWMODEL_COMPOSE
import com.aimicor.convention.config.Libraries.KOIN_COMPOSE
import com.aimicor.convention.config.Libraries.KOTLINX_COROUTINES_SWING
import com.aimicor.convention.config.Plugins.COMPOSE_HOT_RELOAD
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.kotlin
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.plugins
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

fun Project.composeAppMultiplatformPluginComposition() {

    plugins {
        apply(libs.plugins(COMPOSE_HOT_RELOAD))
    }

    kotlin {
        js {
            binaries.executable()
        }

        @OptIn(ExperimentalWasmDsl::class)
        wasmJs {
            binaries.executable()
        }

        sourceSets {
            androidMain.dependencies {
                implementation(libs(ANDROIDX_ACTIVITY_COMPOSE))
            }
            commonMain.dependencies {
                implementation(libs(ANDROIDX_LIFECYCLE_VIEWMODEL_COMPOSE))
                implementation(libs(ANDROIDX_LIFECYCLE_RUNTIME_COMPOSE))
                implementation(libs(KOIN_COMPOSE))
            }
            jvmMain.dependencies {
                implementation(libs(KOTLINX_COROUTINES_SWING))
            }
        }
    }

    // Workaround: android.kotlin.multiplatform.library (AGP 9) doesn't expose assets source
    // sets on variants, so CMP's CopyResourcesToAndroidAssetsTask.outputDirectory is never
    // set. Wire outputDirectory via reflection so the task can run and produce its output.
    afterEvaluate {
        tasks.named("copyAndroidMainComposeResourcesToAndroidAssets").configure {
            val outDir = layout.buildDirectory.dir("generated/compose/assets/androidMain")
            @Suppress("UNCHECKED_CAST")
            (javaClass.methods.first { it.name == "getOutputDirectory" }.invoke(this)
                    as org.gradle.api.file.DirectoryProperty).set(outDir)
        }
    }
}
