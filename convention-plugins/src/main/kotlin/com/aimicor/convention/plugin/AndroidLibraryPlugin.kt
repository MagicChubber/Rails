package com.global.plugin

import org.gradle.api.Project

class AndroidLibraryPlugin : AndroidModulePlugin() {

    override fun apply(project: Project) {
        // Apply application plugin
        project.plugins.apply("com.android.library")

        // Apply default options
        super.apply(project)
    }
}
