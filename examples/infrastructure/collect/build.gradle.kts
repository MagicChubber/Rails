plugins {
    id("multiplatform-compose")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.infrastructure.collect"
    }
    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.runtime)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.koin.core)
        }
    }
}
