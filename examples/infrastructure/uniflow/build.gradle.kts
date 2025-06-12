plugins {
    id("multiplatform-compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.jetbrains.lifecycle.viewmodel)
                implementation(compose.runtime)
            }
        }
    }
}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.junit)
    testImplementation(libs.turbine)
    testImplementation(project(":examples:infrastructure:test"))
}
