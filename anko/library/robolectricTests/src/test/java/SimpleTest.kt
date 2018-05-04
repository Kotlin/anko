package com.example.android_test

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

open class SimpleTestActivity : Activity() {
    var ctxProperty: Context? = null
    var actProperty: Activity? = null

    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        ctxProperty = ctx
        actProperty = act

        verticalLayout {
            val text = textView("Some text") {
                id = 1
            }
            button {
                id = 2
                onClick { text.text = "New text" }
            }
        }
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class) class SimpleTest {

    @Test fun test() {
        val activity = Robolectric.buildActivity(SimpleTestActivity::class.java).create().get()
        val textView = activity.findViewById(1) as TextView
        val button = activity.findViewById(2) as Button

        assertNotNull(activity.ctxProperty)
        assertNotNull(activity.actProperty)

        assertEquals(activity.ctxProperty, activity)
        assertEquals(activity.actProperty, activity)

        assertEquals("Some text", textView.text.toString())
        button.performClick()
        assertEquals("New text", textView.text.toString())

        println("[COMPLETE]")
    }

}
