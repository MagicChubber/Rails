plugins {
    id("multiplatform-kotlin")
}

kotlin {
    sourceSets {

        commonMain.dependencies {
            implementation(project(":examples:feature:videorails:domain:repository"))
            implementation(project(":examples:feature:videorails:domain:entity"))
        }
    }
}
