@file:Suppress("UNUSED_PARAMETER", "EqualsOrHashCode")

package test

import android.text.SpannedString
import org.jetbrains.anko.db.ClassParserConstructor
import org.jetbrains.anko.db.classParser
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
class ClassParserTest {
    @Test
    fun test() {
        with (classParser<Class1>()) {
            arrayOf<Any?>("A", Long.MAX_VALUE, Double.MIN_VALUE).also {
                assertEquals(Class1("A", Long.MAX_VALUE, Double.MIN_VALUE), parseRow(it))
                assertThrows { parseRow(emptyArray()) }
                assertThrows { parseRow(arrayOf<Any?>(1)) }
            }
        }

        with (classParser<Class1>()) {
            arrayOf<Any?>('A', 5, -1.0).also {
                val cl = Class1("A", 5, -1.0)
                assertEquals(cl, parseRow(it))
                assertThrows { parseRow(arrayOf("A", 5.0, -1.0)) }
                assertEquals(cl, parseRow(arrayOf('A', 5, -1.0f)))
            }
        }

        with (classParser<Class2>()) {
            arrayOf<Any?>('c', 4, (-2).toShort(), -10.0F).also {
                val cl = Class2('c', 4, (-2).toShort(), -10.0F)
                assertEquals(cl, parseRow(it))
                assertEquals(cl, parseRow(arrayOf("c", 4L, -2, -10.0)))
                assertEquals(cl, parseRow(arrayOf("c", 4L, -2L, -10.0)))
                assertThrows { parseRow(arrayOf("cc", 4L, -2, -10.0)) }
                assertThrows { parseRow(arrayOf('c', 4.0, -2, -10.0)) }
            }
        }
        
        assertThrows { classParser<Class3>() }
        
        with (classParser<Class4>()) {
            arrayOf<Any?>("ABC", "BCD", null).also {
                assertEquals(Class4("ABC", "BCD", null), parseRow(it))
                parseRow(arrayOf(SpannedString("ABC"), "BCD", 'c'))
            }
        }

        assertThrows { classParser<Class5>() }

        assertThrows { classParser<Class6>() }

        assertThrows { classParser<Class7>() }

        assertThrows { classParser<Class8>() }

        assertThrows { classParser<Class9>() }

        classParser<Class10>()

        assertThrows { classParser<Class11>() }

        with (classParser<Class12>()) {
            arrayOf<Any?>(0).also {
                val clTrue = Class12(true)
                val clFalse = Class12(false)

                assertEquals(clFalse, parseRow(it))
                assertEquals(clFalse, parseRow(arrayOf(0L)))

                assertEquals(clTrue, parseRow(arrayOf(1)))
                assertEquals(clTrue, parseRow(arrayOf(1L)))
            }
        }
    }

    data class Class1(val s: String, val l: Long, val d: Double?)
    data class Class2(val c: Char, val i: Int?, val s: Short, val f: Float)
    class Class3
    data class Class4(val a: CharSequence, val b: String, val c: Char?)
    data class Class5 private constructor(val s: String)
    data class Class6 protected constructor(val s: String)
    data class Class7(val a: String, val b: Throwable)
    class Class8(vararg val a: String) {
        override fun equals(other: Any?) = a.contentEquals((other as Array<*>))
    }

    class Class9 {
        constructor(a: Int)
        constructor(a: Long)
    }

    class Class10 {
        @ClassParserConstructor constructor(a: Int)
        constructor(a: Long)
    }

    class Class11 {
        @ClassParserConstructor constructor(a: Int)
        @ClassParserConstructor constructor(a: Long)
    }

    private fun assertThrows(f: () -> Unit) {
        try {
            f()
        } catch (e: Exception) {
            return
        }
        throw AssertionError("Exception was not thrown")
    }

    data class Class12(val b: Boolean)
}