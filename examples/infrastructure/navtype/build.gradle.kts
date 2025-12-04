plugins {
    id("multiplatform-compose")
    alias(libs.plugins.serialization)
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
//                implementation(libs.androidx.lifecycle.runtime)
//                implementation(libs.androidx.runtime.compose)
//                implementation(libs.koin.android)
            }
        }
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.urlencoder.lib)
//                implementation(compose.runtime)
//                implementation(libs.coroutines.core)
//                implementation(libs.koin.core)
//            }
        }
    }
}
dependencies {
    testImplementation(libs.junit.jupiter)
}
