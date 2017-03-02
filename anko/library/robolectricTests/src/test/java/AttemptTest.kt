package test

import org.jetbrains.anko.AttemptResult
import org.jetbrains.anko.attempt
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class) class AttemptTest {
    @Test fun test() {
        val (value, error) = attempt { "My String" }
        assertEquals("My String", value)
        assertNull(error)
        
        val result1 = attempt { 5 }
        assertTrue(result1.hasValue)
        assertFalse(result1.isError)
        assertEquals(5, result1.value)
        assertNull(result1.error)
        
        val (value2, error2) = attempt { "A".toInt() }
        assertNull(value2)
        assertTrue(error2 is NumberFormatException)
        
        val result3 = attempt { throw Throwable() }
        assertTrue(result3.isError)
        assertFalse(result3.hasValue)
        assertNull(result3.value)
        assertTrue(result3.error is Throwable)
        
        val (value4, error4) = attempt { attempt { throw Throwable() } }
        assertTrue(value4 is AttemptResult<*>)
        assertNull(error4)
        assertNull(value4?.value)
        assertTrue(value4?.error is Throwable)

        val (value5, error5) = attempt { throw NullPointerException() }.then { throw IllegalStateException() }
        assertNull(value5)
        assert(error5 is NullPointerException)

        val (value6, error6) = attempt { 5 + 2 }.then { throw NullPointerException() }
        assertNull(value6)
        assert(error6 is NullPointerException)

        val (value7, error7) = attempt { 5 }.then { it + 5 }
        assertEquals(10, value7)
        assertNull(error7)

        val result8 = attempt { null }
        assertTrue(result8.hasValue)
        assertFalse(result8.isError)
        assertNull(result8.value)
        assertNull(result8.error)

        println("[COMPLETE]")
    }
}