package test

import android.app.Activity
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.robolectric.internal.ShadowExtractor
import org.robolectric.shadows.ShadowAlertDialog
import org.robolectric.shadows.ShadowLooper
import org.robolectric.shadows.ShadowToast

open class DialogsTestActivity : Activity() {
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
            button {
                id = 4
                onClick {
                    alert("Message", "NonCancelable") {
                        isCancelable = false
                        positiveButton("Ok") { dialog -> dialog.dismiss()  }
                    }.show()
                }
            }
        }
    }
}

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class) class DialogsTest {

    @Test fun test() {
        val activity = Robolectric.buildActivity(DialogsTestActivity::class.java).create().get()
        val button1 = activity.findViewById(1) as Button
        val button2 = activity.findViewById(2) as Button
        val button3 = activity.findViewById(3) as Button
        val button4 = activity.findViewById(4) as Button

        button1.performClick()
        ShadowLooper.idleMainLooper()
        assertEquals("Button 1 toast", ShadowToast.getTextOfLatestToast())

        button2.performClick()
        ShadowLooper.idleMainLooper()
        assertEquals("Button 2 toast", ShadowToast.getTextOfLatestToast())

        assertEquals(2, ShadowToast.shownToastCount())

        button3.performClick()
        val alert = ShadowAlertDialog.getLatestAlertDialog()
        assertNotNull(alert)
        val alertShadow = ShadowExtractor.extract(alert) as ShadowAlertDialog

        assertEquals("Message", alertShadow.message.toString())
        assertEquals("Title", alertShadow.title.toString())
        assertEquals(true, alertShadow.isCancelable)
        assertEquals(View.VISIBLE, alert.getButton(DialogInterface.BUTTON_POSITIVE).visibility)
        assertEquals(View.VISIBLE, alert.getButton(DialogInterface.BUTTON_NEGATIVE).visibility)
        assertEquals(View.GONE, alert.getButton(DialogInterface.BUTTON_NEUTRAL).visibility)
        alert.dismiss()

        ShadowLooper.idleMainLooper()

        button4.performClick()
        val nonCancelableAlert = ShadowAlertDialog.getLatestAlertDialog()
        assertNotNull(nonCancelableAlert)
        val nonCancelableAlertShadow = ShadowExtractor.extract(nonCancelableAlert) as ShadowAlertDialog
        assertEquals("NonCancelable", nonCancelableAlertShadow.title.toString())
        assertFalse(nonCancelableAlertShadow.isCancelable)

        println("[COMPLETE]")
    }
}