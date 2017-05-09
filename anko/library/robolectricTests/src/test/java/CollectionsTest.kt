package test

import org.jetbrains.anko.collections.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class) class CollectionsTest {
    @Test fun test() {
        testArray(emptyArray<Int>())
        testArray(emptyArray<String>())
        assertEquals(listOf(1, 2, 3), testArray(arrayOf(1, 2, 3)))
        assertEquals(listOf("A", "B", "C"), testArray(arrayOf("A", "B", "C")))
        assertEquals(listOf("A", null, "C"), testArray(arrayOf("A", null, "C")))

        testList(emptyList<Int>())
        testList(emptyList<String>())
        assertEquals(listOf(1, 2, 3), testList(listOf(1, 2, 3)))
        assertEquals(listOf("A", "B", "C"), testList(listOf("A", "B", "C")))
        assertEquals(listOf("A", null, "C"), testList(listOf("A", null, "C")))

        val pair = Pair(1, "A")
        val androidPair = pair.toAndroidPair()
        val kotlinPair = androidPair.toKotlinPair()
        assertEquals(pair.first, androidPair.first)
        assertEquals(pair.second, androidPair.second)
        assertEquals(pair, kotlinPair)

        println("[COMPLETE]")
    }

    private fun <T> testArray(arr: Array<T>): List<T> {
        val elements = mutableListOf<T>()
        val elements2 = mutableListOf<T>()
        val indices = mutableListOf<Int>()

        val elementsReversed = mutableListOf<T>()
        val elements2Reversed = mutableListOf<T>()
        val indicesReversed = mutableListOf<Int>()

        arr.forEachByIndex { element ->
            elements += element
        }

        arr.forEachWithIndex { index, element ->
            elements2 += element
            indices += index
        }

        arr.forEachReversedByIndex { element ->
            elementsReversed += element
        }

        arr.forEachReversedWithIndex { index, element ->
            elements2Reversed += element
            indicesReversed += index
        }

        assertEquals(elements.size, arr.size)
        assertEquals(arr.toList(), elements)
        assertEquals(arr.toList().reversed(), elementsReversed)

        assertEquals(elements, elements2)
        assertEquals(elementsReversed, elements2Reversed)

        assertEquals(arr.size, indices.size)
        assertEquals(indicesReversed.reversed(), indices)
        assertTrue((0..arr.size - 1).all { it in indices })

        return elements
    }

    private fun <T> testList(list: List<T>): List<T> {
        val elements = mutableListOf<T>()
        val elements2 = mutableListOf<T>()
        val indices = mutableListOf<Int>()

        val elementsReversed = mutableListOf<T>()
        val elements2Reversed = mutableListOf<T>()
        val indicesReversed = mutableListOf<Int>()

        list.forEachByIndex { element ->
            elements += element
        }

        list.forEachWithIndex { index, element ->
            elements2 += element
            indices += index
        }

        list.forEachReversedByIndex { element ->
            elementsReversed += element
        }

        list.forEachReversedWithIndex { index, element ->
            elements2Reversed += element
            indicesReversed += index
        }

        assertEquals(elements.size, list.size)
        assertEquals(list.toList(), elements)
        assertEquals(list.toList().reversed(), elementsReversed)

        assertEquals(elements, elements2)
        assertEquals(elementsReversed, elements2Reversed)

        assertEquals(list.size, indices.size)
        assertEquals(indicesReversed.reversed(), indices)
        assertTrue((0..list.size - 1).all { it in indices })

        return elements
    }

}