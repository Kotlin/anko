public fun ViewManager.textView(text: CharSequence?, init: android.widget.TextView.() -> Unit = defaultInit): android.widget.TextView {
  val v = android.widget.TextView(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.textView(text: Int, init: android.widget.TextView.() -> Unit = defaultInit): android.widget.TextView {
  val v = android.widget.TextView(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, init: android.widget.ImageView.() -> Unit = defaultInit): android.widget.ImageView {
  val v = android.widget.ImageView(dslContext)
  v.setImageDrawable(imageDrawable)
  return addView(v, init, this)
}

public fun ViewManager.imageView(imageResource: Int, init: android.widget.ImageView.() -> Unit = defaultInit): android.widget.ImageView {
  val v = android.widget.ImageView(dslContext)
  v.setImageResource(imageResource)
  return addView(v, init, this)
}

public fun ViewManager.editText(text: CharSequence?, init: android.widget.EditText.() -> Unit = defaultInit): android.widget.EditText {
  val v = android.widget.EditText(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.editText(text: Int, init: android.widget.EditText.() -> Unit = defaultInit): android.widget.EditText {
  val v = android.widget.EditText(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.button(text: CharSequence?, init: android.widget.Button.() -> Unit = defaultInit): android.widget.Button {
  val v = android.widget.Button(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.button(text: Int, init: android.widget.Button.() -> Unit = defaultInit): android.widget.Button {
  val v = android.widget.Button(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, init: android.widget.ImageButton.() -> Unit = defaultInit): android.widget.ImageButton {
  val v = android.widget.ImageButton(dslContext)
  v.setImageDrawable(imageDrawable)
  return addView(v, init, this)
}

public fun ViewManager.imageButton(imageResource: Int, init: android.widget.ImageButton.() -> Unit = defaultInit): android.widget.ImageButton {
  val v = android.widget.ImageButton(dslContext)
  v.setImageResource(imageResource)
  return addView(v, init, this)
}

public fun ViewManager.checkBox(text: CharSequence?, init: android.widget.CheckBox.() -> Unit = defaultInit): android.widget.CheckBox {
  val v = android.widget.CheckBox(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.checkBox(text: Int, init: android.widget.CheckBox.() -> Unit = defaultInit): android.widget.CheckBox {
  val v = android.widget.CheckBox(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, init: android.widget.CheckBox.() -> Unit = defaultInit): android.widget.CheckBox {
  val v = android.widget.CheckBox(dslContext)
  v.setText(text)
  v.setChecked(checked)
  return addView(v, init, this)
}

public fun ViewManager.checkBox(text: Int, checked: Boolean, init: android.widget.CheckBox.() -> Unit = defaultInit): android.widget.CheckBox {
  val v = android.widget.CheckBox(dslContext)
  v.setText(text)
  v.setChecked(checked)
  return addView(v, init, this)
}

