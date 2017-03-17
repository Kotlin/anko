package com.example.android_test

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.RelativeLayout
import org.jetbrains.anko.*

open class AndroidLayoutParamsTestActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                editText().lparams(-2, -2) {
                    bottomMargin = 1
                    leftMargin = 2
                    rightMargin = 3
                    topMargin = 4
                    height = 9
                    gravity = Gravity.RIGHT
                    weight = 1.3591409142295225f
                }
            }
            relativeLayout {
                editText().lparams(-2, -2) {
                    bottomMargin = 1
                    leftMargin = 2
                    rightMargin = 3
                    topMargin = 4
                    height = 9
                    addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
                    addRule(RelativeLayout.CENTER_IN_PARENT)
                }
            }
            absoluteLayout {
                editText().lparams(-2, -2, 12, 23) {
                    height = 9
                    x = 100
                    y = 200
                }
            }
            frameLayout {
                editText().lparams(-2, -2) {
                    bottomMargin = 1
                    leftMargin = 2
                    rightMargin = 3
                    topMargin = 4
                    height = 9
                    gravity = Gravity.RIGHT
                }
            }
            gridLayout {
                editText().lparams {
                    bottomMargin = 1
                    leftMargin = 2
                    rightMargin = 3
                    topMargin = 4
                    height = 9
                }
            }
        }
    }
}