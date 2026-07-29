plugins {
    id("multiplatform-compose")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.infrastructure.navtype"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.navigation.compose)
            implementation(libs.urlencoder.lib)
        }
        commonTest.dependencies {
            implementation(libs.junit)
        }
    }
}
