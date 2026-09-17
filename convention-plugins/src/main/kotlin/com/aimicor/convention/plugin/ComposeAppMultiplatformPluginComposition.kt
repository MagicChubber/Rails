package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.ANDROIDX_ACTIVITY_COMPOSE
import com.aimicor.convention.config.Libraries.ANDROIDX_LIFECYCLE_RUNTIME_COMPOSE
import com.aimicor.convention.config.Libraries.ANDROIDX_LIFECYCLE_VIEWMODEL_COMPOSE
import com.aimicor.convention.config.Libraries.COMPOSE_COMPONENTS_RESOURCES
import com.aimicor.convention.config.Libraries.COMPOSE_FOUNDATION
import com.aimicor.convention.config.Libraries.COMPOSE_MATERIAL3
import com.aimicor.convention.config.Libraries.COMPOSE_RUNTIME
import com.aimicor.convention.config.Libraries.COMPOSE_UI
import com.aimicor.convention.config.Libraries.COMPOSE_UI_TOOLING_PREVIEW
import com.aimicor.convention.config.Libraries.KOIN_COMPOSE
import com.aimicor.convention.config.Libraries.KOTLIN_COROUTINES_TEST
import com.aimicor.convention.config.Libraries.KOTLIN_TEST
import com.aimicor.convention.config.Libraries.KOTLINX_COROUTINES_SWING
import com.aimicor.convention.config.Libraries.PREVIEW
import com.aimicor.convention.config.Libraries.PREVIEW_DESKTOP
import com.aimicor.convention.config.Libraries.TURBINE
import com.aimicor.convention.config.Plugins.ANDROID_LIBRARY
import com.aimicor.convention.config.Plugins.COMPOSE_COMPILER
import com.aimicor.convention.config.Plugins.COMPOSE_HOT_RELOAD
import com.aimicor.convention.config.Plugins.JETBRAINS_COMPOSE
import com.aimicor.convention.config.Plugins.KOTLIN_MULTIPLATFORM
import com.aimicor.convention.config.Versions.COMPILE_SDK
import com.aimicor.convention.config.Versions.JVM_TARGET
import com.aimicor.convention.config.Versions.LIBRARY_GROUP
import com.aimicor.convention.config.Versions.LIBRARY_VERSION
import com.aimicor.convention.config.Versions.MIN_SDK
import com.aimicor.convention.extension.AndroidConfig
import com.aimicor.convention.extension.IosConfig
import com.aimicor.convention.extension.android
import com.aimicor.convention.extension.compose
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.kotlin
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.moduleGroup
import com.aimicor.convention.extension.plugins
import com.aimicor.convention.extension.resources
import com.aimicor.convention.extension.versions
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun Project.composeAppMultiplatformPluginComposition() {

    val compileSdkVersion = libs.versions(COMPILE_SDK).toInt()
    val minSdkVersion = libs.versions(MIN_SDK).toInt()
    val jvmTargetVersion = JvmTarget.valueOf(libs.versions(JVM_TARGET))

    plugins {
        apply(libs.plugins(ANDROID_LIBRARY))
        apply(libs.plugins(KOTLIN_MULTIPLATFORM))
        apply(libs.plugins(COMPOSE_COMPILER))
        apply(libs.plugins(JETBRAINS_COMPOSE))
        apply(libs.plugins(COMPOSE_HOT_RELOAD))
    }

    group = moduleGroup(libs.versions(LIBRARY_GROUP))
    version = libs.versions(LIBRARY_VERSION)

    val resourcesPackage = "${rootProject.name.lowercase()}.${
        path.split(":").drop(1).joinToString(".") { it.lowercase() }
    }.generated.resources"

    compose.resources {
        publicResClass = false
        generateResClass = auto
        packageOfResClass = resourcesPackage
    }

    // All targets are declared eagerly so the KMP plugin registers their tasks during
    // configuration. Outputs and dependencies are wired in afterEvaluate based on which
    // config blocks the build script opted into.
    kotlin {
        android {
            compileSdk = compileSdkVersion
            minSdk = minSdkVersion
            androidResources {
                enable = true
            }
            withHostTest {
                isIncludeAndroidResources = true
            }
            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }
            compilerOptions {
                jvmTarget.set(jvmTargetVersion)
            }
        }

        listOf(iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
            iosTarget.binaries.framework {
                isStatic = true
            }
        }

        jvm {
            compilerOptions {
                jvmTarget.set(jvmTargetVersion)
            }
        }

        js {
            browser()
            binaries.executable()
        }

        @OptIn(ExperimentalWasmDsl::class)
        wasmJs {
            browser()
            binaries.executable()
        }

        sourceSets {
            commonMain.dependencies {
                implementation(libs(COMPOSE_RUNTIME))
                implementation(libs(COMPOSE_FOUNDATION))
                implementation(libs(COMPOSE_MATERIAL3))
                implementation(libs(COMPOSE_UI))
                implementation(libs(COMPOSE_COMPONENTS_RESOURCES))
                implementation(libs(COMPOSE_UI_TOOLING_PREVIEW))
                implementation(libs(ANDROIDX_LIFECYCLE_VIEWMODEL_COMPOSE))
                implementation(libs(ANDROIDX_LIFECYCLE_RUNTIME_COMPOSE))
                implementation(libs(KOIN_COMPOSE))
            }
            commonTest.dependencies {
                implementation(libs(KOTLIN_TEST))
                implementation(libs(KOTLIN_COROUTINES_TEST))
                implementation(libs(TURBINE))
            }
            getByName("jvmMain").dependencies {
                implementation(libs(KOTLINX_COROUTINES_SWING))
                implementation(libs(PREVIEW_DESKTOP))
                implementation(compose.desktop.currentOs)
            }
        }
    }

    afterEvaluate {
        val iosCfg = extensions.findByType<IosConfig>()
        val includeAndroid = extensions.findByType<AndroidConfig>()?.isPresent == true
        kotlin {
            if (iosCfg?.baseName?.isNotEmpty() == true) {
                listOf(iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
                    iosTarget.binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).configureEach {
                        baseName = iosCfg.baseName
                    }
                }
            }

            if (includeAndroid) {
                sourceSets {
                    androidMain.dependencies {
                        implementation(libs(ANDROIDX_ACTIVITY_COMPOSE))
                        implementation(libs(PREVIEW))
                    }
                }
            }
        }
    }
}
