import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    //@OptIn(ExperimentalWasmDsl::class)
    //wasmJs()

    jvm()
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
        val commonMain by getting {
            dependencies {
                implementation(project(":examples:feature:videorails:domain:entity"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
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
}
