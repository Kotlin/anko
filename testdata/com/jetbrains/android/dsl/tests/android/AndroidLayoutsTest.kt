package com.example.android_test

import android.app.Activity
import android.os.Bundle
import kotlinx.android.dsl.*
import android.widget.LinearLayout

public open class MyActivity() : Activity() {
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
