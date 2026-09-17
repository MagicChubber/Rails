rootProject.name = "navcompose"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":examples:feature:videorails:domain:entity")
include(":examples:feature:videorails:domain:repository")
include(":examples:feature:videoplayer:domain:repository")
include(":examples:feature:videorails:domain:usecase")
include(":examples:feature:videoplayer:domain:usecase")
include(":examples:feature:videorails:data")
include(":examples:feature:videoplayer:data")
include(":examples:feature:videorails:presentation:state")
include(":examples:feature:videorails:presentation:ui")
include(":examples:feature:videoplayer:presentation:state")
include(":examples:feature:videoplayer:presentation:ui")
include(":examples:feature:videoplayer:domain:entity")
include(":examples:infrastructure:presentation:ui")
include(":examples:infrastructure:navtype")
include(":examples:infrastructure:test")
include(":examples:infrastructure:uniflow")
include(":examples:composeApp")
include(":examples:composeApp:dependencies")
include(":examples:androidApp")
include(":examples:infrastructure:collect")
