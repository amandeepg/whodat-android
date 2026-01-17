// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("io.nlopez.compose.rules:ktlint:_")
        classpath("com.android.compose.screenshot:com.android.compose.screenshot.gradle.plugin:0.0.1-alpha13")
    }
}

plugins {
    id("com.android.application") apply false
    id("org.jetbrains.kotlin.plugin.compose") apply false
    id("org.jmailen.kotlinter") apply false
}
