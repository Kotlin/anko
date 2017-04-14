package org.jetbrains.android.anko.artifact

import com.google.gson.Gson
import java.io.File

class Artifact(val name: String, val platformJars: List<File>, val targetJars: List<File>) {
    override fun toString(): String {
        return "$name: { platformJars = \"${platformJars.joinToString()}\", targetJars = \"${targetJars.joinToString()}\" }"
    }

    companion object {
        fun parseConfiguration(file: File): Configuration {
            val data = Gson().fromJson(file.readText(), ConfigurationData::class.java)
            val templates = data.templates
            val tunes = data.tunes

            val artifacts = mutableListOf<Artifact>()
            for (artifactData in data.artifacts) {
                val platformJars = artifactData.platform.map { File(substituteTemplates(it, templates)) }
                assert(platformJars.isNotEmpty())
                val targetJars = artifactData.target?.map { File(substituteTemplates(it, templates)) } ?: platformJars
                artifacts += Artifact(artifactData.name, platformJars, targetJars)
            }

            return Configuration(artifacts, tunes)
        }

        private fun substituteTemplates(s: String, templates: Map<String, String>): String {
            var result = s
            for ((key, value) in templates) {
                result = result.replace("%$key%", value)
            }
            return result
        }
    }
}

class Tunes(val excludedClasses: Set<String>)

class Configuration(val artifacts: List<Artifact>, val tunes: Tunes)

private class ConfigurationData(
        val templates: Map<String, String>,
        val artifacts: List<ArtifactData>,
        val tunes: Tunes
) {
    class ArtifactData(val name: String, val platform: List<String>, val target: List<String>?)
}