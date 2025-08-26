plugins {
    id("multiplatform-kotlin")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.jetbrains.lifecycle.viewmodel)
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videoplayer:domain:usecase"))
            implementation(project(":examples:feature:videoplayer:domain:entity"))
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:infrastructure:test"))
        }
    }
}