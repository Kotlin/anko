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
    val ACTION_MENU_ITEM_VIEW = { ctx: Context -> android.support.v7.view.menu.ActionMenuItemView(ctx) }
    val EXPANDED_MENU_VIEW = { ctx: Context -> android.support.v7.view.menu.ExpandedMenuView(ctx, null) }
    val ACTIVITY_CHOOSER_VIEW = { ctx: Context -> android.support.v7.widget.ActivityChooserView(ctx) }
    val TINTED_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatAutoCompleteTextView(ctx) else AutoCompleteTextView(ctx) }
    val TINTED_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatButton(ctx) else Button(ctx) }
    val TINTED_CHECK_BOX = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckBox(ctx) else CheckBox(ctx) }
    val TINTED_CHECKED_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatCheckedTextView(ctx) else CheckedTextView(ctx) }
    val TINTED_EDIT_TEXT = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatEditText(ctx) else EditText(ctx) }
    val TINTED_IMAGE_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatImageButton(ctx) else ImageButton(ctx) }
    val TINTED_IMAGE_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatImageView(ctx) else ImageView(ctx) }
    val TINTED_MULTI_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatMultiAutoCompleteTextView(ctx) else MultiAutoCompleteTextView(ctx) }
    val TINTED_RADIO_BUTTON = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatRadioButton(ctx) else RadioButton(ctx) }
    val TINTED_RATING_BAR = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatRatingBar(ctx) else RatingBar(ctx) }
    val TINTED_SEEK_BAR = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatSeekBar(ctx) else SeekBar(ctx) }
    val TINTED_SPINNER = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatSpinner(ctx) else Spinner(ctx) }
    val TINTED_TEXT_VIEW = { ctx: Context -> if (Build.VERSION.SDK_INT < 21) android.support.v7.widget.AppCompatTextView(ctx) else TextView(ctx) }
    val CONTENT_FRAME_LAYOUT = { ctx: Context -> android.support.v7.widget.ContentFrameLayout(ctx) }
    val DIALOG_TITLE = { ctx: Context -> android.support.v7.widget.DialogTitle(ctx) }
    val FIT_WINDOWS_FRAME_LAYOUT = { ctx: Context -> android.support.v7.widget.FitWindowsFrameLayout(ctx) }
    val FIT_WINDOWS_LINEAR_LAYOUT = { ctx: Context -> android.support.v7.widget.FitWindowsLinearLayout(ctx) }
    val SEARCH_VIEW = { ctx: Context -> android.support.v7.widget.SearchView(ctx) }
    val SWITCH_COMPAT = { ctx: Context -> android.support.v7.widget.SwitchCompat(ctx) }
    val VIEW_STUB_COMPAT = { ctx: Context -> android.support.v7.widget.ViewStubCompat(ctx, null) }
}

inline fun ViewManager.actionMenuItemView(theme: Int = 0): android.support.v7.view.menu.ActionMenuItemView = actionMenuItemView(theme) {}
inline fun ViewManager.actionMenuItemView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.view.menu.ActionMenuItemView).() -> Unit): android.support.v7.view.menu.ActionMenuItemView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.ACTION_MENU_ITEM_VIEW, theme) { init() }
}

inline fun ViewManager.expandedMenuView(theme: Int = 0): android.support.v7.view.menu.ExpandedMenuView = expandedMenuView(theme) {}
inline fun ViewManager.expandedMenuView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.view.menu.ExpandedMenuView).() -> Unit): android.support.v7.view.menu.ExpandedMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.EXPANDED_MENU_VIEW, theme) { init() }
}

inline fun Context.expandedMenuView(theme: Int = 0): android.support.v7.view.menu.ExpandedMenuView = expandedMenuView(theme) {}
inline fun Context.expandedMenuView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.view.menu.ExpandedMenuView).() -> Unit): android.support.v7.view.menu.ExpandedMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.EXPANDED_MENU_VIEW, theme) { init() }
}

inline fun Activity.expandedMenuView(theme: Int = 0): android.support.v7.view.menu.ExpandedMenuView = expandedMenuView(theme) {}
inline fun Activity.expandedMenuView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.view.menu.ExpandedMenuView).() -> Unit): android.support.v7.view.menu.ExpandedMenuView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.EXPANDED_MENU_VIEW, theme) { init() }
}

inline fun ViewManager.activityChooserView(theme: Int = 0): android.support.v7.widget.ActivityChooserView = activityChooserView(theme) {}
inline fun ViewManager.activityChooserView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ActivityChooserView).() -> Unit): android.support.v7.widget.ActivityChooserView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.ACTIVITY_CHOOSER_VIEW, theme) { init() }
}

inline fun Context.activityChooserView(theme: Int = 0): android.support.v7.widget.ActivityChooserView = activityChooserView(theme) {}
inline fun Context.activityChooserView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ActivityChooserView).() -> Unit): android.support.v7.widget.ActivityChooserView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.ACTIVITY_CHOOSER_VIEW, theme) { init() }
}

inline fun Activity.activityChooserView(theme: Int = 0): android.support.v7.widget.ActivityChooserView = activityChooserView(theme) {}
inline fun Activity.activityChooserView(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ActivityChooserView).() -> Unit): android.support.v7.widget.ActivityChooserView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.ACTIVITY_CHOOSER_VIEW, theme) { init() }
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

inline fun ViewManager.tintedImageButton(theme: Int = 0): ImageButton = tintedImageButton(theme) {}
inline fun ViewManager.tintedImageButton(theme: Int = 0, init: (@AnkoViewDslMarker ImageButton).() -> Unit): ImageButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_BUTTON, theme) { init() }
}

inline fun ViewManager.tintedImageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0): ImageButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_BUTTON, theme) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.tintedImageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0, init: (@AnkoViewDslMarker ImageButton).() -> Unit): ImageButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_BUTTON, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.tintedImageButton(imageResource: Int, theme: Int = 0): ImageButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_BUTTON, theme) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.tintedImageButton(imageResource: Int, theme: Int = 0, init: (@AnkoViewDslMarker ImageButton).() -> Unit): ImageButton {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_BUTTON, theme) {
        init()
        setImageResource(imageResource)
    }
}

inline fun ViewManager.tintedImageView(theme: Int = 0): ImageView = tintedImageView(theme) {}
inline fun ViewManager.tintedImageView(theme: Int = 0, init: (@AnkoViewDslMarker ImageView).() -> Unit): ImageView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_VIEW, theme) { init() }
}

inline fun ViewManager.tintedImageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0): ImageView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_VIEW, theme) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.tintedImageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0, init: (@AnkoViewDslMarker ImageView).() -> Unit): ImageView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_VIEW, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.tintedImageView(imageResource: Int, theme: Int = 0): ImageView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_VIEW, theme) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.tintedImageView(imageResource: Int, theme: Int = 0, init: (@AnkoViewDslMarker ImageView).() -> Unit): ImageView {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_IMAGE_VIEW, theme) {
        init()
        setImageResource(imageResource)
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

inline fun ViewManager.tintedSeekBar(theme: Int = 0): SeekBar = tintedSeekBar(theme) {}
inline fun ViewManager.tintedSeekBar(theme: Int = 0, init: (@AnkoViewDslMarker SeekBar).() -> Unit): SeekBar {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.TINTED_SEEK_BAR, theme) { init() }
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

inline fun ViewManager.contentFrameLayout(theme: Int = 0): android.support.v7.widget.ContentFrameLayout = contentFrameLayout(theme) {}
inline fun ViewManager.contentFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ContentFrameLayout).() -> Unit): android.support.v7.widget.ContentFrameLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.CONTENT_FRAME_LAYOUT, theme) { init() }
}

inline fun Context.contentFrameLayout(theme: Int = 0): android.support.v7.widget.ContentFrameLayout = contentFrameLayout(theme) {}
inline fun Context.contentFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ContentFrameLayout).() -> Unit): android.support.v7.widget.ContentFrameLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.CONTENT_FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.contentFrameLayout(theme: Int = 0): android.support.v7.widget.ContentFrameLayout = contentFrameLayout(theme) {}
inline fun Activity.contentFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ContentFrameLayout).() -> Unit): android.support.v7.widget.ContentFrameLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.CONTENT_FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.dialogTitle(theme: Int = 0): android.support.v7.widget.DialogTitle = dialogTitle(theme) {}
inline fun ViewManager.dialogTitle(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.DialogTitle).() -> Unit): android.support.v7.widget.DialogTitle {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.DIALOG_TITLE, theme) { init() }
}

inline fun ViewManager.fitWindowsFrameLayout(theme: Int = 0): android.support.v7.widget.FitWindowsFrameLayout = fitWindowsFrameLayout(theme) {}
inline fun ViewManager.fitWindowsFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.FitWindowsFrameLayout).() -> Unit): android.support.v7.widget.FitWindowsFrameLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.FIT_WINDOWS_FRAME_LAYOUT, theme) { init() }
}

inline fun Context.fitWindowsFrameLayout(theme: Int = 0): android.support.v7.widget.FitWindowsFrameLayout = fitWindowsFrameLayout(theme) {}
inline fun Context.fitWindowsFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.FitWindowsFrameLayout).() -> Unit): android.support.v7.widget.FitWindowsFrameLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.FIT_WINDOWS_FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.fitWindowsFrameLayout(theme: Int = 0): android.support.v7.widget.FitWindowsFrameLayout = fitWindowsFrameLayout(theme) {}
inline fun Activity.fitWindowsFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.FitWindowsFrameLayout).() -> Unit): android.support.v7.widget.FitWindowsFrameLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.FIT_WINDOWS_FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.fitWindowsLinearLayout(theme: Int = 0): android.support.v7.widget.FitWindowsLinearLayout = fitWindowsLinearLayout(theme) {}
inline fun ViewManager.fitWindowsLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.FitWindowsLinearLayout).() -> Unit): android.support.v7.widget.FitWindowsLinearLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.FIT_WINDOWS_LINEAR_LAYOUT, theme) { init() }
}

inline fun Context.fitWindowsLinearLayout(theme: Int = 0): android.support.v7.widget.FitWindowsLinearLayout = fitWindowsLinearLayout(theme) {}
inline fun Context.fitWindowsLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.FitWindowsLinearLayout).() -> Unit): android.support.v7.widget.FitWindowsLinearLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.FIT_WINDOWS_LINEAR_LAYOUT, theme) { init() }
}

inline fun Activity.fitWindowsLinearLayout(theme: Int = 0): android.support.v7.widget.FitWindowsLinearLayout = fitWindowsLinearLayout(theme) {}
inline fun Activity.fitWindowsLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.FitWindowsLinearLayout).() -> Unit): android.support.v7.widget.FitWindowsLinearLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.FIT_WINDOWS_LINEAR_LAYOUT, theme) { init() }
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

inline fun ViewManager.viewStubCompat(theme: Int = 0): android.support.v7.widget.ViewStubCompat = viewStubCompat(theme) {}
inline fun ViewManager.viewStubCompat(theme: Int = 0, init: (@AnkoViewDslMarker android.support.v7.widget.ViewStubCompat).() -> Unit): android.support.v7.widget.ViewStubCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7View`.VIEW_STUB_COMPAT, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$AppcompatV7ViewGroup` {
    val LIST_MENU_ITEM_VIEW = { ctx: Context -> _ListMenuItemView(ctx, null) }
    val ACTION_BAR_CONTAINER = { ctx: Context -> _ActionBarContainer(ctx) }
    val ACTION_BAR_CONTEXT_VIEW = { ctx: Context -> _ActionBarContextView(ctx) }
    val ACTION_BAR_OVERLAY_LAYOUT = { ctx: Context -> _ActionBarOverlayLayout(ctx) }
    val ACTION_MENU_VIEW = { ctx: Context -> _ActionMenuView(ctx) }
    val ALERT_DIALOG_LAYOUT = { ctx: Context -> _AlertDialogLayout(ctx) }
    val BUTTON_BAR_LAYOUT = { ctx: Context -> _ButtonBarLayout(ctx, null) }
    val LINEAR_LAYOUT_COMPAT = { ctx: Context -> _LinearLayoutCompat(ctx) }
    val LIST_VIEW_COMPAT = { ctx: Context -> _ListViewCompat(ctx) }
    val SCROLLING_TAB_CONTAINER_VIEW = { ctx: Context -> _ScrollingTabContainerView(ctx) }
    val TOOLBAR = { ctx: Context -> _Toolbar(ctx) }
}

inline fun ViewManager.listMenuItemView(theme: Int = 0): android.support.v7.view.menu.ListMenuItemView = listMenuItemView(theme) {}
inline fun ViewManager.listMenuItemView(theme: Int = 0, init: (@AnkoViewDslMarker _ListMenuItemView).() -> Unit): android.support.v7.view.menu.ListMenuItemView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LIST_MENU_ITEM_VIEW, theme) { init() }
}

inline fun Context.listMenuItemView(theme: Int = 0): android.support.v7.view.menu.ListMenuItemView = listMenuItemView(theme) {}
inline fun Context.listMenuItemView(theme: Int = 0, init: (@AnkoViewDslMarker _ListMenuItemView).() -> Unit): android.support.v7.view.menu.ListMenuItemView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LIST_MENU_ITEM_VIEW, theme) { init() }
}

inline fun Activity.listMenuItemView(theme: Int = 0): android.support.v7.view.menu.ListMenuItemView = listMenuItemView(theme) {}
inline fun Activity.listMenuItemView(theme: Int = 0, init: (@AnkoViewDslMarker _ListMenuItemView).() -> Unit): android.support.v7.view.menu.ListMenuItemView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LIST_MENU_ITEM_VIEW, theme) { init() }
}

inline fun ViewManager.actionBarContainer(theme: Int = 0): android.support.v7.widget.ActionBarContainer = actionBarContainer(theme) {}
inline fun ViewManager.actionBarContainer(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarContainer).() -> Unit): android.support.v7.widget.ActionBarContainer {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_CONTAINER, theme) { init() }
}

inline fun Context.actionBarContainer(theme: Int = 0): android.support.v7.widget.ActionBarContainer = actionBarContainer(theme) {}
inline fun Context.actionBarContainer(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarContainer).() -> Unit): android.support.v7.widget.ActionBarContainer {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_CONTAINER, theme) { init() }
}

inline fun Activity.actionBarContainer(theme: Int = 0): android.support.v7.widget.ActionBarContainer = actionBarContainer(theme) {}
inline fun Activity.actionBarContainer(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarContainer).() -> Unit): android.support.v7.widget.ActionBarContainer {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_CONTAINER, theme) { init() }
}

inline fun ViewManager.actionBarContextView(theme: Int = 0): android.support.v7.widget.ActionBarContextView = actionBarContextView(theme) {}
inline fun ViewManager.actionBarContextView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarContextView).() -> Unit): android.support.v7.widget.ActionBarContextView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_CONTEXT_VIEW, theme) { init() }
}

inline fun Context.actionBarContextView(theme: Int = 0): android.support.v7.widget.ActionBarContextView = actionBarContextView(theme) {}
inline fun Context.actionBarContextView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarContextView).() -> Unit): android.support.v7.widget.ActionBarContextView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_CONTEXT_VIEW, theme) { init() }
}

inline fun Activity.actionBarContextView(theme: Int = 0): android.support.v7.widget.ActionBarContextView = actionBarContextView(theme) {}
inline fun Activity.actionBarContextView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarContextView).() -> Unit): android.support.v7.widget.ActionBarContextView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_CONTEXT_VIEW, theme) { init() }
}

inline fun ViewManager.actionBarOverlayLayout(theme: Int = 0): android.support.v7.widget.ActionBarOverlayLayout = actionBarOverlayLayout(theme) {}
inline fun ViewManager.actionBarOverlayLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarOverlayLayout).() -> Unit): android.support.v7.widget.ActionBarOverlayLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_OVERLAY_LAYOUT, theme) { init() }
}

inline fun Context.actionBarOverlayLayout(theme: Int = 0): android.support.v7.widget.ActionBarOverlayLayout = actionBarOverlayLayout(theme) {}
inline fun Context.actionBarOverlayLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarOverlayLayout).() -> Unit): android.support.v7.widget.ActionBarOverlayLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_OVERLAY_LAYOUT, theme) { init() }
}

inline fun Activity.actionBarOverlayLayout(theme: Int = 0): android.support.v7.widget.ActionBarOverlayLayout = actionBarOverlayLayout(theme) {}
inline fun Activity.actionBarOverlayLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ActionBarOverlayLayout).() -> Unit): android.support.v7.widget.ActionBarOverlayLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ACTION_BAR_OVERLAY_LAYOUT, theme) { init() }
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

inline fun ViewManager.alertDialogLayout(theme: Int = 0): android.support.v7.widget.AlertDialogLayout = alertDialogLayout(theme) {}
inline fun ViewManager.alertDialogLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AlertDialogLayout).() -> Unit): android.support.v7.widget.AlertDialogLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ALERT_DIALOG_LAYOUT, theme) { init() }
}

inline fun Context.alertDialogLayout(theme: Int = 0): android.support.v7.widget.AlertDialogLayout = alertDialogLayout(theme) {}
inline fun Context.alertDialogLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AlertDialogLayout).() -> Unit): android.support.v7.widget.AlertDialogLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ALERT_DIALOG_LAYOUT, theme) { init() }
}

inline fun Activity.alertDialogLayout(theme: Int = 0): android.support.v7.widget.AlertDialogLayout = alertDialogLayout(theme) {}
inline fun Activity.alertDialogLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AlertDialogLayout).() -> Unit): android.support.v7.widget.AlertDialogLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.ALERT_DIALOG_LAYOUT, theme) { init() }
}

inline fun ViewManager.buttonBarLayout(theme: Int = 0): android.support.v7.widget.ButtonBarLayout = buttonBarLayout(theme) {}
inline fun ViewManager.buttonBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ButtonBarLayout).() -> Unit): android.support.v7.widget.ButtonBarLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.BUTTON_BAR_LAYOUT, theme) { init() }
}

inline fun Context.buttonBarLayout(theme: Int = 0): android.support.v7.widget.ButtonBarLayout = buttonBarLayout(theme) {}
inline fun Context.buttonBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ButtonBarLayout).() -> Unit): android.support.v7.widget.ButtonBarLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.BUTTON_BAR_LAYOUT, theme) { init() }
}

inline fun Activity.buttonBarLayout(theme: Int = 0): android.support.v7.widget.ButtonBarLayout = buttonBarLayout(theme) {}
inline fun Activity.buttonBarLayout(theme: Int = 0, init: (@AnkoViewDslMarker _ButtonBarLayout).() -> Unit): android.support.v7.widget.ButtonBarLayout {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.BUTTON_BAR_LAYOUT, theme) { init() }
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

inline fun ViewManager.listViewCompat(theme: Int = 0): android.support.v7.widget.ListViewCompat = listViewCompat(theme) {}
inline fun ViewManager.listViewCompat(theme: Int = 0, init: (@AnkoViewDslMarker _ListViewCompat).() -> Unit): android.support.v7.widget.ListViewCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LIST_VIEW_COMPAT, theme) { init() }
}

inline fun Context.listViewCompat(theme: Int = 0): android.support.v7.widget.ListViewCompat = listViewCompat(theme) {}
inline fun Context.listViewCompat(theme: Int = 0, init: (@AnkoViewDslMarker _ListViewCompat).() -> Unit): android.support.v7.widget.ListViewCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LIST_VIEW_COMPAT, theme) { init() }
}

inline fun Activity.listViewCompat(theme: Int = 0): android.support.v7.widget.ListViewCompat = listViewCompat(theme) {}
inline fun Activity.listViewCompat(theme: Int = 0, init: (@AnkoViewDslMarker _ListViewCompat).() -> Unit): android.support.v7.widget.ListViewCompat {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.LIST_VIEW_COMPAT, theme) { init() }
}

inline fun ViewManager.scrollingTabContainerView(theme: Int = 0): android.support.v7.widget.ScrollingTabContainerView = scrollingTabContainerView(theme) {}
inline fun ViewManager.scrollingTabContainerView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollingTabContainerView).() -> Unit): android.support.v7.widget.ScrollingTabContainerView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.SCROLLING_TAB_CONTAINER_VIEW, theme) { init() }
}

inline fun Context.scrollingTabContainerView(theme: Int = 0): android.support.v7.widget.ScrollingTabContainerView = scrollingTabContainerView(theme) {}
inline fun Context.scrollingTabContainerView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollingTabContainerView).() -> Unit): android.support.v7.widget.ScrollingTabContainerView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.SCROLLING_TAB_CONTAINER_VIEW, theme) { init() }
}

inline fun Activity.scrollingTabContainerView(theme: Int = 0): android.support.v7.widget.ScrollingTabContainerView = scrollingTabContainerView(theme) {}
inline fun Activity.scrollingTabContainerView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollingTabContainerView).() -> Unit): android.support.v7.widget.ScrollingTabContainerView {
    return ankoView(`$$Anko$Factories$AppcompatV7ViewGroup`.SCROLLING_TAB_CONTAINER_VIEW, theme) { init() }
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

