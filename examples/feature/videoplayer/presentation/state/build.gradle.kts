plugins {
    id("multiplatform-kotlin")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videoplayer.presentation.state"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.jetbrains.lifecycle.viewmodel)
            implementation(libs.navigation.compose)
            implementation(libs.serialization)
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videoplayer:domain:usecase"))
            implementation(project(":examples:feature:videoplayer:domain:entity"))
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:infrastructure:test"))
            implementation(project(":examples:infrastructure:navtype"))
        }
    }
}
