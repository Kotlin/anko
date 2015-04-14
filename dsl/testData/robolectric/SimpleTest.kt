package test

import android.app.*
import android.widget.*
import android.os.Bundle
import kotlinx.android.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import org.junit.Assert.*

public open class TestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

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

RunWith(javaClass<RobolectricTestRunner>())
public class RobolectricTest() {

    Test
    public fun test() {
        val activity = Robolectric.buildActivity(javaClass<TestActivity>()).create().get()
        val textView = activity.findViewById(1) as TextView
        val button = activity.findViewById(2) as Button

        assertEquals("Some text", textView.getText().toString())
        button.performClick()
        assertEquals("New text", textView.getText().toString())

        println("[COMPLETE]")
    }

}