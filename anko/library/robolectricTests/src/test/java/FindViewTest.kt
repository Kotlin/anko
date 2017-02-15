package test

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

open class FindViewTestActivity : Activity() {
    @SuppressLint("SetTextI18n")
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        verticalLayout {
            id = 1

            relativeLayout {
                id = 2

                customView<Button> {
                    text = "Button text"
                    id = 3
                }
            }

            textView {
                id = 4
            }
        }
    }
}

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class) class FindViewTest {

    @Test fun test() {
        val activity = Robolectric.buildActivity(FindViewTestActivity::class.java).create().get()

        val verticalLayout = activity.findViewById(1) as? LinearLayout
        val relativeLayout = activity.findViewById(2) as? RelativeLayout

        assertNotNull(verticalLayout)
        assertNotNull(relativeLayout)

        val button = relativeLayout!!.findViewById(3) as? Button
        val textView = verticalLayout!!.findViewById(4) as? TextView

        assertNotNull(button)
        assertNotNull(textView)

        assertEquals("Button text", button!!.text.toString())

        assertEquals(2, verticalLayout.childCount)
        assertEquals(1, relativeLayout.childCount)

        println("[COMPLETE]")
    }

}