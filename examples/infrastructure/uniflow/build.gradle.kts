plugins {
    id("multiplatform-compose")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.infrastructure.uniflow"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.jetbrains.lifecycle.viewmodel)
        }
        commonTest.dependencies {
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.junit)
            implementation(libs.turbine)
            implementation(project(":examples:infrastructure:test"))
        }
    }
}
