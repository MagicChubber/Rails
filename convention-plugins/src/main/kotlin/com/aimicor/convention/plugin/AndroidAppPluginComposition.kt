package com.aimicor.convention.plugin

import com.aimicor.convention.config.Libraries.ANDROIDX_ACTIVITY_COMPOSE
import com.aimicor.convention.config.Libraries.COMPOSE_UI_TOOLING
import com.aimicor.convention.config.Libraries.KOIN_ANDROID
import com.aimicor.convention.config.Plugins.ANDROID_APPLICATION
import com.aimicor.convention.config.Plugins.COMPOSE_COMPILER
import com.aimicor.convention.config.Versions.COMPILE_SDK
import com.aimicor.convention.config.Versions.JAVA
import com.aimicor.convention.config.Versions.MIN_SDK
import com.aimicor.convention.config.Versions.TARGET_SDK
import com.aimicor.convention.extension.debugImplementation
import com.aimicor.convention.extension.implementation
import com.aimicor.convention.extension.invoke
import com.aimicor.convention.extension.libs
import com.aimicor.convention.extension.plugins
import com.aimicor.convention.extension.versions
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

fun Project.androidAppPluginComposition() {

    plugins {
        apply(libs.plugins(ANDROID_APPLICATION))
        apply(libs.plugins(COMPOSE_COMPILER))
    }

    val compileSdkVersion = libs.versions(COMPILE_SDK).toInt()
    val minSdkVersion = libs.versions(MIN_SDK).toInt()
    val targetSdkVersion = libs.versions(TARGET_SDK).toInt()
    val javaVersion = JavaVersion.valueOf(libs.versions(JAVA))

    extensions.configure<ApplicationExtension> {
        compileSdk = compileSdkVersion

        defaultConfig {
            minSdk = minSdkVersion
            targetSdk = targetSdkVersion
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
            }
        }
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
    }

    dependencies {
        implementation(libs(KOIN_ANDROID))
        implementation(libs(ANDROIDX_ACTIVITY_COMPOSE))
        debugImplementation(libs(COMPOSE_UI_TOOLING))
    }
}
