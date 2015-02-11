package test

import android.app.*
import android.widget.*
import android.os.Bundle
import kotlinx.android.koan.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import kotlin.test.*

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

        val verticalLayout = activity.find<LinearLayout>(1)
        val relativeLayout = activity.find<RelativeLayout>(2)

        val button = relativeLayout.find<Button>(3)
        val textView = verticalLayout.find<TextView>(4)

        println("[COMPLETE]")
    }

}