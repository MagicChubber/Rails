plugins {
    id("multiplatform-kotlin")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videoplayer.domain.entity"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.serialization)
            implementation(project(":examples:feature:videorails:domain:entity"))
        }
    }
}
