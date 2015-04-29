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
import android.support.v4.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import org.jetbrains.anko.internals.internalStartActivity
import android.content.Intent
import org.jetbrains.anko.custom.addView
import org.jetbrains.anko.internals.internalStartActivityForResult
import org.jetbrains.anko.internals.testConfiguration

/* SECTION HELPERS */
public inline fun <T : View> Fragment.addView(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) factory: (ctx: Context) -> T): T {
    val view = factory(getActivity())
    UI { addView(view) }
    return view
}

public fun Fragment.UI(init: UiHelper.() -> Unit): UiHelper = getActivity().UI(false, init)

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
): T? = if (getActivity()?.testConfiguration(screenSize, density, language, orientation, long, fromSdk, sdk, uiMode, nightMode, rightToLeft, smallestWidth) ?: false) init() else null
/* END SECTION */


/* SECTION CONTEXT UTILS */
public val Fragment.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(getActivity())

public val Fragment.act: Activity
    get() = getActivity()

public val Fragment.ctx: Context
    get() = getActivity()

public fun Fragment.browse(url: String): Boolean = getActivity().browse(url)

public fun Fragment.share(text: String, subject: String = ""): Boolean = getActivity().share(text, subject)

public fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean =
        getActivity().email(email, subject, text)

public fun Fragment.makeCall(number: String): Boolean = getActivity().makeCall(number)

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    getActivity().internalStartActivity(javaClass<T>(), params)
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    getActivity().internalStartActivityForResult(javaClass<T>(), requestCode, params)
}

public inline fun <reified T: Any> Fragment.intentFor(): Intent = Intent(getActivity(), javaClass<T>())
/* END SECTION */


/* SECTION CUSTOM */
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.dip(value: Int): Int = getActivity().dip(value)
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.dip(value: Float): Int = getActivity().dip(value)
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.sp(value: Int): Int = getActivity().sp(value)
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.sp(value: Float): Int = getActivity().sp(value)
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.px2dip(px: Int): Float = getActivity().px2dip(px)
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.px2sp(px: Int): Float = getActivity().px2sp(px)
[suppress("NOTHING_TO_INLINE")]
public inline fun Fragment.dimen(resource: Int): Int = getActivity().dimen(resource)
/* END SECTION */

/* SECTION DIALOGS */
public fun Fragment.toast(textResource: Int): Unit = getActivity().toast(textResource)

public fun Fragment.toast(text: String): Unit = getActivity().toast(text)

public fun Fragment.longToast(textResource: Int): Unit = getActivity().longToast(textResource)

public fun Fragment.longToast(text: String): Unit = getActivity().longToast(text)

public fun Fragment.selector(
    title: CharSequence = "",
    items: List<CharSequence>,
    onClick: (Int) -> Unit
): Unit = getActivity().selector(title, items, onClick)
/* END SECTION */


/* SECTION ASYNC */
public inline fun <T: Fragment> T.uiThread(inlineOptions(InlineOption.ONLY_LOCAL_RETURN) f: () -> Unit) {
    getActivity().uiThread { f() }
}

public fun Fragment.async(task: AnkoAsyncContext.() -> Unit): Future<Unit> = getActivity().async(task)

public fun Fragment.async(executorService: ExecutorService, task: AnkoAsyncContext.() -> Unit): Future<Unit> =
    getActivity().async(executorService, task)

public fun <T> Fragment.asyncResult(task: () -> T): Future<T> = getActivity().asyncResult(task)

public fun <T> Fragment.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> =
    getActivity().asyncResult(executorService, task)

public fun Fragment.alert(
    title: String,
    message: String,
    init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder =
    getActivity().alert(title, message, init)

public fun Fragment.alert(
    title: Int,
    message: Int,
    init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder =
    getActivity().alert(title, message, init)

public fun Fragment.alert(init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder =
    getActivity().alert(init)

public fun Fragment.progressDialog(message: String? = null, title: String? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return getActivity().progressDialog(false, message, title, init)
}

public fun Fragment.indeterminateProgressDialog(message: String? = null, title: String? = null, init: (ProgressDialog.() -> Unit)? = null): ProgressDialog {
    return getActivity().progressDialog(true, message, title, init)
}
/* END SECTION */