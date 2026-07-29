plugins {
    id("multiplatform-kotlin")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videoplayer.domain.usecase"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(project(":examples:feature:videorails:domain:entity"))
            implementation(project(":examples:feature:videoplayer:domain:entity"))
            implementation(project(":examples:feature:videoplayer:domain:repository"))
        }
    }
}
