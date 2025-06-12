plugins {
    id("multiplatform-compose-ui")
}

kotlin {
    sourceSets {

        commonMain.dependencies {
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videoplayer:domain:entity"))
            implementation(project(":examples:infrastructure:presentation:ui"))
        }
    }
}
