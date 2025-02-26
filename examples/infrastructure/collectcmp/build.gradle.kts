import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
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
        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime)
                implementation(libs.androidx.runtime.compose)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.coroutines.core)
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
    namespace = if (moduleName.isNotEmpty()) "$name.$moduleName" else name
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.java.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.java.get())
    }
}
