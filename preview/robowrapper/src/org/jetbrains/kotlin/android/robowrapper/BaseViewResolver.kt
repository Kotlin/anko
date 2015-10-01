/*
 * Copyright 2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.android.robowrapper

import android.app.Activity
import android.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import org.robolectric.Robolectric
import org.robolectric.util.FragmentTestUtil
import org.robolectric.util.SupportFragmentTestUtil

class BaseViewResolver {

    fun getBaseView(clazz: Class<Any>): View {
        return when {
            clazz.isActivity() -> {
                @Suppress("CAST_NEVER_SUCCEEDS")
                val activity = Robolectric.buildActivity<Activity>(clazz as Class<Activity>).create().get()
                val contentView = activity.findViewById(android.R.id.content) as ViewGroup
                if (contentView.childCount == 0) FrameLayout(activity) else contentView.getChildAt(0)
            }
            clazz.isFragment() -> {
                val fragment = clazz.newInstance() as Fragment
                FragmentTestUtil.startFragment(fragment)
                fragment.view
            }
            clazz.isSupportFragment() -> {
                val fragment = clazz.newInstance() as android.support.v4.app.Fragment
                SupportFragmentTestUtil.startFragment(fragment)
                fragment.view
            }
            else -> throw UnsupportedClassException()
        }
    }

    private fun Class<*>.isActivity() = Activity::class.java.isAssignableFrom(this)
    private fun Class<*>.isFragment() = Fragment::class.java.isAssignableFrom(this)
    private fun Class<*>.isSupportFragment() = android.support.v4.app.Fragment::class.java.isAssignableFrom(this)

}
