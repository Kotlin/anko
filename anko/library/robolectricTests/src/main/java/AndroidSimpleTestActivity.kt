package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import android.widget.LinearLayout
import org.jetbrains.anko.sdk15.listeners.onClick

open class AndroidSimpleTestActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                val tv1 = textView {
                    text = "9287y4r3"
                }
                button {
                    text = "Buttons1231"
                    onClick {

                    }
                    setOnClickListener {
                        tv1.text = text
                    }
                }
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    checkBox {
                        text = "34563456"
                    }
                    button {
                        text = "9auhdfg9a"
                    }
                }
            }
        }
    }


}
