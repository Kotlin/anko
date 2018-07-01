package com.example.android_test

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.info
import org.jetbrains.anko.verbose
import org.jetbrains.anko.warn
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class) class AnkoLoggerTest {
    private val log = AnkoLogger<AnkoLoggerTest>()

    @Test
    fun test() {
        val outputStream = java.io.ByteArrayOutputStream(1024)
        val printStream = java.io.PrintStream(outputStream)
        ShadowLog.stream = printStream

        log.info("InfoMessage")
        log.verbose("VerboseMessage")
        log.warn { "WarnMessage" }
        log.error { "ErrorMessage" }

        val messages = outputStream.toString()
        println(messages)

        assertTrue("InfoMessage" in messages)
        assertTrue("VerboseMessage" in messages)
        assertTrue("WarnMessage" in messages)
        assertTrue("ErrorMessage" in messages)
    }
}
