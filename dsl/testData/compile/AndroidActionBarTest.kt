package com.example.android_test

import android.app.ActionBar
import android.app.Activity
import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.FrameLayout
import org.jetbrains.anko.*

public open class MyActivity() : Activity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM or ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_SHOW_HOME
        actionBar?.customView = layoutInflater.inflate(0, null)
        actionBar?.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        actionBar?.displayShowHomeEnabled = true
        actionBar?.displayUseLogoEnabled = true
        actionBar?.displayHomeAsUpEnabled = true
        actionBar?.displayShowTitleEnabled = true

        actionBar?.addTab(actionBar?.
                newTab()?.
                setText("Tab 1")?.
                setTabListener(actionBarListener))
        actionBar?.addTab(actionBar?.
                newTab()?.
                setText("Tab 2")?.
                setTabListener(actionBarListener))

        val fragment = fragmentManager.find<MyFragment>(MyFragment.TAG)
        if (fragment == null) {
            fragmentManager.transactions {
                add(MyFragment(), MyFragment.TAG)
            }.commit()
        }

        Log.i("TestActionBarActivity", "ActionBar's height: ${actionBar?.height}")
        Log.i("TestActionBarActivity", "Count of navigation items: ${actionBar?.navigationItemCount}")
        Log.i("TestActionBarActivity", "Count of tabs: ${actionBar?.tabCount}")
    }

    public override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(0, menu)
        return true
    }

    val actionBarListener = object : ActionBar.TabListener {
        override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        }

        override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
            Log.i("TestActionBarActivity", "Selected navigation index: ${actionBar?.selectedNavigationIndex}")
            Log.i("TestActionBarActivity", "Selected navigation tab: ${actionBar?.selectedTab}")

            if (tab?.getPosition() == 0) {
                actionBar?.title = "Title 1"
                actionBar?.subtitle = "Subtitle 1"
            } else {
                actionBar?.title = "Title 2"
                actionBar?.subtitle = "Subtitle 2"
            }
        }

        override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        }
    }

}

class MyFragment: Fragment() {
    companion object {
        val TAG = "MyFragment"
    }
}
