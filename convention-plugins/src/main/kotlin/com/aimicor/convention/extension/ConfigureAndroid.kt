package com.aimicor.convention.extension

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

fun Project.android(configure: LibraryExtension.() -> Unit) =
    extensions.getByType<LibraryExtension>().apply(configure)
