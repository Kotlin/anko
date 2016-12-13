package test

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

public open class SimpleTestActivity() : Activity() {
    public var ctxProperty: Context? = null
    public var actProperty: Activity? = null

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

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
public class SimpleTest() {

    @Test
    public fun test() {
        val activity = Robolectric.buildActivity(SimpleTestActivity::class.java).create().get()
        val textView = activity.findViewById(1) as TextView
        val button = activity.findViewById(2) as Button

        assertNotNull(activity.ctxProperty)
        assertNotNull(activity.actProperty)

        assertEquals(activity.ctxProperty, activity)
        assertEquals(activity.actProperty, activity)

        assertEquals("Some text", textView.getText().toString())
        button.performClick()
        assertEquals("New text", textView.getText().toString())

        println("[COMPLETE]")
    }

}