package com.aimicor.convention.extension

import org.gradle.api.NamedDomainObjectContainer
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

operator fun NamedDomainObjectContainer<KotlinSourceSet>.invoke(
    block: NamedDomainObjectContainer<KotlinSourceSet>.() -> Unit
) = apply(block)
