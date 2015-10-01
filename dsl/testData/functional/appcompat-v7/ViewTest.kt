object `$$Anko$Factories$AppcompatV7View` {
    val TINTED_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatAutoCompleteTextView(ctx) else AutoCompleteTextView(ctx) }
    val TINTED_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx) }
    val TINTED_CHECK_BOX = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx) }
    val TINTED_CHECKED_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckedTextView(ctx) else CheckedTextView(ctx) }
    val TINTED_EDIT_TEXT = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx) }
    val TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatMultiAutoCompleteTextView(ctx) else MultiAutoCompleteTextView(ctx) }
    val TINTED_RADIO_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatRadioButton(ctx) else RadioButton(ctx) }
    val TINTED_RATING_BAR = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatRatingBar(ctx) else RatingBar(ctx) }
    val TINTED_SPINNER = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatSpinner(ctx) else Spinner(ctx) }
    val TINTED_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx) }
    val SEARCH_VIEW = { ctx: Context -> android.support.v7.widget.SearchView(ctx) }
    val SWITCH_COMPAT = { ctx: Context -> android.support.v7.widget.SwitchCompat(ctx) }
}

inline fun ViewManager.tintedAutoCompleteTextView(): AutoCompleteTextView = tintedAutoCompleteTextView({})
inline fun ViewManager.tintedAutoCompleteTextView(init: AutoCompleteTextView.() -> Unit): AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_AUTO_COMPLETE_TEXT_VIEW) { init() }
}

inline fun ViewManager.tintedButton(): Button = tintedButton({})
inline fun ViewManager.tintedButton(init: Button.() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) { init() }
}

inline fun ViewManager.tintedButton(text: CharSequence?): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        setText(text)
    }
}
inline fun ViewManager.tintedButton(text: CharSequence?, init: Button.() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedButton(text: Int): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        setText(text)
    }
}
inline fun ViewManager.tintedButton(text: Int, init: Button.() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedCheckBox(): CheckBox = tintedCheckBox({})
inline fun ViewManager.tintedCheckBox(init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) { init() }
}

inline fun ViewManager.tintedCheckBox(text: CharSequence?): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
    }
}
inline fun ViewManager.tintedCheckBox(text: CharSequence?, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedCheckBox(text: Int): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
    }
}
inline fun ViewManager.tintedCheckBox(text: Int, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean, init: CheckBox.() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.tintedCheckedTextView(): CheckedTextView = tintedCheckedTextView({})
inline fun ViewManager.tintedCheckedTextView(init: CheckedTextView.() -> Unit): CheckedTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECKED_TEXT_VIEW) { init() }
}

inline fun ViewManager.tintedEditText(): EditText = tintedEditText({})
inline fun ViewManager.tintedEditText(init: EditText.() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) { init() }
}

inline fun ViewManager.tintedEditText(text: CharSequence?): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        setText(text)
    }
}
inline fun ViewManager.tintedEditText(text: CharSequence?, init: EditText.() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedEditText(text: Int): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        setText(text)
    }
}
inline fun ViewManager.tintedEditText(text: Int, init: EditText.() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedMultiAutoCompleteTextView(): MultiAutoCompleteTextView = tintedMultiAutoCompleteTextView({})
inline fun ViewManager.tintedMultiAutoCompleteTextView(init: MultiAutoCompleteTextView.() -> Unit): MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW) { init() }
}

inline fun ViewManager.tintedRadioButton(): RadioButton = tintedRadioButton({})
inline fun ViewManager.tintedRadioButton(init: RadioButton.() -> Unit): RadioButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_RADIO_BUTTON) { init() }
}

inline fun ViewManager.tintedRatingBar(): RatingBar = tintedRatingBar({})
inline fun ViewManager.tintedRatingBar(init: RatingBar.() -> Unit): RatingBar {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_RATING_BAR) { init() }
}

inline fun ViewManager.tintedSpinner(): Spinner = tintedSpinner({})
inline fun ViewManager.tintedSpinner(init: Spinner.() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER) { init() }
}

inline fun Context.tintedSpinner(): Spinner = tintedSpinner({})
inline fun Context.tintedSpinner(init: Spinner.() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER) { init() }
}

inline fun Activity.tintedSpinner(): Spinner = tintedSpinner({})
inline fun Activity.tintedSpinner(init: Spinner.() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER) { init() }
}

inline fun ViewManager.tintedTextView(): TextView = tintedTextView({})
inline fun ViewManager.tintedTextView(init: TextView.() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) { init() }
}

inline fun ViewManager.tintedTextView(text: CharSequence?): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        setText(text)
    }
}
inline fun ViewManager.tintedTextView(text: CharSequence?, init: TextView.() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedTextView(text: Int): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        setText(text)
    }
}
inline fun ViewManager.tintedTextView(text: Int, init: TextView.() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW) {
        init()
        setText(text)
    }
}

inline fun ViewManager.searchView(): android.support.v7.widget.SearchView = searchView({})
inline fun ViewManager.searchView(init: android.support.v7.widget.SearchView.() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW) { init() }
}

inline fun Context.searchView(): android.support.v7.widget.SearchView = searchView({})
inline fun Context.searchView(init: android.support.v7.widget.SearchView.() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW) { init() }
}

inline fun Activity.searchView(): android.support.v7.widget.SearchView = searchView({})
inline fun Activity.searchView(init: android.support.v7.widget.SearchView.() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW) { init() }
}

inline fun ViewManager.switchCompat(): android.support.v7.widget.SwitchCompat = switchCompat({})
inline fun ViewManager.switchCompat(init: android.support.v7.widget.SwitchCompat.() -> Unit): android.support.v7.widget.SwitchCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SWITCH_COMPAT) { init() }
}

object `$$Anko$Factories$AppcompatV7ViewGroup` {
    val ACTION_MENU_VIEW = { ctx: Context -> _ActionMenuView(ctx) }
    val LINEAR_LAYOUT_COMPAT = { ctx: Context -> _LinearLayoutCompat(ctx) }
    val TOOLBAR = { ctx: Context -> _Toolbar(ctx) }
}

inline fun ViewManager.actionMenuView(): android.support.v7.widget.ActionMenuView = actionMenuView({})
inline fun ViewManager.actionMenuView(init: _ActionMenuView.() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW) { init() }
}

inline fun Context.actionMenuView(): android.support.v7.widget.ActionMenuView = actionMenuView({})
inline fun Context.actionMenuView(init: _ActionMenuView.() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW) { init() }
}

inline fun Activity.actionMenuView(): android.support.v7.widget.ActionMenuView = actionMenuView({})
inline fun Activity.actionMenuView(init: _ActionMenuView.() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW) { init() }
}

inline fun ViewManager.linearLayoutCompat(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat({})
inline fun ViewManager.linearLayoutCompat(init: _LinearLayoutCompat.() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT) { init() }
}

inline fun Context.linearLayoutCompat(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat({})
inline fun Context.linearLayoutCompat(init: _LinearLayoutCompat.() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT) { init() }
}

inline fun Activity.linearLayoutCompat(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat({})
inline fun Activity.linearLayoutCompat(init: _LinearLayoutCompat.() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT) { init() }
}

inline fun ViewManager.toolbar(): android.support.v7.widget.Toolbar = toolbar({})
inline fun ViewManager.toolbar(init: _Toolbar.() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR) { init() }
}

inline fun Context.toolbar(): android.support.v7.widget.Toolbar = toolbar({})
inline fun Context.toolbar(init: _Toolbar.() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR) { init() }
}

inline fun Activity.toolbar(): android.support.v7.widget.Toolbar = toolbar({})
inline fun Activity.toolbar(init: _Toolbar.() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR) { init() }
}