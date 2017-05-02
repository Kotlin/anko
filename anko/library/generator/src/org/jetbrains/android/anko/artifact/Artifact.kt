package org.jetbrains.android.anko.artifact

import com.google.gson.Gson
import org.jetbrains.android.anko.config.ArtifactType
import java.io.File

class Artifact(val name: String, val type: ArtifactType, val platformJars: List<File>, val targetJars: List<File>) {
    override fun toString(): String {
        return "$name: { platformJars = \"${platformJars.joinToString()}\", targetJars = \"${targetJars.joinToString()}\" }"
    }

    companion object {
        fun parseConfiguration(file: File): ExecutionConfiguration {
            val data = Gson().fromJson(file.readText(), ExecutionConfigurationData::class.java)
            val templates = data.templates
            val tunes = data.tunes

            val artifacts = mutableListOf<Artifact>()
            for (artifactData in data.artifacts) {
                val platformJars = artifactData.platform.map { File(substituteTemplates(it, templates)) }
                assert(platformJars.isNotEmpty())
                val targetJars = artifactData.target?.map { File(substituteTemplates(it, templates)) } ?: platformJars
                val type = ArtifactType.values().firstOrNull { it.nameInConfiguration == artifactData.type }
                        ?: error("Type invalid or not specified for artifact ${artifactData.name}")
                artifacts += Artifact(artifactData.name, type, platformJars, targetJars)
            }

            return ExecutionConfiguration(artifacts, tunes)
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

class ExecutionConfiguration(val artifacts: List<Artifact>, val tunes: Tunes)

private class ExecutionConfigurationData(
        val templates: Map<String, String>,
        val artifacts: List<ArtifactData>,
        val tunes: Tunes
) {
    class ArtifactData(val name: String, val type: String, val platform: List<String>, val target: List<String>?)
}