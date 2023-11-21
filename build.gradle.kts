// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
//    id("androidx.navigation.safeargs") version "2.7.5" apply false
}
buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
    dependencies {
        // other plugins...
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
//        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.5")
    }
}
