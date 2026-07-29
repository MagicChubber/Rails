plugins {
    id("multiplatform-kotlin")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.infrastructure.test"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.kotlin.test)
            implementation(libs.junit)
        }
        jvmMain.dependencies {
            implementation(libs.kotlin.testJunit)
        }
    }
}
