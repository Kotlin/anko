package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.FrameLayout
import android.widget.GridLayout
import android.view.Gravity


public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                        weight = 1.3591409142295225f
                    }
                }
            }
            relativeLayout {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
                        addRule(RelativeLayout.CENTER_IN_PARENT)
                    }
                }
            }
            scrollView {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                    }
                }
            }
            frameLayout {
                editText {
                    layoutParams(-2, -2) {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                    }
                }
            }
            gridLayout {
                editText {
                    layoutParams() {
                        bottomMargin = 1
                        leftMargin = 2
                        rightMargin = 3
                        topMargin = 4
                        height = 9
                        gravity = Gravity.RIGHT
                    }
                }
            }
        }
    }
}