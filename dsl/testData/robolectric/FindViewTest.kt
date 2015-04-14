package test

import android.app.*
import android.widget.*
import android.os.Bundle
import kotlinx.android.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import kotlin.test.*
import org.junit.Assert.*

public open class TestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        verticalLayout {
            id = 1

            relativeLayout {
                id = 2

                button {
                    id = 3
                }
            }

            val text = textView {
                id = 4
            }
        }
    }
}

RunWith(javaClass<RobolectricTestRunner>())
public class RobolectricTest() {

    Test
    public fun test() {
        val activity = Robolectric.buildActivity(javaClass<TestActivity>()).create().get()

        val verticalLayout = activity.findViewById(1) as? LinearLayout
        val relativeLayout = activity.findViewById(2) as? RelativeLayout

        assertNotNull(verticalLayout)
        assertNotNull(relativeLayout)

        val button = relativeLayout!!.findViewById(3) as? Button
        val textView = verticalLayout!!.findViewById(4) as? TextView

        assertNotNull(button)
        assertNotNull(textView)

        assertEquals(2, verticalLayout!!.getChildCount())
        assertEquals(1, relativeLayout!!.getChildCount())

        println("[COMPLETE]")
    }

}