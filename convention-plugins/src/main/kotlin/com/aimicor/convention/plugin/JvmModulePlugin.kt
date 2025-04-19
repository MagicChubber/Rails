package com.global.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class JvmModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        // Add plugins
        project.plugins.apply("java")
        project.plugins.apply("kotlin")
        project.plugins.apply("kotlin-kapt")

        // Add Kover support
        project.plugins.apply("org.jetbrains.kotlinx.kover")
        project.apply(from = "${project.rootProject.rootDir}/tools/test-coverage/kover_filter.gradle")

        // Dependencies
        project.dependencies {
            if (project.path != ":logger:api") add("implementation", project(mapOf("path" to ":logger:api")))
        }
    }
}
