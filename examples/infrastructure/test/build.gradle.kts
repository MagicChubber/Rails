plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    val moduleName = path.split(":").drop(1).joinToString(".")
    val name = libs.versions.namespace.get()
    namespace = if(moduleName.isNotEmpty()) "$name.$moduleName" else name
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.java.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.java.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.android.kotlin.jvm.get()
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlin.test.junit)
    implementation(libs.junit)
}