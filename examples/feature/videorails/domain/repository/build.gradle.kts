plugins {
    id("multiplatform-kotlin")
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe.feature.videorails.domain.repository"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(project(":examples:feature:videorails:domain:entity"))
        }
    }
}
