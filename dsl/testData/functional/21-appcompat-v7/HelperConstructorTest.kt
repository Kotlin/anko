@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedButton(text: CharSequence?): Button = addView<Button> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedButton(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Button.() -> Unit): Button = addView<Button> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedButton(text: Int): Button = addView<Button> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedButton(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Button.() -> Unit): Button = addView<Button> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: CharSequence?): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: CheckBox.() -> Unit): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: Int): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedCheckBox(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: CheckBox.() -> Unit): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: CheckBox.() -> Unit): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: CheckBox.() -> Unit): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedEditText(text: CharSequence?): EditText = addView<EditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedEditText(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: EditText.() -> Unit): EditText = addView<EditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedEditText(text: Int): EditText = addView<EditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedEditText(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: EditText.() -> Unit): EditText = addView<EditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedTextView(text: CharSequence?): TextView = addView<TextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedTextView(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: TextView.() -> Unit): TextView = addView<TextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedTextView(text: Int): TextView = addView<TextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedTextView(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: TextView.() -> Unit): TextView = addView<TextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view.init()
    view
}