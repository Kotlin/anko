package com.example.android_test

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import org.jetbrains.anko.childrenRecursiveSequence
import org.jetbrains.anko.childrenSequence
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

open class ChildrenSequenceTestActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            id = 1

            relativeLayout {
                id = 2
                textView {
                    id = 3
                }
                textView {
                    id = 4
                }
                relativeLayout {
                    id = 5
                    textView {
                        id = 6
                    }
                }
            }
            textView {
                id = 7
            }
        }
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class) class ChildrenSequenceTest {
    @Test fun testChildrenSequence() {
        val activity = Robolectric.buildActivity(ChildrenSequenceTestActivity::class.java).create().get()

        val verticalLayout = activity.findViewById(1) as LinearLayout
        val relativeLayout = activity.findViewById(2) as RelativeLayout
        val textView = activity.findViewById(3) as TextView

        assertEquals(listOf(2, 7), verticalLayout.childrenSequence().map { it.id }.toList())
        assertEquals(listOf(3, 4, 5), relativeLayout.childrenSequence().map { it.id }.toList())
        assert(textView.childrenSequence().toList().isEmpty())
    }

    @Test fun testChildrenRecursiveSequence() {
        val activity = Robolectric.buildActivity(ChildrenSequenceTestActivity::class.java).create().get()

        val verticalLayout = activity.findViewById(1) as LinearLayout
        val relativeLayout = activity.findViewById(2) as RelativeLayout
        val textView = activity.findViewById(3) as TextView

        assertEquals(listOf(2, 7, 3, 4, 5, 6), verticalLayout.childrenRecursiveSequence().map { it.id }.toList())
        assertEquals(listOf(3, 4, 5, 6), relativeLayout.childrenRecursiveSequence().map { it.id }.toList())
        assert(textView.childrenRecursiveSequence().toList().isEmpty())
    }
}
