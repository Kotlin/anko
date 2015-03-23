package com.example.android_test

import android.app.Activity
import android.os.Bundle
import kotlinx.android.anko.*
import android.widget.LinearLayout
import android.view.View
import android.view.View.OnClickListener

public open class MyActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                listView {
                    onScroll { a,b,c,d ->  }
                    onScrollStateChanged { a,b -> }
                }
                searchView {
                    onQueryTextChange { a -> true }
                    onQueryTextSubmit { a -> true }
                }
                seekBar {
                    onProgressChanged { a,b,c -> }
                    onStartTrackingTouch { a -> }
                    onStopTrackingTouch { a -> }
                }
            }
        }
    }
}