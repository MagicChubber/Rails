plugins {
    id("multiplatform-compose")
}

kotlin {
    sourceSets {

        commonMain.dependencies {
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videorails:presentation:state"))
            implementation(project(":examples:infrastructure:presentation:ui"))
            implementation(project(":examples:infrastructure:collectcmp"))
        }
     }
}
