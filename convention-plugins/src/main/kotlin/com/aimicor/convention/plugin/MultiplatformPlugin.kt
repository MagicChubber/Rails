package com.aimicor.convention.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MultiplatformPlugin: Plugin<Project> {

    override fun apply(project: Project) =
        project.multiplatformPluginComposition()
}