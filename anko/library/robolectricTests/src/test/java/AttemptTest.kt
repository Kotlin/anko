package test

import org.jetbrains.anko.AttemptResult
import org.jetbrains.anko.attempt
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
public class AttemptTest() {
    @Test
    public fun test() {
        val (value, error) = attempt { "My String" }
        assertEquals("My String", value)
        assertNull(error)
        
        val (value1, error1) = attempt { 5 }
        assertEquals(5, value1)
        assertNull(error1)
        
        val (value2, error2) = attempt { "A".toInt() }
        assertNull(value2)
        assertTrue(error2 is NumberFormatException)
        
        val (value3, error3) = attempt { throw Throwable() }
        assertNull(value3)
        assertTrue(error3 is Throwable)
        
        val (value4, error4) = attempt { attempt { throw Throwable() } }
        assertTrue(value4 is AttemptResult<*>)
        assertNull(error4)
        assertNull(value4?.value)
        assertTrue(value4?.error is Throwable)

        println("[COMPLETE]")
    }
}