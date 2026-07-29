plugins {
    id("android-app")
}

android {
    namespace = "com.aimicor.navcompose.typesafe.android"

    defaultConfig {
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":examples:composeApp"))
    implementation(project(":examples:composeApp:dependencies"))
    implementation(project(":examples:infrastructure:collect"))
}
