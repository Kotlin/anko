@file:Suppress("NOTHING_TO_INLINE")

package dialogs

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.view.KeyEvent
import android.view.View
import android.view.ViewManager
import android.widget.AdapterView
import org.jetbrains.anko.UI
import org.jetbrains.anko.internals.AnkoInternals.NO_GETTER
import org.jetbrains.anko.internals.AnkoInternals.noGetter
import kotlin.DeprecationLevel.ERROR

interface AlertBuilder<out T : Any> {
    val ctx: Context

    var title: CharSequence
    var titleResource: CharSequence
    
    var message: CharSequence
    var messageResource: CharSequence
    
    var icon: Drawable
    var iconResource: Int
    
    var customTitle: View
    var customView: View

    fun onCancelled(handler: (dialog: DialogInterface) -> Unit)

    fun onKeyPressed(handler: (dialog: DialogInterface, keyCode: Int, e: KeyEvent) -> Boolean)

    fun positiveButton(buttonText: String, handler: (dialog: DialogInterface) -> Unit)
    fun positiveButton(buttonTextResource: Int, handler: (dialog: DialogInterface) -> Unit)

    fun negativeButton(buttonText: String, handler: (dialog: DialogInterface) -> Unit)
    fun negativeButton(buttonTextResource: Int, handler: (dialog: DialogInterface) -> Unit)

    fun neutralPressed(buttonText: String, handler: (dialog: DialogInterface) -> Unit)
    fun neutralPressed(buttonTextResource: Int, handler: (dialog: DialogInterface) -> Unit)

    fun onItemSelected(handler: (item: T?, index: Int) -> Unit)
}

class AndroidAlertBuilder<T : Any>(override val ctx: Context) : AlertBuilder<T> {
    private val builder = AlertDialog.Builder(ctx)

    override var title: CharSequence
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setTitle(value) }

    override var titleResource: CharSequence
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setTitle(value) }

    override var message: CharSequence
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setMessage(value) }

    override var messageResource: CharSequence
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setMessage(value) }

    override var icon: Drawable
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setIcon(value) }

    override var iconResource: Int
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setIcon(value) }

    override var customTitle: View
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setCustomTitle(value) }

    override var customView: View
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) { builder.setView(value) }

    override fun onCancelled(handler: (DialogInterface) -> Unit) {
        builder.setOnCancelListener(handler)
    }

    override fun onKeyPressed(handler: (dialog: DialogInterface, keyCode: Int, e: KeyEvent) -> Boolean) {
        builder.setOnKeyListener(handler)
    }

    override fun positiveButton(buttonText: String, handler: (dialog: DialogInterface) -> Unit) {
        builder.setPositiveButton(buttonText) { dialog, _ -> handler(dialog) }
    }

    override fun positiveButton(buttonTextResource: Int, handler: (dialog: DialogInterface) -> Unit) {
        builder.setPositiveButton(buttonTextResource) { dialog, _ -> handler(dialog) }
    }

    override fun negativeButton(buttonText: String, handler: (dialog: DialogInterface) -> Unit) {
        builder.setNegativeButton(buttonText) { dialog, _ -> handler(dialog) }
    }

    override fun negativeButton(buttonTextResource: Int, handler: (dialog: DialogInterface) -> Unit) {
        builder.setNegativeButton(buttonTextResource) { dialog, _ -> handler(dialog) }
    }

    override fun neutralPressed(buttonText: String, handler: (dialog: DialogInterface) -> Unit) {
        builder.setNeutralButton(buttonText) { dialog, _ -> handler(dialog) }
    }

    override fun neutralPressed(buttonTextResource: Int, handler: (dialog: DialogInterface) -> Unit) {
        builder.setNeutralButton(buttonTextResource) { dialog, _ -> handler(dialog) }
    }

    override fun onItemSelected(handler: (item: T?, index: Int) -> Unit) {
        builder.setOnItemSelectedListener(object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(adapter: AdapterView<*>) {
                handler(null, -1)
            }

            override fun onItemSelected(adapter: AdapterView<*>, view: View, position: Int, id: Long) {
                @Suppress("UNCHECKED_CAST")
                handler(adapter.adapter.getItem(position) as T, position)
            }
        })
    }
}

fun AlertBuilder<*>.customTitle(dsl: ViewManager.() -> Unit) {
    customTitle = ctx.UI(dsl).view
}

fun AlertBuilder<*>.customView(dsl: ViewManager.() -> Unit) {
    customView = ctx.UI(dsl).view
}

inline fun AlertBuilder<*>.okButton(noinline handler: (dialog: DialogInterface) -> Unit) {
    positiveButton(android.R.string.ok, handler)
}

inline fun AlertBuilder<*>.cancelButton(noinline handler: (dialog: DialogInterface) -> Unit) {
    negativeButton(android.R.string.cancel, handler)
}

inline fun AlertBuilder<*>.yesButton(noinline handler: (dialog: DialogInterface) -> Unit) {
    positiveButton(android.R.string.yes, handler)
}

inline fun AlertBuilder<*>.noButton(noinline handler: (dialog: DialogInterface) -> Unit) {
    negativeButton(android.R.string.no, handler)
}