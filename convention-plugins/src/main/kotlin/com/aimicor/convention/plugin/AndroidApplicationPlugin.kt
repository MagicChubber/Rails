package com.global.plugin

import com.android.build.gradle.BaseExtension
import com.global.config.VERSION
import org.gradle.api.Project

class AndroidApplicationPlugin : FlavouredAndroidModulePlugin() {

    override fun apply(project: Project) {
        // Apply application plugin
        project.plugins.apply("com.android.application")

        // Set the app version
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                defaultConfig {
                    versionName = VERSION
                }
            }
        }

        // Apply default options
        super.apply(project)
    }
}
