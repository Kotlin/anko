@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedAutoCompleteTextView(): AutoCompleteTextView = tintedAutoCompleteTextView({})
public inline fun ViewManager.tintedAutoCompleteTextView(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: AutoCompleteTextView.() -> Unit
): AutoCompleteTextView = addView<AutoCompleteTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatAutoCompleteTextView(ctx)
    else
        AutoCompleteTextView(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedButton(): Button = tintedButton({})
public inline fun ViewManager.tintedButton(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Button.() -> Unit
): Button = addView<Button> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatButton(ctx)
    else
        Button(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckBox(): CheckBox = tintedCheckBox({})
public inline fun ViewManager.tintedCheckBox(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: CheckBox.() -> Unit
): CheckBox = addView<CheckBox> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatCheckBox(ctx)
    else
        CheckBox(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedCheckedTextView(): CheckedTextView = tintedCheckedTextView({})
public inline fun ViewManager.tintedCheckedTextView(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: CheckedTextView.() -> Unit
): CheckedTextView = addView<CheckedTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatCheckedTextView(ctx)
    else
        CheckedTextView(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedEditText(): EditText = tintedEditText({})
public inline fun ViewManager.tintedEditText(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: EditText.() -> Unit
): EditText = addView<EditText> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatEditText(ctx)
    else
        EditText(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedMultiAutoCompleteTextView(): MultiAutoCompleteTextView = tintedMultiAutoCompleteTextView({})
public inline fun ViewManager.tintedMultiAutoCompleteTextView(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: MultiAutoCompleteTextView.() -> Unit
): MultiAutoCompleteTextView = addView<MultiAutoCompleteTextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatMultiAutoCompleteTextView(ctx)
    else
        MultiAutoCompleteTextView(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedRadioButton(): RadioButton = tintedRadioButton({})
public inline fun ViewManager.tintedRadioButton(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: RadioButton.() -> Unit
): RadioButton = addView<RadioButton> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatRadioButton(ctx)
    else
        RadioButton(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedRatingBar(): RatingBar = tintedRatingBar({})
public inline fun ViewManager.tintedRatingBar(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: RatingBar.() -> Unit
): RatingBar = addView<RatingBar> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatRatingBar(ctx)
    else
        RatingBar(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun ViewManager.tintedSpinner(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Spinner.() -> Unit
): Spinner = addView<Spinner> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatSpinner(ctx)
    else
        Spinner(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun Context.tintedSpinner(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Spinner.() -> Unit
): Spinner = addView<Spinner> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatSpinner(ctx)
    else
        Spinner(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.tintedSpinner(): Spinner = tintedSpinner({})
public inline fun Activity.tintedSpinner(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: Spinner.() -> Unit
): Spinner = addView<Spinner> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatSpinner(ctx)
    else
        Spinner(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.tintedTextView(): TextView = tintedTextView({})
public inline fun ViewManager.tintedTextView(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: TextView.() -> Unit
): TextView = addView<TextView> {
    ctx ->
    val view = if (Build.VERSION.SDK_INT < 21)
        android.support.v7.widget.AppCompatTextView(ctx)
    else
        TextView(ctx)

    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.searchViewSupport(): android.support.v7.widget.SearchView = searchViewSupport({})
public inline fun ViewManager.searchViewSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.SearchView.() -> Unit
): android.support.v7.widget.SearchView = addView<android.support.v7.widget.SearchView> {
    ctx ->
    val view = android.support.v7.widget.SearchView(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.searchViewSupport(): android.support.v7.widget.SearchView = searchViewSupport({})
public inline fun Context.searchViewSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.SearchView.() -> Unit
): android.support.v7.widget.SearchView = addView<android.support.v7.widget.SearchView> {
    ctx ->
    val view = android.support.v7.widget.SearchView(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.searchViewSupport(): android.support.v7.widget.SearchView = searchViewSupport({})
public inline fun Activity.searchViewSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.SearchView.() -> Unit
): android.support.v7.widget.SearchView = addView<android.support.v7.widget.SearchView> {
    ctx ->
    val view = android.support.v7.widget.SearchView(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.switchCompatSupport(): android.support.v7.widget.SwitchCompat = switchCompatSupport({})
public inline fun ViewManager.switchCompatSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: android.support.v7.widget.SwitchCompat.() -> Unit
): android.support.v7.widget.SwitchCompat = addView<android.support.v7.widget.SwitchCompat> {
    ctx ->
    val view = android.support.v7.widget.SwitchCompat(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.actionMenuViewSupport(): android.support.v7.widget.ActionMenuView = actionMenuViewSupport({})
public inline fun ViewManager.actionMenuViewSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _ActionMenuViewSupport.() -> Unit
): android.support.v7.widget.ActionMenuView = addView<android.support.v7.widget.ActionMenuView> {
    ctx ->
    val view = _ActionMenuViewSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.actionMenuViewSupport(): android.support.v7.widget.ActionMenuView = actionMenuViewSupport({})
public inline fun Context.actionMenuViewSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _ActionMenuViewSupport.() -> Unit
): android.support.v7.widget.ActionMenuView = addView<android.support.v7.widget.ActionMenuView> {
    ctx ->
    val view = _ActionMenuViewSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.actionMenuViewSupport(): android.support.v7.widget.ActionMenuView = actionMenuViewSupport({})
public inline fun Activity.actionMenuViewSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _ActionMenuViewSupport.() -> Unit
): android.support.v7.widget.ActionMenuView = addView<android.support.v7.widget.ActionMenuView> {
    ctx ->
    val view = _ActionMenuViewSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.linearLayoutCompatSupport(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompatSupport({})
public inline fun ViewManager.linearLayoutCompatSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayoutCompatSupport.() -> Unit
): android.support.v7.widget.LinearLayoutCompat = addView<android.support.v7.widget.LinearLayoutCompat> {
    ctx ->
    val view = _LinearLayoutCompatSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.linearLayoutCompatSupport(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompatSupport({})
public inline fun Context.linearLayoutCompatSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayoutCompatSupport.() -> Unit
): android.support.v7.widget.LinearLayoutCompat = addView<android.support.v7.widget.LinearLayoutCompat> {
    ctx ->
    val view = _LinearLayoutCompatSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.linearLayoutCompatSupport(): android.support.v7.widget.LinearLayoutCompat = linearLayoutCompatSupport({})
public inline fun Activity.linearLayoutCompatSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _LinearLayoutCompatSupport.() -> Unit
): android.support.v7.widget.LinearLayoutCompat = addView<android.support.v7.widget.LinearLayoutCompat> {
    ctx ->
    val view = _LinearLayoutCompatSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun ViewManager.toolbarSupport(): android.support.v7.widget.Toolbar = toolbarSupport({})
public inline fun ViewManager.toolbarSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _ToolbarSupport.() -> Unit
): android.support.v7.widget.Toolbar = addView<android.support.v7.widget.Toolbar> {
    ctx ->
    val view = _ToolbarSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Context.toolbarSupport(): android.support.v7.widget.Toolbar = toolbarSupport({})
public inline fun Context.toolbarSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _ToolbarSupport.() -> Unit
): android.support.v7.widget.Toolbar = addView<android.support.v7.widget.Toolbar> {
    ctx ->
    val view = _ToolbarSupport(ctx)
    view.init()
    view
}

@suppress("NOTHING_TO_INLINE")
public inline fun Activity.toolbarSupport(): android.support.v7.widget.Toolbar = toolbarSupport({})
public inline fun Activity.toolbarSupport(
        inlineOptions(InlineOption.ONLY_LOCAL_RETURN) init: _ToolbarSupport.() -> Unit
): android.support.v7.widget.Toolbar = addView<android.support.v7.widget.Toolbar> {
    ctx ->
    val view = _ToolbarSupport(ctx)
    view.init()
    view
}