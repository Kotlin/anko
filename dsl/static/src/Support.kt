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

package kotlinx.android.anko

import android.app.Activity
import android.support.v4.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import kotlinx.android.anko.internals.__internalStartActivity
import android.content.Intent
import kotlinx.android.anko.internals.__internalStartActivityForResult
import kotlinx.android.anko.internals.UiHelper

/* SECTION HELPERS */
private fun <T : View> Fragment.addFragmentTopLevelView(v: T, init: T.() -> Unit): T {
    UI { addView(v, init, this) }
    return v
}

public fun <T : View> __dslAddView(
    view: (ctx: Context) -> T,
    init: T.() -> Unit,
    fragment: Fragment): T {
    val ctx = fragment.getActivity()
    return fragment.addFragmentTopLevelView(view(ctx), init)
}

public fun Fragment.UI(init: UiHelper.() -> Unit): UiHelper = getActivity().UI(false, init)
/* END SECTION */


/* SECTION CONTEXT UTILS */
public val Fragment.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(getActivity())

public val Fragment.act: Activity
    get() = getActivity()

public val Fragment.ctx: Context
    get() = getActivity()

public fun Fragment.browse(url: String): Boolean = ctx.browse(url)

public fun Fragment.share(text: String, subject: String = ""): Boolean = ctx.share(text, subject)

public fun Fragment.email(email: String, subject: String = "", text: String = ""): Boolean =
    ctx.email(email, subject, text)

public fun Fragment.makeCall(number: String): Boolean = ctx.makeCall(number)

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any>) {
    getActivity().__internalStartActivity(javaClass<T>(), params)
}

[suppress("NOTHING_TO_INLINE")]
public inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any>) {
    getActivity().__internalStartActivityForResult(javaClass<T>(), requestCode, params)
}

public inline fun <reified T: Any> Fragment.intentFor(): Intent = Intent(getActivity(), javaClass<T>())
/* END SECTION */


/* SECTION DIALOGS */
public fun Fragment.toast(textResource: Int): Unit = ctx.toast(textResource)

public fun Fragment.toast(text: String): Unit = ctx.toast(text)

public fun Fragment.longToast(textResource: Int): Unit = ctx.longToast(textResource)

public fun Fragment.longToast(text: String): Unit = ctx.longToast(text)

public fun Fragment.selector(
    title: CharSequence = "",
    items: List<CharSequence>,
    onCancel: () -> Unit = {},
    onClick: (Int) -> Unit
): Unit = ctx.selector(title, items, onCancel, onClick)
/* END SECTION */


/* SECTION ASYNC */
public fun Fragment.async(task: AnkoAsyncContext.() -> Unit): Future<Unit> = getActivity().async(task)

public fun Fragment.async(executorService: ExecutorService, task: AnkoAsyncContext.() -> Unit): Future<Unit> =
    getActivity().async(executorService, task)

public fun <T> Fragment.asyncResult(task: () -> T): Future<T> = getActivity().asyncResult(task)

public fun <T> Fragment.asyncResult(executorService: ExecutorService, task: () -> T): Future<T> =
    getActivity().asyncResult(executorService, task)

public fun Fragment.verticalLayout(init: _LinearLayout.() -> Unit): LinearLayout =
    __dslAddView(verticalLayoutFactory, init, this)

public fun <T: View> Fragment.include(layoutId: Int, init: T.() -> Unit): T =
    __dslAddView(inflaterFactory(layoutId), init, this)

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
/* END SECTION */