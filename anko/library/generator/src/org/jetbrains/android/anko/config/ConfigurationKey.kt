package org.jetbrains.android.anko.config

import java.io.File

interface ConfigurationKey<out T : Any> {
    val name: String
    val defaultValue: T?
}

fun <T : Any> ConfigurationKey(name: String, defaultValue: T? = null): ConfigurationKey<T> = ConfigurationKeyImpl(name, defaultValue)

private open class ConfigurationKeyImpl<out T : Any>(
        override val name: String,
        override val defaultValue: T? = null) : ConfigurationKey<T>

class CliConfigurationKey<out T : Any>(
        name: String,
        val cliName: String = name,
        defaultValue: T? = null,
        val mapper: (String) -> T?
) : ConfigurationKey<T> by ConfigurationKeyImpl(name, defaultValue)

val LOG_LEVEL = CliConfigurationKey(
        "logLevel",
        defaultValue = LogManager.LogLevel.WARNING,
        mapper = { LogManager.LogLevel.valueOf(it) })

val ORIGINAL_DIRECTORY = CliConfigurationKey(
        "originalDirectory",
        mapper = ::File)

val OUTPUT_DIRECTORY = CliConfigurationKey(
        "outputDirectory",
        mapper = ::File)

val ANDROID_SDK_LOCATION = CliConfigurationKey(
        "androidSdk",
        mapper = ::File)

val CHECK_MODE = ConfigurationKey("checkMode", false)

val CLI_CONFIGURATION_KEYS: List<CliConfigurationKey<Any>> = listOf(
        LOG_LEVEL, ORIGINAL_DIRECTORY, OUTPUT_DIRECTORY, ANDROID_SDK_LOCATION)

interface Options {
    operator fun <T : Any> get(key: ConfigurationKey<T>): T = opt(key)!!
    fun <T : Any> opt(key: ConfigurationKey<T>): T?

    operator fun contains(key: ConfigurationKey<*>) = opt(key) != null

    companion object {
        fun create(): Options = OptionsImpl()
    }
}

interface MutableOptions : Options {
    operator fun <T : Any> set(key: ConfigurationKey<T>, value: T)

    companion object {
        fun create(): MutableOptions = OptionsImpl()
    }
}

fun <T : Any> MutableOptions.setCliOption(key: CliConfigurationKey<T>, stringValue: String) {
    val value = key.mapper(stringValue)
    if (value != null) {
        this[key] = value
    }
}

private class OptionsImpl : MutableOptions {
    private val options = mutableMapOf<ConfigurationKey<*>, Any>()

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> opt(key: ConfigurationKey<T>) = options[key] as T? ?: key.defaultValue

    override fun <T : Any> set(key: ConfigurationKey<T>, value: T) {
        options[key] = value
    }
}