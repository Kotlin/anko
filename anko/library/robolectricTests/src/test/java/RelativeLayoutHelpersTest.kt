package com.example.android_test

import android.app.Activity
import android.view.View
import android.widget.RelativeLayout
import org.jetbrains.anko.UI
import org.jetbrains.anko.above
import org.jetbrains.anko.alignParentBottom
import org.jetbrains.anko.alignParentEnd
import org.jetbrains.anko.alignParentLeft
import org.jetbrains.anko.alignParentRight
import org.jetbrains.anko.alignParentStart
import org.jetbrains.anko.alignParentTop
import org.jetbrains.anko.below
import org.jetbrains.anko.bottomOf
import org.jetbrains.anko.centerHorizontally
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.centerVertically
import org.jetbrains.anko.leftOf
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.rightOf
import org.jetbrains.anko.sameBottom
import org.jetbrains.anko.sameLeft
import org.jetbrains.anko.sameRight
import org.jetbrains.anko.sameTop
import org.jetbrains.anko.textView
import org.jetbrains.anko.topOf
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

open class RelativeLayoutHelpersTestActivity : Activity()

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class) class RelativeLayoutHelpersTest {

    @Test fun test() {
        val activity = Robolectric.buildActivity(RelativeLayoutHelpersTestActivity::class.java).create().get()
        test(activity)

        println("[COMPLETE]")
    }

}

fun test(activity: Activity) {
    val fst = 50
    val snd = 60
    with (activity) {
        fun get(rule: Int, l: RelativeLayout.LayoutParams.(View) -> Unit) = test(fst, snd, l).rules[rule]
        assertTrue(get(RelativeLayout.BELOW) { below(fst) } == fst)
        assertTrue(get(RelativeLayout.BELOW) { bottomOf(fst) } == fst)
        assertTrue(get(RelativeLayout.ABOVE) { above(fst) } == fst)
        assertTrue(get(RelativeLayout.ABOVE) { topOf(fst) } == fst)
        assertTrue(get(RelativeLayout.LEFT_OF) { leftOf(fst) } == fst)
        assertTrue(get(RelativeLayout.RIGHT_OF) { rightOf(fst) } == fst)

        assertTrue(test(fst, snd) { below(it) }.rules[RelativeLayout.BELOW] == fst)

        assertTrue(get(RelativeLayout.ALIGN_LEFT) { sameLeft(fst) } == fst)
        assertTrue(get(RelativeLayout.ALIGN_TOP) { sameTop(fst) } == fst)
        assertTrue(get(RelativeLayout.ALIGN_RIGHT) { sameRight(fst) } == fst)
        assertTrue(get(RelativeLayout.ALIGN_BOTTOM) { sameBottom(fst) } == fst)

        assertTrue(get(RelativeLayout.ALIGN_PARENT_BOTTOM) { alignParentBottom() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.ALIGN_PARENT_TOP) { alignParentBottom() } == 0)
        assertTrue(get(RelativeLayout.ALIGN_PARENT_LEFT) { alignParentLeft() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.ALIGN_PARENT_RIGHT) { alignParentRight() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.ALIGN_PARENT_START) { alignParentStart() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.ALIGN_PARENT_END) { alignParentEnd() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.CENTER_VERTICAL) { centerVertically() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.CENTER_HORIZONTAL) { centerHorizontally() } == RelativeLayout.TRUE)
        assertTrue(get(RelativeLayout.CENTER_IN_PARENT) { centerInParent() } == RelativeLayout.TRUE)

        val compoundRules = test(fst, snd) { alignParentTop(); alignParentLeft(); above(it); sameLeft(it) }.rules
        assertTrue(compoundRules[RelativeLayout.ALIGN_PARENT_TOP] == RelativeLayout.TRUE)
        assertTrue(compoundRules[RelativeLayout.ALIGN_PARENT_LEFT] == RelativeLayout.TRUE)
        assertTrue(compoundRules[RelativeLayout.ALIGN_PARENT_BOTTOM] == 0)
        assertTrue(compoundRules[RelativeLayout.ABOVE] == fst)
        assertTrue(compoundRules[RelativeLayout.ALIGN_LEFT] == fst)
    }
}

fun Activity.test(fst: Int, snd: Int, l: RelativeLayout.LayoutParams.(View) -> Unit) = (UI {
    relativeLayout {
        val fstView = textView {
            id = fst
        }
        textView {
            id = snd
        }.lparams { l(fstView) }
    }
}.view as RelativeLayout).findViewById<View>(snd)?.layoutParams as RelativeLayout.LayoutParams
