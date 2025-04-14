import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    sourceSets {
        androidMain.dependencies {
//            implementation(compose.runtime)
//            implementation(compose.foundation)
//            implementation(compose.material3)
//            implementation(compose.components.resources)
//            implementation(compose.preview)
//            implementation(compose.components.uiToolingPreview)
//            implementation(libs.androidx.activity.compose)
//            implementation(libs.androidx.lifecycle.runtime.compose)
//            implementation(libs.androidx.lifecycle.viewmodel)
//            implementation(libs.kotlinx.serialization.json)
//            implementation(libs.androidx.navigation.compose)
//            implementation(libs.androidx.appcompat)
//            implementation(libs.androidx.core.ktx)
//
//            // Network
//            implementation(libs.retrofit)
//            implementation(libs.okhttp)
//            implementation(libs.okhttp.logging)
//
//            // MVI
//            implementation(libs.mvi.kotlin)
//            implementation(libs.mvi.kotlin.main)
//            implementation(libs.mvi.kotlin.coroutines)
//
//            // Coroutines
//            implementation(libs.kotlinx.coroutines.android)
//            implementation(libs.kotlinx.coroutines.core)
//
//            // Hilt
//            implementation(libs.hilt)
//
//            // Room
//            implementation(libs.room)
        }
    }
}

android {
    namespace = "io.stokk.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "io.stokk.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material3)
    implementation(compose.components.resources)
    implementation(compose.preview)
    implementation(compose.components.uiToolingPreview)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    // Network
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // MVI
    implementation(libs.mvi.kotlin)
    implementation(libs.mvi.kotlin.main)
    implementation(libs.mvi.kotlin.coroutines)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)

    // Hilt
    implementation(libs.hilt)

    // Room
    implementation(libs.room)
    debugImplementation(libs.androidx.ui.tooling)
    ksp(libs.hilt.compiler)
    ksp(libs.room.compiler)
}