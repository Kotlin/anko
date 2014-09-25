package com.jetbrains.android.dsl.xmlconverter

import java.util.HashMap
import java.util.ArrayList
import java.util.HashSet

abstract class BaseConverterSettings {
  abstract val ignoredProperties: Set<String>
  abstract val quotedKeys: Set<String>
  abstract val helperConProps: HashMap<String, ArrayList<Set<String>>>

	abstract val dslPackage: String
	abstract val className: String
}