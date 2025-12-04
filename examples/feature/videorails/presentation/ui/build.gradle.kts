plugins {
    id("multiplatform-compose-ui")
}

kotlin {
    sourceSets {

        androidMain.dependencies {
            implementation(project(":examples:infrastructure:collect"))
        }

        commonMain.dependencies {
            implementation(libs.koin.compose.viewmodel)
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videorails:presentation:state"))
            implementation(project(":examples:feature:videoplayer:presentation:state"))
            implementation(project(":examples:infrastructure:presentation:ui"))
            implementation(project(":examples:infrastructure:collect"))
        }
     }
}
