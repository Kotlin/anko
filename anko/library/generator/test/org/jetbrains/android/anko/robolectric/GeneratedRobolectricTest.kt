package org.jetbrains.android.anko.robolectric

import org.junit.*

class GeneratedRobolectricTest : AbstractRobolectricTest() {
    @Test
    fun testAttemptTestForSdk23() {
        runRobolectricTest("AttemptTest.kt", "sdk23")
    }

    @Test
    fun testCollectionsTestForSdk23() {
        runRobolectricTest("CollectionsTest.kt", "sdk23")
    }

    @Test
    fun testDialogsTestForSdk23() {
        runRobolectricTest("DialogsTest.kt", "sdk23")
    }

    @Test
    fun testFindViewTestForSdk23() {
        runRobolectricTest("FindViewTest.kt", "sdk23")
    }

    @Test
    fun testServiceTestForSdk23() {
        runRobolectricTest("ServiceTest.kt", "sdk23")
    }

    @Test
    fun testSimpleTestForSdk23() {
        runRobolectricTest("SimpleTest.kt", "sdk23")
    }

}
