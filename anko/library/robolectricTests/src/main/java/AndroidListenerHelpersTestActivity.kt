package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import android.widget.LinearLayout
import android.view.View
import android.view.View.OnClickListener

public open class AndroidListenerHelpersTestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
               button() {
                  onClick {
                      text = "clicked"
                  }
               }
               checkBox {
                  onCheckedChange {
                     cb, checkstate ->
                        if(checkstate)
                            text = "checked"
                  }
               }
            }
        }
    }


}
