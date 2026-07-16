import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("android-app") {
            id = "android-app"
            implementationClass = "com.aimicor.convention.plugin.AndroidAppPlugin"
        }
        register("multiplatform-kotlin") {
            id = "multiplatform-kotlin"
            implementationClass = "com.aimicor.convention.plugin.MultiplatformPlugin"
        }
        register("multiplatform-compose") {
            id = "multiplatform-compose"
            implementationClass = "com.aimicor.convention.plugin.ComposeMultiplatformPlugin"
        }
        register("multiplatform-compose-ui") {
            id = "multiplatform-compose-ui"
            implementationClass = "com.aimicor.convention.plugin.ComposeUiMultiplatformPlugin"
        }
        register("multiplatform-compose-app") {
            id = "multiplatform-compose-app"
            implementationClass = "com.aimicor.convention.plugin.ComposeAppMultiplatformPlugin"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.android.tools.gradle)
    compileOnly(libs.android.tools.gradle.api)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.compose.gradle.plugin)
    implementation(kotlin("stdlib"))
}
