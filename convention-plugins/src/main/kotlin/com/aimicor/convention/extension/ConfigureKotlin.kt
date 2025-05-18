package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun Project.kotlin(configure:  KotlinMultiplatformExtension.()->Unit) =
    extensions.getByType<KotlinMultiplatformExtension>().apply(configure)
