package com.example.android_test

import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.FrameLayout
import org.jetbrains.anko.*

public open class MyActivity() : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM or ActionBar.DISPLAY_SHOW_TITLE or ActionBar.DISPLAY_SHOW_HOME
        supportActionBar?.customView = layoutInflater.inflate(0, null)
        supportActionBar?.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        supportActionBar?.addTab(supportActionBar?.
                newTab()?.
                setText("Tab 1")?.
                setTabListener(actionBarListener))
        supportActionBar?.addTab(supportActionBar?.
                newTab()?.
                setText("Tab 2")?.
                setTabListener(actionBarListener))

        val fragment = supportFragmentManager?.find<MyFragment>(MyFragment.TAG)
        if (fragment == null) {
            supportFragmentManager?.transactions {
                add(MyFragment(), MyFragment.TAG)
            }?.commit()
        }

        Log.i("TestActionBarActivity", "ActionBar's height: ${supportActionBar?.height}")
        Log.i("TestActionBarActivity", "Count of navigation items: ${supportActionBar?.navigationItemCount}")
        Log.i("TestActionBarActivity", "Count of tabs: ${supportActionBar?.tabCount}")
    }

    public override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(0, menu)
        return true
    }

    val actionBarListener = object : ActionBar.TabListener {
        override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
        }

        override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
            Log.i("TestActionBarActivity", "Selected navigation index: ${supportActionBar?.selectedNavigationIndex}")
            Log.i("TestActionBarActivity", "Selected navigation tab: ${supportActionBar?.selectedTab}")

            if (tab?.getPosition() == 0) {
                supportActionBar?.title = "Title 1"
                supportActionBar?.subtitle = "Subtitle 1"
            } else {
                supportActionBar?.title = "Title 2"
                supportActionBar?.subtitle = "Subtitle 2"
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
