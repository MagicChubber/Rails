plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("multiplatform-kotlin") {
            id = "multiplatform-kotlin"
            implementationClass = "com.aimicor.convention.plugin.MultiplatformPlugin"
        }
        register("multiplatform-compose") {
            id = "multiplatform-compose"
            implementationClass = "com.aimicor.convention.plugin.ComposeMultiplatformPlugin"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.android.tools.gradle)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.compose.gradle.plugin)
    implementation(kotlin("stdlib"))
}
