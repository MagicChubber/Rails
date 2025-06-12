plugins {
    id("multiplatform-compose")
}

kotlin {
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
        val jsMain by getting {
            dependencies {
                implementation(libs.coroutines.core.js)
            }
        }
    }
}
