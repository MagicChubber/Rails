plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("multiplatform-library") {
            id = "multiplatform-library"
            implementationClass = "com.aimicor.convention.plugin.MultiplatformLibrary"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.android.tools.gradle)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(kotlin("stdlib"))
}
