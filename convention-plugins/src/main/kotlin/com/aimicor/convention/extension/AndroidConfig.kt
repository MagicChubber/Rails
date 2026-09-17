package com.aimicor.convention.extension

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

open class AndroidConfig {
    internal var isPresent = false
    internal var kmpExtension: KotlinMultiplatformExtension? = null

    var nameSpace: String = ""
        set(value) {
            field = value
            isPresent = true
            kmpExtension?.targets
                ?.withType(KotlinMultiplatformAndroidLibraryTarget::class.java)
                ?.forEach { it.namespace = value }
        }
}

