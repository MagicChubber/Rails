package com.aimicor.convention.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeAppMultiplatformPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        multiplatformPluginComposition()
        composeMultiplatformPluginComposition()
        composeUiMultiplatformPluginComposition()
        composeAppMultiplatformPluginComposition()
    }
}
