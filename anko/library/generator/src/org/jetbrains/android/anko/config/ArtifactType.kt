package org.jetbrains.android.anko.config

enum class ArtifactType(val nameInConfiguration: String) {
    COMMON("common"), // Common stuff (does not contain platform-dependent functions)
    SQLITE("sqlite"), // SqLite Database helpers
    PLATFORM("platform"), // Artifacts for the specific Android SDK version (eg. 15, 19, 21 etc.)
    SUPPORT_V4("supportV4"), // Artifact for Android support-v4 library (contains some helpers for support.v4 Fragments)
    TOOLKIT("toolkit"), // Helpers for any other Android libraries
    SIMPLE_LISTENERS("simpleListeners"), // Old View listeners
    COROUTINE_LISTENERS("coroutineListeners") // View listeners with coroutine support
}