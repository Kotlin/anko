package org.jetbrains.android.anko.config

enum class ArtifactType(val nameInConfiguration: String) {
    COMMONS("commons"), // Anko Commons (does not contain platform-dependent functions)
    SQLITE("sqlite"), // Anko SQLite
    PLATFORM("platform"), // Anko Layouts for the specific Android SDK version (eg. 15, 19, 21 etc.)
    SUPPORT_V4("supportV4"), // Anko Layouts for Android support-v4 library
    TOOLKIT("toolkit"), // Anko Layouts for any other Android libraries
    SIMPLE_LISTENERS("simpleListeners"), // Old View listeners
    COROUTINE_LISTENERS("coroutineListeners") // View listeners with coroutine support
}