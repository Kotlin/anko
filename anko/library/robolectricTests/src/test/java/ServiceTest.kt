package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.vibrator
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

open class ServiceTestActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        linearLayout {}
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class) class ServiceTest {

    @Test fun test() {
        val activity = Robolectric.buildActivity(ServiceTestActivity::class.java).create().get()

        val vibrator = activity.vibrator
        vibrator.vibrate(100)

        println("[COMPLETE]")
    }

}
