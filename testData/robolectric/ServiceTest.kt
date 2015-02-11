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
        linearLayout {}
    }
}

RunWith(javaClass<RobolectricTestRunner>())
public class RobolectricTest() {

    Test
    public fun test() {
        val activity = Robolectric.buildActivity(javaClass<TestActivity>()).create().get()

        val vibrator = activity.vibrator
        vibrator.vibrate(100)

        println("[COMPLETE]")
    }

}