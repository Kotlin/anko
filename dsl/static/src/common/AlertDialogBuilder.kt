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
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface.OnKeyListener
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.view.ViewManager
import android.widget.ListAdapter

public class AlertDialogBuilder(val ctx: Context) {
    public val builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
    protected var dialog: AlertDialog? = null

    public fun dismiss() {
        dialog?.dismiss()
    }

    public fun show(): AlertDialogBuilder {
        dialog = builder.create()
        dialog!!.show()
        return this
    }

    public fun title(title: CharSequence) {
        builder.setTitle(title)
    }

    public fun title(resource: Int) {
        builder.setTitle(resource)
    }

    public fun message(title: CharSequence) {
        builder.setMessage(title)
    }

    public fun message(resource: Int) {
        builder.setMessage(resource)
    }

    public fun icon(icon: Int) {
        builder.setIcon(icon)
    }

    public fun icon(icon: Drawable) {
        builder.setIcon(icon)
    }

    public fun customTitle(title: View) {
        builder.setCustomTitle(title)
    }

    public fun customView(view: View) {
        builder.setView(view)
    }

    public fun customView(dsl: ViewManager.() -> Unit) {
        val view = ctx.UI(dsl).toView()
        builder.setView(view)
    }

    public fun cancellable(value: Boolean = true) {
        builder.setCancelable(value)
    }

    public fun onCancel(f: () -> Unit) {
        builder.setOnCancelListener { f() }
    }

    public fun onKey(f: (keyCode: Int, e: KeyEvent) -> Boolean) {
        builder.setOnKeyListener(object : OnKeyListener {
            override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent): Boolean {
                return f(keyCode, event)
            }
        })
    }

    public fun neutralButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = { dismiss() }) {
        neutralButton(ctx.getString(textResource), f)
    }

    public fun neutralButton(title: String, f: DialogInterface.() -> Unit = { dismiss() }) {
        builder.setNeutralButton(title, object : OnClickListener {
            override public fun onClick(dialog: DialogInterface, which: Int) {
                dialog.f()
            }
        })
    }

    public fun positiveButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit) {
        positiveButton(ctx.getString(textResource), f)
    }

    public fun positiveButton(title: String, f: DialogInterface.() -> Unit) {
        builder.setPositiveButton(title, object : OnClickListener {
            override public fun onClick(dialog: DialogInterface, which: Int) {
                dialog.f()
            }
        })
    }

    public fun negativeButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = { dismiss() }) {
        negativeButton(ctx.getString(textResource), f)
    }

    public fun negativeButton(title: String, f: DialogInterface.() -> Unit = { dismiss() }) {
        builder.setNegativeButton(title, object : OnClickListener {
            override public fun onClick(dialog: DialogInterface, which: Int) {
                dialog.f()
            }
        })
    }

    public fun items(itemsId: Int, f: (which: Int) -> Unit) {
        items(ctx.resources!!.getTextArray(itemsId), f)
    }

    public fun items(items: List<CharSequence>, f: (which: Int) -> Unit) {
        items(items.toTypedArray(), f)
    }

    public fun items(items: Array<CharSequence>, f: (which: Int) -> Unit) {
        builder.setItems(items, object : OnClickListener {
            override public fun onClick(dialog: DialogInterface, which: Int) {
                f(which)
            }
        })
    }

    public fun adapter(adapter: ListAdapter, f: (which: Int) -> Unit) {
        builder.setAdapter(adapter, object : OnClickListener {
            override public fun onClick(dialog: DialogInterface, which: Int) {
                f(which)
            }
        })
    }

    public fun adapter(cursor: Cursor, labelColumn: String, f: (which: Int) -> Unit) {
        builder.setCursor(cursor, object : OnClickListener {
            override public fun onClick(dialog: DialogInterface, which: Int) {
                f(which)
            }
        }, labelColumn)
    }

}