plugins {
    id("multiplatform-compose-ui")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videoplayer.presentation.ui"
    }
    sourceSets {
        androidMain.dependencies {
            implementation(project(":examples:infrastructure:collect"))
        }
        commonMain.dependencies {
            implementation(libs.nav3)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.nav3)
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videoplayer:presentation:state"))
            implementation(project(":examples:infrastructure:presentation:ui"))
            implementation(project(":examples:infrastructure:collect"))
        }
    }
}
