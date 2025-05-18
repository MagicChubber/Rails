plugins {
    id("multiplatform-kotlin")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":examples:feature:videorails:domain:entity"))
             }
        }
    }
}
