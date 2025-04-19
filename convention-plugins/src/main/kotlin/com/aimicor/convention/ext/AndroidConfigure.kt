package com.aimicor.convention.ext

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project

fun Project.android(configure: LibraryExtension.() -> Unit) =
    (extensions.getByName("android") as? LibraryExtension)?.apply { configure() }
