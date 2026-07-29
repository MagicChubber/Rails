plugins {
    id("multiplatform-kotlin")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videoplayer.data"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(project(":examples:feature:videoplayer:domain:repository"))
        }
    }
}
