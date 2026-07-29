plugins {
    id("multiplatform-kotlin")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videorails.domain.usecase"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videorails:domain:repository"))
        }
    }
}
