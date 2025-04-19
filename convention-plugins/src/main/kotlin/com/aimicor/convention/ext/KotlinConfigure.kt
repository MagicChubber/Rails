package com.aimicor.convention.ext

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun Project.kotlin(configure:  KotlinMultiplatformExtension.()->Unit) =
    (extensions.getByName("kotlin") as? KotlinMultiplatformExtension)?.apply(configure)
