package com.jetbrains.android.dsl

import java.io.File

class DSLGenerator(
  val version: Int,
  val fVersion: String,
  val jars: List<String>,
  val props: BaseGeneratorProps): Runnable
{

  private val sVersion = version.toString()

  private val mvnManifest: String
    get() = readFile("props/mvn/AndroidManifest.xml")

  private fun copy(original: String) {
    val originalFile = File("props/mvn/$original")
    val toCreateFile = File((props.outputDirectory+original))
    originalFile.copyTo(toCreateFile)
  }

  private fun copy(original: String, process: (String) -> String) {
    val contents = process(readFile("props/mvn/$original"))
    writeFile(props.outputDirectory+original, contents)
  }

  override fun run() {
    props.generateSupport = fVersion.contains("s")

    val classTree = ClassProcessor(jars).genClassTree()
    val generator = Generator(classTree, props)
    val renderer = Renderer(generator)
    Writer(renderer).write()

    if (props.generateMavenArtifact) {
      //create res directory
      val resDirectory = File(props.outputDirectory+"src/main/res/")
      if (!resDirectory.exists()) {
        resDirectory.mkdirs()
      }

      //write manifest
      val manifest = mvnManifest.replace("%VERSION%", sVersion)
      writeFile(props.outputDirectory+"src/main/AndroidManifest.xml", manifest)

      //copy gradle wrapper
      copy("gradlew")
      copy("gradlew.bat")
      copy("gradle/wrapper/gradle-wrapper.jar")
      copy("gradle/wrapper/gradle-wrapper.properties")

      //copy gradle build files
      copy("gradle.properties") { it.replace("%FVERSION%", fVersion) }
      copy("maven_push.gradle")
      copy("build.gradle") { it.replace("%VERSION%", sVersion) }
    }
  }
}