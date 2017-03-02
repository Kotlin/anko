package org.jetbrains.android.anko.config

enum class TargetArtifactType {
    COMMON, // Common stuff (does not contain platform-dependent functions)
    SQLITE, // SqLite Database helpers
    PLATFORM, // Artifacts for the specific Android SDK version (eg. 15, 19, 21 etc.)
    SUPPORT_V4, // Artifact for Android support-v4 library (contains some helpers for support.v4 Fragments)
    TOOLKIT; // Helpers for any other Android libraries
}