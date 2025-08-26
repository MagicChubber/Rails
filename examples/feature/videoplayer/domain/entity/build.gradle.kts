plugins {
    id("multiplatform-kotlin")
    alias(libs.plugins.serialization)
}

kotlin{
   sourceSets{
       commonMain.dependencies{
           implementation(libs.serialization)
           implementation(project(":examples:feature:videorails:domain:entity"))
       }
   }
}
