plugins {
    id("multiplatform-kotlin")
}

dependencies {
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlin.test.junit)
    implementation(libs.junit)
}