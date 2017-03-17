package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.*

open class AndroidMultiMethodListenersActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                listView {
                    onScrollListener {
                        onScroll { _, _, _, _ ->  }
                        onScrollStateChanged { _, _ -> }
                    }
                }
                searchView {
                    onQueryTextListener {
                        onQueryTextChange { _ -> true }
                        onQueryTextSubmit { _ -> true }
                    }
                }
                seekBar {
                    onSeekBarChangeListener {
                        onProgressChanged { _, _, _ -> }
                        onStartTrackingTouch { _ -> }
                        onStopTrackingTouch { _ -> }
                    }
                }
            }
        }
    }
}