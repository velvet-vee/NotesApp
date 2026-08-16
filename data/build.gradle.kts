plugins {
    alias(libs.plugins.android.library)
    id("com.google.devtools.ksp") version "2.3.10"
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.data"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(project(":domain"))


    implementation(libs.androidx.room3.common.jvm)
    implementation(libs.androidx.room3.runtime)
    ksp("androidx.room3:room3-compiler:3.0.1")
    implementation("androidx.sqlite:sqlite-bundled:2.5.0-alpha11")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.2")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    implementation("com.google.dagger:hilt-android:2.60.1")
    ksp("com.google.dagger:hilt-compiler:2.60.1")
}