import org.gradle.api.tasks.testing.Test
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
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    flavorDimensions += "tier"
    productFlavors {
        create("slim") {
            dimension = "tier"
        }
        create("full") {
            dimension = "tier"
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

androidComponents {
    onVariants(selector().all()) { variant ->
        if (variant.productFlavors.any { it.second == "slim" }) {
            variant.androidResources?.apply {
                localeFilters.addAll(listOf("en"))
                aaptAdditionalParameters.addAll(listOf("--preferred-density", "xxxhdpi"))
            }
        }
    }
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

// Termux-specific: Work around optimizeFullReleaseResources not emitting an .ap_ on some Termux setups.
val fixOptimizeFullReleaseResources = tasks.register("fixOptimizeFullReleaseResources", Exec::class) {
    val enableAapt2OptimizeFix = providers.gradleProperty("enableAapt2OptimizeFix")
        .map(String::toBoolean)
        .orElse(false)
    val shrunkResources = layout.buildDirectory.file(
        "intermediates/shrunk_resources_binary_format/fullRelease/" +
            "convertShrunkResourcesToBinaryFullRelease/shrunk-resources-binary-format-full-release.ap_"
    )
    val optimizedResources = layout.buildDirectory.file(
        "intermediates/optimized_processed_res/fullRelease/" +
            "optimizeFullReleaseResources/resources-full-release-optimize.ap_"
    )
    val aapt2Executable = providers.gradleProperty("android.aapt2FromMavenOverride")
        .orElse(providers.environmentVariable("AAPT2"))
        .orElse("aapt2")

    inputs.file(shrunkResources)
    outputs.file(optimizedResources)
    dependsOn("convertShrunkResourcesToBinaryFullRelease")
    mustRunAfter("optimizeFullReleaseResources")
    enabled = enableAapt2OptimizeFix.get()

    doFirst {
        val shrunkFile = shrunkResources.get().asFile
        if (!shrunkFile.exists()) {
            throw org.gradle.api.tasks.StopExecutionException(
                "Shrunk resources not found; skipping Termux aapt2 optimize fix."
            )
        }
        optimizedResources.get().asFile.parentFile.mkdirs()
    }

    commandLine(
        aapt2Executable.get(),
        "optimize",
        "-o",
        optimizedResources.get().asFile.absolutePath,
        shrunkResources.get().asFile.absolutePath
    )
}

tasks.matching { it.name == "packageFullRelease" }.configureEach {
    dependsOn(fixOptimizeFullReleaseResources)
}

tasks.withType<Test>().configureEach {
    if (name.contains("ScreenshotTest")) {
        isScanForTestClasses = true
        doFirst {
            isScanForTestClasses = true
        }
    }
}
