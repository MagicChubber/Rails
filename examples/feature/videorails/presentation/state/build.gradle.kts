plugins {
    id("multiplatform-kotlin")
    alias(libs.plugins.serialization)
}

kotlin {
    sourceSets {

        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.jetbrains.lifecycle.viewmodel)
            implementation(libs.serialization)
            implementation(project(":examples:infrastructure:uniflow"))
            implementation(project(":examples:feature:videorails:domain:usecase"))
            implementation(project(":examples:feature:videorails:domain:entity"))
        }

//        commonTest.dependencies {
//            implementation(libs.turbine)
//        }
    }
}
