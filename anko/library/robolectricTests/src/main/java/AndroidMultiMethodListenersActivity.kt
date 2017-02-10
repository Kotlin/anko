package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*

open class AndroidMultiMethodListenersActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                listView {
                    onScrollListener {
                        onScroll { a, b, c, d ->  }
                        onScrollStateChanged { a, b -> }
                    }
                }
                searchView {
                    onQueryTextListener {
                        onQueryTextChange { a -> true }
                        onQueryTextSubmit { a -> true }
                    }
                }
                seekBar {
                    onSeekBarChangeListener {
                        onProgressChanged { a, b, c -> }
                        onStartTrackingTouch { a -> }
                        onStopTrackingTouch { a -> }
                    }
                }
            }
        }
    }
}