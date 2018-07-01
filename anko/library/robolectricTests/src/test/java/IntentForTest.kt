package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.intentFor
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

open class IntentForTestActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
    }
}

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class IntentForTest {

    @Test
    fun test() {
        val activity = Robolectric.buildActivity(IntentForTestActivity::class.java).create().get()

        val intent1 = activity.intentFor<IntentForTestActivity>()
        assert(intent1.extras == null)

        val intent2 = activity.intentFor<IntentForTestActivity>(
                "one" to 1,
                "abc" to "ABC",
                "null" to null)

        val extras2 = intent2.extras!!
        assert(extras2.size() == 3)
        assert(extras2.get("one") == 1)
        assert(extras2.get("abc") == "ABC")
        assert(extras2.get("null") == null)

        println("[COMPLETE]")
    }
}
