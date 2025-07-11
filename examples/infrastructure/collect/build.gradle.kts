plugins {
    id("multiplatform-compose")
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime)
                implementation(libs.androidx.runtime.compose)
                implementation(libs.koin.android)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.coroutines.core)
                implementation(libs.koin.core)
            }
        }
    }
}
