package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*

open class AndroidLayoutsTestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout { }
            relativeLayout { }
            absoluteLayout { }
            frameLayout { }
            gridLayout { }
        }
    }


}
