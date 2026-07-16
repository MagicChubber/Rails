package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.KOTLIN_COROUTINES_TEST
import com.aimicor.convention.config.Libraries.KOTLIN_TEST
import com.aimicor.convention.config.Libraries.TURBINE
import com.aimicor.convention.config.Plugins.ANDROID_LIBRARY
import com.aimicor.convention.config.Plugins.KOTLIN_MULTIPLATFORM
import com.aimicor.convention.config.Versions.COMPILE_SDK
import com.aimicor.convention.config.Versions.JVM_TARGET
import com.aimicor.convention.config.Versions.LIBRARY_GROUP
import com.aimicor.convention.config.Versions.LIBRARY_VERSION
import com.aimicor.convention.config.Versions.MIN_SDK
import com.aimicor.convention.extension.android
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.kotlin
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.plugins
import com.aimicor.convention.extension.versions
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun Project.multiplatformPluginComposition() {

    plugins {
        apply(libs.plugins(ANDROID_LIBRARY))
        apply(libs.plugins(KOTLIN_MULTIPLATFORM))
    }

    group = libs.versions(LIBRARY_GROUP)
    version = libs.versions(LIBRARY_VERSION)

    val compileSdkVersion = libs.versions(COMPILE_SDK).toInt()
    val minSdkVersion = libs.versions(MIN_SDK).toInt()
    val jvmTargetVersion = JvmTarget.valueOf(libs.versions(JVM_TARGET))
    val kotlinTest = libs(KOTLIN_TEST)
    val coroutinesTest = libs(KOTLIN_COROUTINES_TEST)
    val turbine = libs(TURBINE)

    kotlin {
        jvm()
        android {
            compileSdk = compileSdkVersion
            minSdk = minSdkVersion
            withJava()
            withHostTestBuilder {}.configure {}
            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }
            compilerOptions {
                jvmTarget.set(jvmTargetVersion)
            }
        }
        iosArm64()
        iosSimulatorArm64()
        js {
            browser()
        }
        @OptIn(ExperimentalWasmDsl::class)
        wasmJs {
            browser()
        }

        sourceSets {
            commonTest.dependencies {
                implementation(kotlinTest)
                implementation(coroutinesTest)
                implementation(turbine)
            }
        }
    }
}
