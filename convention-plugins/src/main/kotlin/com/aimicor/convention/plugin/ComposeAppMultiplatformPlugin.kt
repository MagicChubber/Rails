package com.aimicor.convention.plugin

import com.aimicor.convention.extension.AndroidConfig
import com.aimicor.convention.extension.DesktopConfig
import com.aimicor.convention.extension.IosConfig
import com.aimicor.convention.extension.JsConfig
import com.aimicor.convention.extension.WasmJsConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeAppMultiplatformPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        val androidCfg = extensions.create("androidConfig", AndroidConfig::class.java)
        extensions.create("iosConfig", IosConfig::class.java)
        extensions.create("desktopConfig", DesktopConfig::class.java)
        extensions.create("jsConfig", JsConfig::class.java)
        extensions.create("wasmJsConfig", WasmJsConfig::class.java)
        composeAppMultiplatformPluginComposition()
        // Wire KMP extension into AndroidConfig so nameSpace setter can apply eagerly.
        androidCfg.kmpExtension = extensions.findByType<KotlinMultiplatformExtension>()
    }
}
