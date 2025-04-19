@file:Suppress("MissingPackageDeclaration", "UnstableApiUsage")

package com.aimicor.convention.ext

import com.android.build.gradle.BaseExtension
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

//internal val Project.libs
//    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.addCompose(activity: Boolean = false, koin: Boolean = false) {
    // Apply Android extension configuration for Compose
    project.plugins.apply("org.jetbrains.kotlin.plugin.compose")
    val androidExtension = project.extensions.getByName("android")
    if (androidExtension is BaseExtension) {
        androidExtension.apply {
            buildFeatures.compose = true
        }
    } else {
        throw GradleException("Android extension not found, is this an Android module?")
    }

    // Add Compose dependencies
    dependencies {
        if (activity) {
            "implementation"(libs.findLibrary("activity.compose").get())
        }
        if (koin) {
            "implementation"(libs.findLibrary("koin.androidx.compose").get())
        }
        "implementation"(platform(libs.findLibrary("compose.bom").get()))
        "implementation"(libs.findLibrary("compose.material").get())
        "implementation"(libs.findLibrary("compose.tooling").get())
        "implementation"(libs.findLibrary("lifecycle.runtime.compose").get())
        "implementation"(libs.findLibrary("constraintlayout.compose").get())
        "implementation"(libs.findLibrary("navigation.compose").get())
    }
}

fun Project.addJsonSerialization() {
    project.plugins.apply("kotlinx-serialization")
    dependencies {
        "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
    }
}

fun Project.addRxJava(vararg version: Int) {
    dependencies {
        if (version.contains(1)) {
            "implementation"(libs.findLibrary("rxjava").get())
            "implementation"(libs.findLibrary("rxandroid").get())
            "implementation"(libs.findLibrary("rxkotlin").get())
        }
        if (version.contains(2)) {
            "implementation"(libs.findLibrary("rxjava2").get())
            "implementation"(libs.findLibrary("rxandroid2").get())
            "implementation"(libs.findLibrary("rxkotlin2").get())
            if (version.contains(1)) {
                "implementation"(libs.findLibrary("rxjava2.interop").get())
            }
        }
        if (version.contains(3)) {
            "implementation"(libs.findLibrary("rxjava3").get())
            "implementation"(libs.findLibrary("rxandroid3").get())
            "implementation"(libs.findLibrary("rxkotlin3").get())
            if (version.contains(1)) {
                "implementation"(libs.findLibrary("rxjava3.interop").get())
            }
            if (version.contains(2)) {
                "implementation"(libs.findLibrary("rxjava3.bridge").get())
            }
        }
    }
}

fun Project.addDesignSystem(vararg components: Component) {
    dependencies {
        "implementation"(project(mapOf("path" to ":design_system:theme")))
        components.forEach {
            "implementation"(project(mapOf("path" to it.module)))
        }
    }
}

enum class Component(val module: String) {
    BUTTON(module = ":design_system:button"),
    TEXTFIELD(module = ":design_system:text_field"),
    DIALOG(module = ":design_system:dialog")
}
