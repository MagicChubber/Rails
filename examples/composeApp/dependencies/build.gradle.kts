plugins {
    id("multiplatform-kotlin")
}
kotlin{
    sourceSets{
        commonMain.dependencies{
            implementation(libs.koin.core)
            implementation(project(":examples:feature:videorails:data"))
            implementation(project(":examples:feature:videorails:domain:usecase"))
            implementation(project(":examples:feature:videoplayer:domain:usecase"))
            implementation(project(":examples:feature:videorails:presentation:ui"))
            implementation(project(":examples:feature:videorails:presentation:state"))
            implementation(project(":examples:feature:videoplayer:presentation:state"))
            implementation(project(":examples:feature:videoplayer:data"))
            implementation(project(":examples:infrastructure:collect"))
        }
    }
}