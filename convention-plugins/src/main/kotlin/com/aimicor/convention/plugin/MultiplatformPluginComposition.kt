package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.KOTLIN_COROUTINES_TEST
import com.aimicor.convention.config.Libraries.KOTLIN_TEST
import com.aimicor.convention.config.Libraries.TURBINE
import com.aimicor.convention.config.Plugins.ANDROID_LIBRARY
import com.aimicor.convention.config.Plugins.KOTLIN_MULTIPLATFORM
import com.aimicor.convention.config.Versions.COMPILE_SDK
import com.aimicor.convention.config.Versions.JAVA
import com.aimicor.convention.config.Versions.JVM_TARGET
import com.aimicor.convention.config.Versions.MIN_SDK
import com.aimicor.convention.config.Versions.NAMESPACE
import com.aimicor.convention.extension.android
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.kotlin
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.plugins
import com.aimicor.convention.extension.versions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun Project.multiplatformPluginComposition() {

    plugins {
        apply(libs.plugins(ANDROID_LIBRARY))
        apply(libs.plugins(KOTLIN_MULTIPLATFORM))
    }

    kotlin {
        jvm("desktop")
        androidTarget {
            publishLibraryVariants("release")
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            compilerOptions {
                jvmTarget.set(JvmTarget.valueOf(libs.versions(JVM_TARGET)))
            }
        }
        iosX64()
        iosArm64()
        iosSimulatorArm64()
//        linuxX64()

        sourceSets {
            commonTest.dependencies {
                implementation(libs(KOTLIN_TEST))
                implementation(libs(KOTLIN_COROUTINES_TEST))
                implementation(libs(TURBINE))
            }
        }
    }

    android {
        val moduleName = path.split(":").drop(1).joinToString(".")
        val name = libs.versions(NAMESPACE)

        namespace = if (moduleName.isNotEmpty()) "$name.$moduleName" else name
        compileSdk = libs.versions(COMPILE_SDK).toInt()

        defaultConfig {
            minSdk = libs.versions(MIN_SDK).toInt()
        }
        compileOptions {
            sourceCompatibility = JavaVersion.valueOf(libs.versions(JAVA))
            targetCompatibility = JavaVersion.valueOf(libs.versions(JAVA))
        }
    }
}
