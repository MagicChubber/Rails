package com.aimicor.convention.composition

import com.aimicor.convention.config.TypeLibrary.KOTLIN_TEST
import com.aimicor.convention.config.TypePlugin.ANDROID_LIBRARY
import com.aimicor.convention.config.TypePlugin.KOTLIN_MULTIPLATFORM
import com.aimicor.convention.config.TypeVersion.COMPILE_SDK
import com.aimicor.convention.config.TypeVersion.JAVA
import com.aimicor.convention.config.TypeVersion.JVM_TARGET
import com.aimicor.convention.config.TypeVersion.MIN_SDK
import com.aimicor.convention.config.TypeVersion.NAMESPACE
import com.aimicor.convention.ext.alias
import com.aimicor.convention.ext.android
import com.aimicor.convention.ext.invoke
import com.aimicor.convention.ext.kotlin
import com.aimicor.convention.ext.libs
import com.aimicor.convention.ext.plugin
import com.aimicor.convention.ext.plugins
import com.aimicor.convention.ext.sourceSets
import com.aimicor.convention.ext.versions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

fun Project.androidLibraryComposition() {

    plugins {
        alias(libs.plugin(ANDROID_LIBRARY))
        alias(libs.plugin(KOTLIN_MULTIPLATFORM))
    }

    kotlin {
        //@OptIn(ExperimentalWasmDsl::class)
        //wasmJs()

        jvm()
        androidTarget {
            publishLibraryVariants("release")
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            compilerOptions {
                jvmTarget.set(JvmTarget.valueOf(libs.versions(JVM_TARGET)))
            }
        }

        js(IR) {
            browser()
        }
        iosX64()
        iosArm64()
        iosSimulatorArm64()
//    linuxX64()

        sourceSets {
            commonTest.configure {
                dependencies{
                    implementation(libs(KOTLIN_TEST))
                }
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
