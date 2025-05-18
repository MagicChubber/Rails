plugins {
    id("multiplatform-kotlin")
}

kotlin {

    sourceSets {
//        val androidMain by getting {
//            dependencies {
//                implementation(libs.koin.android)
//            }
//        }
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.jetbrains.lifecycle.viewmodel)
                implementation(project(":examples:infrastructure:uniflow"))
                implementation(project(":examples:feature:videorails:domain:usecase"))
                implementation(project(":examples:feature:videorails:domain:entity"))
            }
        }
    }
}
