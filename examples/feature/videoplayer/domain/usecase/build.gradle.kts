plugins {
    id("multiplatform-kotlin")
}

kotlin {
    sourceSets {

        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videoplayer:domain:entity"))
            implementation(project(":examples:feature:videoplayer:domain:repository"))
        }
    }
}

