package com.example.android_test

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.*

open class AndroidLayoutsTestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            val name = find<TextView>(100)
            name.hint = "Enter your name"
            name.onClick { /*do something*/ }


            linearLayout { }
            relativeLayout { }
            absoluteLayout { }
            frameLayout { }
            gridLayout { }
        }
    }


}
