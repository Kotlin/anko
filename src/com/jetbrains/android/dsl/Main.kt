package com.jetbrains.android.dsl

import java.io.File

fun main(args: Array<String>) {
  val original = File("original/")
  if (!original.exists() || !original.isDirectory()) {
    throw RuntimeException("\"original\" directory does not exist.")
  }
  val versions = original.listFiles { it.isDirectory() } ?: array<File>()

  for (version in versions) {
    val jars = version.listFiles { it.isFile() && it.getName().toLowerCase().endsWith(".jar") }
      ?.map { it.getAbsolutePath() } ?: listOf<String>()
    val intVersion = parseVersion(version.getName())
    if (intVersion!=null && jars.isNotEmpty()) {
      println("Processing version=${version.getName()}, jars: ${jars.joinToString(",")}")

      val outputDirectory = "gen/${version.getName()}/"
      val fileOutputDirectory = File("$outputDirectory/src/main/kotlin/")
      if (!fileOutputDirectory.exists()) {
        fileOutputDirectory.mkdirs()
      }

      DSLGenerator(intVersion, version.getName(), jars, GeneratorProps(outputDirectory)).run()
    }
  }

  File("props/mvn/deploy.sh").copyTo(File("gen/deploy.sh"))
}

private fun parseVersion(name: String): Int? {
  val prob = name.filter { it.isDigit() }
  return if (prob.isNotEmpty())
    prob.toInt()
  else null
}