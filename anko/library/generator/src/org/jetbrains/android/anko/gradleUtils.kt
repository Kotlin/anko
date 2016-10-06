package org.jetbrains.android.anko

import java.io.File

private val mvnManifest: String
    get() = File("anko/props/mvn/AndroidManifest.xml").readText()

fun generateMavenArtifact(outputDirectory: File, artifactName: String, sdkVersion: String) {
    fun copy(original: String) {
        val originalFile = File("anko/props/mvn/$original")
        val toCreateFile = File(outputDirectory, original)
        originalFile.copyTo(toCreateFile)
    }

    fun copy(original: String, process: (String) -> String) {
        val contents = process(File("anko/props/mvn/$original").readText())
        File(outputDirectory, original).writeText(contents)
    }
    
    // Create res directory
    val resDirectory = File(outputDirectory, "src/main/res/")
    if (!resDirectory.exists()) {
        resDirectory.mkdirs()
    }

    // Write manifest
    val manifest = mvnManifest.replace("%SDK_VERSION", sdkVersion)
    File(outputDirectory, "src/main/AndroidManifest.xml").writeText(manifest)

    // Copy gradle wrapper
    copy("gradlew")
    copy("gradlew.bat")
    copy("gradle/wrapper/gradle-wrapper.jar")
    copy("gradle/wrapper/gradle-wrapper.properties")

    // Copy gradle build files
    fun String.substVersions(): String {
        return replace("%SDK_VERSION", sdkVersion)
                .replace("%ARTIFACT_VERSION", File("version.txt").readText())
                .replace("%ARTIFACT_NAME", artifactName)
    }
    copy("gradle.properties", String::substVersions)
    copy("build.gradle", String::substVersions)
}