plugins {
    id("multiplatform-kotlin")
}
kotlin{
    sourceSets{
        commonMain.dependencies{
            implementation(libs.koin.core)
            implementation(project(":examples:feature:videoplayer:domain:repository"))
        }
    }
}
