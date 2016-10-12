package test

import android.os.Bundle
import org.jetbrains.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import org.junit.Assert.*
import java.io.*
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
public class AnkoLoggerTest() {
    private val log = AnkoLogger(this)

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