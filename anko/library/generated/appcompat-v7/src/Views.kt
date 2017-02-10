@file:JvmName("AppcompatV7ViewsKt")
package org.jetbrains.anko.appcompat.v7

import org.jetbrains.anko.custom.*
import org.jetbrains.anko.AnkoViewDslMarker
import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.widget.*

@PublishedApi
internal object `$$Anko$Factories$AppcompatV7View` {
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

inline fun ViewManager.tintedAutoCompleteTextView(theme: Int = 0): AutoCompleteTextView = tintedAutoCompleteTextView(theme) {}
inline fun ViewManager.tintedAutoCompleteTextView(theme: Int = 0, init: (@AnkoViewDslMarker AutoCompleteTextView).() -> Unit): AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.tintedButton(theme: Int = 0): Button = tintedButton(theme) {}
inline fun ViewManager.tintedButton(theme: Int = 0, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON, theme) { init() }
}

inline fun ViewManager.tintedButton(text: CharSequence?, theme: Int = 0): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedButton(text: CharSequence?, theme: Int = 0, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedButton(text: Int, theme: Int = 0): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedButton(text: Int, theme: Int = 0, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_BUTTON, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedCheckBox(theme: Int = 0): CheckBox = tintedCheckBox(theme) {}
inline fun ViewManager.tintedCheckBox(theme: Int = 0, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) { init() }
}

inline fun ViewManager.tintedCheckBox(text: CharSequence?, theme: Int = 0): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedCheckBox(text: CharSequence?, theme: Int = 0, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedCheckBox(text: Int, theme: Int = 0): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedCheckBox(text: Int, theme: Int = 0, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean, theme: Int = 0): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.tintedCheckBox(text: CharSequence?, checked: Boolean, theme: Int = 0, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean, theme: Int = 0): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.tintedCheckBox(text: Int, checked: Boolean, theme: Int = 0, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.tintedCheckedTextView(theme: Int = 0): CheckedTextView = tintedCheckedTextView(theme) {}
inline fun ViewManager.tintedCheckedTextView(theme: Int = 0, init: (@AnkoViewDslMarker CheckedTextView).() -> Unit): CheckedTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_CHECKED_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.tintedEditText(theme: Int = 0): EditText = tintedEditText(theme) {}
inline fun ViewManager.tintedEditText(theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT, theme) { init() }
}

inline fun ViewManager.tintedEditText(text: CharSequence?, theme: Int = 0): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedEditText(text: CharSequence?, theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedEditText(text: Int, theme: Int = 0): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedEditText(text: Int, theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedMultiAutoCompleteTextView(theme: Int = 0): MultiAutoCompleteTextView = tintedMultiAutoCompleteTextView(theme) {}
inline fun ViewManager.tintedMultiAutoCompleteTextView(theme: Int = 0, init: (@AnkoViewDslMarker MultiAutoCompleteTextView).() -> Unit): MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.tintedRadioButton(theme: Int = 0): RadioButton = tintedRadioButton(theme) {}
inline fun ViewManager.tintedRadioButton(theme: Int = 0, init: (@AnkoViewDslMarker RadioButton).() -> Unit): RadioButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_RADIO_BUTTON, theme) { init() }
}

inline fun ViewManager.tintedRatingBar(theme: Int = 0): RatingBar = tintedRatingBar(theme) {}
inline fun ViewManager.tintedRatingBar(theme: Int = 0, init: (@AnkoViewDslMarker RatingBar).() -> Unit): RatingBar {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_RATING_BAR, theme) { init() }
}

inline fun ViewManager.tintedSpinner(theme: Int = 0): Spinner = tintedSpinner(theme) {}
inline fun ViewManager.tintedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER, theme) { init() }
}

inline fun Context.tintedSpinner(theme: Int = 0): Spinner = tintedSpinner(theme) {}
inline fun Context.tintedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER, theme) { init() }
}

inline fun Activity.tintedSpinner(theme: Int = 0): Spinner = tintedSpinner(theme) {}
inline fun Activity.tintedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SPINNER, theme) { init() }
}

inline fun ViewManager.tintedTextView(theme: Int = 0): TextView = tintedTextView(theme) {}
inline fun ViewManager.tintedTextView(theme: Int = 0, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.tintedTextView(text: CharSequence?, theme: Int = 0): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedTextView(text: CharSequence?, theme: Int = 0, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.tintedTextView(text: Int, theme: Int = 0): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW, theme) {
        setText(text)
    }
}
inline fun ViewManager.tintedTextView(text: Int, theme: Int = 0, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.searchView(theme: Int = 0): android.support.v7.widget.SearchView = searchView(theme) {}
inline fun ViewManager.searchView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.SearchView).() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW, theme) { init() }
}

inline fun Context.searchView(theme: Int = 0): android.support.v7.widget.SearchView = searchView(theme) {}
inline fun Context.searchView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.SearchView).() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW, theme) { init() }
}

inline fun Activity.searchView(theme: Int = 0): android.support.v7.widget.SearchView = searchView(theme) {}
inline fun Activity.searchView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.SearchView).() -> Unit): android.support.v7.widget.SearchView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SEARCH_VIEW, theme) { init() }
}

inline fun ViewManager.switchCompat(theme: Int = 0): android.support.v7.widget.SwitchCompat = switchCompat(theme) {}
inline fun ViewManager.switchCompat(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.SwitchCompat).() -> Unit): android.support.v7.widget.SwitchCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.SWITCH_COMPAT, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$AppcompatV7ViewGroup` {
    val ACTION_MENU_VIEW = { ctx: Context -> _ActionMenuView(ctx) }
    val LINEAR_LAYOUT_COMPAT = { ctx: Context -> _LinearLayoutCompat(ctx) }
    val TOOLBAR = { ctx: Context -> _Toolbar(ctx) }
}

inline fun ViewManager.actionMenuView(theme: Int = 0): android.support.v7.widget.ActionMenuView = actionMenuView(theme) {}
inline fun ViewManager.actionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

inline fun Context.actionMenuView(theme: Int = 0): android.support.v7.widget.ActionMenuView = actionMenuView(theme) {}
inline fun Context.actionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

inline fun Activity.actionMenuView(theme: Int = 0): android.support.v7.widget.ActionMenuView = actionMenuView(theme) {}
inline fun Activity.actionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.support.v7.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

inline fun ViewManager.linearLayoutCompat(theme: Int = 0): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat(theme) {}
inline fun ViewManager.linearLayoutCompat(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayoutCompat).() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT, theme) { init() }
}

inline fun Context.linearLayoutCompat(theme: Int = 0): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat(theme) {}
inline fun Context.linearLayoutCompat(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayoutCompat).() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT, theme) { init() }
}

inline fun Activity.linearLayoutCompat(theme: Int = 0): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompat(theme) {}
inline fun Activity.linearLayoutCompat(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayoutCompat).() -> Unit): android.support.v7.widget.LinearLayoutCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LINEAR_LAYOUT_COMPAT, theme) { init() }
}

inline fun ViewManager.toolbar(theme: Int = 0): android.support.v7.widget.Toolbar = toolbar(theme) {}
inline fun ViewManager.toolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR, theme) { init() }
}

inline fun Context.toolbar(theme: Int = 0): android.support.v7.widget.Toolbar = toolbar(theme) {}
inline fun Context.toolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR, theme) { init() }
}

inline fun Activity.toolbar(theme: Int = 0): android.support.v7.widget.Toolbar = toolbar(theme) {}
inline fun Activity.toolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.support.v7.widget.Toolbar {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.TOOLBAR, theme) { init() }
}

