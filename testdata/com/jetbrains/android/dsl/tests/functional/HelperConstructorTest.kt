public fun ViewManager.textView(text: CharSequence?, init: android.widget.TextView.() -> Unit = {}): android.widget.TextView {
	val v = android.widget.TextView(dslContext)
	v.setText(text)
	return addView(v, init, this)
}
public fun ViewManager.button(text: CharSequence?, init: android.widget.Button.() -> Unit = {}): android.widget.Button {
	val v = android.widget.Button(dslContext)
	v.setText(text)
	return addView(v, init, this)
}
public fun ViewManager.checkBox(text: CharSequence?, init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox {
	val v = android.widget.CheckBox(dslContext)
	v.setText(text)
	return addView(v, init, this)
}
public fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox {
	val v = android.widget.CheckBox(dslContext)
	v.setText(text)
	v.setChecked(checked)
	return addView(v, init, this)
}
