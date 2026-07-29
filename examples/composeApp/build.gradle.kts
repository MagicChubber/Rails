import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    id("multiplatform-compose-app")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.aimicor.navcompose.typesafe"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.serialization)
            implementation(libs.navigation.compose)
            implementation(project(":examples:composeApp:dependencies"))
            implementation(project(":examples:feature:videorails:presentation:ui"))
            implementation(project(":examples:feature:videorails:presentation:state"))
            implementation(project(":examples:feature:videoplayer:presentation:ui"))
            implementation(project(":examples:feature:videoplayer:presentation:state"))
            implementation(project(":examples:infrastructure:collect"))
            implementation(project(":examples:infrastructure:navtype"))
        }
    }
}

compose.desktop {
    application {
        mainClass = "org.example.project.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}
