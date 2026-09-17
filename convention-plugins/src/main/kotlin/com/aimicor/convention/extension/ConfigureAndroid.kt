package com.aimicor.convention.extension

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun KotlinMultiplatformExtension.android(
    configure: KotlinMultiplatformAndroidLibraryTarget.() -> Unit
) = targets.withType(KotlinMultiplatformAndroidLibraryTarget::class.java).configureEach(configure)
