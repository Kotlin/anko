public object `$$Anko$Factories$AppcompatV7View` {
    public val TINTED_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatAutoCompleteTextView(ctx) else AutoCompleteTextView(ctx) }
    public val TINTED_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx) }
    public val TINTED_CHECK_BOX = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx) }
    public val TINTED_CHECKED_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckedTextView(ctx) else CheckedTextView(ctx) }
    public val TINTED_EDIT_TEXT = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx) }
    public val TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatMultiAutoCompleteTextView(ctx) else MultiAutoCompleteTextView(ctx) }
    public val TINTED_RADIO_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatRadioButton(ctx) else RadioButton(ctx) }
    public val TINTED_RATING_BAR = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatRatingBar(ctx) else RatingBar(ctx) }
    public val TINTED_SPINNER = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatSpinner(ctx) else Spinner(ctx) }
    public val TINTED_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx) }
    public val SEARCH_VIEW = { ctx: Context -> android.support.v7.widget.SearchView(ctx) }
    public val SWITCH_COMPAT = { ctx: Context -> android.support.v7.widget.SwitchCompat(ctx) }
}

public inline fun ViewManager.tintedAutoCompleteTextView(): AutoCompleteTextView = tintedAutoCompleteTextView({})
public inline fun ViewManager.tintedAutoCompleteTextView(init: AutoCompleteTextView.() -> Unit): AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_AUTO_COMPLETE_TEXT_VIEW) { init() }
}

public inline fun ViewManager.tintedButton(): Button = tintedButton({})
public inline fun ViewManager.tintedButton(init: Button.() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) { init() }
}

public inline fun ViewManager.tintedButton(text: CharSequence?): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        setText(text)
    }
}
public inline fun ViewManager.tintedButton(text: CharSequence?, init: Button.() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedButton(text: Int): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        setText(text)
    }
}
public inline fun ViewManager.tintedButton(text: Int, init: Button.() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedCheckBox(): CheckBox = tintedCheckBox({})
public inline fun ViewManager.tintedCheckBox(init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) { init() }
}

public inline fun ViewManager.tintedCheckBox(text: CharSequence?): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
    }
}
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedCheckBox(text: Int): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
    }
}
public inline fun ViewManager.tintedCheckBox(text: Int, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
        setChecked(checked)
    }
}
public inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
        setChecked(checked)
    }
}

public inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
        setChecked(checked)
    }
}
public inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
        setChecked(checked)
    }
}

public inline fun ViewManager.tintedCheckedTextView(): CheckedTextView = tintedCheckedTextView({})
public inline fun ViewManager.tintedCheckedTextView(init: CheckedTextView.() -> Unit): CheckedTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECKED_TEXT_VIEW) { init() }
}

public inline fun ViewManager.tintedEditText(): EditText = tintedEditText({})
public inline fun ViewManager.tintedEditText(init: EditText.() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) { init() }
}

public inline fun ViewManager.tintedEditText(text: CharSequence?): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        setText(text)
    }
}
public inline fun ViewManager.tintedEditText(text: CharSequence?, init: EditText.() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedEditText(text: Int): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        setText(text)
    }
}
public inline fun ViewManager.tintedEditText(text: Int, init: EditText.() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedMultiAutoCompleteTextView(): MultiAutoCompleteTextView = tintedMultiAutoCompleteTextView({})
public inline fun ViewManager.tintedMultiAutoCompleteTextView(init: MultiAutoCompleteTextView.() -> Unit): MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW) { init() }
}

public inline fun ViewManager.tintedRadioButton(): RadioButton = tintedRadioButton({})
public inline fun ViewManager.tintedRadioButton(init: RadioButton.() -> Unit): RadioButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_RADIO_BUTTON) { init() }
}

public inline fun ViewManager.tintedRatingBar(): RatingBar = tintedRatingBar({})
public inline fun ViewManager.tintedRatingBar(init: RatingBar.() -> Unit): RatingBar {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_RATING_BAR) { init() }
}

public inline fun ViewManager.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun ViewManager.tintedSpinner(init: Spinner.() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER) { init() }
}

public inline fun Context.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun Context.tintedSpinner(init: Spinner.() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER) { init() }
}

public inline fun Activity.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun Activity.tintedSpinner(init: Spinner.() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER) { init() }
}

public inline fun ViewManager.tintedTextView(): TextView = tintedTextView({})
public inline fun ViewManager.tintedTextView(init: TextView.() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) { init() }
}

public inline fun ViewManager.tintedTextView(text: CharSequence?): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        setText(text)
    }
}
public inline fun ViewManager.tintedTextView(text: CharSequence?, init: TextView.() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.tintedTextView(text: Int): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        setText(text)
    }
}
public inline fun ViewManager.tintedTextView(text: Int, init: TextView.() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.searchView(): android.support.v7.widget.SearchView = searchView({})
public inline fun ViewManager.searchView(init: android.support.v7.widget.SearchView.() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW) { init() }
}

public inline fun Context.searchView(): android.support.v7.widget.SearchView = searchView({})
public inline fun Context.searchView(init: android.support.v7.widget.SearchView.() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW) { init() }
}

public inline fun Activity.searchView(): android.support.v7.widget.SearchView = searchView({})
public inline fun Activity.searchView(init: android.support.v7.widget.SearchView.() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW) { init() }
}

public inline fun ViewManager.switchCompat(): android.support.v7.widget.SwitchCompat = switchCompat({})
public inline fun ViewManager.switchCompat(init: android.support.v7.widget.SwitchCompat.() -> Unit): android.support.v7.widget.SwitchCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SWITCH_COMPAT) { init() }
}

public object `$$Anko$Factories$AppcompatV7ViewGroup` {
    public val ACTION_MENU_VIEW = { ctx: Context -> _ActionMenuView(ctx) }
    public val LINEAR_LAYOUT_COMPAT = { ctx: Context -> _LinearLayoutCompat(ctx) }
    public val TOOLBAR = { ctx: Context -> _Toolbar(ctx) }
}

public inline fun ViewManager.actionMenuView(): android.support.v7.widget.ActionMenuView = actionMenuView({})
public inline fun ViewManager.actionMenuView(init: _ActionMenuView.() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW) { init() }
}

public inline fun Context.actionMenuView(): android.support.v7.widget.ActionMenuView = actionMenuView({})
public inline fun Context.actionMenuView(init: _ActionMenuView.() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW) { init() }
}

public inline fun Activity.actionMenuView(): android.support.v7.widget.ActionMenuView = actionMenuView({})
public inline fun Activity.actionMenuView(init: _ActionMenuView.() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW) { init() }
}

public inline fun ViewManager.linearLayoutCompat(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat({})
public inline fun ViewManager.linearLayoutCompat(init: _LinearLayoutCompat.() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT) { init() }
}

public inline fun Context.linearLayoutCompat(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat({})
public inline fun Context.linearLayoutCompat(init: _LinearLayoutCompat.() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT) { init() }
}

public inline fun Activity.linearLayoutCompat(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat({})
public inline fun Activity.linearLayoutCompat(init: _LinearLayoutCompat.() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT) { init() }
}

public inline fun ViewManager.toolbar(): android.support.v7.widget.Toolbar = toolbar({})
public inline fun ViewManager.toolbar(init: _Toolbar.() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR) { init() }
}

public inline fun Context.toolbar(): android.support.v7.widget.Toolbar = toolbar({})
public inline fun Context.toolbar(init: _Toolbar.() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR) { init() }
}

public inline fun Activity.toolbar(): android.support.v7.widget.Toolbar = toolbar({})
public inline fun Activity.toolbar(init: _Toolbar.() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR) { init() }
}