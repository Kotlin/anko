package org.jetbrains.android.anko.config

import java.io.File

val LOG_LEVEL = CliConfigurationKey(
        "logLevel",
        defaultValue = Logger.LogLevel.WARNING,
        mapper = { Logger.LogLevel.valueOf(it) })

val CONFIGURATION = CliConfigurationKey(
        "configuration",
        mapper = ::File)

val OUTPUT_DIRECTORY = CliConfigurationKey(
        "outputDirectory",
        mapper = ::File)

val ANDROID_SDK_LOCATION = CliConfigurationKey(
        "androidSdk",
        mapper = ::File)

val CLI_CONFIGURATION_KEYS: List<CliConfigurationKey<Any>> = listOf(
        LOG_LEVEL, CONFIGURATION, OUTPUT_DIRECTORY, ANDROID_SDK_LOCATION)