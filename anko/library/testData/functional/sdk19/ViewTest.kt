object `$$Anko$Factories$Sdk19View` {
    val MEDIA_ROUTE_BUTTON = { ctx: Context -> android.app.MediaRouteButton(ctx) }
    val GESTURE_OVERLAY_VIEW = { ctx: Context -> android.gesture.GestureOverlayView(ctx) }
    val EXTRACT_EDIT_TEXT = { ctx: Context -> android.inputmethodservice.ExtractEditText(ctx) }
    val G_L_SURFACE_VIEW = { ctx: Context -> android.opengl.GLSurfaceView(ctx) }
    val SURFACE_VIEW = { ctx: Context -> android.view.SurfaceView(ctx) }
    val TEXTURE_VIEW = { ctx: Context -> android.view.TextureView(ctx) }
    val VIEW = { ctx: Context -> android.view.View(ctx) }
    val VIEW_STUB = { ctx: Context -> android.view.ViewStub(ctx) }
    val ADAPTER_VIEW_FLIPPER = { ctx: Context -> android.widget.AdapterViewFlipper(ctx) }
    val ANALOG_CLOCK = { ctx: Context -> android.widget.AnalogClock(ctx) }
    val AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> android.widget.AutoCompleteTextView(ctx) }
    val BUTTON = { ctx: Context -> android.widget.Button(ctx) }
    val CALENDAR_VIEW = { ctx: Context -> android.widget.CalendarView(ctx) }
    val CHECK_BOX = { ctx: Context -> android.widget.CheckBox(ctx) }
    val CHECKED_TEXT_VIEW = { ctx: Context -> android.widget.CheckedTextView(ctx) }
    val CHRONOMETER = { ctx: Context -> android.widget.Chronometer(ctx) }
    val DATE_PICKER = { ctx: Context -> android.widget.DatePicker(ctx) }
    val DIALER_FILTER = { ctx: Context -> android.widget.DialerFilter(ctx) }
    val DIGITAL_CLOCK = { ctx: Context -> android.widget.DigitalClock(ctx) }
    val EDIT_TEXT = { ctx: Context -> android.widget.EditText(ctx) }
    val EXPANDABLE_LIST_VIEW = { ctx: Context -> android.widget.ExpandableListView(ctx) }
    val IMAGE_BUTTON = { ctx: Context -> android.widget.ImageButton(ctx) }
    val IMAGE_VIEW = { ctx: Context -> android.widget.ImageView(ctx) }
    val LIST_VIEW = { ctx: Context -> android.widget.ListView(ctx) }
    val MULTI_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> android.widget.MultiAutoCompleteTextView(ctx) }
    val NUMBER_PICKER = { ctx: Context -> android.widget.NumberPicker(ctx) }
    val PROGRESS_BAR = { ctx: Context -> android.widget.ProgressBar(ctx) }
    val QUICK_CONTACT_BADGE = { ctx: Context -> android.widget.QuickContactBadge(ctx) }
    val RADIO_BUTTON = { ctx: Context -> android.widget.RadioButton(ctx) }
    val RATING_BAR = { ctx: Context -> android.widget.RatingBar(ctx) }
    val SEARCH_VIEW = { ctx: Context -> android.widget.SearchView(ctx) }
    val SEEK_BAR = { ctx: Context -> android.widget.SeekBar(ctx) }
    val SLIDING_DRAWER = { ctx: Context -> android.widget.SlidingDrawer(ctx, null) }
    val SPACE = { ctx: Context -> android.widget.Space(ctx) }
    val SPINNER = { ctx: Context -> android.widget.Spinner(ctx) }
    val STACK_VIEW = { ctx: Context -> android.widget.StackView(ctx) }
    val SWITCH = { ctx: Context -> android.widget.Switch(ctx) }
    val TAB_HOST = { ctx: Context -> android.widget.TabHost(ctx) }
    val TAB_WIDGET = { ctx: Context -> android.widget.TabWidget(ctx) }
    val TEXT_CLOCK = { ctx: Context -> android.widget.TextClock(ctx) }
    val TEXT_VIEW = { ctx: Context -> android.widget.TextView(ctx) }
    val TIME_PICKER = { ctx: Context -> android.widget.TimePicker(ctx) }
    val TOGGLE_BUTTON = { ctx: Context -> android.widget.ToggleButton(ctx) }
    val TWO_LINE_LIST_ITEM = { ctx: Context -> android.widget.TwoLineListItem(ctx) }
    val VIDEO_VIEW = { ctx: Context -> android.widget.VideoView(ctx) }
    val VIEW_FLIPPER = { ctx: Context -> android.widget.ViewFlipper(ctx) }
    val ZOOM_BUTTON = { ctx: Context -> android.widget.ZoomButton(ctx) }
    val ZOOM_CONTROLS = { ctx: Context -> android.widget.ZoomControls(ctx) }
}

inline fun ViewManager.mediaRouteButton(theme: Int = 0): android.app.MediaRouteButton = mediaRouteButton(theme) {}
inline fun ViewManager.mediaRouteButton(theme: Int = 0, init: android.app.MediaRouteButton.() -> Unit): android.app.MediaRouteButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.MEDIA_ROUTE_BUTTON, theme) { init() }
}

inline fun ViewManager.gestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = gestureOverlayView(theme) {}
inline fun ViewManager.gestureOverlayView(theme: Int = 0, init: android.gesture.GestureOverlayView.() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk19View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

inline fun Context.gestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = gestureOverlayView(theme) {}
inline fun Context.gestureOverlayView(theme: Int = 0, init: android.gesture.GestureOverlayView.() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk19View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

inline fun Activity.gestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = gestureOverlayView(theme) {}
inline fun Activity.gestureOverlayView(theme: Int = 0, init: android.gesture.GestureOverlayView.() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk19View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

inline fun ViewManager.extractEditText(theme: Int = 0): android.inputmethodservice.ExtractEditText = extractEditText(theme) {}
inline fun ViewManager.extractEditText(theme: Int = 0, init: android.inputmethodservice.ExtractEditText.() -> Unit): android.inputmethodservice.ExtractEditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXTRACT_EDIT_TEXT, theme) { init() }
}

inline fun ViewManager.gLSurfaceView(theme: Int = 0): android.opengl.GLSurfaceView = gLSurfaceView(theme) {}
inline fun ViewManager.gLSurfaceView(theme: Int = 0, init: android.opengl.GLSurfaceView.() -> Unit): android.opengl.GLSurfaceView {
    return ankoView(`$$Anko$Factories$Sdk19View`.G_L_SURFACE_VIEW, theme) { init() }
}

inline fun ViewManager.surfaceView(theme: Int = 0): android.view.SurfaceView = surfaceView(theme) {}
inline fun ViewManager.surfaceView(theme: Int = 0, init: android.view.SurfaceView.() -> Unit): android.view.SurfaceView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SURFACE_VIEW, theme) { init() }
}

inline fun ViewManager.textureView(theme: Int = 0): android.view.TextureView = textureView(theme) {}
inline fun ViewManager.textureView(theme: Int = 0, init: android.view.TextureView.() -> Unit): android.view.TextureView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXTURE_VIEW, theme) { init() }
}

inline fun ViewManager.view(theme: Int = 0): android.view.View = view(theme) {}
inline fun ViewManager.view(theme: Int = 0, init: android.view.View.() -> Unit): android.view.View {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW, theme) { init() }
}

inline fun ViewManager.viewStub(theme: Int = 0): android.view.ViewStub = viewStub(theme) {}
inline fun ViewManager.viewStub(theme: Int = 0, init: android.view.ViewStub.() -> Unit): android.view.ViewStub {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_STUB, theme) { init() }
}

inline fun ViewManager.adapterViewFlipper(theme: Int = 0): android.widget.AdapterViewFlipper = adapterViewFlipper(theme) {}
inline fun ViewManager.adapterViewFlipper(theme: Int = 0, init: android.widget.AdapterViewFlipper.() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

inline fun Context.adapterViewFlipper(theme: Int = 0): android.widget.AdapterViewFlipper = adapterViewFlipper(theme) {}
inline fun Context.adapterViewFlipper(theme: Int = 0, init: android.widget.AdapterViewFlipper.() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

inline fun Activity.adapterViewFlipper(theme: Int = 0): android.widget.AdapterViewFlipper = adapterViewFlipper(theme) {}
inline fun Activity.adapterViewFlipper(theme: Int = 0, init: android.widget.AdapterViewFlipper.() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

inline fun ViewManager.analogClock(theme: Int = 0): android.widget.AnalogClock = analogClock(theme) {}
inline fun ViewManager.analogClock(theme: Int = 0, init: android.widget.AnalogClock.() -> Unit): android.widget.AnalogClock {
    return ankoView(`$$Anko$Factories$Sdk19View`.ANALOG_CLOCK, theme) { init() }
}

inline fun ViewManager.autoCompleteTextView(theme: Int = 0): android.widget.AutoCompleteTextView = autoCompleteTextView(theme) {}
inline fun ViewManager.autoCompleteTextView(theme: Int = 0, init: android.widget.AutoCompleteTextView.() -> Unit): android.widget.AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.button(theme: Int = 0): android.widget.Button = button(theme) {}
inline fun ViewManager.button(theme: Int = 0, init: android.widget.Button.() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON, theme) { init() }
}

inline fun ViewManager.button(text: CharSequence?, theme: Int = 0): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON, theme) {
        setText(text)
    }
}
inline fun ViewManager.button(text: CharSequence?, theme: Int = 0, init: android.widget.Button.() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.button(text: Int, theme: Int = 0): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON, theme) {
        setText(text)
    }
}
inline fun ViewManager.button(text: Int, theme: Int = 0, init: android.widget.Button.() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk19View`.BUTTON, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.calendarView(theme: Int = 0): android.widget.CalendarView = calendarView(theme) {}
inline fun ViewManager.calendarView(theme: Int = 0, init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CALENDAR_VIEW, theme) { init() }
}

inline fun Context.calendarView(theme: Int = 0): android.widget.CalendarView = calendarView(theme) {}
inline fun Context.calendarView(theme: Int = 0, init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CALENDAR_VIEW, theme) { init() }
}

inline fun Activity.calendarView(theme: Int = 0): android.widget.CalendarView = calendarView(theme) {}
inline fun Activity.calendarView(theme: Int = 0, init: android.widget.CalendarView.() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CALENDAR_VIEW, theme) { init() }
}

inline fun ViewManager.checkBox(theme: Int = 0): android.widget.CheckBox = checkBox(theme) {}
inline fun ViewManager.checkBox(theme: Int = 0, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) { init() }
}

inline fun ViewManager.checkBox(text: CharSequence?, theme: Int = 0): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        setText(text)
    }
}
inline fun ViewManager.checkBox(text: CharSequence?, theme: Int = 0, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.checkBox(text: Int, theme: Int = 0): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        setText(text)
    }
}
inline fun ViewManager.checkBox(text: Int, theme: Int = 0, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, theme: Int = 0): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, theme: Int = 0, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.checkBox(text: Int, checked: Boolean, theme: Int = 0): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.checkBox(text: Int, checked: Boolean, theme: Int = 0, init: android.widget.CheckBox.() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.checkedTextView(theme: Int = 0): android.widget.CheckedTextView = checkedTextView(theme) {}
inline fun ViewManager.checkedTextView(theme: Int = 0, init: android.widget.CheckedTextView.() -> Unit): android.widget.CheckedTextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHECKED_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.chronometer(theme: Int = 0): android.widget.Chronometer = chronometer(theme) {}
inline fun ViewManager.chronometer(theme: Int = 0, init: android.widget.Chronometer.() -> Unit): android.widget.Chronometer {
    return ankoView(`$$Anko$Factories$Sdk19View`.CHRONOMETER, theme) { init() }
}

inline fun ViewManager.datePicker(theme: Int = 0): android.widget.DatePicker = datePicker(theme) {}
inline fun ViewManager.datePicker(theme: Int = 0, init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.DATE_PICKER, theme) { init() }
}

inline fun Context.datePicker(theme: Int = 0): android.widget.DatePicker = datePicker(theme) {}
inline fun Context.datePicker(theme: Int = 0, init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.DATE_PICKER, theme) { init() }
}

inline fun Activity.datePicker(theme: Int = 0): android.widget.DatePicker = datePicker(theme) {}
inline fun Activity.datePicker(theme: Int = 0, init: android.widget.DatePicker.() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.DATE_PICKER, theme) { init() }
}

inline fun ViewManager.dialerFilter(theme: Int = 0): android.widget.DialerFilter = dialerFilter(theme) {}
inline fun ViewManager.dialerFilter(theme: Int = 0, init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIALER_FILTER, theme) { init() }
}

inline fun Context.dialerFilter(theme: Int = 0): android.widget.DialerFilter = dialerFilter(theme) {}
inline fun Context.dialerFilter(theme: Int = 0, init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIALER_FILTER, theme) { init() }
}

inline fun Activity.dialerFilter(theme: Int = 0): android.widget.DialerFilter = dialerFilter(theme) {}
inline fun Activity.dialerFilter(theme: Int = 0, init: android.widget.DialerFilter.() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIALER_FILTER, theme) { init() }
}

inline fun ViewManager.digitalClock(theme: Int = 0): android.widget.DigitalClock = digitalClock(theme) {}
inline fun ViewManager.digitalClock(theme: Int = 0, init: android.widget.DigitalClock.() -> Unit): android.widget.DigitalClock {
    return ankoView(`$$Anko$Factories$Sdk19View`.DIGITAL_CLOCK, theme) { init() }
}

inline fun ViewManager.editText(theme: Int = 0): android.widget.EditText = editText(theme) {}
inline fun ViewManager.editText(theme: Int = 0, init: android.widget.EditText.() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT, theme) { init() }
}

inline fun ViewManager.editText(text: CharSequence?, theme: Int = 0): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT, theme) {
        setText(text)
    }
}
inline fun ViewManager.editText(text: CharSequence?, theme: Int = 0, init: android.widget.EditText.() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.editText(text: Int, theme: Int = 0): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT, theme) {
        setText(text)
    }
}
inline fun ViewManager.editText(text: Int, theme: Int = 0, init: android.widget.EditText.() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk19View`.EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.expandableListView(theme: Int = 0): android.widget.ExpandableListView = expandableListView(theme) {}
inline fun ViewManager.expandableListView(theme: Int = 0, init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

inline fun Context.expandableListView(theme: Int = 0): android.widget.ExpandableListView = expandableListView(theme) {}
inline fun Context.expandableListView(theme: Int = 0, init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

inline fun Activity.expandableListView(theme: Int = 0): android.widget.ExpandableListView = expandableListView(theme) {}
inline fun Activity.expandableListView(theme: Int = 0, init: android.widget.ExpandableListView.() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

inline fun ViewManager.imageButton(theme: Int = 0): android.widget.ImageButton = imageButton(theme) {}
inline fun ViewManager.imageButton(theme: Int = 0, init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON, theme) { init() }
}

inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON, theme) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0, init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.imageButton(imageResource: Int, theme: Int = 0): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON, theme) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.imageButton(imageResource: Int, theme: Int = 0, init: android.widget.ImageButton.() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_BUTTON, theme) {
        init()
        setImageResource(imageResource)
    }
}

inline fun ViewManager.imageView(theme: Int = 0): android.widget.ImageView = imageView(theme) {}
inline fun ViewManager.imageView(theme: Int = 0, init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW, theme) { init() }
}

inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW, theme) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int = 0, init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.imageView(imageResource: Int, theme: Int = 0): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW, theme) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.imageView(imageResource: Int, theme: Int = 0, init: android.widget.ImageView.() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk19View`.IMAGE_VIEW, theme) {
        init()
        setImageResource(imageResource)
    }
}

inline fun ViewManager.listView(theme: Int = 0): android.widget.ListView = listView(theme) {}
inline fun ViewManager.listView(theme: Int = 0, init: android.widget.ListView.() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.LIST_VIEW, theme) { init() }
}

inline fun Context.listView(theme: Int = 0): android.widget.ListView = listView(theme) {}
inline fun Context.listView(theme: Int = 0, init: android.widget.ListView.() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.LIST_VIEW, theme) { init() }
}

inline fun Activity.listView(theme: Int = 0): android.widget.ListView = listView(theme) {}
inline fun Activity.listView(theme: Int = 0, init: android.widget.ListView.() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk19View`.LIST_VIEW, theme) { init() }
}

inline fun ViewManager.multiAutoCompleteTextView(theme: Int = 0): android.widget.MultiAutoCompleteTextView = multiAutoCompleteTextView(theme) {}
inline fun ViewManager.multiAutoCompleteTextView(theme: Int = 0, init: android.widget.MultiAutoCompleteTextView.() -> Unit): android.widget.MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.MULTI_AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.numberPicker(theme: Int = 0): android.widget.NumberPicker = numberPicker(theme) {}
inline fun ViewManager.numberPicker(theme: Int = 0, init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.NUMBER_PICKER, theme) { init() }
}

inline fun Context.numberPicker(theme: Int = 0): android.widget.NumberPicker = numberPicker(theme) {}
inline fun Context.numberPicker(theme: Int = 0, init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.NUMBER_PICKER, theme) { init() }
}

inline fun Activity.numberPicker(theme: Int = 0): android.widget.NumberPicker = numberPicker(theme) {}
inline fun Activity.numberPicker(theme: Int = 0, init: android.widget.NumberPicker.() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.NUMBER_PICKER, theme) { init() }
}

inline fun ViewManager.progressBar(theme: Int = 0): android.widget.ProgressBar = progressBar(theme) {}
inline fun ViewManager.progressBar(theme: Int = 0, init: android.widget.ProgressBar.() -> Unit): android.widget.ProgressBar {
    return ankoView(`$$Anko$Factories$Sdk19View`.PROGRESS_BAR, theme) { init() }
}

inline fun ViewManager.quickContactBadge(theme: Int = 0): android.widget.QuickContactBadge = quickContactBadge(theme) {}
inline fun ViewManager.quickContactBadge(theme: Int = 0, init: android.widget.QuickContactBadge.() -> Unit): android.widget.QuickContactBadge {
    return ankoView(`$$Anko$Factories$Sdk19View`.QUICK_CONTACT_BADGE, theme) { init() }
}

inline fun ViewManager.radioButton(theme: Int = 0): android.widget.RadioButton = radioButton(theme) {}
inline fun ViewManager.radioButton(theme: Int = 0, init: android.widget.RadioButton.() -> Unit): android.widget.RadioButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.RADIO_BUTTON, theme) { init() }
}

inline fun ViewManager.ratingBar(theme: Int = 0): android.widget.RatingBar = ratingBar(theme) {}
inline fun ViewManager.ratingBar(theme: Int = 0, init: android.widget.RatingBar.() -> Unit): android.widget.RatingBar {
    return ankoView(`$$Anko$Factories$Sdk19View`.RATING_BAR, theme) { init() }
}

inline fun ViewManager.searchView(theme: Int = 0): android.widget.SearchView = searchView(theme) {}
inline fun ViewManager.searchView(theme: Int = 0, init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEARCH_VIEW, theme) { init() }
}

inline fun Context.searchView(theme: Int = 0): android.widget.SearchView = searchView(theme) {}
inline fun Context.searchView(theme: Int = 0, init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEARCH_VIEW, theme) { init() }
}

inline fun Activity.searchView(theme: Int = 0): android.widget.SearchView = searchView(theme) {}
inline fun Activity.searchView(theme: Int = 0, init: android.widget.SearchView.() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEARCH_VIEW, theme) { init() }
}

inline fun ViewManager.seekBar(theme: Int = 0): android.widget.SeekBar = seekBar(theme) {}
inline fun ViewManager.seekBar(theme: Int = 0, init: android.widget.SeekBar.() -> Unit): android.widget.SeekBar {
    return ankoView(`$$Anko$Factories$Sdk19View`.SEEK_BAR, theme) { init() }
}

inline fun ViewManager.slidingDrawer(theme: Int = 0): android.widget.SlidingDrawer = slidingDrawer(theme) {}
inline fun ViewManager.slidingDrawer(theme: Int = 0, init: android.widget.SlidingDrawer.() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk19View`.SLIDING_DRAWER, theme) { init() }
}

inline fun Context.slidingDrawer(theme: Int = 0): android.widget.SlidingDrawer = slidingDrawer(theme) {}
inline fun Context.slidingDrawer(theme: Int = 0, init: android.widget.SlidingDrawer.() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk19View`.SLIDING_DRAWER, theme) { init() }
}

inline fun Activity.slidingDrawer(theme: Int = 0): android.widget.SlidingDrawer = slidingDrawer(theme) {}
inline fun Activity.slidingDrawer(theme: Int = 0, init: android.widget.SlidingDrawer.() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk19View`.SLIDING_DRAWER, theme) { init() }
}

inline fun ViewManager.space(theme: Int = 0): android.widget.Space = space(theme) {}
inline fun ViewManager.space(theme: Int = 0, init: android.widget.Space.() -> Unit): android.widget.Space {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPACE, theme) { init() }
}

inline fun ViewManager.spinner(theme: Int = 0): android.widget.Spinner = spinner(theme) {}
inline fun ViewManager.spinner(theme: Int = 0, init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPINNER, theme) { init() }
}

inline fun Context.spinner(theme: Int = 0): android.widget.Spinner = spinner(theme) {}
inline fun Context.spinner(theme: Int = 0, init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPINNER, theme) { init() }
}

inline fun Activity.spinner(theme: Int = 0): android.widget.Spinner = spinner(theme) {}
inline fun Activity.spinner(theme: Int = 0, init: android.widget.Spinner.() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk19View`.SPINNER, theme) { init() }
}

inline fun ViewManager.stackView(theme: Int = 0): android.widget.StackView = stackView(theme) {}
inline fun ViewManager.stackView(theme: Int = 0, init: android.widget.StackView.() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk19View`.STACK_VIEW, theme) { init() }
}

inline fun Context.stackView(theme: Int = 0): android.widget.StackView = stackView(theme) {}
inline fun Context.stackView(theme: Int = 0, init: android.widget.StackView.() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk19View`.STACK_VIEW, theme) { init() }
}

inline fun Activity.stackView(theme: Int = 0): android.widget.StackView = stackView(theme) {}
inline fun Activity.stackView(theme: Int = 0, init: android.widget.StackView.() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk19View`.STACK_VIEW, theme) { init() }
}

inline fun ViewManager.switch(theme: Int = 0): android.widget.Switch = switch(theme) {}
inline fun ViewManager.switch(theme: Int = 0, init: android.widget.Switch.() -> Unit): android.widget.Switch {
    return ankoView(`$$Anko$Factories$Sdk19View`.SWITCH, theme) { init() }
}

inline fun ViewManager.tabHost(theme: Int = 0): android.widget.TabHost = tabHost(theme) {}
inline fun ViewManager.tabHost(theme: Int = 0, init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_HOST, theme) { init() }
}

inline fun Context.tabHost(theme: Int = 0): android.widget.TabHost = tabHost(theme) {}
inline fun Context.tabHost(theme: Int = 0, init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_HOST, theme) { init() }
}

inline fun Activity.tabHost(theme: Int = 0): android.widget.TabHost = tabHost(theme) {}
inline fun Activity.tabHost(theme: Int = 0, init: android.widget.TabHost.() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_HOST, theme) { init() }
}

inline fun ViewManager.tabWidget(theme: Int = 0): android.widget.TabWidget = tabWidget(theme) {}
inline fun ViewManager.tabWidget(theme: Int = 0, init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_WIDGET, theme) { init() }
}

inline fun Context.tabWidget(theme: Int = 0): android.widget.TabWidget = tabWidget(theme) {}
inline fun Context.tabWidget(theme: Int = 0, init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_WIDGET, theme) { init() }
}

inline fun Activity.tabWidget(theme: Int = 0): android.widget.TabWidget = tabWidget(theme) {}
inline fun Activity.tabWidget(theme: Int = 0, init: android.widget.TabWidget.() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk19View`.TAB_WIDGET, theme) { init() }
}

inline fun ViewManager.textClock(theme: Int = 0): android.widget.TextClock = textClock(theme) {}
inline fun ViewManager.textClock(theme: Int = 0, init: android.widget.TextClock.() -> Unit): android.widget.TextClock {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_CLOCK, theme) { init() }
}

inline fun ViewManager.textView(theme: Int = 0): android.widget.TextView = textView(theme) {}
inline fun ViewManager.textView(theme: Int = 0, init: android.widget.TextView.() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.textView(text: CharSequence?, theme: Int = 0): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW, theme) {
        setText(text)
    }
}
inline fun ViewManager.textView(text: CharSequence?, theme: Int = 0, init: android.widget.TextView.() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.textView(text: Int, theme: Int = 0): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW, theme) {
        setText(text)
    }
}
inline fun ViewManager.textView(text: Int, theme: Int = 0, init: android.widget.TextView.() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk19View`.TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.timePicker(theme: Int = 0): android.widget.TimePicker = timePicker(theme) {}
inline fun ViewManager.timePicker(theme: Int = 0, init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.TIME_PICKER, theme) { init() }
}

inline fun Context.timePicker(theme: Int = 0): android.widget.TimePicker = timePicker(theme) {}
inline fun Context.timePicker(theme: Int = 0, init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.TIME_PICKER, theme) { init() }
}

inline fun Activity.timePicker(theme: Int = 0): android.widget.TimePicker = timePicker(theme) {}
inline fun Activity.timePicker(theme: Int = 0, init: android.widget.TimePicker.() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk19View`.TIME_PICKER, theme) { init() }
}

inline fun ViewManager.toggleButton(theme: Int = 0): android.widget.ToggleButton = toggleButton(theme) {}
inline fun ViewManager.toggleButton(theme: Int = 0, init: android.widget.ToggleButton.() -> Unit): android.widget.ToggleButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.TOGGLE_BUTTON, theme) { init() }
}

inline fun ViewManager.twoLineListItem(theme: Int = 0): android.widget.TwoLineListItem = twoLineListItem(theme) {}
inline fun ViewManager.twoLineListItem(theme: Int = 0, init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk19View`.TWO_LINE_LIST_ITEM, theme) { init() }
}

inline fun Context.twoLineListItem(theme: Int = 0): android.widget.TwoLineListItem = twoLineListItem(theme) {}
inline fun Context.twoLineListItem(theme: Int = 0, init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk19View`.TWO_LINE_LIST_ITEM, theme) { init() }
}

inline fun Activity.twoLineListItem(theme: Int = 0): android.widget.TwoLineListItem = twoLineListItem(theme) {}
inline fun Activity.twoLineListItem(theme: Int = 0, init: android.widget.TwoLineListItem.() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk19View`.TWO_LINE_LIST_ITEM, theme) { init() }
}

inline fun ViewManager.videoView(theme: Int = 0): android.widget.VideoView = videoView(theme) {}
inline fun ViewManager.videoView(theme: Int = 0, init: android.widget.VideoView.() -> Unit): android.widget.VideoView {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIDEO_VIEW, theme) { init() }
}

inline fun ViewManager.viewFlipper(theme: Int = 0): android.widget.ViewFlipper = viewFlipper(theme) {}
inline fun ViewManager.viewFlipper(theme: Int = 0, init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_FLIPPER, theme) { init() }
}

inline fun Context.viewFlipper(theme: Int = 0): android.widget.ViewFlipper = viewFlipper(theme) {}
inline fun Context.viewFlipper(theme: Int = 0, init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_FLIPPER, theme) { init() }
}

inline fun Activity.viewFlipper(theme: Int = 0): android.widget.ViewFlipper = viewFlipper(theme) {}
inline fun Activity.viewFlipper(theme: Int = 0, init: android.widget.ViewFlipper.() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk19View`.VIEW_FLIPPER, theme) { init() }
}

inline fun ViewManager.zoomButton(theme: Int = 0): android.widget.ZoomButton = zoomButton(theme) {}
inline fun ViewManager.zoomButton(theme: Int = 0, init: android.widget.ZoomButton.() -> Unit): android.widget.ZoomButton {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_BUTTON, theme) { init() }
}

inline fun ViewManager.zoomControls(theme: Int = 0): android.widget.ZoomControls = zoomControls(theme) {}
inline fun ViewManager.zoomControls(theme: Int = 0, init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_CONTROLS, theme) { init() }
}

inline fun Context.zoomControls(theme: Int = 0): android.widget.ZoomControls = zoomControls(theme) {}
inline fun Context.zoomControls(theme: Int = 0, init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_CONTROLS, theme) { init() }
}

inline fun Activity.zoomControls(theme: Int = 0): android.widget.ZoomControls = zoomControls(theme) {}
inline fun Activity.zoomControls(theme: Int = 0, init: android.widget.ZoomControls.() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk19View`.ZOOM_CONTROLS, theme) { init() }
}

object `$$Anko$Factories$Sdk19ViewGroup` {
    val APP_WIDGET_HOST_VIEW = { ctx: Context -> _AppWidgetHostView(ctx) }
    val WEB_VIEW = { ctx: Context -> _WebView(ctx) }
    val ABSOLUTE_LAYOUT = { ctx: Context -> _AbsoluteLayout(ctx) }
    val FRAME_LAYOUT = { ctx: Context -> _FrameLayout(ctx) }
    val GALLERY = { ctx: Context -> _Gallery(ctx) }
    val GRID_LAYOUT = { ctx: Context -> _GridLayout(ctx) }
    val GRID_VIEW = { ctx: Context -> _GridView(ctx) }
    val HORIZONTAL_SCROLL_VIEW = { ctx: Context -> _HorizontalScrollView(ctx) }
    val IMAGE_SWITCHER = { ctx: Context -> _ImageSwitcher(ctx) }
    val LINEAR_LAYOUT = { ctx: Context -> _LinearLayout(ctx) }
    val RADIO_GROUP = { ctx: Context -> _RadioGroup(ctx) }
    val RELATIVE_LAYOUT = { ctx: Context -> _RelativeLayout(ctx) }
    val SCROLL_VIEW = { ctx: Context -> _ScrollView(ctx) }
    val TABLE_LAYOUT = { ctx: Context -> _TableLayout(ctx) }
    val TABLE_ROW = { ctx: Context -> _TableRow(ctx) }
    val TEXT_SWITCHER = { ctx: Context -> _TextSwitcher(ctx) }
    val VIEW_ANIMATOR = { ctx: Context -> _ViewAnimator(ctx) }
    val VIEW_SWITCHER = { ctx: Context -> _ViewSwitcher(ctx) }
}

inline fun ViewManager.appWidgetHostView(theme: Int = 0): android.appwidget.AppWidgetHostView = appWidgetHostView(theme) {}
inline fun ViewManager.appWidgetHostView(theme: Int = 0, init: _AppWidgetHostView.() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.APP_WIDGET_HOST_VIEW, theme) { init() }
}

inline fun Context.appWidgetHostView(theme: Int = 0): android.appwidget.AppWidgetHostView = appWidgetHostView(theme) {}
inline fun Context.appWidgetHostView(theme: Int = 0, init: _AppWidgetHostView.() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.APP_WIDGET_HOST_VIEW, theme) { init() }
}

inline fun Activity.appWidgetHostView(theme: Int = 0): android.appwidget.AppWidgetHostView = appWidgetHostView(theme) {}
inline fun Activity.appWidgetHostView(theme: Int = 0, init: _AppWidgetHostView.() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.APP_WIDGET_HOST_VIEW, theme) { init() }
}

inline fun ViewManager.webView(theme: Int = 0): android.webkit.WebView = webView(theme) {}
inline fun ViewManager.webView(theme: Int = 0, init: _WebView.() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.WEB_VIEW, theme) { init() }
}

inline fun Context.webView(theme: Int = 0): android.webkit.WebView = webView(theme) {}
inline fun Context.webView(theme: Int = 0, init: _WebView.() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.WEB_VIEW, theme) { init() }
}

inline fun Activity.webView(theme: Int = 0): android.webkit.WebView = webView(theme) {}
inline fun Activity.webView(theme: Int = 0, init: _WebView.() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.WEB_VIEW, theme) { init() }
}

inline fun ViewManager.absoluteLayout(theme: Int = 0): android.widget.AbsoluteLayout = absoluteLayout(theme) {}
inline fun ViewManager.absoluteLayout(theme: Int = 0, init: _AbsoluteLayout.() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.ABSOLUTE_LAYOUT, theme) { init() }
}

inline fun Context.absoluteLayout(theme: Int = 0): android.widget.AbsoluteLayout = absoluteLayout(theme) {}
inline fun Context.absoluteLayout(theme: Int = 0, init: _AbsoluteLayout.() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.ABSOLUTE_LAYOUT, theme) { init() }
}

inline fun Activity.absoluteLayout(theme: Int = 0): android.widget.AbsoluteLayout = absoluteLayout(theme) {}
inline fun Activity.absoluteLayout(theme: Int = 0, init: _AbsoluteLayout.() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.ABSOLUTE_LAYOUT, theme) { init() }
}

inline fun ViewManager.frameLayout(theme: Int = 0): android.widget.FrameLayout = frameLayout(theme) {}
inline fun ViewManager.frameLayout(theme: Int = 0, init: _FrameLayout.() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

inline fun Context.frameLayout(theme: Int = 0): android.widget.FrameLayout = frameLayout(theme) {}
inline fun Context.frameLayout(theme: Int = 0, init: _FrameLayout.() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.frameLayout(theme: Int = 0): android.widget.FrameLayout = frameLayout(theme) {}
inline fun Activity.frameLayout(theme: Int = 0, init: _FrameLayout.() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.gallery(theme: Int = 0): android.widget.Gallery = gallery(theme) {}
inline fun ViewManager.gallery(theme: Int = 0, init: _Gallery.() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GALLERY, theme) { init() }
}

inline fun Context.gallery(theme: Int = 0): android.widget.Gallery = gallery(theme) {}
inline fun Context.gallery(theme: Int = 0, init: _Gallery.() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GALLERY, theme) { init() }
}

inline fun Activity.gallery(theme: Int = 0): android.widget.Gallery = gallery(theme) {}
inline fun Activity.gallery(theme: Int = 0, init: _Gallery.() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GALLERY, theme) { init() }
}

inline fun ViewManager.gridLayout(theme: Int = 0): android.widget.GridLayout = gridLayout(theme) {}
inline fun ViewManager.gridLayout(theme: Int = 0, init: _GridLayout.() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun Context.gridLayout(theme: Int = 0): android.widget.GridLayout = gridLayout(theme) {}
inline fun Context.gridLayout(theme: Int = 0, init: _GridLayout.() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun Activity.gridLayout(theme: Int = 0): android.widget.GridLayout = gridLayout(theme) {}
inline fun Activity.gridLayout(theme: Int = 0, init: _GridLayout.() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun ViewManager.gridView(theme: Int = 0): android.widget.GridView = gridView(theme) {}
inline fun ViewManager.gridView(theme: Int = 0, init: _GridView.() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_VIEW, theme) { init() }
}

inline fun Context.gridView(theme: Int = 0): android.widget.GridView = gridView(theme) {}
inline fun Context.gridView(theme: Int = 0, init: _GridView.() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_VIEW, theme) { init() }
}

inline fun Activity.gridView(theme: Int = 0): android.widget.GridView = gridView(theme) {}
inline fun Activity.gridView(theme: Int = 0, init: _GridView.() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.GRID_VIEW, theme) { init() }
}

inline fun ViewManager.horizontalScrollView(theme: Int = 0): android.widget.HorizontalScrollView = horizontalScrollView(theme) {}
inline fun ViewManager.horizontalScrollView(theme: Int = 0, init: _HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

inline fun Context.horizontalScrollView(theme: Int = 0): android.widget.HorizontalScrollView = horizontalScrollView(theme) {}
inline fun Context.horizontalScrollView(theme: Int = 0, init: _HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

inline fun Activity.horizontalScrollView(theme: Int = 0): android.widget.HorizontalScrollView = horizontalScrollView(theme) {}
inline fun Activity.horizontalScrollView(theme: Int = 0, init: _HorizontalScrollView.() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

inline fun ViewManager.imageSwitcher(theme: Int = 0): android.widget.ImageSwitcher = imageSwitcher(theme) {}
inline fun ViewManager.imageSwitcher(theme: Int = 0, init: _ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

inline fun Context.imageSwitcher(theme: Int = 0): android.widget.ImageSwitcher = imageSwitcher(theme) {}
inline fun Context.imageSwitcher(theme: Int = 0, init: _ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

inline fun Activity.imageSwitcher(theme: Int = 0): android.widget.ImageSwitcher = imageSwitcher(theme) {}
inline fun Activity.imageSwitcher(theme: Int = 0, init: _ImageSwitcher.() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

inline fun ViewManager.linearLayout(theme: Int = 0): android.widget.LinearLayout = linearLayout(theme) {}
inline fun ViewManager.linearLayout(theme: Int = 0, init: _LinearLayout.() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

inline fun Context.linearLayout(theme: Int = 0): android.widget.LinearLayout = linearLayout(theme) {}
inline fun Context.linearLayout(theme: Int = 0, init: _LinearLayout.() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

inline fun Activity.linearLayout(theme: Int = 0): android.widget.LinearLayout = linearLayout(theme) {}
inline fun Activity.linearLayout(theme: Int = 0, init: _LinearLayout.() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.radioGroup(theme: Int = 0): android.widget.RadioGroup = radioGroup(theme) {}
inline fun ViewManager.radioGroup(theme: Int = 0, init: _RadioGroup.() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RADIO_GROUP, theme) { init() }
}

inline fun Context.radioGroup(theme: Int = 0): android.widget.RadioGroup = radioGroup(theme) {}
inline fun Context.radioGroup(theme: Int = 0, init: _RadioGroup.() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RADIO_GROUP, theme) { init() }
}

inline fun Activity.radioGroup(theme: Int = 0): android.widget.RadioGroup = radioGroup(theme) {}
inline fun Activity.radioGroup(theme: Int = 0, init: _RadioGroup.() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RADIO_GROUP, theme) { init() }
}

inline fun ViewManager.relativeLayout(theme: Int = 0): android.widget.RelativeLayout = relativeLayout(theme) {}
inline fun ViewManager.relativeLayout(theme: Int = 0, init: _RelativeLayout.() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

inline fun Context.relativeLayout(theme: Int = 0): android.widget.RelativeLayout = relativeLayout(theme) {}
inline fun Context.relativeLayout(theme: Int = 0, init: _RelativeLayout.() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

inline fun Activity.relativeLayout(theme: Int = 0): android.widget.RelativeLayout = relativeLayout(theme) {}
inline fun Activity.relativeLayout(theme: Int = 0, init: _RelativeLayout.() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

inline fun ViewManager.scrollView(theme: Int = 0): android.widget.ScrollView = scrollView(theme) {}
inline fun ViewManager.scrollView(theme: Int = 0, init: _ScrollView.() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.SCROLL_VIEW, theme) { init() }
}

inline fun Context.scrollView(theme: Int = 0): android.widget.ScrollView = scrollView(theme) {}
inline fun Context.scrollView(theme: Int = 0, init: _ScrollView.() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.SCROLL_VIEW, theme) { init() }
}

inline fun Activity.scrollView(theme: Int = 0): android.widget.ScrollView = scrollView(theme) {}
inline fun Activity.scrollView(theme: Int = 0, init: _ScrollView.() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.SCROLL_VIEW, theme) { init() }
}

inline fun ViewManager.tableLayout(theme: Int = 0): android.widget.TableLayout = tableLayout(theme) {}
inline fun ViewManager.tableLayout(theme: Int = 0, init: _TableLayout.() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

inline fun Context.tableLayout(theme: Int = 0): android.widget.TableLayout = tableLayout(theme) {}
inline fun Context.tableLayout(theme: Int = 0, init: _TableLayout.() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

inline fun Activity.tableLayout(theme: Int = 0): android.widget.TableLayout = tableLayout(theme) {}
inline fun Activity.tableLayout(theme: Int = 0, init: _TableLayout.() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

inline fun ViewManager.tableRow(theme: Int = 0): android.widget.TableRow = tableRow(theme) {}
inline fun ViewManager.tableRow(theme: Int = 0, init: _TableRow.() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_ROW, theme) { init() }
}

inline fun Context.tableRow(theme: Int = 0): android.widget.TableRow = tableRow(theme) {}
inline fun Context.tableRow(theme: Int = 0, init: _TableRow.() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_ROW, theme) { init() }
}

inline fun Activity.tableRow(theme: Int = 0): android.widget.TableRow = tableRow(theme) {}
inline fun Activity.tableRow(theme: Int = 0, init: _TableRow.() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TABLE_ROW, theme) { init() }
}

inline fun ViewManager.textSwitcher(theme: Int = 0): android.widget.TextSwitcher = textSwitcher(theme) {}
inline fun ViewManager.textSwitcher(theme: Int = 0, init: _TextSwitcher.() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

inline fun Context.textSwitcher(theme: Int = 0): android.widget.TextSwitcher = textSwitcher(theme) {}
inline fun Context.textSwitcher(theme: Int = 0, init: _TextSwitcher.() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

inline fun Activity.textSwitcher(theme: Int = 0): android.widget.TextSwitcher = textSwitcher(theme) {}
inline fun Activity.textSwitcher(theme: Int = 0, init: _TextSwitcher.() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

inline fun ViewManager.viewAnimator(theme: Int = 0): android.widget.ViewAnimator = viewAnimator(theme) {}
inline fun ViewManager.viewAnimator(theme: Int = 0, init: _ViewAnimator.() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

inline fun Context.viewAnimator(theme: Int = 0): android.widget.ViewAnimator = viewAnimator(theme) {}
inline fun Context.viewAnimator(theme: Int = 0, init: _ViewAnimator.() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

inline fun Activity.viewAnimator(theme: Int = 0): android.widget.ViewAnimator = viewAnimator(theme) {}
inline fun Activity.viewAnimator(theme: Int = 0, init: _ViewAnimator.() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

inline fun ViewManager.viewSwitcher(theme: Int = 0): android.widget.ViewSwitcher = viewSwitcher(theme) {}
inline fun ViewManager.viewSwitcher(theme: Int = 0, init: _ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

inline fun Context.viewSwitcher(theme: Int = 0): android.widget.ViewSwitcher = viewSwitcher(theme) {}
inline fun Context.viewSwitcher(theme: Int = 0, init: _ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

inline fun Activity.viewSwitcher(theme: Int = 0): android.widget.ViewSwitcher = viewSwitcher(theme) {}
inline fun Activity.viewSwitcher(theme: Int = 0, init: _ViewSwitcher.() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk19ViewGroup`.VIEW_SWITCHER, theme) { init() }
}