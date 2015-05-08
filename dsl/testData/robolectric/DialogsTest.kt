package test

import android.app.*
import android.content.DialogInterface
import android.widget.*
import android.os.Bundle
import org.jetbrains.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.shadows.*
import org.robolectric.*
import org.junit.Test
import org.junit.Assert.*

public open class TestActivity() : Activity() {
    public var dialog: AlertDialog? = null

    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)

        verticalLayout {
            button {
                id = 1
                onClick { toast("Button 1 toast") }
            }
            button {
                id = 2
                onClick { longToast("Button 2 toast") }
            }
            button {
                id = 3
                onClick {
                    alert("Message", "Title") {
                        positiveButton("Positive") {}
                        negativeButton("Negative") {}
                    }.show()
                }
            }
        }
    }
}

RunWith(javaClass<RobolectricTestRunner>())
public class RobolectricTest() {

    Test
    public fun test() {
        val activity = Robolectric.buildActivity(javaClass<TestActivity>()).create().get()
        val button1 = activity.findViewById(1) as Button
        val button2 = activity.findViewById(2) as Button
        val button3 = activity.findViewById(3) as Button

        button1.performClick()
        ShadowHandler.idleMainLooper()
        assertEquals("Button 1 toast", ShadowToast.getTextOfLatestToast())

        button2.performClick()
        ShadowHandler.idleMainLooper()
        assertEquals("Button 2 toast", ShadowToast.getTextOfLatestToast())

        assertEquals(2, ShadowToast.shownToastCount())

        button3.performClick()
        val alert = ShadowAlertDialog.getLatestAlertDialog()
        assertNotNull(alert)
        val alertShadow = Robolectric.shadowOf_<ShadowAlertDialog, AlertDialog>(alert)

        assertEquals("Message", alertShadow.getMessage().toString())
        assertEquals("Title", alertShadow.getTitle().toString())
        assertEquals(true, alertShadow.isCancelable())
        assertNotNull(alert.getButton(DialogInterface.BUTTON_POSITIVE))
        assertNotNull(alert.getButton(DialogInterface.BUTTON_NEGATIVE))
        assertNull(alert.getButton(DialogInterface.BUTTON_NEUTRAL))
        alert.dismiss()

        println("[COMPLETE]")
    }

}