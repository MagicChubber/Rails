package com.aimicor.convention.ext

import com.aimicor.convention.config.TypeLibrary
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

private var libs_: VersionCatalog? = null

val Project.libs: VersionCatalog
    get() = libs_ ?: extensions
        .getByType<VersionCatalogsExtension>()
        .named("libs")
        .also { libs_ = it }

operator fun VersionCatalog.invoke(library: TypeLibrary): String =
    findLibrary(library.key).get().get().toString()
