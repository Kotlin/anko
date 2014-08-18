package com.jetbrains.android.dsl

class DSLGenerator(val jars: Array<String>, val props: BaseGeneratorProps): Runnable {

	override fun run() {
		val classTree = ClassProcessor(jars).genClassTree()
		val generator = Generator(classTree, props)
		val renderer = Renderer(generator)
		Writer(renderer).write()
	}
}