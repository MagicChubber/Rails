package com.aimicor.convention.ext

import org.gradle.api.NamedDomainObjectContainer
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

fun KotlinMultiplatformExtension.sourceSets(
    configure: NamedDomainObjectContainer<KotlinSourceSet>.() -> Unit
) = configure(sourceSets)
