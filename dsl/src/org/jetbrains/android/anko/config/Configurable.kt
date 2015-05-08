package org.jetbrains.android.anko.config

abstract class Configurable(val config: AnkoConfiguration)

fun <T> Configurable.generate(vararg file: AnkoFile, init: () -> Collection<T>) : Collection<T> {
    return if (file.any { config[it] }) init() else listOf()
}

fun <T> Configurable.generate(vararg tune: ConfigurationTune, init: () -> Collection<T>) : Collection<T> {
    return if (tune.any { config[it] }) init() else listOf()
}