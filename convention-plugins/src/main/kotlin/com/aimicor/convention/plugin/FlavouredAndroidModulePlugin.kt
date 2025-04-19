package com.global.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

open class FlavouredAndroidModulePlugin : AndroidModulePlugin() {

    override fun apply(project: Project) {
        // Apply everything from AndroidModulePlugin first
        super.apply(project)

        // Add product flavours
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                flavorDimensions("theme")
                productFlavors {
                    create("global") {
                        dimension = "theme"
                    }
                    create("lbc") {
                        dimension = "theme"
                    }
                    create("lbcv2") {
                        dimension = "theme"
                    }
                }
            }
        }
    }
}
