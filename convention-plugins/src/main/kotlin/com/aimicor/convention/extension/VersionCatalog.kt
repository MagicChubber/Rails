package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

interface TypeVersion {
    val key: String
}

interface TypeLibrary {
    val key: String
}

interface TypePlugin {
    val key: String
}

internal val Project.libs: VersionCatalog
    get() = extensions
            .getByType<VersionCatalogsExtension>()
            .named("libs")

operator fun VersionCatalog.invoke(library: TypeLibrary): String =
    findLibrary(library.key).get().get().toString()

fun VersionCatalog.versions(version: TypeVersion): String =
    findVersion(version.key).get().requiredVersion

fun VersionCatalog.plugins(plugin: TypePlugin): String =
    findPlugin(plugin.key).get().get().pluginId
