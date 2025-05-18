plugins {
    id("multiplatform-kotlin")
}

kotlin {

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(project(":examples:feature:videorails:domain:entity"))
                implementation(project(":examples:feature:videorails:domain:repository"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}
