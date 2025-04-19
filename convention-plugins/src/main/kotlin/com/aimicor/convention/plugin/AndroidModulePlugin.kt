package com.global.plugin

import com.android.build.gradle.BaseExtension
import com.global.config.COMPILE_SDK
import com.global.config.MIN_SDK
import com.global.config.TARGET_SDK
import com.aimicor.convention.ext.libs
import org.gradle.api.GradleException
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

open class AndroidModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // Add Kotlin and Kapt
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-kapt")

        // Apply default Android module settings
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                defaultConfig {
                    compileSdkVersion(COMPILE_SDK)
                    minSdk = MIN_SDK
                    targetSdk = TARGET_SDK
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                        isShrinkResources = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
        } else {
            throw GradleException("Android extension not found, is this an Android module?")
        }

        // Add Kover support
        project.plugins.apply("org.jetbrains.kotlinx.kover")
        project.apply(from = "${project.rootProject.rootDir}/tools/test-coverage/kover_filter.gradle")

        // Default dependencies
        project.dependencies {
            "implementation"(project(mapOf("path" to ":logger:api")))
            "implementation"(project.libs.findLibrary("core.ktx").get())
        }
    }
}
