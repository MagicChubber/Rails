package com.aimicor.convention.extension

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.compose.resources.ResourcesExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal val KotlinMultiplatformExtension.compose: ComposePlugin.Dependencies
    get() = extensions.getByType<ComposePlugin.Dependencies>()

internal val DependencyHandler.compose: ComposePlugin.Dependencies
    get() = extensions.getByType<ComposePlugin.Dependencies>()

internal val Project.compose: ComposeExtension
    get() = extensions.getByType<ComposeExtension>()

internal fun ComposeExtension.resources(configure: ResourcesExtension.() -> Unit) =
    extensions.getByType<ResourcesExtension>().apply(configure)
