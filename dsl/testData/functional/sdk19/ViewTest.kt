public object `$$Anko$Factories$Sdk19View` {
    public val MEDIA_ROUTE_BUTTON = { ctx: Context -> android.app.MediaRouteButton(ctx) }
    public val GESTURE_OVERLAY_VIEW = { ctx: Context -> android.gesture.GestureOverlayView(ctx) }
    public val EXTRACT_EDIT_TEXT = { ctx: Context -> android.inputmethodservice.ExtractEditText(ctx) }
    public val G_L_SURFACE_VIEW = { ctx: Context -> android.opengl.GLSurfaceView(ctx) }
    public val SURFACE_VIEW = { ctx: Context -> android.view.SurfaceView(ctx) }
    public val TEXTURE_VIEW = { ctx: Context -> android.view.TextureView(ctx) }
    public val VIEW = { ctx: Context -> android.view.View(ctx) }
    public val VIEW_STUB = { ctx: Context -> android.view.ViewStub(ctx) }
    public val ADAPTER_VIEW_FLIPPER = { ctx: Context -> android.widget.AdapterViewFlipper(ctx) }
    public val ANALOG_CLOCK = { ctx: Context -> android.widget.AnalogClock(ctx) }
    public val AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> android.widget.AutoCompleteTextView(ctx) }
    public val BUTTON = { ctx: Context -> android.widget.Button(ctx) }
    public val CALENDAR_VIEW = { ctx: Context -> android.widget.CalendarView(ctx) }
    public val CHECK_BOX = { ctx: Context -> android.widget.CheckBox(ctx) }
    public val CHECKED_TEXT_VIEW = { ctx: Context -> android.widget.CheckedTextView(ctx) }
    public val CHRONOMETER = { ctx: Context -> android.widget.Chronometer(ctx) }
    public val DATE_PICKER = { ctx: Context -> android.widget.DatePicker(ctx) }
    public val DIALER_FILTER = { ctx: Context -> android.widget.DialerFilter(ctx) }
    public val DIGITAL_CLOCK = { ctx: Context -> android.widget.DigitalClock(ctx) }
    public val EDIT_TEXT = { ctx: Context -> android.widget.EditText(ctx) }
    public val EXPANDABLE_LIST_VIEW = { ctx: Context -> android.widget.ExpandableListView(ctx) }
    public val IMAGE_BUTTON = { ctx: Context -> android.widget.ImageButton(ctx) }
    public val IMAGE_VIEW = { ctx: Context -> android.widget.ImageView(ctx) }
    public val LIST_VIEW = { ctx: Context -> android.widget.ListView(ctx) }
    public val MULTI_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> android.widget.MultiAutoCompleteTextView(ctx) }
    public val NUMBER_PICKER = { ctx: Context -> android.widget.NumberPicker(ctx) }
    public val PROGRESS_BAR = { ctx: Context -> android.widget.ProgressBar(ctx) }
    public val QUICK_CONTACT_BADGE = { ctx: Context -> android.widget.QuickContactBadge(ctx) }
    public val RADIO_BUTTON = { ctx: Context -> android.widget.RadioButton(ctx) }
    public val RATING_BAR = { ctx: Context -> android.widget.RatingBar(ctx) }
    public val SEARCH_VIEW = { ctx: Context -> android.widget.SearchView(ctx) }
    public val SEEK_BAR = { ctx: Context -> android.widget.SeekBar(ctx) }
    public val SLIDING_DRAWER = { ctx: Context -> android.widget.SlidingDrawer(ctx, null) }
    public val SPACE = { ctx: Context -> android.widget.Space(ctx) }
    public val SPINNER = { ctx: Context -> android.widget.Spinner(ctx) }
    public val STACK_VIEW = { ctx: Context -> android.widget.StackView(ctx) }
    public val SWITCH = { ctx: Context -> android.widget.Switch(ctx) }
    public val TAB_HOST = { ctx: Context -> android.widget.TabHost(ctx) }
    public val TAB_WIDGET = { ctx: Context -> android.widget.TabWidget(ctx) }
    public val TEXT_CLOCK = { ctx: Context -> android.widget.TextClock(ctx) }
    public val TEXT_VIEW = { ctx: Context -> android.widget.TextView(ctx) }
    public val TIME_PICKER = { ctx: Context -> android.widget.TimePicker(ctx) }
    public val TOGGLE_BUTTON = { ctx: Context -> android.widget.ToggleButton(ctx) }
    public val TWO_LINE_LIST_ITEM = { ctx: Context -> android.widget.TwoLineListItem(ctx) }
    public val VIDEO_VIEW = { ctx: Context -> android.widget.VideoView(ctx) }
    public val VIEW_FLIPPER = { ctx: Context -> android.widget.ViewFlipper(ctx) }
    public val ZOOM_BUTTON = { ctx: Context -> android.widget.ZoomButton(ctx) }
    public val ZOOM_CONTROLS = { ctx: Context -> android.widget.ZoomControls(ctx) }
}

public inline fun ViewManager.mediaRouteButton(): android.app.MediaRouteButton = mediaRouteButton({})
public inline fun ViewManager.mediaRouteButton(init: android.app.MediaRouteButton.() -> Unit): android.app.MediaRouteButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.MEDIA_ROUTE_BUTTON) { init() }
}

public inline fun ViewManager.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView({})
public inline fun ViewManager.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk19View`.GESTURE_OVERLAY_VIEW) { init() }
}

public inline fun Context.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView({})
public inline fun Context.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk19View`.GESTURE_OVERLAY_VIEW) { init() }
}

public inline fun Activity.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView({})
public inline fun Activity.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk19View`.GESTURE_OVERLAY_VIEW) { init() }
}

public inline fun ViewManager.extractEditText(): android.inputmethodservice.ExtractEditText = extractEditText({})
public inline fun ViewManager.extractEditText(init: android.inputmethodservice.ExtractEditText.() -> Unit): android.inputmethodservice.ExtractEditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXTRACT_EDIT_TEXT) { init() }
}

public inline fun ViewManager.gLSurfaceView(): android.opengl.GLSurfaceView = gLSurfaceView({})
public inline fun ViewManager.gLSurfaceView(init: android.opengl.GLSurfaceView.() -> Unit): android.opengl.GLSurfaceView {
    return ankoView(`$$Anko$Factories$Sdk19View`.G_L_SURFACE_VIEW) { init() }
}

public inline fun ViewManager.surfaceView(): android.view.SurfaceView = surfaceView({})
public inline fun ViewManager.surfaceView(init: android.view.SurfaceView.() -> Unit): android.view.SurfaceView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SURFACE_VIEW) { init() }
}

public inline fun ViewManager.textureView(): android.view.TextureView = textureView({})
public inline fun ViewManager.textureView(init: android.view.TextureView.() -> Unit): android.view.TextureView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXTURE_VIEW) { init() }
}

public inline fun ViewManager.view(): android.view.View = view({})
public inline fun ViewManager.view(init: android.view.View.() -> Unit): android.view.View {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW) { init() }
}

public inline fun ViewManager.viewStub(): android.view.ViewStub = viewStub({})
public inline fun ViewManager.viewStub(init: android.view.ViewStub.() -> Unit): android.view.ViewStub {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_STUB) { init() }
}

public inline fun ViewManager.adapterViewFlipper(): android.widget.AdapterViewFlipper = adapterViewFlipper({})
public inline fun ViewManager.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.ADAPTER_VIEW_FLIPPER) { init() }
}

public inline fun Context.adapterViewFlipper(): android.widget.AdapterViewFlipper = adapterViewFlipper({})
public inline fun Context.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.ADAPTER_VIEW_FLIPPER) { init() }
}

public inline fun Activity.adapterViewFlipper(): android.widget.AdapterViewFlipper = adapterViewFlipper({})
public inline fun Activity.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.ADAPTER_VIEW_FLIPPER) { init() }
}

public inline fun ViewManager.analogClock(): android.widget.AnalogClock = analogClock({})
public inline fun ViewManager.analogClock(init: android.widget.AnalogClock.() -> Unit): android.widget.AnalogClock {
    return ankoView(`$$Anko$Factories$Sdk19View`.ANALOG_CLOCK) { init() }
}

public inline fun ViewManager.autoCompleteTextView(): android.widget.AutoCompleteTextView = autoCompleteTextView({})
public inline fun ViewManager.autoCompleteTextView(init: android.widget.AutoCompleteTextView.() -> Unit): android.widget.AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.AUTO_COMPLETE_TEXT_VIEW) { init() }
}

public inline fun ViewManager.button(): android.widget.Button = button({})
public inline fun ViewManager.button(init: android.widget.Button.() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON) { init() }
}

public inline fun ViewManager.button(text: CharSequence?): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON) {
        setText(text)
    }
}
public inline fun ViewManager.button(text: CharSequence?, init: android.widget.Button.() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.button(text: Int): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON) {
        setText(text)
    }
}
public inline fun ViewManager.button(text: Int, init: android.widget.Button.() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.calendarView(): android.widget.CalendarView = calendarView({})
public inline fun ViewManager.calendarView(init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CALENDAR_VIEW) { init() }
}

public inline fun Context.calendarView(): android.widget.CalendarView = calendarView({})
public inline fun Context.calendarView(init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CALENDAR_VIEW) { init() }
}

public inline fun Activity.calendarView(): android.widget.CalendarView = calendarView({})
public inline fun Activity.calendarView(init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CALENDAR_VIEW) { init() }
}

public inline fun ViewManager.checkBox(): android.widget.CheckBox = checkBox({})
public inline fun ViewManager.checkBox(init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) { init() }
}

public inline fun ViewManager.checkBox(text: CharSequence?): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        setText(text)
    }
}
public inline fun ViewManager.checkBox(text: CharSequence?, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.checkBox(text: Int): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        setText(text)
    }
}
public inline fun ViewManager.checkBox(text: Int, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        setText(text)
        setChecked(checked)
    }
}
public inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        init()
        setText(text)
        setChecked(checked)
    }
}

public inline fun ViewManager.checkBox(text: Int, checked: Boolean): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        setText(text)
        setChecked(checked)
    }
}
public inline fun ViewManager.checkBox(text: Int, checked: Boolean, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX) {
        init()
        setText(text)
        setChecked(checked)
    }
}

public inline fun ViewManager.checkedTextView(): android.widget.CheckedTextView = checkedTextView({})
public inline fun ViewManager.checkedTextView(init: android.widget.CheckedTextView.() -> Unit): android.widget.CheckedTextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECKED_TEXT_VIEW) { init() }
}

public inline fun ViewManager.chronometer(): android.widget.Chronometer = chronometer({})
public inline fun ViewManager.chronometer(init: android.widget.Chronometer.() -> Unit): android.widget.Chronometer {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHRONOMETER) { init() }
}

public inline fun ViewManager.datePicker(): android.widget.DatePicker = datePicker({})
public inline fun ViewManager.datePicker(init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.DATE_PICKER) { init() }
}

public inline fun Context.datePicker(): android.widget.DatePicker = datePicker({})
public inline fun Context.datePicker(init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.DATE_PICKER) { init() }
}

public inline fun Activity.datePicker(): android.widget.DatePicker = datePicker({})
public inline fun Activity.datePicker(init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.DATE_PICKER) { init() }
}

public inline fun ViewManager.dialerFilter(): android.widget.DialerFilter = dialerFilter({})
public inline fun ViewManager.dialerFilter(init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIALER_FILTER) { init() }
}

public inline fun Context.dialerFilter(): android.widget.DialerFilter = dialerFilter({})
public inline fun Context.dialerFilter(init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIALER_FILTER) { init() }
}

public inline fun Activity.dialerFilter(): android.widget.DialerFilter = dialerFilter({})
public inline fun Activity.dialerFilter(init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIALER_FILTER) { init() }
}

public inline fun ViewManager.digitalClock(): android.widget.DigitalClock = digitalClock({})
public inline fun ViewManager.digitalClock(init: android.widget.DigitalClock.() -> Unit): android.widget.DigitalClock {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIGITAL_CLOCK) { init() }
}

public inline fun ViewManager.editText(): android.widget.EditText = editText({})
public inline fun ViewManager.editText(init: android.widget.EditText.() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT) { init() }
}

public inline fun ViewManager.editText(text: CharSequence?): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT) {
        setText(text)
    }
}
public inline fun ViewManager.editText(text: CharSequence?, init: android.widget.EditText.() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.editText(text: Int): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT) {
        setText(text)
    }
}
public inline fun ViewManager.editText(text: Int, init: android.widget.EditText.() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.expandableListView(): android.widget.ExpandableListView = expandableListView({})
public inline fun ViewManager.expandableListView(init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXPANDABLE_LIST_VIEW) { init() }
}

public inline fun Context.expandableListView(): android.widget.ExpandableListView = expandableListView({})
public inline fun Context.expandableListView(init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXPANDABLE_LIST_VIEW) { init() }
}

public inline fun Activity.expandableListView(): android.widget.ExpandableListView = expandableListView({})
public inline fun Activity.expandableListView(init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXPANDABLE_LIST_VIEW) { init() }
}

public inline fun ViewManager.imageButton(): android.widget.ImageButton = imageButton({})
public inline fun ViewManager.imageButton(init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON) { init() }
}

public inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON) {
        setImageDrawable(imageDrawable)
    }
}
public inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON) {
        init()
        setImageDrawable(imageDrawable)
    }
}

public inline fun ViewManager.imageButton(imageResource: Int): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON) {
        setImageResource(imageResource)
    }
}
public inline fun ViewManager.imageButton(imageResource: Int, init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON) {
        init()
        setImageResource(imageResource)
    }
}

public inline fun ViewManager.imageView(): android.widget.ImageView = imageView({})
public inline fun ViewManager.imageView(init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW) { init() }
}

public inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW) {
        setImageDrawable(imageDrawable)
    }
}
public inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW) {
        init()
        setImageDrawable(imageDrawable)
    }
}

public inline fun ViewManager.imageView(imageResource: Int): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW) {
        setImageResource(imageResource)
    }
}
public inline fun ViewManager.imageView(imageResource: Int, init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW) {
        init()
        setImageResource(imageResource)
    }
}

public inline fun ViewManager.listView(): android.widget.ListView = listView({})
public inline fun ViewManager.listView(init: android.widget.ListView.() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.LIST_VIEW) { init() }
}

public inline fun Context.listView(): android.widget.ListView = listView({})
public inline fun Context.listView(init: android.widget.ListView.() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.LIST_VIEW) { init() }
}

public inline fun Activity.listView(): android.widget.ListView = listView({})
public inline fun Activity.listView(init: android.widget.ListView.() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.LIST_VIEW) { init() }
}

public inline fun ViewManager.multiAutoCompleteTextView(): android.widget.MultiAutoCompleteTextView = multiAutoCompleteTextView({})
public inline fun ViewManager.multiAutoCompleteTextView(init: android.widget.MultiAutoCompleteTextView.() -> Unit): android.widget.MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.MULTI_AUTO_COMPLETE_TEXT_VIEW) { init() }
}

public inline fun ViewManager.numberPicker(): android.widget.NumberPicker = numberPicker({})
public inline fun ViewManager.numberPicker(init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.NUMBER_PICKER) { init() }
}

public inline fun Context.numberPicker(): android.widget.NumberPicker = numberPicker({})
public inline fun Context.numberPicker(init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.NUMBER_PICKER) { init() }
}

public inline fun Activity.numberPicker(): android.widget.NumberPicker = numberPicker({})
public inline fun Activity.numberPicker(init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.NUMBER_PICKER) { init() }
}

public inline fun ViewManager.progressBar(): android.widget.ProgressBar = progressBar({})
public inline fun ViewManager.progressBar(init: android.widget.ProgressBar.() -> Unit): android.widget.ProgressBar {
    return ankoView(`$$Anko$Factories$Sdk19View`.PROGRESS_BAR) { init() }
}

public inline fun ViewManager.quickContactBadge(): android.widget.QuickContactBadge = quickContactBadge({})
public inline fun ViewManager.quickContactBadge(init: android.widget.QuickContactBadge.() -> Unit): android.widget.QuickContactBadge {
    return ankoView(`$$Anko$Factories$Sdk19View`.QUICK_CONTACT_BADGE) { init() }
}

public inline fun ViewManager.radioButton(): android.widget.RadioButton = radioButton({})
public inline fun ViewManager.radioButton(init: android.widget.RadioButton.() -> Unit): android.widget.RadioButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.RADIO_BUTTON) { init() }
}

public inline fun ViewManager.ratingBar(): android.widget.RatingBar = ratingBar({})
public inline fun ViewManager.ratingBar(init: android.widget.RatingBar.() -> Unit): android.widget.RatingBar {
    return ankoView(`$$Anko$Factories$Sdk19View`.RATING_BAR) { init() }
}

public inline fun ViewManager.searchView(): android.widget.SearchView = searchView({})
public inline fun ViewManager.searchView(init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEARCH_VIEW) { init() }
}

public inline fun Context.searchView(): android.widget.SearchView = searchView({})
public inline fun Context.searchView(init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEARCH_VIEW) { init() }
}

public inline fun Activity.searchView(): android.widget.SearchView = searchView({})
public inline fun Activity.searchView(init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEARCH_VIEW) { init() }
}

public inline fun ViewManager.seekBar(): android.widget.SeekBar = seekBar({})
public inline fun ViewManager.seekBar(init: android.widget.SeekBar.() -> Unit): android.widget.SeekBar {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEEK_BAR) { init() }
}

public inline fun ViewManager.slidingDrawer(): android.widget.SlidingDrawer = slidingDrawer({})
public inline fun ViewManager.slidingDrawer(init: android.widget.SlidingDrawer.() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk19View`.SLIDING_DRAWER) { init() }
}

public inline fun Context.slidingDrawer(): android.widget.SlidingDrawer = slidingDrawer({})
public inline fun Context.slidingDrawer(init: android.widget.SlidingDrawer.() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk19View`.SLIDING_DRAWER) { init() }
}

public inline fun Activity.slidingDrawer(): android.widget.SlidingDrawer = slidingDrawer({})
public inline fun Activity.slidingDrawer(init: android.widget.SlidingDrawer.() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk19View`.SLIDING_DRAWER) { init() }
}

public inline fun ViewManager.space(): android.widget.Space = space({})
public inline fun ViewManager.space(init: android.widget.Space.() -> Unit): android.widget.Space {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPACE) { init() }
}

public inline fun ViewManager.spinner(): android.widget.Spinner = spinner({})
public inline fun ViewManager.spinner(init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPINNER) { init() }
}

public inline fun Context.spinner(): android.widget.Spinner = spinner({})
public inline fun Context.spinner(init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPINNER) { init() }
}

public inline fun Activity.spinner(): android.widget.Spinner = spinner({})
public inline fun Activity.spinner(init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPINNER) { init() }
}

public inline fun ViewManager.stackView(): android.widget.StackView = stackView({})
public inline fun ViewManager.stackView(init: android.widget.StackView.() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk19View`.STACK_VIEW) { init() }
}

public inline fun Context.stackView(): android.widget.StackView = stackView({})
public inline fun Context.stackView(init: android.widget.StackView.() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk19View`.STACK_VIEW) { init() }
}

public inline fun Activity.stackView(): android.widget.StackView = stackView({})
public inline fun Activity.stackView(init: android.widget.StackView.() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk19View`.STACK_VIEW) { init() }
}

public inline fun ViewManager.switch(): android.widget.Switch = switch({})
public inline fun ViewManager.switch(init: android.widget.Switch.() -> Unit): android.widget.Switch {
    return ankoView(`$$Anko$Factories$Sdk19View`.SWITCH) { init() }
}

public inline fun ViewManager.tabHost(): android.widget.TabHost = tabHost({})
public inline fun ViewManager.tabHost(init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_HOST) { init() }
}

public inline fun Context.tabHost(): android.widget.TabHost = tabHost({})
public inline fun Context.tabHost(init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_HOST) { init() }
}

public inline fun Activity.tabHost(): android.widget.TabHost = tabHost({})
public inline fun Activity.tabHost(init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_HOST) { init() }
}

public inline fun ViewManager.tabWidget(): android.widget.TabWidget = tabWidget({})
public inline fun ViewManager.tabWidget(init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_WIDGET) { init() }
}

public inline fun Context.tabWidget(): android.widget.TabWidget = tabWidget({})
public inline fun Context.tabWidget(init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_WIDGET) { init() }
}

public inline fun Activity.tabWidget(): android.widget.TabWidget = tabWidget({})
public inline fun Activity.tabWidget(init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_WIDGET) { init() }
}

public inline fun ViewManager.textClock(): android.widget.TextClock = textClock({})
public inline fun ViewManager.textClock(init: android.widget.TextClock.() -> Unit): android.widget.TextClock {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_CLOCK) { init() }
}

public inline fun ViewManager.textView(): android.widget.TextView = textView({})
public inline fun ViewManager.textView(init: android.widget.TextView.() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW) { init() }
}

public inline fun ViewManager.textView(text: CharSequence?): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW) {
        setText(text)
    }
}
public inline fun ViewManager.textView(text: CharSequence?, init: android.widget.TextView.() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.textView(text: Int): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW) {
        setText(text)
    }
}
public inline fun ViewManager.textView(text: Int, init: android.widget.TextView.() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW) {
        init()
        setText(text)
    }
}

public inline fun ViewManager.timePicker(): android.widget.TimePicker = timePicker({})
public inline fun ViewManager.timePicker(init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.TIME_PICKER) { init() }
}

public inline fun Context.timePicker(): android.widget.TimePicker = timePicker({})
public inline fun Context.timePicker(init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.TIME_PICKER) { init() }
}

public inline fun Activity.timePicker(): android.widget.TimePicker = timePicker({})
public inline fun Activity.timePicker(init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.TIME_PICKER) { init() }
}

public inline fun ViewManager.toggleButton(): android.widget.ToggleButton = toggleButton({})
public inline fun ViewManager.toggleButton(init: android.widget.ToggleButton.() -> Unit): android.widget.ToggleButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.TOGGLE_BUTTON) { init() }
}

public inline fun ViewManager.twoLineListItem(): android.widget.TwoLineListItem = twoLineListItem({})
public inline fun ViewManager.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk19View`.TWO_LINE_LIST_ITEM) { init() }
}

public inline fun Context.twoLineListItem(): android.widget.TwoLineListItem = twoLineListItem({})
public inline fun Context.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk19View`.TWO_LINE_LIST_ITEM) { init() }
}

public inline fun Activity.twoLineListItem(): android.widget.TwoLineListItem = twoLineListItem({})
public inline fun Activity.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk19View`.TWO_LINE_LIST_ITEM) { init() }
}

public inline fun ViewManager.videoView(): android.widget.VideoView = videoView({})
public inline fun ViewManager.videoView(init: android.widget.VideoView.() -> Unit): android.widget.VideoView {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIDEO_VIEW) { init() }
}

public inline fun ViewManager.viewFlipper(): android.widget.ViewFlipper = viewFlipper({})
public inline fun ViewManager.viewFlipper(init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_FLIPPER) { init() }
}

public inline fun Context.viewFlipper(): android.widget.ViewFlipper = viewFlipper({})
public inline fun Context.viewFlipper(init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_FLIPPER) { init() }
}

public inline fun Activity.viewFlipper(): android.widget.ViewFlipper = viewFlipper({})
public inline fun Activity.viewFlipper(init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_FLIPPER) { init() }
}

public inline fun ViewManager.zoomButton(): android.widget.ZoomButton = zoomButton({})
public inline fun ViewManager.zoomButton(init: android.widget.ZoomButton.() -> Unit): android.widget.ZoomButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_BUTTON) { init() }
}

public inline fun ViewManager.zoomControls(): android.widget.ZoomControls = zoomControls({})
public inline fun ViewManager.zoomControls(init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_CONTROLS) { init() }
}

public inline fun Context.zoomControls(): android.widget.ZoomControls = zoomControls({})
public inline fun Context.zoomControls(init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_CONTROLS) { init() }
}

public inline fun Activity.zoomControls(): android.widget.ZoomControls = zoomControls({})
public inline fun Activity.zoomControls(init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_CONTROLS) { init() }
}

public object `$$Anko$Factories$Sdk19ViewGroup` {
    public val APP_WIDGET_HOST_VIEW = { ctx: Context -> _AppWidgetHostView(ctx) }
    public val WEB_VIEW = { ctx: Context -> _WebView(ctx) }
    public val ABSOLUTE_LAYOUT = { ctx: Context -> _AbsoluteLayout(ctx) }
    public val FRAME_LAYOUT = { ctx: Context -> _FrameLayout(ctx) }
    public val GALLERY = { ctx: Context -> _Gallery(ctx) }
    public val GRID_LAYOUT = { ctx: Context -> _GridLayout(ctx) }
    public val GRID_VIEW = { ctx: Context -> _GridView(ctx) }
    public val HORIZONTAL_SCROLL_VIEW = { ctx: Context -> _HorizontalScrollView(ctx) }
    public val IMAGE_SWITCHER = { ctx: Context -> _ImageSwitcher(ctx) }
    public val LINEAR_LAYOUT = { ctx: Context -> _LinearLayout(ctx) }
    public val RADIO_GROUP = { ctx: Context -> _RadioGroup(ctx) }
    public val RELATIVE_LAYOUT = { ctx: Context -> _RelativeLayout(ctx) }
    public val SCROLL_VIEW = { ctx: Context -> _ScrollView(ctx) }
    public val TABLE_LAYOUT = { ctx: Context -> _TableLayout(ctx) }
    public val TABLE_ROW = { ctx: Context -> _TableRow(ctx) }
    public val TEXT_SWITCHER = { ctx: Context -> _TextSwitcher(ctx) }
    public val VIEW_ANIMATOR = { ctx: Context -> _ViewAnimator(ctx) }
    public val VIEW_SWITCHER = { ctx: Context -> _ViewSwitcher(ctx) }
}

public inline fun ViewManager.appWidgetHostView(): android.appwidget.AppWidgetHostView = appWidgetHostView({})
public inline fun ViewManager.appWidgetHostView(init: _AppWidgetHostView.() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.APP_WIDGET_HOST_VIEW) { init() }
}

public inline fun Context.appWidgetHostView(): android.appwidget.AppWidgetHostView = appWidgetHostView({})
public inline fun Context.appWidgetHostView(init: _AppWidgetHostView.() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.APP_WIDGET_HOST_VIEW) { init() }
}

public inline fun Activity.appWidgetHostView(): android.appwidget.AppWidgetHostView = appWidgetHostView({})
public inline fun Activity.appWidgetHostView(init: _AppWidgetHostView.() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.APP_WIDGET_HOST_VIEW) { init() }
}

public inline fun ViewManager.webView(): android.webkit.WebView = webView({})
public inline fun ViewManager.webView(init: _WebView.() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.WEB_VIEW) { init() }
}

public inline fun Context.webView(): android.webkit.WebView = webView({})
public inline fun Context.webView(init: _WebView.() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.WEB_VIEW) { init() }
}

public inline fun Activity.webView(): android.webkit.WebView = webView({})
public inline fun Activity.webView(init: _WebView.() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.WEB_VIEW) { init() }
}

public inline fun ViewManager.absoluteLayout(): android.widget.AbsoluteLayout = absoluteLayout({})
public inline fun ViewManager.absoluteLayout(init: _AbsoluteLayout.() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.ABSOLUTE_LAYOUT) { init() }
}

public inline fun Context.absoluteLayout(): android.widget.AbsoluteLayout = absoluteLayout({})
public inline fun Context.absoluteLayout(init: _AbsoluteLayout.() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.ABSOLUTE_LAYOUT) { init() }
}

public inline fun Activity.absoluteLayout(): android.widget.AbsoluteLayout = absoluteLayout({})
public inline fun Activity.absoluteLayout(init: _AbsoluteLayout.() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.ABSOLUTE_LAYOUT) { init() }
}

public inline fun ViewManager.frameLayout(): android.widget.FrameLayout = frameLayout({})
public inline fun ViewManager.frameLayout(init: _FrameLayout.() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.FRAME_LAYOUT) { init() }
}

public inline fun Context.frameLayout(): android.widget.FrameLayout = frameLayout({})
public inline fun Context.frameLayout(init: _FrameLayout.() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.FRAME_LAYOUT) { init() }
}

public inline fun Activity.frameLayout(): android.widget.FrameLayout = frameLayout({})
public inline fun Activity.frameLayout(init: _FrameLayout.() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.FRAME_LAYOUT) { init() }
}

public inline fun ViewManager.gallery(): android.widget.Gallery = gallery({})
public inline fun ViewManager.gallery(init: _Gallery.() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GALLERY) { init() }
}

public inline fun Context.gallery(): android.widget.Gallery = gallery({})
public inline fun Context.gallery(init: _Gallery.() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GALLERY) { init() }
}

public inline fun Activity.gallery(): android.widget.Gallery = gallery({})
public inline fun Activity.gallery(init: _Gallery.() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GALLERY) { init() }
}

public inline fun ViewManager.gridLayout(): android.widget.GridLayout = gridLayout({})
public inline fun ViewManager.gridLayout(init: _GridLayout.() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_LAYOUT) { init() }
}

public inline fun Context.gridLayout(): android.widget.GridLayout = gridLayout({})
public inline fun Context.gridLayout(init: _GridLayout.() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_LAYOUT) { init() }
}

public inline fun Activity.gridLayout(): android.widget.GridLayout = gridLayout({})
public inline fun Activity.gridLayout(init: _GridLayout.() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_LAYOUT) { init() }
}

public inline fun ViewManager.gridView(): android.widget.GridView = gridView({})
public inline fun ViewManager.gridView(init: _GridView.() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_VIEW) { init() }
}

public inline fun Context.gridView(): android.widget.GridView = gridView({})
public inline fun Context.gridView(init: _GridView.() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_VIEW) { init() }
}

public inline fun Activity.gridView(): android.widget.GridView = gridView({})
public inline fun Activity.gridView(init: _GridView.() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_VIEW) { init() }
}

public inline fun ViewManager.horizontalScrollView(): android.widget.HorizontalScrollView = horizontalScrollView({})
public inline fun ViewManager.horizontalScrollView(init: _HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.HORIZONTAL_SCROLL_VIEW) { init() }
}

public inline fun Context.horizontalScrollView(): android.widget.HorizontalScrollView = horizontalScrollView({})
public inline fun Context.horizontalScrollView(init: _HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.HORIZONTAL_SCROLL_VIEW) { init() }
}

public inline fun Activity.horizontalScrollView(): android.widget.HorizontalScrollView = horizontalScrollView({})
public inline fun Activity.horizontalScrollView(init: _HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.HORIZONTAL_SCROLL_VIEW) { init() }
}

public inline fun ViewManager.imageSwitcher(): android.widget.ImageSwitcher = imageSwitcher({})
public inline fun ViewManager.imageSwitcher(init: _ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.IMAGE_SWITCHER) { init() }
}

public inline fun Context.imageSwitcher(): android.widget.ImageSwitcher = imageSwitcher({})
public inline fun Context.imageSwitcher(init: _ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.IMAGE_SWITCHER) { init() }
}

public inline fun Activity.imageSwitcher(): android.widget.ImageSwitcher = imageSwitcher({})
public inline fun Activity.imageSwitcher(init: _ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.IMAGE_SWITCHER) { init() }
}

public inline fun ViewManager.linearLayout(): android.widget.LinearLayout = linearLayout({})
public inline fun ViewManager.linearLayout(init: _LinearLayout.() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.LINEAR_LAYOUT) { init() }
}

public inline fun Context.linearLayout(): android.widget.LinearLayout = linearLayout({})
public inline fun Context.linearLayout(init: _LinearLayout.() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.LINEAR_LAYOUT) { init() }
}

public inline fun Activity.linearLayout(): android.widget.LinearLayout = linearLayout({})
public inline fun Activity.linearLayout(init: _LinearLayout.() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.LINEAR_LAYOUT) { init() }
}

public inline fun ViewManager.radioGroup(): android.widget.RadioGroup = radioGroup({})
public inline fun ViewManager.radioGroup(init: _RadioGroup.() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RADIO_GROUP) { init() }
}

public inline fun Context.radioGroup(): android.widget.RadioGroup = radioGroup({})
public inline fun Context.radioGroup(init: _RadioGroup.() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RADIO_GROUP) { init() }
}

public inline fun Activity.radioGroup(): android.widget.RadioGroup = radioGroup({})
public inline fun Activity.radioGroup(init: _RadioGroup.() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RADIO_GROUP) { init() }
}

public inline fun ViewManager.relativeLayout(): android.widget.RelativeLayout = relativeLayout({})
public inline fun ViewManager.relativeLayout(init: _RelativeLayout.() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RELATIVE_LAYOUT) { init() }
}

public inline fun Context.relativeLayout(): android.widget.RelativeLayout = relativeLayout({})
public inline fun Context.relativeLayout(init: _RelativeLayout.() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RELATIVE_LAYOUT) { init() }
}

public inline fun Activity.relativeLayout(): android.widget.RelativeLayout = relativeLayout({})
public inline fun Activity.relativeLayout(init: _RelativeLayout.() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RELATIVE_LAYOUT) { init() }
}

public inline fun ViewManager.scrollView(): android.widget.ScrollView = scrollView({})
public inline fun ViewManager.scrollView(init: _ScrollView.() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.SCROLL_VIEW) { init() }
}

public inline fun Context.scrollView(): android.widget.ScrollView = scrollView({})
public inline fun Context.scrollView(init: _ScrollView.() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.SCROLL_VIEW) { init() }
}

public inline fun Activity.scrollView(): android.widget.ScrollView = scrollView({})
public inline fun Activity.scrollView(init: _ScrollView.() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.SCROLL_VIEW) { init() }
}

public inline fun ViewManager.tableLayout(): android.widget.TableLayout = tableLayout({})
public inline fun ViewManager.tableLayout(init: _TableLayout.() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_LAYOUT) { init() }
}

public inline fun Context.tableLayout(): android.widget.TableLayout = tableLayout({})
public inline fun Context.tableLayout(init: _TableLayout.() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_LAYOUT) { init() }
}

public inline fun Activity.tableLayout(): android.widget.TableLayout = tableLayout({})
public inline fun Activity.tableLayout(init: _TableLayout.() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_LAYOUT) { init() }
}

public inline fun ViewManager.tableRow(): android.widget.TableRow = tableRow({})
public inline fun ViewManager.tableRow(init: _TableRow.() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_ROW) { init() }
}

public inline fun Context.tableRow(): android.widget.TableRow = tableRow({})
public inline fun Context.tableRow(init: _TableRow.() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_ROW) { init() }
}

public inline fun Activity.tableRow(): android.widget.TableRow = tableRow({})
public inline fun Activity.tableRow(init: _TableRow.() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_ROW) { init() }
}

public inline fun ViewManager.textSwitcher(): android.widget.TextSwitcher = textSwitcher({})
public inline fun ViewManager.textSwitcher(init: _TextSwitcher.() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TEXT_SWITCHER) { init() }
}

public inline fun Context.textSwitcher(): android.widget.TextSwitcher = textSwitcher({})
public inline fun Context.textSwitcher(init: _TextSwitcher.() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TEXT_SWITCHER) { init() }
}

public inline fun Activity.textSwitcher(): android.widget.TextSwitcher = textSwitcher({})
public inline fun Activity.textSwitcher(init: _TextSwitcher.() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TEXT_SWITCHER) { init() }
}

public inline fun ViewManager.viewAnimator(): android.widget.ViewAnimator = viewAnimator({})
public inline fun ViewManager.viewAnimator(init: _ViewAnimator.() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_ANIMATOR) { init() }
}

public inline fun Context.viewAnimator(): android.widget.ViewAnimator = viewAnimator({})
public inline fun Context.viewAnimator(init: _ViewAnimator.() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_ANIMATOR) { init() }
}

public inline fun Activity.viewAnimator(): android.widget.ViewAnimator = viewAnimator({})
public inline fun Activity.viewAnimator(init: _ViewAnimator.() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_ANIMATOR) { init() }
}

public inline fun ViewManager.viewSwitcher(): android.widget.ViewSwitcher = viewSwitcher({})
public inline fun ViewManager.viewSwitcher(init: _ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_SWITCHER) { init() }
}

public inline fun Context.viewSwitcher(): android.widget.ViewSwitcher = viewSwitcher({})
public inline fun Context.viewSwitcher(init: _ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_SWITCHER) { init() }
}

public inline fun Activity.viewSwitcher(): android.widget.ViewSwitcher = viewSwitcher({})
public inline fun Activity.viewSwitcher(init: _ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_SWITCHER) { init() }
}