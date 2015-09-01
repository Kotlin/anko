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

package org.jetbrains.anko

import android.app.Activity
import android.app.ProgressDialog
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.custom.addView
import org.jetbrains.anko.internals.AnkoInternals
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

/* SECTION HELPERS */
public inline fun <T : View> Fragment.addView(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) factory: (ctx: Context) -> T): T {
    val view = factory(activity)
    UI { addView(view) }
    return view
}

public fun Fragment.UI(init: UiHelper.() -> Unit): UiHelper = activity.UI(false, init)

public inline fun <T: Any> Fragment.configuration(
        screenSize: ScreenSize? = null,
        density: Range<Int>? = null,
        language: String? = null,
        orientation: Orientation? = null,
        long: Boolean? = null,
        fromSdk: Int? = null,
        sdk: Int? = null,
        uiMode: UiMode? = null,
        nightMode: Boolean? = null,
        rightToLeft: Boolean? = null,
        smallestWidth: Int? = null,
        init: () -> T
): T? {
    val act = activity
    return if (act != null) {
        if (AnkoInternals.testConfiguration(act, screenSize, density, language, orientation, long,
                fromSdk, sdk, uiMode, nightMode, rightToLeft, smallestWidth)) init() else null
    }
    else null
}
/* END SECTION */


/* SECTION CONTEXT UTILS */
public fun <T: Fragment> T.withArguments(vararg params: Pair<String, Any>): T {
    setArguments(bundleOf(*params))
    return this
}

public val Fragment.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(activity)

public val Fragment.act: Activity
    get() = activity

public val Fragment.ctx: Context
    get() = activity

public fun Fragment.browse(url: String): Boolean = activity.browse(url)

public fun Fragment.share(text: String, subject: String = ""): Boolean = activity.share(text, subject)

public fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean =
        activity.email(email, subject, text)

public fun Fragment.makeCall(number: String): Boolean = activity.makeCall(number)

@suppress("NOTHING_TO_INLINE")
public inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartActivity(activity, T::class.java, params)
}

@suppress("NOTHING_TO_INLINE")
public inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartActivityForResult(activity, T::class.java, requestCode, params)
}

@suppress("NOTHING_TO_INLINE")
public inline fun <reified T: Service> Fragment.startService(vararg params: Pair<String, Any>) {
    AnkoInternals.internalStartService(activity, T::class.java, params)
}

public inline fun <reified T: Any> Fragment.intentFor(): Intent = Intent(activity, T::class.java)
/* END SECTION */


/* SECTION OTHER */
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.dip(value: Int): Int = activity.dip(value)
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.dip(value: Float): Int = activity.dip(value)
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.sp(value: Int): Int = activity.sp(value)
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.sp(value: Float): Int = activity.sp(value)
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.px2dip(px: Int): Float = activity.px2dip(px)
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.px2sp(px: Int): Float = activity.px2sp(px)
@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.dimen(resource: Int): Int = activity.dimen(resource)

@suppress("NOTHING_TO_INLINE")
public inline fun Fragment.verticalLayout(): LinearLayout = verticalLayout({})
public inline fun Fragment.verticalLayout(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayout.() -> Unit): LinearLayout = addView { ctx ->
    val view = _LinearLayout(ctx)
    view.orientation = LinearLayout.VERTICAL
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun <T: View> Fragment.include(layoutId: Int): LinearLayout = include(layoutId, {})
public inline fun <T: View> Fragment.include(layoutId: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: T.() -> Unit): T = addView { ctx ->
    @suppress("UNCHECKED_CAST")
    val view = ctx.layoutInflater.inflate(layoutId, null) as T
    view.init()
    view
}
/* END SECTION */


/* SECTION DIALOGS */
public fun Fragment.toast(textResource: Int): Unit = activity.toast(textResource)

public fun Fragment.toast(text: CharSequence): Unit = activity.toast(text)

public fun Fragment.longToast(textResource: Int): Unit = activity.longToast(textResource)

public fun Fragment.longToast(text: CharSequence): Unit = activity.longToast(text)

public fun Fragment.selector(
    title: CharSequence? = null,
    items: List<CharSequence>,
    onClick: (Int) -> Unit
): Unit = activity.selector(title, items, onClick)
/* END SECTION */


/* SECTION ASYNC */
public inline fun Fragment.uiThread(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) f: () -> Unit) {
    activity.uiThread { f() }
}

public fun Fragment.async(task: AnkoAsyncContext.() -> Unit): Future<Unit> = activity.async(task)

public fun Fragment.async(executorService: ExecutorService, task: AnkoAsyncContext.() -> Unit): Future<Unit> =
    activity.async(executorService, task)

public fun <T> Fragment.asyncResult(task: () -> T): Future<T> = activity.asyncResult(task)

public fun <T> Fragment.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> =
    activity.asyncResult(executorService, task)

public fun Fragment.alert(
    message: String,
    title: String? = null,
    init: (AlertDialogBuilder.() -> Unit)? = null): AlertDialogBuilder =
    activity.alert(message, title, init)

public fun Fragment.alert(
    message: Int,
    title: Int? = null,
    init: (AlertDialogBuilder.() -> Unit)? = null): AlertDialogBuilder =
    activity.alert(message, title, init)

public fun Fragment.alert(init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder =
    activity.alert(init)

public fun Fragment.progressDialog(message: String? = null, title: String? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(false, message, title, init)
}

public fun Fragment.indeterminateProgressDialog(message: String? = null, title: String? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(true, message, title, init)
}

public fun Fragment.progressDialog(message: Int? = null, title: Int? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(false, message?.let { activity.getString(it) }, title?.let { activity.getString(it) }, init)
}

public fun Fragment.indeterminateProgressDialog(message: Int? = null, title: Int? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return activity.progressDialog(true, message?.let { activity.getString(it) }, title?.let { activity.getString(it) }, init)
}

/* END SECTION */