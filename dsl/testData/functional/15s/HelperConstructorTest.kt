@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedButton(text: CharSequence?): android.support.v7.widget.AppCompatButton = addView<android.support.v7.widget.AppCompatButton> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedButton(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatButton.() -> Unit): android.support.v7.widget.AppCompatButton = addView<android.support.v7.widget.AppCompatButton> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedButton(text: Int): android.support.v7.widget.AppCompatButton = addView<android.support.v7.widget.AppCompatButton> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedButton(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatButton.() -> Unit): android.support.v7.widget.AppCompatButton = addView<android.support.v7.widget.AppCompatButton> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: CharSequence?): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatCheckBox.() -> Unit): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: Int): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedCheckBox(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatCheckBox.() -> Unit): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatCheckBox.() -> Unit): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatCheckBox.() -> Unit): android.support.v7.widget.AppCompatCheckBox = addView<android.support.v7.widget.AppCompatCheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedEditText(text: CharSequence?): android.support.v7.widget.AppCompatEditText = addView<android.support.v7.widget.AppCompatEditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedEditText(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatEditText.() -> Unit): android.support.v7.widget.AppCompatEditText = addView<android.support.v7.widget.AppCompatEditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedEditText(text: Int): android.support.v7.widget.AppCompatEditText = addView<android.support.v7.widget.AppCompatEditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedEditText(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatEditText.() -> Unit): android.support.v7.widget.AppCompatEditText = addView<android.support.v7.widget.AppCompatEditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedTextView(text: CharSequence?): android.support.v7.widget.AppCompatTextView = addView<android.support.v7.widget.AppCompatTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedTextView(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatTextView.() -> Unit): android.support.v7.widget.AppCompatTextView = addView<android.support.v7.widget.AppCompatTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedTextView(text: Int): android.support.v7.widget.AppCompatTextView = addView<android.support.v7.widget.AppCompatTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.tintedTextView(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.AppCompatTextView.() -> Unit): android.support.v7.widget.AppCompatTextView = addView<android.support.v7.widget.AppCompatTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.button(text: CharSequence?): android.widget.Button = addView<android.widget.Button> {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.button(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.Button.() -> Unit): android.widget.Button = addView<android.widget.Button> {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.button(text: Int): android.widget.Button = addView<android.widget.Button> {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.button(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.Button.() -> Unit): android.widget.Button = addView<android.widget.Button> {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.checkBox(text: CharSequence?): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.checkBox(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.checkBox(text: Int): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.checkBox(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.checkBox(text: Int, checked: Boolean): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.checkBox(text: Int, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView<android.widget.CheckBox> {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.editText(text: CharSequence?): android.widget.EditText = addView<android.widget.EditText> {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.editText(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.EditText.() -> Unit): android.widget.EditText = addView<android.widget.EditText> {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.editText(text: Int): android.widget.EditText = addView<android.widget.EditText> {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.editText(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.EditText.() -> Unit): android.widget.EditText = addView<android.widget.EditText> {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageButton = addView<android.widget.ImageButton> {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageDrawable(imageDrawable)
    view
}
public inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton = addView<android.widget.ImageButton> {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageDrawable(imageDrawable)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.imageButton(imageResource: Int): android.widget.ImageButton = addView<android.widget.ImageButton> {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageResource(imageResource)
    view
}
public inline fun ViewManager.imageButton(imageResource: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton = addView<android.widget.ImageButton> {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageResource(imageResource)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageView = addView<android.widget.ImageView> {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageDrawable(imageDrawable)
    view
}
public inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageView.() -> Unit): android.widget.ImageView = addView<android.widget.ImageView> {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageDrawable(imageDrawable)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.imageView(imageResource: Int): android.widget.ImageView = addView<android.widget.ImageView> {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageResource(imageResource)
    view
}
public inline fun ViewManager.imageView(imageResource: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageView.() -> Unit): android.widget.ImageView = addView<android.widget.ImageView> {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageResource(imageResource)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.textView(text: CharSequence?): android.widget.TextView = addView<android.widget.TextView> {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.textView(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.TextView.() -> Unit): android.widget.TextView = addView<android.widget.TextView> {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.textView(text: Int): android.widget.TextView = addView<android.widget.TextView> {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.textView(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.TextView.() -> Unit): android.widget.TextView = addView<android.widget.TextView> {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view.init()
    view
}