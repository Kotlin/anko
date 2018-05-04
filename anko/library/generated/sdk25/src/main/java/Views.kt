@file:JvmName("Sdk25ViewsKt")
package org.jetbrains.anko

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
internal object `$$Anko$Factories$Sdk25View` {
    val MEDIA_ROUTE_BUTTON = { ctx: Context -> android.app.MediaRouteButton(ctx) }
    val GESTURE_OVERLAY_VIEW = { ctx: Context -> android.gesture.GestureOverlayView(ctx) }
    val EXTRACT_EDIT_TEXT = { ctx: Context -> android.inputmethodservice.ExtractEditText(ctx) }
    val TV_VIEW = { ctx: Context -> android.media.tv.TvView(ctx) }
    val G_L_SURFACE_VIEW = { ctx: Context -> android.opengl.GLSurfaceView(ctx) }
    val SURFACE_VIEW = { ctx: Context -> android.view.SurfaceView(ctx) }
    val TEXTURE_VIEW = { ctx: Context -> android.view.TextureView(ctx) }
    val VIEW = { ctx: Context -> android.view.View(ctx) }
    val VIEW_STUB = { ctx: Context -> android.view.ViewStub(ctx) }
    val WEB_VIEW = { ctx: Context -> android.webkit.WebView(ctx) }
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

inline fun ViewManager.mediaRouteButton(): android.app.MediaRouteButton = mediaRouteButton() {}
inline fun ViewManager.mediaRouteButton(init: (@AnkoViewDslMarker android.app.MediaRouteButton).() -> Unit): android.app.MediaRouteButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.MEDIA_ROUTE_BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedMediaRouteButton(theme: Int = 0): android.app.MediaRouteButton = themedMediaRouteButton(theme) {}
inline fun ViewManager.themedMediaRouteButton(theme: Int = 0, init: (@AnkoViewDslMarker android.app.MediaRouteButton).() -> Unit): android.app.MediaRouteButton {
return ankoView(`$$Anko$Factories$Sdk25View`.MEDIA_ROUTE_BUTTON, theme) { init() }
}

inline fun ViewManager.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView() {}
inline fun ViewManager.gestureOverlayView(init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedGestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = themedGestureOverlayView(theme) {}
inline fun ViewManager.themedGestureOverlayView(theme: Int = 0, init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

inline fun Context.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView() {}
inline fun Context.gestureOverlayView(init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme = 0) { init() }
}

inline fun Context.themedGestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = themedGestureOverlayView(theme) {}
inline fun Context.themedGestureOverlayView(theme: Int = 0, init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

inline fun Activity.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView() {}
inline fun Activity.gestureOverlayView(init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme = 0) { init() }
}

inline fun Activity.themedGestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = themedGestureOverlayView(theme) {}
inline fun Activity.themedGestureOverlayView(theme: Int = 0, init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

inline fun ViewManager.extractEditText(): android.inputmethodservice.ExtractEditText = extractEditText() {}
inline fun ViewManager.extractEditText(init: (@AnkoViewDslMarker android.inputmethodservice.ExtractEditText).() -> Unit): android.inputmethodservice.ExtractEditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXTRACT_EDIT_TEXT, theme = 0) { init() }
}

inline fun ViewManager.themedExtractEditText(theme: Int = 0): android.inputmethodservice.ExtractEditText = themedExtractEditText(theme) {}
inline fun ViewManager.themedExtractEditText(theme: Int = 0, init: (@AnkoViewDslMarker android.inputmethodservice.ExtractEditText).() -> Unit): android.inputmethodservice.ExtractEditText {
return ankoView(`$$Anko$Factories$Sdk25View`.EXTRACT_EDIT_TEXT, theme) { init() }
}

inline fun ViewManager.tvView(): android.media.tv.TvView = tvView() {}
inline fun ViewManager.tvView(init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedTvView(theme: Int = 0): android.media.tv.TvView = themedTvView(theme) {}
inline fun ViewManager.themedTvView(theme: Int = 0, init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme) { init() }
}

inline fun Context.tvView(): android.media.tv.TvView = tvView() {}
inline fun Context.tvView(init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme = 0) { init() }
}

inline fun Context.themedTvView(theme: Int = 0): android.media.tv.TvView = themedTvView(theme) {}
inline fun Context.themedTvView(theme: Int = 0, init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme) { init() }
}

inline fun Activity.tvView(): android.media.tv.TvView = tvView() {}
inline fun Activity.tvView(init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme = 0) { init() }
}

inline fun Activity.themedTvView(theme: Int = 0): android.media.tv.TvView = themedTvView(theme) {}
inline fun Activity.themedTvView(theme: Int = 0, init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme) { init() }
}

inline fun ViewManager.gLSurfaceView(): android.opengl.GLSurfaceView = gLSurfaceView() {}
inline fun ViewManager.gLSurfaceView(init: (@AnkoViewDslMarker android.opengl.GLSurfaceView).() -> Unit): android.opengl.GLSurfaceView {
    return ankoView(`$$Anko$Factories$Sdk25View`.G_L_SURFACE_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedGLSurfaceView(theme: Int = 0): android.opengl.GLSurfaceView = themedGLSurfaceView(theme) {}
inline fun ViewManager.themedGLSurfaceView(theme: Int = 0, init: (@AnkoViewDslMarker android.opengl.GLSurfaceView).() -> Unit): android.opengl.GLSurfaceView {
return ankoView(`$$Anko$Factories$Sdk25View`.G_L_SURFACE_VIEW, theme) { init() }
}

inline fun ViewManager.surfaceView(): android.view.SurfaceView = surfaceView() {}
inline fun ViewManager.surfaceView(init: (@AnkoViewDslMarker android.view.SurfaceView).() -> Unit): android.view.SurfaceView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SURFACE_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedSurfaceView(theme: Int = 0): android.view.SurfaceView = themedSurfaceView(theme) {}
inline fun ViewManager.themedSurfaceView(theme: Int = 0, init: (@AnkoViewDslMarker android.view.SurfaceView).() -> Unit): android.view.SurfaceView {
return ankoView(`$$Anko$Factories$Sdk25View`.SURFACE_VIEW, theme) { init() }
}

inline fun ViewManager.textureView(): android.view.TextureView = textureView() {}
inline fun ViewManager.textureView(init: (@AnkoViewDslMarker android.view.TextureView).() -> Unit): android.view.TextureView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXTURE_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedTextureView(theme: Int = 0): android.view.TextureView = themedTextureView(theme) {}
inline fun ViewManager.themedTextureView(theme: Int = 0, init: (@AnkoViewDslMarker android.view.TextureView).() -> Unit): android.view.TextureView {
return ankoView(`$$Anko$Factories$Sdk25View`.TEXTURE_VIEW, theme) { init() }
}

inline fun ViewManager.view(): android.view.View = view() {}
inline fun ViewManager.view(init: (@AnkoViewDslMarker android.view.View).() -> Unit): android.view.View {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedView(theme: Int = 0): android.view.View = themedView(theme) {}
inline fun ViewManager.themedView(theme: Int = 0, init: (@AnkoViewDslMarker android.view.View).() -> Unit): android.view.View {
return ankoView(`$$Anko$Factories$Sdk25View`.VIEW, theme) { init() }
}

inline fun ViewManager.viewStub(): android.view.ViewStub = viewStub() {}
inline fun ViewManager.viewStub(init: (@AnkoViewDslMarker android.view.ViewStub).() -> Unit): android.view.ViewStub {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_STUB, theme = 0) { init() }
}

inline fun ViewManager.themedViewStub(theme: Int = 0): android.view.ViewStub = themedViewStub(theme) {}
inline fun ViewManager.themedViewStub(theme: Int = 0, init: (@AnkoViewDslMarker android.view.ViewStub).() -> Unit): android.view.ViewStub {
return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_STUB, theme) { init() }
}

inline fun ViewManager.webView(): android.webkit.WebView = webView() {}
inline fun ViewManager.webView(init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedWebView(theme: Int = 0): android.webkit.WebView = themedWebView(theme) {}
inline fun ViewManager.themedWebView(theme: Int = 0, init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme) { init() }
}

inline fun Context.webView(): android.webkit.WebView = webView() {}
inline fun Context.webView(init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme = 0) { init() }
}

inline fun Context.themedWebView(theme: Int = 0): android.webkit.WebView = themedWebView(theme) {}
inline fun Context.themedWebView(theme: Int = 0, init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme) { init() }
}

inline fun Activity.webView(): android.webkit.WebView = webView() {}
inline fun Activity.webView(init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme = 0) { init() }
}

inline fun Activity.themedWebView(theme: Int = 0): android.webkit.WebView = themedWebView(theme) {}
inline fun Activity.themedWebView(theme: Int = 0, init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme) { init() }
}

inline fun ViewManager.adapterViewFlipper(): android.widget.AdapterViewFlipper = adapterViewFlipper() {}
inline fun ViewManager.adapterViewFlipper(init: (@AnkoViewDslMarker android.widget.AdapterViewFlipper).() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme = 0) { init() }
}

inline fun ViewManager.themedAdapterViewFlipper(theme: Int = 0): android.widget.AdapterViewFlipper = themedAdapterViewFlipper(theme) {}
inline fun ViewManager.themedAdapterViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.AdapterViewFlipper).() -> Unit): android.widget.AdapterViewFlipper {
return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

inline fun Context.adapterViewFlipper(): android.widget.AdapterViewFlipper = adapterViewFlipper() {}
inline fun Context.adapterViewFlipper(init: (@AnkoViewDslMarker android.widget.AdapterViewFlipper).() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme = 0) { init() }
}

inline fun Context.themedAdapterViewFlipper(theme: Int = 0): android.widget.AdapterViewFlipper = themedAdapterViewFlipper(theme) {}
inline fun Context.themedAdapterViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.AdapterViewFlipper).() -> Unit): android.widget.AdapterViewFlipper {
return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

inline fun Activity.adapterViewFlipper(): android.widget.AdapterViewFlipper = adapterViewFlipper() {}
inline fun Activity.adapterViewFlipper(init: (@AnkoViewDslMarker android.widget.AdapterViewFlipper).() -> Unit): android.widget.AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme = 0) { init() }
}

inline fun Activity.themedAdapterViewFlipper(theme: Int = 0): android.widget.AdapterViewFlipper = themedAdapterViewFlipper(theme) {}
inline fun Activity.themedAdapterViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.AdapterViewFlipper).() -> Unit): android.widget.AdapterViewFlipper {
return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

inline fun ViewManager.analogClock(): android.widget.AnalogClock = analogClock() {}
inline fun ViewManager.analogClock(init: (@AnkoViewDslMarker android.widget.AnalogClock).() -> Unit): android.widget.AnalogClock {
    return ankoView(`$$Anko$Factories$Sdk25View`.ANALOG_CLOCK, theme = 0) { init() }
}

inline fun ViewManager.themedAnalogClock(theme: Int = 0): android.widget.AnalogClock = themedAnalogClock(theme) {}
inline fun ViewManager.themedAnalogClock(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.AnalogClock).() -> Unit): android.widget.AnalogClock {
return ankoView(`$$Anko$Factories$Sdk25View`.ANALOG_CLOCK, theme) { init() }
}

inline fun ViewManager.autoCompleteTextView(): android.widget.AutoCompleteTextView = autoCompleteTextView() {}
inline fun ViewManager.autoCompleteTextView(init: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit): android.widget.AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.AUTO_COMPLETE_TEXT_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedAutoCompleteTextView(theme: Int = 0): android.widget.AutoCompleteTextView = themedAutoCompleteTextView(theme) {}
inline fun ViewManager.themedAutoCompleteTextView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit): android.widget.AutoCompleteTextView {
return ankoView(`$$Anko$Factories$Sdk25View`.AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.button(): android.widget.Button = button() {}
inline fun ViewManager.button(init: (@AnkoViewDslMarker android.widget.Button).() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedButton(theme: Int = 0): android.widget.Button = themedButton(theme) {}
inline fun ViewManager.themedButton(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Button).() -> Unit): android.widget.Button {
return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) { init() }
}

inline fun ViewManager.button(text: CharSequence?): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.button(text: CharSequence?, init: (@AnkoViewDslMarker android.widget.Button).() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedButton(text: CharSequence?, theme: Int): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedButton(text: CharSequence?, theme: Int, init: (@AnkoViewDslMarker android.widget.Button).() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.button(text: Int): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.button(text: Int, init: (@AnkoViewDslMarker android.widget.Button).() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedButton(text: Int, theme: Int): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedButton(text: Int, theme: Int, init: (@AnkoViewDslMarker android.widget.Button).() -> Unit): android.widget.Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.calendarView(): android.widget.CalendarView = calendarView() {}
inline fun ViewManager.calendarView(init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedCalendarView(theme: Int = 0): android.widget.CalendarView = themedCalendarView(theme) {}
inline fun ViewManager.themedCalendarView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme) { init() }
}

inline fun Context.calendarView(): android.widget.CalendarView = calendarView() {}
inline fun Context.calendarView(init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme = 0) { init() }
}

inline fun Context.themedCalendarView(theme: Int = 0): android.widget.CalendarView = themedCalendarView(theme) {}
inline fun Context.themedCalendarView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme) { init() }
}

inline fun Activity.calendarView(): android.widget.CalendarView = calendarView() {}
inline fun Activity.calendarView(init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme = 0) { init() }
}

inline fun Activity.themedCalendarView(theme: Int = 0): android.widget.CalendarView = themedCalendarView(theme) {}
inline fun Activity.themedCalendarView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme) { init() }
}

inline fun ViewManager.checkBox(): android.widget.CheckBox = checkBox() {}
inline fun ViewManager.checkBox(init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) { init() }
}

inline fun ViewManager.themedCheckBox(theme: Int = 0): android.widget.CheckBox = themedCheckBox(theme) {}
inline fun ViewManager.themedCheckBox(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) { init() }
}

inline fun ViewManager.checkBox(text: CharSequence?): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.checkBox(text: CharSequence?, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedCheckBox(text: CharSequence?, theme: Int): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedCheckBox(text: CharSequence?, theme: Int, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.checkBox(text: Int): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.checkBox(text: Int, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedCheckBox(text: Int, theme: Int): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedCheckBox(text: Int, theme: Int, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.checkBox(text: CharSequence?, checked: Boolean, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.themedCheckBox(text: CharSequence?, checked: Boolean, theme: Int): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.themedCheckBox(text: CharSequence?, checked: Boolean, theme: Int, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.checkBox(text: Int, checked: Boolean): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.checkBox(text: Int, checked: Boolean, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.themedCheckBox(text: Int, checked: Boolean, theme: Int): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}
inline fun ViewManager.themedCheckBox(text: Int, checked: Boolean, theme: Int, init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit): android.widget.CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.checkedTextView(): android.widget.CheckedTextView = checkedTextView() {}
inline fun ViewManager.checkedTextView(init: (@AnkoViewDslMarker android.widget.CheckedTextView).() -> Unit): android.widget.CheckedTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECKED_TEXT_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedCheckedTextView(theme: Int = 0): android.widget.CheckedTextView = themedCheckedTextView(theme) {}
inline fun ViewManager.themedCheckedTextView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.CheckedTextView).() -> Unit): android.widget.CheckedTextView {
return ankoView(`$$Anko$Factories$Sdk25View`.CHECKED_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.chronometer(): android.widget.Chronometer = chronometer() {}
inline fun ViewManager.chronometer(init: (@AnkoViewDslMarker android.widget.Chronometer).() -> Unit): android.widget.Chronometer {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHRONOMETER, theme = 0) { init() }
}

inline fun ViewManager.themedChronometer(theme: Int = 0): android.widget.Chronometer = themedChronometer(theme) {}
inline fun ViewManager.themedChronometer(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Chronometer).() -> Unit): android.widget.Chronometer {
return ankoView(`$$Anko$Factories$Sdk25View`.CHRONOMETER, theme) { init() }
}

inline fun ViewManager.datePicker(): android.widget.DatePicker = datePicker() {}
inline fun ViewManager.datePicker(init: (@AnkoViewDslMarker android.widget.DatePicker).() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme = 0) { init() }
}

inline fun ViewManager.themedDatePicker(theme: Int = 0): android.widget.DatePicker = themedDatePicker(theme) {}
inline fun ViewManager.themedDatePicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DatePicker).() -> Unit): android.widget.DatePicker {
return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme) { init() }
}

inline fun Context.datePicker(): android.widget.DatePicker = datePicker() {}
inline fun Context.datePicker(init: (@AnkoViewDslMarker android.widget.DatePicker).() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme = 0) { init() }
}

inline fun Context.themedDatePicker(theme: Int = 0): android.widget.DatePicker = themedDatePicker(theme) {}
inline fun Context.themedDatePicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DatePicker).() -> Unit): android.widget.DatePicker {
return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme) { init() }
}

inline fun Activity.datePicker(): android.widget.DatePicker = datePicker() {}
inline fun Activity.datePicker(init: (@AnkoViewDslMarker android.widget.DatePicker).() -> Unit): android.widget.DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme = 0) { init() }
}

inline fun Activity.themedDatePicker(theme: Int = 0): android.widget.DatePicker = themedDatePicker(theme) {}
inline fun Activity.themedDatePicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DatePicker).() -> Unit): android.widget.DatePicker {
return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme) { init() }
}

inline fun ViewManager.dialerFilter(): android.widget.DialerFilter = dialerFilter() {}
inline fun ViewManager.dialerFilter(init: (@AnkoViewDslMarker android.widget.DialerFilter).() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk25View`.DIALER_FILTER, theme = 0) { init() }
}

inline fun ViewManager.themedDialerFilter(theme: Int = 0): android.widget.DialerFilter = themedDialerFilter(theme) {}
inline fun ViewManager.themedDialerFilter(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DialerFilter).() -> Unit): android.widget.DialerFilter {
return ankoView(`$$Anko$Factories$Sdk25View`.DIALER_FILTER, theme) { init() }
}

inline fun Context.dialerFilter(): android.widget.DialerFilter = dialerFilter() {}
inline fun Context.dialerFilter(init: (@AnkoViewDslMarker android.widget.DialerFilter).() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk25View`.DIALER_FILTER, theme = 0) { init() }
}

inline fun Context.themedDialerFilter(theme: Int = 0): android.widget.DialerFilter = themedDialerFilter(theme) {}
inline fun Context.themedDialerFilter(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DialerFilter).() -> Unit): android.widget.DialerFilter {
return ankoView(`$$Anko$Factories$Sdk25View`.DIALER_FILTER, theme) { init() }
}

inline fun Activity.dialerFilter(): android.widget.DialerFilter = dialerFilter() {}
inline fun Activity.dialerFilter(init: (@AnkoViewDslMarker android.widget.DialerFilter).() -> Unit): android.widget.DialerFilter {
    return ankoView(`$$Anko$Factories$Sdk25View`.DIALER_FILTER, theme = 0) { init() }
}

inline fun Activity.themedDialerFilter(theme: Int = 0): android.widget.DialerFilter = themedDialerFilter(theme) {}
inline fun Activity.themedDialerFilter(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DialerFilter).() -> Unit): android.widget.DialerFilter {
return ankoView(`$$Anko$Factories$Sdk25View`.DIALER_FILTER, theme) { init() }
}

inline fun ViewManager.digitalClock(): android.widget.DigitalClock = digitalClock() {}
inline fun ViewManager.digitalClock(init: (@AnkoViewDslMarker android.widget.DigitalClock).() -> Unit): android.widget.DigitalClock {
    return ankoView(`$$Anko$Factories$Sdk25View`.DIGITAL_CLOCK, theme = 0) { init() }
}

inline fun ViewManager.themedDigitalClock(theme: Int = 0): android.widget.DigitalClock = themedDigitalClock(theme) {}
inline fun ViewManager.themedDigitalClock(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.DigitalClock).() -> Unit): android.widget.DigitalClock {
return ankoView(`$$Anko$Factories$Sdk25View`.DIGITAL_CLOCK, theme) { init() }
}

inline fun ViewManager.editText(): android.widget.EditText = editText() {}
inline fun ViewManager.editText(init: (@AnkoViewDslMarker android.widget.EditText).() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) { init() }
}

inline fun ViewManager.themedEditText(theme: Int = 0): android.widget.EditText = themedEditText(theme) {}
inline fun ViewManager.themedEditText(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.EditText).() -> Unit): android.widget.EditText {
return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) { init() }
}

inline fun ViewManager.editText(text: CharSequence?): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.editText(text: CharSequence?, init: (@AnkoViewDslMarker android.widget.EditText).() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedEditText(text: CharSequence?, theme: Int): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedEditText(text: CharSequence?, theme: Int, init: (@AnkoViewDslMarker android.widget.EditText).() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.editText(text: Int): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.editText(text: Int, init: (@AnkoViewDslMarker android.widget.EditText).() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedEditText(text: Int, theme: Int): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedEditText(text: Int, theme: Int, init: (@AnkoViewDslMarker android.widget.EditText).() -> Unit): android.widget.EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.expandableListView(): android.widget.ExpandableListView = expandableListView() {}
inline fun ViewManager.expandableListView(init: (@AnkoViewDslMarker android.widget.ExpandableListView).() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedExpandableListView(theme: Int = 0): android.widget.ExpandableListView = themedExpandableListView(theme) {}
inline fun ViewManager.themedExpandableListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ExpandableListView).() -> Unit): android.widget.ExpandableListView {
return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

inline fun Context.expandableListView(): android.widget.ExpandableListView = expandableListView() {}
inline fun Context.expandableListView(init: (@AnkoViewDslMarker android.widget.ExpandableListView).() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme = 0) { init() }
}

inline fun Context.themedExpandableListView(theme: Int = 0): android.widget.ExpandableListView = themedExpandableListView(theme) {}
inline fun Context.themedExpandableListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ExpandableListView).() -> Unit): android.widget.ExpandableListView {
return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

inline fun Activity.expandableListView(): android.widget.ExpandableListView = expandableListView() {}
inline fun Activity.expandableListView(init: (@AnkoViewDslMarker android.widget.ExpandableListView).() -> Unit): android.widget.ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme = 0) { init() }
}

inline fun Activity.themedExpandableListView(theme: Int = 0): android.widget.ExpandableListView = themedExpandableListView(theme) {}
inline fun Activity.themedExpandableListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ExpandableListView).() -> Unit): android.widget.ExpandableListView {
return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

inline fun ViewManager.imageButton(): android.widget.ImageButton = imageButton() {}
inline fun ViewManager.imageButton(init: (@AnkoViewDslMarker android.widget.ImageButton).() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedImageButton(theme: Int = 0): android.widget.ImageButton = themedImageButton(theme) {}
inline fun ViewManager.themedImageButton(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ImageButton).() -> Unit): android.widget.ImageButton {
return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) { init() }
}

inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, init: (@AnkoViewDslMarker android.widget.ImageButton).() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        init()
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.themedImageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.themedImageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int, init: (@AnkoViewDslMarker android.widget.ImageButton).() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.imageButton(imageResource: Int): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.imageButton(imageResource: Int, init: (@AnkoViewDslMarker android.widget.ImageButton).() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        init()
        setImageResource(imageResource)
    }
}
inline fun ViewManager.themedImageButton(imageResource: Int, theme: Int): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.themedImageButton(imageResource: Int, theme: Int, init: (@AnkoViewDslMarker android.widget.ImageButton).() -> Unit): android.widget.ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        init()
        setImageResource(imageResource)
    }
}

inline fun ViewManager.imageView(): android.widget.ImageView = imageView() {}
inline fun ViewManager.imageView(init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedImageView(theme: Int = 0): android.widget.ImageView = themedImageView(theme) {}
inline fun ViewManager.themedImageView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit): android.widget.ImageView {
return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) { init() }
}

inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        init()
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.themedImageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        setImageDrawable(imageDrawable)
    }
}
inline fun ViewManager.themedImageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int, init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.imageView(imageResource: Int): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.imageView(imageResource: Int, init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        init()
        setImageResource(imageResource)
    }
}
inline fun ViewManager.themedImageView(imageResource: Int, theme: Int): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        setImageResource(imageResource)
    }
}
inline fun ViewManager.themedImageView(imageResource: Int, theme: Int, init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit): android.widget.ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        init()
        setImageResource(imageResource)
    }
}

inline fun ViewManager.listView(): android.widget.ListView = listView() {}
inline fun ViewManager.listView(init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedListView(theme: Int = 0): android.widget.ListView = themedListView(theme) {}
inline fun ViewManager.themedListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme) { init() }
}

inline fun Context.listView(): android.widget.ListView = listView() {}
inline fun Context.listView(init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme = 0) { init() }
}

inline fun Context.themedListView(theme: Int = 0): android.widget.ListView = themedListView(theme) {}
inline fun Context.themedListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme) { init() }
}

inline fun Activity.listView(): android.widget.ListView = listView() {}
inline fun Activity.listView(init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme = 0) { init() }
}

inline fun Activity.themedListView(theme: Int = 0): android.widget.ListView = themedListView(theme) {}
inline fun Activity.themedListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme) { init() }
}

inline fun ViewManager.multiAutoCompleteTextView(): android.widget.MultiAutoCompleteTextView = multiAutoCompleteTextView() {}
inline fun ViewManager.multiAutoCompleteTextView(init: (@AnkoViewDslMarker android.widget.MultiAutoCompleteTextView).() -> Unit): android.widget.MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.MULTI_AUTO_COMPLETE_TEXT_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedMultiAutoCompleteTextView(theme: Int = 0): android.widget.MultiAutoCompleteTextView = themedMultiAutoCompleteTextView(theme) {}
inline fun ViewManager.themedMultiAutoCompleteTextView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.MultiAutoCompleteTextView).() -> Unit): android.widget.MultiAutoCompleteTextView {
return ankoView(`$$Anko$Factories$Sdk25View`.MULTI_AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.numberPicker(): android.widget.NumberPicker = numberPicker() {}
inline fun ViewManager.numberPicker(init: (@AnkoViewDslMarker android.widget.NumberPicker).() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme = 0) { init() }
}

inline fun ViewManager.themedNumberPicker(theme: Int = 0): android.widget.NumberPicker = themedNumberPicker(theme) {}
inline fun ViewManager.themedNumberPicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.NumberPicker).() -> Unit): android.widget.NumberPicker {
return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme) { init() }
}

inline fun Context.numberPicker(): android.widget.NumberPicker = numberPicker() {}
inline fun Context.numberPicker(init: (@AnkoViewDslMarker android.widget.NumberPicker).() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme = 0) { init() }
}

inline fun Context.themedNumberPicker(theme: Int = 0): android.widget.NumberPicker = themedNumberPicker(theme) {}
inline fun Context.themedNumberPicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.NumberPicker).() -> Unit): android.widget.NumberPicker {
return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme) { init() }
}

inline fun Activity.numberPicker(): android.widget.NumberPicker = numberPicker() {}
inline fun Activity.numberPicker(init: (@AnkoViewDslMarker android.widget.NumberPicker).() -> Unit): android.widget.NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme = 0) { init() }
}

inline fun Activity.themedNumberPicker(theme: Int = 0): android.widget.NumberPicker = themedNumberPicker(theme) {}
inline fun Activity.themedNumberPicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.NumberPicker).() -> Unit): android.widget.NumberPicker {
return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme) { init() }
}

inline fun ViewManager.progressBar(): android.widget.ProgressBar = progressBar() {}
inline fun ViewManager.progressBar(init: (@AnkoViewDslMarker android.widget.ProgressBar).() -> Unit): android.widget.ProgressBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.PROGRESS_BAR, theme = 0) { init() }
}

inline fun ViewManager.themedProgressBar(theme: Int = 0): android.widget.ProgressBar = themedProgressBar(theme) {}
inline fun ViewManager.themedProgressBar(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ProgressBar).() -> Unit): android.widget.ProgressBar {
return ankoView(`$$Anko$Factories$Sdk25View`.PROGRESS_BAR, theme) { init() }
}

inline fun ViewManager.quickContactBadge(): android.widget.QuickContactBadge = quickContactBadge() {}
inline fun ViewManager.quickContactBadge(init: (@AnkoViewDslMarker android.widget.QuickContactBadge).() -> Unit): android.widget.QuickContactBadge {
    return ankoView(`$$Anko$Factories$Sdk25View`.QUICK_CONTACT_BADGE, theme = 0) { init() }
}

inline fun ViewManager.themedQuickContactBadge(theme: Int = 0): android.widget.QuickContactBadge = themedQuickContactBadge(theme) {}
inline fun ViewManager.themedQuickContactBadge(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.QuickContactBadge).() -> Unit): android.widget.QuickContactBadge {
return ankoView(`$$Anko$Factories$Sdk25View`.QUICK_CONTACT_BADGE, theme) { init() }
}

inline fun ViewManager.radioButton(): android.widget.RadioButton = radioButton() {}
inline fun ViewManager.radioButton(init: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit): android.widget.RadioButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.RADIO_BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedRadioButton(theme: Int = 0): android.widget.RadioButton = themedRadioButton(theme) {}
inline fun ViewManager.themedRadioButton(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit): android.widget.RadioButton {
return ankoView(`$$Anko$Factories$Sdk25View`.RADIO_BUTTON, theme) { init() }
}

inline fun ViewManager.ratingBar(): android.widget.RatingBar = ratingBar() {}
inline fun ViewManager.ratingBar(init: (@AnkoViewDslMarker android.widget.RatingBar).() -> Unit): android.widget.RatingBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.RATING_BAR, theme = 0) { init() }
}

inline fun ViewManager.themedRatingBar(theme: Int = 0): android.widget.RatingBar = themedRatingBar(theme) {}
inline fun ViewManager.themedRatingBar(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.RatingBar).() -> Unit): android.widget.RatingBar {
return ankoView(`$$Anko$Factories$Sdk25View`.RATING_BAR, theme) { init() }
}

inline fun ViewManager.searchView(): android.widget.SearchView = searchView() {}
inline fun ViewManager.searchView(init: (@AnkoViewDslMarker android.widget.SearchView).() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedSearchView(theme: Int = 0): android.widget.SearchView = themedSearchView(theme) {}
inline fun ViewManager.themedSearchView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SearchView).() -> Unit): android.widget.SearchView {
return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme) { init() }
}

inline fun Context.searchView(): android.widget.SearchView = searchView() {}
inline fun Context.searchView(init: (@AnkoViewDslMarker android.widget.SearchView).() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme = 0) { init() }
}

inline fun Context.themedSearchView(theme: Int = 0): android.widget.SearchView = themedSearchView(theme) {}
inline fun Context.themedSearchView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SearchView).() -> Unit): android.widget.SearchView {
return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme) { init() }
}

inline fun Activity.searchView(): android.widget.SearchView = searchView() {}
inline fun Activity.searchView(init: (@AnkoViewDslMarker android.widget.SearchView).() -> Unit): android.widget.SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme = 0) { init() }
}

inline fun Activity.themedSearchView(theme: Int = 0): android.widget.SearchView = themedSearchView(theme) {}
inline fun Activity.themedSearchView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SearchView).() -> Unit): android.widget.SearchView {
return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme) { init() }
}

inline fun ViewManager.seekBar(): android.widget.SeekBar = seekBar() {}
inline fun ViewManager.seekBar(init: (@AnkoViewDslMarker android.widget.SeekBar).() -> Unit): android.widget.SeekBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEEK_BAR, theme = 0) { init() }
}

inline fun ViewManager.themedSeekBar(theme: Int = 0): android.widget.SeekBar = themedSeekBar(theme) {}
inline fun ViewManager.themedSeekBar(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SeekBar).() -> Unit): android.widget.SeekBar {
return ankoView(`$$Anko$Factories$Sdk25View`.SEEK_BAR, theme) { init() }
}

inline fun ViewManager.slidingDrawer(): android.widget.SlidingDrawer = slidingDrawer() {}
inline fun ViewManager.slidingDrawer(init: (@AnkoViewDslMarker android.widget.SlidingDrawer).() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk25View`.SLIDING_DRAWER, theme = 0) { init() }
}

inline fun ViewManager.themedSlidingDrawer(theme: Int = 0): android.widget.SlidingDrawer = themedSlidingDrawer(theme) {}
inline fun ViewManager.themedSlidingDrawer(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SlidingDrawer).() -> Unit): android.widget.SlidingDrawer {
return ankoView(`$$Anko$Factories$Sdk25View`.SLIDING_DRAWER, theme) { init() }
}

inline fun Context.slidingDrawer(): android.widget.SlidingDrawer = slidingDrawer() {}
inline fun Context.slidingDrawer(init: (@AnkoViewDslMarker android.widget.SlidingDrawer).() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk25View`.SLIDING_DRAWER, theme = 0) { init() }
}

inline fun Context.themedSlidingDrawer(theme: Int = 0): android.widget.SlidingDrawer = themedSlidingDrawer(theme) {}
inline fun Context.themedSlidingDrawer(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SlidingDrawer).() -> Unit): android.widget.SlidingDrawer {
return ankoView(`$$Anko$Factories$Sdk25View`.SLIDING_DRAWER, theme) { init() }
}

inline fun Activity.slidingDrawer(): android.widget.SlidingDrawer = slidingDrawer() {}
inline fun Activity.slidingDrawer(init: (@AnkoViewDslMarker android.widget.SlidingDrawer).() -> Unit): android.widget.SlidingDrawer {
    return ankoView(`$$Anko$Factories$Sdk25View`.SLIDING_DRAWER, theme = 0) { init() }
}

inline fun Activity.themedSlidingDrawer(theme: Int = 0): android.widget.SlidingDrawer = themedSlidingDrawer(theme) {}
inline fun Activity.themedSlidingDrawer(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.SlidingDrawer).() -> Unit): android.widget.SlidingDrawer {
return ankoView(`$$Anko$Factories$Sdk25View`.SLIDING_DRAWER, theme) { init() }
}

inline fun ViewManager.space(): android.widget.Space = space() {}
inline fun ViewManager.space(init: (@AnkoViewDslMarker android.widget.Space).() -> Unit): android.widget.Space {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPACE, theme = 0) { init() }
}

inline fun ViewManager.themedSpace(theme: Int = 0): android.widget.Space = themedSpace(theme) {}
inline fun ViewManager.themedSpace(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Space).() -> Unit): android.widget.Space {
return ankoView(`$$Anko$Factories$Sdk25View`.SPACE, theme) { init() }
}

inline fun ViewManager.spinner(): android.widget.Spinner = spinner() {}
inline fun ViewManager.spinner(init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme = 0) { init() }
}

inline fun ViewManager.themedSpinner(theme: Int = 0): android.widget.Spinner = themedSpinner(theme) {}
inline fun ViewManager.themedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit): android.widget.Spinner {
return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme) { init() }
}

inline fun Context.spinner(): android.widget.Spinner = spinner() {}
inline fun Context.spinner(init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme = 0) { init() }
}

inline fun Context.themedSpinner(theme: Int = 0): android.widget.Spinner = themedSpinner(theme) {}
inline fun Context.themedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit): android.widget.Spinner {
return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme) { init() }
}

inline fun Activity.spinner(): android.widget.Spinner = spinner() {}
inline fun Activity.spinner(init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit): android.widget.Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme = 0) { init() }
}

inline fun Activity.themedSpinner(theme: Int = 0): android.widget.Spinner = themedSpinner(theme) {}
inline fun Activity.themedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit): android.widget.Spinner {
return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme) { init() }
}

inline fun ViewManager.stackView(): android.widget.StackView = stackView() {}
inline fun ViewManager.stackView(init: (@AnkoViewDslMarker android.widget.StackView).() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedStackView(theme: Int = 0): android.widget.StackView = themedStackView(theme) {}
inline fun ViewManager.themedStackView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.StackView).() -> Unit): android.widget.StackView {
return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme) { init() }
}

inline fun Context.stackView(): android.widget.StackView = stackView() {}
inline fun Context.stackView(init: (@AnkoViewDslMarker android.widget.StackView).() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme = 0) { init() }
}

inline fun Context.themedStackView(theme: Int = 0): android.widget.StackView = themedStackView(theme) {}
inline fun Context.themedStackView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.StackView).() -> Unit): android.widget.StackView {
return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme) { init() }
}

inline fun Activity.stackView(): android.widget.StackView = stackView() {}
inline fun Activity.stackView(init: (@AnkoViewDslMarker android.widget.StackView).() -> Unit): android.widget.StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme = 0) { init() }
}

inline fun Activity.themedStackView(theme: Int = 0): android.widget.StackView = themedStackView(theme) {}
inline fun Activity.themedStackView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.StackView).() -> Unit): android.widget.StackView {
return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme) { init() }
}

inline fun ViewManager.switch(): android.widget.Switch = switch() {}
inline fun ViewManager.switch(init: (@AnkoViewDslMarker android.widget.Switch).() -> Unit): android.widget.Switch {
    return ankoView(`$$Anko$Factories$Sdk25View`.SWITCH, theme = 0) { init() }
}

inline fun ViewManager.themedSwitch(theme: Int = 0): android.widget.Switch = themedSwitch(theme) {}
inline fun ViewManager.themedSwitch(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.Switch).() -> Unit): android.widget.Switch {
return ankoView(`$$Anko$Factories$Sdk25View`.SWITCH, theme) { init() }
}

inline fun ViewManager.tabHost(): android.widget.TabHost = tabHost() {}
inline fun ViewManager.tabHost(init: (@AnkoViewDslMarker android.widget.TabHost).() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk25View`.TAB_HOST, theme = 0) { init() }
}

inline fun ViewManager.themedTabHost(theme: Int = 0): android.widget.TabHost = themedTabHost(theme) {}
inline fun ViewManager.themedTabHost(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TabHost).() -> Unit): android.widget.TabHost {
return ankoView(`$$Anko$Factories$Sdk25View`.TAB_HOST, theme) { init() }
}

inline fun Context.tabHost(): android.widget.TabHost = tabHost() {}
inline fun Context.tabHost(init: (@AnkoViewDslMarker android.widget.TabHost).() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk25View`.TAB_HOST, theme = 0) { init() }
}

inline fun Context.themedTabHost(theme: Int = 0): android.widget.TabHost = themedTabHost(theme) {}
inline fun Context.themedTabHost(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TabHost).() -> Unit): android.widget.TabHost {
return ankoView(`$$Anko$Factories$Sdk25View`.TAB_HOST, theme) { init() }
}

inline fun Activity.tabHost(): android.widget.TabHost = tabHost() {}
inline fun Activity.tabHost(init: (@AnkoViewDslMarker android.widget.TabHost).() -> Unit): android.widget.TabHost {
    return ankoView(`$$Anko$Factories$Sdk25View`.TAB_HOST, theme = 0) { init() }
}

inline fun Activity.themedTabHost(theme: Int = 0): android.widget.TabHost = themedTabHost(theme) {}
inline fun Activity.themedTabHost(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TabHost).() -> Unit): android.widget.TabHost {
return ankoView(`$$Anko$Factories$Sdk25View`.TAB_HOST, theme) { init() }
}

inline fun ViewManager.tabWidget(): android.widget.TabWidget = tabWidget() {}
inline fun ViewManager.tabWidget(init: (@AnkoViewDslMarker android.widget.TabWidget).() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk25View`.TAB_WIDGET, theme = 0) { init() }
}

inline fun ViewManager.themedTabWidget(theme: Int = 0): android.widget.TabWidget = themedTabWidget(theme) {}
inline fun ViewManager.themedTabWidget(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TabWidget).() -> Unit): android.widget.TabWidget {
return ankoView(`$$Anko$Factories$Sdk25View`.TAB_WIDGET, theme) { init() }
}

inline fun Context.tabWidget(): android.widget.TabWidget = tabWidget() {}
inline fun Context.tabWidget(init: (@AnkoViewDslMarker android.widget.TabWidget).() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk25View`.TAB_WIDGET, theme = 0) { init() }
}

inline fun Context.themedTabWidget(theme: Int = 0): android.widget.TabWidget = themedTabWidget(theme) {}
inline fun Context.themedTabWidget(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TabWidget).() -> Unit): android.widget.TabWidget {
return ankoView(`$$Anko$Factories$Sdk25View`.TAB_WIDGET, theme) { init() }
}

inline fun Activity.tabWidget(): android.widget.TabWidget = tabWidget() {}
inline fun Activity.tabWidget(init: (@AnkoViewDslMarker android.widget.TabWidget).() -> Unit): android.widget.TabWidget {
    return ankoView(`$$Anko$Factories$Sdk25View`.TAB_WIDGET, theme = 0) { init() }
}

inline fun Activity.themedTabWidget(theme: Int = 0): android.widget.TabWidget = themedTabWidget(theme) {}
inline fun Activity.themedTabWidget(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TabWidget).() -> Unit): android.widget.TabWidget {
return ankoView(`$$Anko$Factories$Sdk25View`.TAB_WIDGET, theme) { init() }
}

inline fun ViewManager.textClock(): android.widget.TextClock = textClock() {}
inline fun ViewManager.textClock(init: (@AnkoViewDslMarker android.widget.TextClock).() -> Unit): android.widget.TextClock {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_CLOCK, theme = 0) { init() }
}

inline fun ViewManager.themedTextClock(theme: Int = 0): android.widget.TextClock = themedTextClock(theme) {}
inline fun ViewManager.themedTextClock(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TextClock).() -> Unit): android.widget.TextClock {
return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_CLOCK, theme) { init() }
}

inline fun ViewManager.textView(): android.widget.TextView = textView() {}
inline fun ViewManager.textView(init: (@AnkoViewDslMarker android.widget.TextView).() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedTextView(theme: Int = 0): android.widget.TextView = themedTextView(theme) {}
inline fun ViewManager.themedTextView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TextView).() -> Unit): android.widget.TextView {
return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) { init() }
}

inline fun ViewManager.textView(text: CharSequence?): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.textView(text: CharSequence?, init: (@AnkoViewDslMarker android.widget.TextView).() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedTextView(text: CharSequence?, theme: Int): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedTextView(text: CharSequence?, theme: Int, init: (@AnkoViewDslMarker android.widget.TextView).() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.textView(text: Int): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        setText(text)
    }
}
inline fun ViewManager.textView(text: Int, init: (@AnkoViewDslMarker android.widget.TextView).() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        init()
        setText(text)
    }
}
inline fun ViewManager.themedTextView(text: Int, theme: Int): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        setText(text)
    }
}
inline fun ViewManager.themedTextView(text: Int, theme: Int, init: (@AnkoViewDslMarker android.widget.TextView).() -> Unit): android.widget.TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

inline fun ViewManager.timePicker(): android.widget.TimePicker = timePicker() {}
inline fun ViewManager.timePicker(init: (@AnkoViewDslMarker android.widget.TimePicker).() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme = 0) { init() }
}

inline fun ViewManager.themedTimePicker(theme: Int = 0): android.widget.TimePicker = themedTimePicker(theme) {}
inline fun ViewManager.themedTimePicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TimePicker).() -> Unit): android.widget.TimePicker {
return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme) { init() }
}

inline fun Context.timePicker(): android.widget.TimePicker = timePicker() {}
inline fun Context.timePicker(init: (@AnkoViewDslMarker android.widget.TimePicker).() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme = 0) { init() }
}

inline fun Context.themedTimePicker(theme: Int = 0): android.widget.TimePicker = themedTimePicker(theme) {}
inline fun Context.themedTimePicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TimePicker).() -> Unit): android.widget.TimePicker {
return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme) { init() }
}

inline fun Activity.timePicker(): android.widget.TimePicker = timePicker() {}
inline fun Activity.timePicker(init: (@AnkoViewDslMarker android.widget.TimePicker).() -> Unit): android.widget.TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme = 0) { init() }
}

inline fun Activity.themedTimePicker(theme: Int = 0): android.widget.TimePicker = themedTimePicker(theme) {}
inline fun Activity.themedTimePicker(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TimePicker).() -> Unit): android.widget.TimePicker {
return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme) { init() }
}

inline fun ViewManager.toggleButton(): android.widget.ToggleButton = toggleButton() {}
inline fun ViewManager.toggleButton(init: (@AnkoViewDslMarker android.widget.ToggleButton).() -> Unit): android.widget.ToggleButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.TOGGLE_BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedToggleButton(theme: Int = 0): android.widget.ToggleButton = themedToggleButton(theme) {}
inline fun ViewManager.themedToggleButton(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ToggleButton).() -> Unit): android.widget.ToggleButton {
return ankoView(`$$Anko$Factories$Sdk25View`.TOGGLE_BUTTON, theme) { init() }
}

inline fun ViewManager.twoLineListItem(): android.widget.TwoLineListItem = twoLineListItem() {}
inline fun ViewManager.twoLineListItem(init: (@AnkoViewDslMarker android.widget.TwoLineListItem).() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk25View`.TWO_LINE_LIST_ITEM, theme = 0) { init() }
}

inline fun ViewManager.themedTwoLineListItem(theme: Int = 0): android.widget.TwoLineListItem = themedTwoLineListItem(theme) {}
inline fun ViewManager.themedTwoLineListItem(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TwoLineListItem).() -> Unit): android.widget.TwoLineListItem {
return ankoView(`$$Anko$Factories$Sdk25View`.TWO_LINE_LIST_ITEM, theme) { init() }
}

inline fun Context.twoLineListItem(): android.widget.TwoLineListItem = twoLineListItem() {}
inline fun Context.twoLineListItem(init: (@AnkoViewDslMarker android.widget.TwoLineListItem).() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk25View`.TWO_LINE_LIST_ITEM, theme = 0) { init() }
}

inline fun Context.themedTwoLineListItem(theme: Int = 0): android.widget.TwoLineListItem = themedTwoLineListItem(theme) {}
inline fun Context.themedTwoLineListItem(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TwoLineListItem).() -> Unit): android.widget.TwoLineListItem {
return ankoView(`$$Anko$Factories$Sdk25View`.TWO_LINE_LIST_ITEM, theme) { init() }
}

inline fun Activity.twoLineListItem(): android.widget.TwoLineListItem = twoLineListItem() {}
inline fun Activity.twoLineListItem(init: (@AnkoViewDslMarker android.widget.TwoLineListItem).() -> Unit): android.widget.TwoLineListItem {
    return ankoView(`$$Anko$Factories$Sdk25View`.TWO_LINE_LIST_ITEM, theme = 0) { init() }
}

inline fun Activity.themedTwoLineListItem(theme: Int = 0): android.widget.TwoLineListItem = themedTwoLineListItem(theme) {}
inline fun Activity.themedTwoLineListItem(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.TwoLineListItem).() -> Unit): android.widget.TwoLineListItem {
return ankoView(`$$Anko$Factories$Sdk25View`.TWO_LINE_LIST_ITEM, theme) { init() }
}

inline fun ViewManager.videoView(): android.widget.VideoView = videoView() {}
inline fun ViewManager.videoView(init: (@AnkoViewDslMarker android.widget.VideoView).() -> Unit): android.widget.VideoView {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIDEO_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedVideoView(theme: Int = 0): android.widget.VideoView = themedVideoView(theme) {}
inline fun ViewManager.themedVideoView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.VideoView).() -> Unit): android.widget.VideoView {
return ankoView(`$$Anko$Factories$Sdk25View`.VIDEO_VIEW, theme) { init() }
}

inline fun ViewManager.viewFlipper(): android.widget.ViewFlipper = viewFlipper() {}
inline fun ViewManager.viewFlipper(init: (@AnkoViewDslMarker android.widget.ViewFlipper).() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme = 0) { init() }
}

inline fun ViewManager.themedViewFlipper(theme: Int = 0): android.widget.ViewFlipper = themedViewFlipper(theme) {}
inline fun ViewManager.themedViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ViewFlipper).() -> Unit): android.widget.ViewFlipper {
return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme) { init() }
}

inline fun Context.viewFlipper(): android.widget.ViewFlipper = viewFlipper() {}
inline fun Context.viewFlipper(init: (@AnkoViewDslMarker android.widget.ViewFlipper).() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme = 0) { init() }
}

inline fun Context.themedViewFlipper(theme: Int = 0): android.widget.ViewFlipper = themedViewFlipper(theme) {}
inline fun Context.themedViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ViewFlipper).() -> Unit): android.widget.ViewFlipper {
return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme) { init() }
}

inline fun Activity.viewFlipper(): android.widget.ViewFlipper = viewFlipper() {}
inline fun Activity.viewFlipper(init: (@AnkoViewDslMarker android.widget.ViewFlipper).() -> Unit): android.widget.ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme = 0) { init() }
}

inline fun Activity.themedViewFlipper(theme: Int = 0): android.widget.ViewFlipper = themedViewFlipper(theme) {}
inline fun Activity.themedViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ViewFlipper).() -> Unit): android.widget.ViewFlipper {
return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme) { init() }
}

inline fun ViewManager.zoomButton(): android.widget.ZoomButton = zoomButton() {}
inline fun ViewManager.zoomButton(init: (@AnkoViewDslMarker android.widget.ZoomButton).() -> Unit): android.widget.ZoomButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_BUTTON, theme = 0) { init() }
}

inline fun ViewManager.themedZoomButton(theme: Int = 0): android.widget.ZoomButton = themedZoomButton(theme) {}
inline fun ViewManager.themedZoomButton(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ZoomButton).() -> Unit): android.widget.ZoomButton {
return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_BUTTON, theme) { init() }
}

inline fun ViewManager.zoomControls(): android.widget.ZoomControls = zoomControls() {}
inline fun ViewManager.zoomControls(init: (@AnkoViewDslMarker android.widget.ZoomControls).() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_CONTROLS, theme = 0) { init() }
}

inline fun ViewManager.themedZoomControls(theme: Int = 0): android.widget.ZoomControls = themedZoomControls(theme) {}
inline fun ViewManager.themedZoomControls(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ZoomControls).() -> Unit): android.widget.ZoomControls {
return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_CONTROLS, theme) { init() }
}

inline fun Context.zoomControls(): android.widget.ZoomControls = zoomControls() {}
inline fun Context.zoomControls(init: (@AnkoViewDslMarker android.widget.ZoomControls).() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_CONTROLS, theme = 0) { init() }
}

inline fun Context.themedZoomControls(theme: Int = 0): android.widget.ZoomControls = themedZoomControls(theme) {}
inline fun Context.themedZoomControls(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ZoomControls).() -> Unit): android.widget.ZoomControls {
return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_CONTROLS, theme) { init() }
}

inline fun Activity.zoomControls(): android.widget.ZoomControls = zoomControls() {}
inline fun Activity.zoomControls(init: (@AnkoViewDslMarker android.widget.ZoomControls).() -> Unit): android.widget.ZoomControls {
    return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_CONTROLS, theme = 0) { init() }
}

inline fun Activity.themedZoomControls(theme: Int = 0): android.widget.ZoomControls = themedZoomControls(theme) {}
inline fun Activity.themedZoomControls(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ZoomControls).() -> Unit): android.widget.ZoomControls {
return ankoView(`$$Anko$Factories$Sdk25View`.ZOOM_CONTROLS, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$Sdk25ViewGroup` {
    val APP_WIDGET_HOST_VIEW = { ctx: Context -> _AppWidgetHostView(ctx) }
    val ABSOLUTE_LAYOUT = { ctx: Context -> _AbsoluteLayout(ctx) }
    val ACTION_MENU_VIEW = { ctx: Context -> _ActionMenuView(ctx) }
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
    val TOOLBAR = { ctx: Context -> _Toolbar(ctx) }
    val VIEW_ANIMATOR = { ctx: Context -> _ViewAnimator(ctx) }
    val VIEW_SWITCHER = { ctx: Context -> _ViewSwitcher(ctx) }
}

inline fun ViewManager.appWidgetHostView(): android.appwidget.AppWidgetHostView = appWidgetHostView() {}
inline fun ViewManager.appWidgetHostView(init: (@AnkoViewDslMarker _AppWidgetHostView).() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.APP_WIDGET_HOST_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedAppWidgetHostView(theme: Int = 0): android.appwidget.AppWidgetHostView = themedAppWidgetHostView(theme) {}
inline fun ViewManager.themedAppWidgetHostView(theme: Int = 0, init: (@AnkoViewDslMarker _AppWidgetHostView).() -> Unit): android.appwidget.AppWidgetHostView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.APP_WIDGET_HOST_VIEW, theme) { init() }
}

inline fun Context.appWidgetHostView(): android.appwidget.AppWidgetHostView = appWidgetHostView() {}
inline fun Context.appWidgetHostView(init: (@AnkoViewDslMarker _AppWidgetHostView).() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.APP_WIDGET_HOST_VIEW, theme = 0) { init() }
}

inline fun Context.themedAppWidgetHostView(theme: Int = 0): android.appwidget.AppWidgetHostView = themedAppWidgetHostView(theme) {}
inline fun Context.themedAppWidgetHostView(theme: Int = 0, init: (@AnkoViewDslMarker _AppWidgetHostView).() -> Unit): android.appwidget.AppWidgetHostView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.APP_WIDGET_HOST_VIEW, theme) { init() }
}

inline fun Activity.appWidgetHostView(): android.appwidget.AppWidgetHostView = appWidgetHostView() {}
inline fun Activity.appWidgetHostView(init: (@AnkoViewDslMarker _AppWidgetHostView).() -> Unit): android.appwidget.AppWidgetHostView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.APP_WIDGET_HOST_VIEW, theme = 0) { init() }
}

inline fun Activity.themedAppWidgetHostView(theme: Int = 0): android.appwidget.AppWidgetHostView = themedAppWidgetHostView(theme) {}
inline fun Activity.themedAppWidgetHostView(theme: Int = 0, init: (@AnkoViewDslMarker _AppWidgetHostView).() -> Unit): android.appwidget.AppWidgetHostView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.APP_WIDGET_HOST_VIEW, theme) { init() }
}

inline fun ViewManager.absoluteLayout(): android.widget.AbsoluteLayout = absoluteLayout() {}
inline fun ViewManager.absoluteLayout(init: (@AnkoViewDslMarker _AbsoluteLayout).() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ABSOLUTE_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedAbsoluteLayout(theme: Int = 0): android.widget.AbsoluteLayout = themedAbsoluteLayout(theme) {}
inline fun ViewManager.themedAbsoluteLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AbsoluteLayout).() -> Unit): android.widget.AbsoluteLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ABSOLUTE_LAYOUT, theme) { init() }
}

inline fun Context.absoluteLayout(): android.widget.AbsoluteLayout = absoluteLayout() {}
inline fun Context.absoluteLayout(init: (@AnkoViewDslMarker _AbsoluteLayout).() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ABSOLUTE_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedAbsoluteLayout(theme: Int = 0): android.widget.AbsoluteLayout = themedAbsoluteLayout(theme) {}
inline fun Context.themedAbsoluteLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AbsoluteLayout).() -> Unit): android.widget.AbsoluteLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ABSOLUTE_LAYOUT, theme) { init() }
}

inline fun Activity.absoluteLayout(): android.widget.AbsoluteLayout = absoluteLayout() {}
inline fun Activity.absoluteLayout(init: (@AnkoViewDslMarker _AbsoluteLayout).() -> Unit): android.widget.AbsoluteLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ABSOLUTE_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedAbsoluteLayout(theme: Int = 0): android.widget.AbsoluteLayout = themedAbsoluteLayout(theme) {}
inline fun Activity.themedAbsoluteLayout(theme: Int = 0, init: (@AnkoViewDslMarker _AbsoluteLayout).() -> Unit): android.widget.AbsoluteLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ABSOLUTE_LAYOUT, theme) { init() }
}

inline fun ViewManager.actionMenuView(): android.widget.ActionMenuView = actionMenuView() {}
inline fun ViewManager.actionMenuView(init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedActionMenuView(theme: Int = 0): android.widget.ActionMenuView = themedActionMenuView(theme) {}
inline fun ViewManager.themedActionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.widget.ActionMenuView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

inline fun Context.actionMenuView(): android.widget.ActionMenuView = actionMenuView() {}
inline fun Context.actionMenuView(init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme = 0) { init() }
}

inline fun Context.themedActionMenuView(theme: Int = 0): android.widget.ActionMenuView = themedActionMenuView(theme) {}
inline fun Context.themedActionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.widget.ActionMenuView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

inline fun Activity.actionMenuView(): android.widget.ActionMenuView = actionMenuView() {}
inline fun Activity.actionMenuView(init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.widget.ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme = 0) { init() }
}

inline fun Activity.themedActionMenuView(theme: Int = 0): android.widget.ActionMenuView = themedActionMenuView(theme) {}
inline fun Activity.themedActionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): android.widget.ActionMenuView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

inline fun ViewManager.frameLayout(): android.widget.FrameLayout = frameLayout() {}
inline fun ViewManager.frameLayout(init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedFrameLayout(theme: Int = 0): android.widget.FrameLayout = themedFrameLayout(theme) {}
inline fun ViewManager.themedFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): android.widget.FrameLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

inline fun Context.frameLayout(): android.widget.FrameLayout = frameLayout() {}
inline fun Context.frameLayout(init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedFrameLayout(theme: Int = 0): android.widget.FrameLayout = themedFrameLayout(theme) {}
inline fun Context.themedFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): android.widget.FrameLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

inline fun Activity.frameLayout(): android.widget.FrameLayout = frameLayout() {}
inline fun Activity.frameLayout(init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): android.widget.FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedFrameLayout(theme: Int = 0): android.widget.FrameLayout = themedFrameLayout(theme) {}
inline fun Activity.themedFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): android.widget.FrameLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

inline fun ViewManager.gallery(): android.widget.Gallery = gallery() {}
inline fun ViewManager.gallery(init: (@AnkoViewDslMarker _Gallery).() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GALLERY, theme = 0) { init() }
}

inline fun ViewManager.themedGallery(theme: Int = 0): android.widget.Gallery = themedGallery(theme) {}
inline fun ViewManager.themedGallery(theme: Int = 0, init: (@AnkoViewDslMarker _Gallery).() -> Unit): android.widget.Gallery {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GALLERY, theme) { init() }
}

inline fun Context.gallery(): android.widget.Gallery = gallery() {}
inline fun Context.gallery(init: (@AnkoViewDslMarker _Gallery).() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GALLERY, theme = 0) { init() }
}

inline fun Context.themedGallery(theme: Int = 0): android.widget.Gallery = themedGallery(theme) {}
inline fun Context.themedGallery(theme: Int = 0, init: (@AnkoViewDslMarker _Gallery).() -> Unit): android.widget.Gallery {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GALLERY, theme) { init() }
}

inline fun Activity.gallery(): android.widget.Gallery = gallery() {}
inline fun Activity.gallery(init: (@AnkoViewDslMarker _Gallery).() -> Unit): android.widget.Gallery {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GALLERY, theme = 0) { init() }
}

inline fun Activity.themedGallery(theme: Int = 0): android.widget.Gallery = themedGallery(theme) {}
inline fun Activity.themedGallery(theme: Int = 0, init: (@AnkoViewDslMarker _Gallery).() -> Unit): android.widget.Gallery {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GALLERY, theme) { init() }
}

inline fun ViewManager.gridLayout(): android.widget.GridLayout = gridLayout() {}
inline fun ViewManager.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedGridLayout(theme: Int = 0): android.widget.GridLayout = themedGridLayout(theme) {}
inline fun ViewManager.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.widget.GridLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun Context.gridLayout(): android.widget.GridLayout = gridLayout() {}
inline fun Context.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedGridLayout(theme: Int = 0): android.widget.GridLayout = themedGridLayout(theme) {}
inline fun Context.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.widget.GridLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun Activity.gridLayout(): android.widget.GridLayout = gridLayout() {}
inline fun Activity.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.widget.GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedGridLayout(theme: Int = 0): android.widget.GridLayout = themedGridLayout(theme) {}
inline fun Activity.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): android.widget.GridLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme) { init() }
}

inline fun ViewManager.gridView(): android.widget.GridView = gridView() {}
inline fun ViewManager.gridView(init: (@AnkoViewDslMarker _GridView).() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedGridView(theme: Int = 0): android.widget.GridView = themedGridView(theme) {}
inline fun ViewManager.themedGridView(theme: Int = 0, init: (@AnkoViewDslMarker _GridView).() -> Unit): android.widget.GridView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme) { init() }
}

inline fun Context.gridView(): android.widget.GridView = gridView() {}
inline fun Context.gridView(init: (@AnkoViewDslMarker _GridView).() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme = 0) { init() }
}

inline fun Context.themedGridView(theme: Int = 0): android.widget.GridView = themedGridView(theme) {}
inline fun Context.themedGridView(theme: Int = 0, init: (@AnkoViewDslMarker _GridView).() -> Unit): android.widget.GridView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme) { init() }
}

inline fun Activity.gridView(): android.widget.GridView = gridView() {}
inline fun Activity.gridView(init: (@AnkoViewDslMarker _GridView).() -> Unit): android.widget.GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme = 0) { init() }
}

inline fun Activity.themedGridView(theme: Int = 0): android.widget.GridView = themedGridView(theme) {}
inline fun Activity.themedGridView(theme: Int = 0, init: (@AnkoViewDslMarker _GridView).() -> Unit): android.widget.GridView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme) { init() }
}

inline fun ViewManager.horizontalScrollView(): android.widget.HorizontalScrollView = horizontalScrollView() {}
inline fun ViewManager.horizontalScrollView(init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedHorizontalScrollView(theme: Int = 0): android.widget.HorizontalScrollView = themedHorizontalScrollView(theme) {}
inline fun ViewManager.themedHorizontalScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): android.widget.HorizontalScrollView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

inline fun Context.horizontalScrollView(): android.widget.HorizontalScrollView = horizontalScrollView() {}
inline fun Context.horizontalScrollView(init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme = 0) { init() }
}

inline fun Context.themedHorizontalScrollView(theme: Int = 0): android.widget.HorizontalScrollView = themedHorizontalScrollView(theme) {}
inline fun Context.themedHorizontalScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): android.widget.HorizontalScrollView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

inline fun Activity.horizontalScrollView(): android.widget.HorizontalScrollView = horizontalScrollView() {}
inline fun Activity.horizontalScrollView(init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): android.widget.HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme = 0) { init() }
}

inline fun Activity.themedHorizontalScrollView(theme: Int = 0): android.widget.HorizontalScrollView = themedHorizontalScrollView(theme) {}
inline fun Activity.themedHorizontalScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): android.widget.HorizontalScrollView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

inline fun ViewManager.imageSwitcher(): android.widget.ImageSwitcher = imageSwitcher() {}
inline fun ViewManager.imageSwitcher(init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme = 0) { init() }
}

inline fun ViewManager.themedImageSwitcher(theme: Int = 0): android.widget.ImageSwitcher = themedImageSwitcher(theme) {}
inline fun ViewManager.themedImageSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): android.widget.ImageSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

inline fun Context.imageSwitcher(): android.widget.ImageSwitcher = imageSwitcher() {}
inline fun Context.imageSwitcher(init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme = 0) { init() }
}

inline fun Context.themedImageSwitcher(theme: Int = 0): android.widget.ImageSwitcher = themedImageSwitcher(theme) {}
inline fun Context.themedImageSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): android.widget.ImageSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

inline fun Activity.imageSwitcher(): android.widget.ImageSwitcher = imageSwitcher() {}
inline fun Activity.imageSwitcher(init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): android.widget.ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme = 0) { init() }
}

inline fun Activity.themedImageSwitcher(theme: Int = 0): android.widget.ImageSwitcher = themedImageSwitcher(theme) {}
inline fun Activity.themedImageSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): android.widget.ImageSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

inline fun ViewManager.linearLayout(): android.widget.LinearLayout = linearLayout() {}
inline fun ViewManager.linearLayout(init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedLinearLayout(theme: Int = 0): android.widget.LinearLayout = themedLinearLayout(theme) {}
inline fun ViewManager.themedLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): android.widget.LinearLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

inline fun Context.linearLayout(): android.widget.LinearLayout = linearLayout() {}
inline fun Context.linearLayout(init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedLinearLayout(theme: Int = 0): android.widget.LinearLayout = themedLinearLayout(theme) {}
inline fun Context.themedLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): android.widget.LinearLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

inline fun Activity.linearLayout(): android.widget.LinearLayout = linearLayout() {}
inline fun Activity.linearLayout(init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): android.widget.LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedLinearLayout(theme: Int = 0): android.widget.LinearLayout = themedLinearLayout(theme) {}
inline fun Activity.themedLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): android.widget.LinearLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

inline fun ViewManager.radioGroup(): android.widget.RadioGroup = radioGroup() {}
inline fun ViewManager.radioGroup(init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme = 0) { init() }
}

inline fun ViewManager.themedRadioGroup(theme: Int = 0): android.widget.RadioGroup = themedRadioGroup(theme) {}
inline fun ViewManager.themedRadioGroup(theme: Int = 0, init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): android.widget.RadioGroup {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme) { init() }
}

inline fun Context.radioGroup(): android.widget.RadioGroup = radioGroup() {}
inline fun Context.radioGroup(init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme = 0) { init() }
}

inline fun Context.themedRadioGroup(theme: Int = 0): android.widget.RadioGroup = themedRadioGroup(theme) {}
inline fun Context.themedRadioGroup(theme: Int = 0, init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): android.widget.RadioGroup {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme) { init() }
}

inline fun Activity.radioGroup(): android.widget.RadioGroup = radioGroup() {}
inline fun Activity.radioGroup(init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): android.widget.RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme = 0) { init() }
}

inline fun Activity.themedRadioGroup(theme: Int = 0): android.widget.RadioGroup = themedRadioGroup(theme) {}
inline fun Activity.themedRadioGroup(theme: Int = 0, init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): android.widget.RadioGroup {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme) { init() }
}

inline fun ViewManager.relativeLayout(): android.widget.RelativeLayout = relativeLayout() {}
inline fun ViewManager.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedRelativeLayout(theme: Int = 0): android.widget.RelativeLayout = themedRelativeLayout(theme) {}
inline fun ViewManager.themedRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

inline fun Context.relativeLayout(): android.widget.RelativeLayout = relativeLayout() {}
inline fun Context.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedRelativeLayout(theme: Int = 0): android.widget.RelativeLayout = themedRelativeLayout(theme) {}
inline fun Context.themedRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

inline fun Activity.relativeLayout(): android.widget.RelativeLayout = relativeLayout() {}
inline fun Activity.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedRelativeLayout(theme: Int = 0): android.widget.RelativeLayout = themedRelativeLayout(theme) {}
inline fun Activity.themedRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

inline fun ViewManager.scrollView(): android.widget.ScrollView = scrollView() {}
inline fun ViewManager.scrollView(init: (@AnkoViewDslMarker _ScrollView).() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme = 0) { init() }
}

inline fun ViewManager.themedScrollView(theme: Int = 0): android.widget.ScrollView = themedScrollView(theme) {}
inline fun ViewManager.themedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollView).() -> Unit): android.widget.ScrollView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme) { init() }
}

inline fun Context.scrollView(): android.widget.ScrollView = scrollView() {}
inline fun Context.scrollView(init: (@AnkoViewDslMarker _ScrollView).() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme = 0) { init() }
}

inline fun Context.themedScrollView(theme: Int = 0): android.widget.ScrollView = themedScrollView(theme) {}
inline fun Context.themedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollView).() -> Unit): android.widget.ScrollView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme) { init() }
}

inline fun Activity.scrollView(): android.widget.ScrollView = scrollView() {}
inline fun Activity.scrollView(init: (@AnkoViewDslMarker _ScrollView).() -> Unit): android.widget.ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme = 0) { init() }
}

inline fun Activity.themedScrollView(theme: Int = 0): android.widget.ScrollView = themedScrollView(theme) {}
inline fun Activity.themedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollView).() -> Unit): android.widget.ScrollView {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme) { init() }
}

inline fun ViewManager.tableLayout(): android.widget.TableLayout = tableLayout() {}
inline fun ViewManager.tableLayout(init: (@AnkoViewDslMarker _TableLayout).() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme = 0) { init() }
}

inline fun ViewManager.themedTableLayout(theme: Int = 0): android.widget.TableLayout = themedTableLayout(theme) {}
inline fun ViewManager.themedTableLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TableLayout).() -> Unit): android.widget.TableLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

inline fun Context.tableLayout(): android.widget.TableLayout = tableLayout() {}
inline fun Context.tableLayout(init: (@AnkoViewDslMarker _TableLayout).() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme = 0) { init() }
}

inline fun Context.themedTableLayout(theme: Int = 0): android.widget.TableLayout = themedTableLayout(theme) {}
inline fun Context.themedTableLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TableLayout).() -> Unit): android.widget.TableLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

inline fun Activity.tableLayout(): android.widget.TableLayout = tableLayout() {}
inline fun Activity.tableLayout(init: (@AnkoViewDslMarker _TableLayout).() -> Unit): android.widget.TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme = 0) { init() }
}

inline fun Activity.themedTableLayout(theme: Int = 0): android.widget.TableLayout = themedTableLayout(theme) {}
inline fun Activity.themedTableLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TableLayout).() -> Unit): android.widget.TableLayout {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

inline fun ViewManager.tableRow(): android.widget.TableRow = tableRow() {}
inline fun ViewManager.tableRow(init: (@AnkoViewDslMarker _TableRow).() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme = 0) { init() }
}

inline fun ViewManager.themedTableRow(theme: Int = 0): android.widget.TableRow = themedTableRow(theme) {}
inline fun ViewManager.themedTableRow(theme: Int = 0, init: (@AnkoViewDslMarker _TableRow).() -> Unit): android.widget.TableRow {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme) { init() }
}

inline fun Context.tableRow(): android.widget.TableRow = tableRow() {}
inline fun Context.tableRow(init: (@AnkoViewDslMarker _TableRow).() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme = 0) { init() }
}

inline fun Context.themedTableRow(theme: Int = 0): android.widget.TableRow = themedTableRow(theme) {}
inline fun Context.themedTableRow(theme: Int = 0, init: (@AnkoViewDslMarker _TableRow).() -> Unit): android.widget.TableRow {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme) { init() }
}

inline fun Activity.tableRow(): android.widget.TableRow = tableRow() {}
inline fun Activity.tableRow(init: (@AnkoViewDslMarker _TableRow).() -> Unit): android.widget.TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme = 0) { init() }
}

inline fun Activity.themedTableRow(theme: Int = 0): android.widget.TableRow = themedTableRow(theme) {}
inline fun Activity.themedTableRow(theme: Int = 0, init: (@AnkoViewDslMarker _TableRow).() -> Unit): android.widget.TableRow {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme) { init() }
}

inline fun ViewManager.textSwitcher(): android.widget.TextSwitcher = textSwitcher() {}
inline fun ViewManager.textSwitcher(init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme = 0) { init() }
}

inline fun ViewManager.themedTextSwitcher(theme: Int = 0): android.widget.TextSwitcher = themedTextSwitcher(theme) {}
inline fun ViewManager.themedTextSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): android.widget.TextSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

inline fun Context.textSwitcher(): android.widget.TextSwitcher = textSwitcher() {}
inline fun Context.textSwitcher(init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme = 0) { init() }
}

inline fun Context.themedTextSwitcher(theme: Int = 0): android.widget.TextSwitcher = themedTextSwitcher(theme) {}
inline fun Context.themedTextSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): android.widget.TextSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

inline fun Activity.textSwitcher(): android.widget.TextSwitcher = textSwitcher() {}
inline fun Activity.textSwitcher(init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): android.widget.TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme = 0) { init() }
}

inline fun Activity.themedTextSwitcher(theme: Int = 0): android.widget.TextSwitcher = themedTextSwitcher(theme) {}
inline fun Activity.themedTextSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): android.widget.TextSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

inline fun ViewManager.toolbar(): android.widget.Toolbar = toolbar() {}
inline fun ViewManager.toolbar(init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.widget.Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme = 0) { init() }
}

inline fun ViewManager.themedToolbar(theme: Int = 0): android.widget.Toolbar = themedToolbar(theme) {}
inline fun ViewManager.themedToolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.widget.Toolbar {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme) { init() }
}

inline fun Context.toolbar(): android.widget.Toolbar = toolbar() {}
inline fun Context.toolbar(init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.widget.Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme = 0) { init() }
}

inline fun Context.themedToolbar(theme: Int = 0): android.widget.Toolbar = themedToolbar(theme) {}
inline fun Context.themedToolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.widget.Toolbar {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme) { init() }
}

inline fun Activity.toolbar(): android.widget.Toolbar = toolbar() {}
inline fun Activity.toolbar(init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.widget.Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme = 0) { init() }
}

inline fun Activity.themedToolbar(theme: Int = 0): android.widget.Toolbar = themedToolbar(theme) {}
inline fun Activity.themedToolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): android.widget.Toolbar {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme) { init() }
}

inline fun ViewManager.viewAnimator(): android.widget.ViewAnimator = viewAnimator() {}
inline fun ViewManager.viewAnimator(init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme = 0) { init() }
}

inline fun ViewManager.themedViewAnimator(theme: Int = 0): android.widget.ViewAnimator = themedViewAnimator(theme) {}
inline fun ViewManager.themedViewAnimator(theme: Int = 0, init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): android.widget.ViewAnimator {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

inline fun Context.viewAnimator(): android.widget.ViewAnimator = viewAnimator() {}
inline fun Context.viewAnimator(init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme = 0) { init() }
}

inline fun Context.themedViewAnimator(theme: Int = 0): android.widget.ViewAnimator = themedViewAnimator(theme) {}
inline fun Context.themedViewAnimator(theme: Int = 0, init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): android.widget.ViewAnimator {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

inline fun Activity.viewAnimator(): android.widget.ViewAnimator = viewAnimator() {}
inline fun Activity.viewAnimator(init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): android.widget.ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme = 0) { init() }
}

inline fun Activity.themedViewAnimator(theme: Int = 0): android.widget.ViewAnimator = themedViewAnimator(theme) {}
inline fun Activity.themedViewAnimator(theme: Int = 0, init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): android.widget.ViewAnimator {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

inline fun ViewManager.viewSwitcher(): android.widget.ViewSwitcher = viewSwitcher() {}
inline fun ViewManager.viewSwitcher(init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme = 0) { init() }
}

inline fun ViewManager.themedViewSwitcher(theme: Int = 0): android.widget.ViewSwitcher = themedViewSwitcher(theme) {}
inline fun ViewManager.themedViewSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): android.widget.ViewSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

inline fun Context.viewSwitcher(): android.widget.ViewSwitcher = viewSwitcher() {}
inline fun Context.viewSwitcher(init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme = 0) { init() }
}

inline fun Context.themedViewSwitcher(theme: Int = 0): android.widget.ViewSwitcher = themedViewSwitcher(theme) {}
inline fun Context.themedViewSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): android.widget.ViewSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

inline fun Activity.viewSwitcher(): android.widget.ViewSwitcher = viewSwitcher() {}
inline fun Activity.viewSwitcher(init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): android.widget.ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme = 0) { init() }
}

inline fun Activity.themedViewSwitcher(theme: Int = 0): android.widget.ViewSwitcher = themedViewSwitcher(theme) {}
inline fun Activity.themedViewSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): android.widget.ViewSwitcher {
return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

