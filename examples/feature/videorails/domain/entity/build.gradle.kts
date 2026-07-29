plugins {
    id("multiplatform-kotlin")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videorails.domain.entity"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.serialization)
        }
    }
}
