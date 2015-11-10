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

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.view.ViewManager
import android.widget.ListAdapter

class AlertDialogBuilder(val ctx: Context) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
    protected var dialog: AlertDialog? = null

    fun dismiss() {
        dialog?.dismiss()
    }

    fun show(): AlertDialogBuilder {
        dialog = builder.create()
        dialog!!.show()
        return this
    }

    fun title(title: CharSequence) {
        builder.setTitle(title)
    }

    fun title(resource: Int) {
        builder.setTitle(resource)
    }

    fun message(title: CharSequence) {
        builder.setMessage(title)
    }

    fun message(resource: Int) {
        builder.setMessage(resource)
    }

    fun icon(icon: Int) {
        builder.setIcon(icon)
    }

    fun icon(icon: Drawable) {
        builder.setIcon(icon)
    }

    fun customTitle(title: View) {
        builder.setCustomTitle(title)
    }

    fun customView(view: View) {
        builder.setView(view)
    }

    fun customView(dsl: ViewManager.() -> Unit) {
        val view = ctx.UI(dsl).view
        builder.setView(view)
    }

    fun cancellable(value: Boolean = true) {
        builder.setCancelable(value)
    }

    fun onCancel(f: () -> Unit) {
        builder.setOnCancelListener { f() }
    }

    fun onKey(f: (keyCode: Int, e: KeyEvent) -> Boolean) {
        builder.setOnKeyListener({ dialog, keyCode, event -> f(keyCode, event) })
    }

    fun neutralButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = { dismiss() }) {
        neutralButton(ctx.getString(textResource), f)
    }

    fun neutralButton(title: String, f: DialogInterface.() -> Unit = { dismiss() }) {
        builder.setNeutralButton(title, { dialog, which -> dialog.f() })
    }

    fun positiveButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit) {
        positiveButton(ctx.getString(textResource), f)
    }

    fun positiveButton(title: String, f: DialogInterface.() -> Unit) {
        builder.setPositiveButton(title, { dialog, which -> dialog.f() })
    }

    fun negativeButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = { dismiss() }) {
        negativeButton(ctx.getString(textResource), f)
    }

    fun negativeButton(title: String, f: DialogInterface.() -> Unit = { dismiss() }) {
        builder.setNegativeButton(title, { dialog, which -> dialog.f() })
    }

    fun items(itemsId: Int, f: (which: Int) -> Unit) {
        items(ctx.resources!!.getTextArray(itemsId), f)
    }

    fun items(items: List<CharSequence>, f: (which: Int) -> Unit) {
        items(items.toTypedArray(), f)
    }

    fun items(items: Array<CharSequence>, f: (which: Int) -> Unit) {
        builder.setItems(items, { dialog, which -> f(which) })
    }

    fun adapter(adapter: ListAdapter, f: (which: Int) -> Unit) {
        builder.setAdapter(adapter, { dialog, which -> f(which) })
    }

    fun adapter(cursor: Cursor, labelColumn: String, f: (which: Int) -> Unit) {
        builder.setCursor(cursor, { dialog, which -> f(which) }, labelColumn)
    }

}