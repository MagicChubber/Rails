package com.aimicor.convention.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidAppPlugin : Plugin<Project> {

    override fun apply(project: Project) =
        project.androidAppPluginComposition()
}
