package com.jetbrains.android.dsl

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.ByteBuffer
import java.io.File
import java.util.HashMap

abstract class BaseGeneratorProps() {
	open var generateImports: Boolean = true
	open var generatePackage: Boolean = true

	open var generateProperties: Boolean = true
	open var generatePropertySetters: Boolean = true
	open var generateLayoutParamsHelperClasses: Boolean = true
	open var generateViewExtensionMethods: Boolean = true
	open var generateViewHelperConstructors: Boolean = true
	open var generateViewGroupExtensionMethods: Boolean = true
	open var generateSimpleListeners: Boolean = true
	open var generateComplexListenerClasses: Boolean = true
	open var generateComplexListenerSetters: Boolean = true

  abstract public fun getOutputFile(subsystem: Subsystem): File

	abstract val indent: String

  abstract val outputDirectory: String
  abstract val outputPackage: String

  abstract val viewGroupBaseClass: String
  abstract val viewBaseClass: String

  abstract val imports: HashMap<String, String>

  abstract val excludedClasses: Set<String>
  abstract val excludedMethods: Set<String>
  abstract val helperConstructors: Map<String, List<List<String>>>
	abstract val customMethodParameters: Map<String, String>
}