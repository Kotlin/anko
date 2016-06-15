package test

import android.app.*
import android.widget.*
import android.os.Bundle
import org.jetbrains.anko.*
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.*
import org.junit.Test
import org.junit.Assert.*

public open class ServiceTestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        linearLayout {}
    }
}

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class)
public class ServiceTest() {

    @Test
    public fun test() {
        val activity = Robolectric.buildActivity(ServiceTestActivity::class.java).create().get()

        val vibrator = activity.vibrator
        vibrator.vibrate(100)

        println("[COMPLETE]")
    }

}