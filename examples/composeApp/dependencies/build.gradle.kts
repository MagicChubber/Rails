import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
kotlin{
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
//    linuxX64()

    sourceSets{
        commonMain {
//            kotlin.srcDir("src/main/kotlin")
            dependencies {
                implementation(libs.koin.core)
                implementation(project(":examples:feature:videorails:data"))
                implementation(project(":examples:feature:videorails:domain:usecase"))
                implementation(project(":examples:feature:videoplayer:domain:usecase"))
                implementation(project(":examples:feature:videorails:presentation:ui"))
                implementation(project(":examples:feature:videorails:presentation:state"))
                implementation(project(":examples:feature:videoplayer:presentation:state"))
                implementation(project(":examples:feature:videoplayer:data"))
                implementation(project(":examples:infrastructure:collect"))
            }
        }
    }
}
android {
    namespace = "com.aimicor.navcompose.typesafe.dependencies"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}