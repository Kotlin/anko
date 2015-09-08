package test

import android.app.*
import android.content.Context
import android.widget.*
import android.os.Bundle
import org.jetbrains.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import org.junit.Assert.*

public open class TestActivity() : Activity() {
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

@RunWith(RobolectricTestRunner::class)
public class RobolectricTest() {

    Test
    public fun test() {
        val activity = Robolectric.buildActivity(javaClass<TestActivity>()).create().get()
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