package org.jetbrains.android.anko.config

import java.io.File

val LOG_LEVEL = CliConfigurationKey(
        "logLevel",
        defaultValue = Logger.LogLevel.WARNING,
        mapper = { Logger.LogLevel.valueOf(it) })

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