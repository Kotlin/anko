package test

import android.os.Bundle
import org.jetbrains.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import org.junit.Assert.*

@RunWith(RobolectricTestRunner::class)
public class RobolectricTest() {
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