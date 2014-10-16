import android.view.View
import android.view.KeyEvent
import android.widget.Toast
import android.widget.ListAdapter
import android.content.DialogInterface.OnClickListener
import android.content.DialogInterface
import android.content.DialogInterface.OnKeyListener
import android.content.Context
import android.app.Fragment
import android.app.AlertDialog
import android.graphics.drawable.Drawable
import android.database.Cursor
import android.view.ViewManager

public fun Fragment.toast(textResource: Int): Unit = ctx.toast(textResource)
public fun Context.toast(textResource: Int) {
  uiThread { Toast.makeText(this, textResource, Toast.LENGTH_SHORT).show() }
}

public fun Fragment.toast(text: String): Unit = ctx.toast(text)
public fun Context.toast(text: String) {
  uiThread { Toast.makeText(this, text, Toast.LENGTH_SHORT).show() }
}

public fun Fragment.longToast(textResource: Int): Unit = ctx.longToast(textResource)
public fun Context.longToast(textResource: Int) {
  uiThread { Toast.makeText(this, textResource, Toast.LENGTH_LONG).show() }
}

public fun Fragment.longToast(text: String): Unit = ctx.longToast(text)
public fun Context.longToast(text: String) {
  uiThread { Toast.makeText(this, text, Toast.LENGTH_LONG).show() }
}

private val defaultOnCancel = {}

public fun Fragment.selector(
  title: CharSequence = "",
  items: List<CharSequence>,
  onCancel: () -> Unit = defaultOnCancel,
  onClick: (Int) -> Unit): Unit =
  ctx.selector(title, items, onCancel, onClick)

public fun Context.alert(title: String, message: String, init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder {
  return AlertDialogBuilder(this) {
    title(title)
    message(message)
    init()
  }
}

public fun Context.alert(title: Int, message: Int, init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder {
  return AlertDialogBuilder(this) {
    title(title)
    message(message)
    init()
  }
}

public fun Context.alert(init: AlertDialogBuilder.() -> Unit): AlertDialogBuilder = AlertDialogBuilder(this, init)

public fun Context.selector(
  title: CharSequence = "",
  items: List<CharSequence>,
  onCancel: () -> Unit = defaultOnCancel,
  onClick: (Int) -> Unit)
{
  uiThread {
    AlertDialogBuilder(this) {
      title(title)
      items(items, onClick)
      onCancel(onCancel)
    }.show()
  }
}

public class AlertDialogBuilder(val ctx: Context, val init: AlertDialogBuilder.() -> Unit = {}) {
  private val builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
  protected var dialog: AlertDialog? = null;

  { init() }

  public fun dismiss() {
    dialog?.dismiss()
  }

  public fun show(): AlertDialogBuilder {
    dialog = builder.create()
    ctx.uiThread { dialog!!.show() }
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

  public fun view(view: View) {
    builder.setView(view)
  }
  public fun view(dsl: ViewManager.() -> Unit) {
    val view = ctx.UI(dsl).toView()
    builder.setView(view)
  }

  public fun cancellable(value: Boolean = true) {
    builder.setCancelable(value)
  }

  public fun onCancel(f: () -> Unit) {
    builder.setOnCancelListener { f() }
  }

  public fun onDismiss(f: () -> Unit) {
    builder.setOnDismissListener { f() }
  }

  public fun onKey(f: (keyCode: Int, e: KeyEvent) -> Boolean) {
    builder.setOnKeyListener(object : OnKeyListener {

      override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent): Boolean {
        return f(keyCode, event)
      }
    })
  }

  public fun neutralButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = {dismiss()}) {
    neutralButton(ctx.getString(textResource), f)
  }

  public fun neutralButton(title: String, f: DialogInterface.() -> Unit = {dismiss()}) {
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

  public fun negativeButton(textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = {dismiss()}) {
    negativeButton(ctx.getString(textResource), f)
  }

  public fun negativeButton(title: String, f: DialogInterface.() -> Unit = {dismiss()}) {
    builder.setNegativeButton(title, object : OnClickListener {
      override public fun onClick(dialog: DialogInterface, which: Int) {
        dialog.f()
      }
    })
  }

  public fun items(itemsId: Int, f: (which: Int) -> Unit) {
    items(ctx.getResources()!!.getTextArray(itemsId), f)
  }

  public fun items(items: List<CharSequence>, f: (which: Int) -> Unit) {
    items(items.copyToArray(), f)
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