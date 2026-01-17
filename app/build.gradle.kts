import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jmailen.kotlinter")
}

apply(plugin = "com.android.compose.screenshot")

android {
    namespace = "ca.amandeep.playernumber"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "ca.amandeep.playernumber"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    buildFeatures {
        compose = true
    }
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    implementation(AndroidX.core.ktx)
    implementation("androidx.core:core-splashscreen:_")
    implementation(AndroidX.lifecycle.runtime.ktx)
    implementation(AndroidX.activity.compose)
    implementation(platform(AndroidX.compose.bom))
    implementation(AndroidX.compose.ui)
    implementation(AndroidX.compose.ui.graphics)
    implementation(AndroidX.compose.ui.toolingPreview)
    implementation(AndroidX.compose.material3)
    implementation("androidx.compose.material3.adaptive:adaptive:_")
    implementation(AndroidX.compose.material.icons.extended)
    implementation("androidx.navigation3:navigation3-runtime:_")
    implementation("androidx.navigation3:navigation3-ui:_")
    implementation(AndroidX.compose.ui.text)
    implementation(Square.okHttp3)
    implementation(Square.retrofit2)
    implementation(Square.retrofit2.converter.moshi)
    implementation(Square.moshi)
    implementation(Square.moshi.kotlinReflect)
    testImplementation(Testing.junit4)
    debugImplementation(AndroidX.compose.ui.tooling)
    debugImplementation(AndroidX.compose.ui.testManifest)
    screenshotTestImplementation(AndroidX.compose.ui.tooling)
    screenshotTestImplementation("com.android.tools.screenshot:screenshot-validation-api:_")
}
