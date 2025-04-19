package com.aimicor.convention.plugin

import com.aimicor.convention.composition.androidLibraryComposition
import org.gradle.api.Plugin
import org.gradle.api.Project

class MultiplatformLibrary: Plugin<Project> {
    override fun apply(project: Project) {
        project.androidLibraryComposition()
    }
}