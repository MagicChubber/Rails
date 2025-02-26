import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    //@OptIn(ExperimentalWasmDsl::class)
    //wasmJs()

    jvm("desktop")
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.valueOf(libs.versions.jvm.target.get()))
        }
    }

    js(IR) {
        browser()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
//    linuxX64()

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.ui.tooling.preview)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videorails:presentation:state"))
            implementation(project(":examples:infrastructure:presentation:ui"))
            implementation(project(":examples:infrastructure:collectcmp"))
        }
        desktopMain.dependencies {
            implementation(libs.ui.tooling.preview.desktop)
            implementation(compose.desktop.currentOs)
        }
    }
}
compose.resources {
    publicResClass = false
    generateResClass = auto
}
android {
    val moduleName = path.split(":").drop(1).joinToString(".")
    val name = libs.versions.namespace.get()
    namespace = if(moduleName.isNotEmpty()) "$name.$moduleName" else name
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.java.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.java.get())
    }
    buildFeatures {
        compose = true
    }
    dependencies {
         debugImplementation(compose.uiTooling)
    }
}
