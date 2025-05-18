pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "navcompose"
include(":examples:feature:videorails:domain:entity")
include(":examples:feature:videorails:domain:repository")
include(":examples:feature:videoplayer:domain:repository")
include(":examples:feature:videorails:domain:usecase")
include(":examples:feature:videoplayer:domain:usecase")
include(":examples:feature:videorails:data")
include(":examples:feature:videorails:presentation:state")
include(":examples:feature:videorails:presentation:ui")
include(":examples:feature:videoplayer:presentation:state")
include(":examples:feature:videoplayer:presentation:ui")
include(":examples:feature:videoplayer:domain:entity")
include(":examples:infrastructure:presentation:state")
include(":examples:infrastructure:presentation:ui")
include(":examples:infrastructure:test")
include(":examples:infrastructure:uniflow")
include(":examples:infrastructure:collectcmp")
include(":examples:composeApp")

includeBuild ("convention-plugins")
