[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.button(text: CharSequence?): android.widget.Button = addView {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.button(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.Button.() -> Unit): android.widget.Button = addView {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.button(text: Int): android.widget.Button = addView {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.button(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.Button.() -> Unit): android.widget.Button = addView {
    ctx ->
    val view = android.widget.Button(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.checkBox(text: CharSequence?): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.checkBox(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.checkBox(text: Int): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.checkBox(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.checkBox(text: Int, checked: Boolean): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view
}
public inline fun ViewManager.checkBox(text: Int, checked: Boolean, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox = addView {
    ctx ->
    val view = android.widget.CheckBox(ctx)
    view.setText(text)
    view.setChecked(checked)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.editText(text: CharSequence?): android.widget.EditText = addView {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.editText(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.EditText.() -> Unit): android.widget.EditText = addView {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.editText(text: Int): android.widget.EditText = addView {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.editText(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.EditText.() -> Unit): android.widget.EditText = addView {
    ctx ->
    val view = android.widget.EditText(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageButton = addView {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageDrawable(imageDrawable)
    view
}
public inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton = addView {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageDrawable(imageDrawable)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.imageButton(imageResource: Int): android.widget.ImageButton = addView {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageResource(imageResource)
    view
}
public inline fun ViewManager.imageButton(imageResource: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton = addView {
    ctx ->
    val view = android.widget.ImageButton(ctx)
    view.setImageResource(imageResource)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageView = addView {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageDrawable(imageDrawable)
    view
}
public inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageView.() -> Unit): android.widget.ImageView = addView {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageDrawable(imageDrawable)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.imageView(imageResource: Int): android.widget.ImageView = addView {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageResource(imageResource)
    view
}
public inline fun ViewManager.imageView(imageResource: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.ImageView.() -> Unit): android.widget.ImageView = addView {
    ctx ->
    val view = android.widget.ImageView(ctx)
    view.setImageResource(imageResource)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.textView(text: CharSequence?): android.widget.TextView = addView {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.textView(text: CharSequence?, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.TextView.() -> Unit): android.widget.TextView = addView {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view.init()
    view
}

[suppress("NOTHING_TO_INLINE")]
public inline fun ViewManager.textView(text: Int): android.widget.TextView = addView {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view
}
public inline fun ViewManager.textView(text: Int, inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.widget.TextView.() -> Unit): android.widget.TextView = addView {
    ctx ->
    val view = android.widget.TextView(ctx)
    view.setText(text)
    view.init()
    view
}

