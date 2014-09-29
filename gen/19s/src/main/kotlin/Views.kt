package kotlinx.android.koan

import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.app.Fragment
import android.content.Context

public fun ViewManager.view(init: android.view.View.() -> Unit = {}): android.view.View =
  addView(android.view.View(dslContext), init, this)
public fun Activity.view(init: android.view.View.() -> Unit = {}): android.view.View =
  addActivityTopLevelView(android.view.View(this), init)
public fun Fragment.view(init: android.view.View.() -> Unit = {}): android.view.View =
  addFragmentTopLevelView(android.view.View(getActivity()!!), init)
public fun Context.view(init: android.view.View.() -> Unit = {}): android.view.View =
  addContextTopLevelView(android.view.View(this), init)

public fun ViewManager.mediaRouteButton(init: android.app.MediaRouteButton.() -> Unit = {}): android.app.MediaRouteButton =
  addView(android.app.MediaRouteButton(dslContext), init, this)
public fun Activity.mediaRouteButton(init: android.app.MediaRouteButton.() -> Unit = {}): android.app.MediaRouteButton =
  addActivityTopLevelView(android.app.MediaRouteButton(this), init)
public fun Fragment.mediaRouteButton(init: android.app.MediaRouteButton.() -> Unit = {}): android.app.MediaRouteButton =
  addFragmentTopLevelView(android.app.MediaRouteButton(getActivity()!!), init)
public fun Context.mediaRouteButton(init: android.app.MediaRouteButton.() -> Unit = {}): android.app.MediaRouteButton =
  addContextTopLevelView(android.app.MediaRouteButton(this), init)

public fun ViewManager.surfaceView(init: android.view.SurfaceView.() -> Unit = {}): android.view.SurfaceView =
  addView(android.view.SurfaceView(dslContext), init, this)
public fun Activity.surfaceView(init: android.view.SurfaceView.() -> Unit = {}): android.view.SurfaceView =
  addActivityTopLevelView(android.view.SurfaceView(this), init)
public fun Fragment.surfaceView(init: android.view.SurfaceView.() -> Unit = {}): android.view.SurfaceView =
  addFragmentTopLevelView(android.view.SurfaceView(getActivity()!!), init)
public fun Context.surfaceView(init: android.view.SurfaceView.() -> Unit = {}): android.view.SurfaceView =
  addContextTopLevelView(android.view.SurfaceView(this), init)

public fun ViewManager.textureView(init: android.view.TextureView.() -> Unit = {}): android.view.TextureView =
  addView(android.view.TextureView(dslContext), init, this)
public fun Activity.textureView(init: android.view.TextureView.() -> Unit = {}): android.view.TextureView =
  addActivityTopLevelView(android.view.TextureView(this), init)
public fun Fragment.textureView(init: android.view.TextureView.() -> Unit = {}): android.view.TextureView =
  addFragmentTopLevelView(android.view.TextureView(getActivity()!!), init)
public fun Context.textureView(init: android.view.TextureView.() -> Unit = {}): android.view.TextureView =
  addContextTopLevelView(android.view.TextureView(this), init)

public fun ViewManager.viewStub(init: android.view.ViewStub.() -> Unit = {}): android.view.ViewStub =
  addView(android.view.ViewStub(dslContext), init, this)
public fun Activity.viewStub(init: android.view.ViewStub.() -> Unit = {}): android.view.ViewStub =
  addActivityTopLevelView(android.view.ViewStub(this), init)
public fun Fragment.viewStub(init: android.view.ViewStub.() -> Unit = {}): android.view.ViewStub =
  addFragmentTopLevelView(android.view.ViewStub(getActivity()!!), init)
public fun Context.viewStub(init: android.view.ViewStub.() -> Unit = {}): android.view.ViewStub =
  addContextTopLevelView(android.view.ViewStub(this), init)

public fun ViewManager.textView(init: android.widget.TextView.() -> Unit = {}): android.widget.TextView =
  addView(android.widget.TextView(dslContext), init, this)
public fun Activity.textView(init: android.widget.TextView.() -> Unit = {}): android.widget.TextView =
  addActivityTopLevelView(android.widget.TextView(this), init)
public fun Fragment.textView(init: android.widget.TextView.() -> Unit = {}): android.widget.TextView =
  addFragmentTopLevelView(android.widget.TextView(getActivity()!!), init)
public fun Context.textView(init: android.widget.TextView.() -> Unit = {}): android.widget.TextView =
  addContextTopLevelView(android.widget.TextView(this), init)

public fun ViewManager.progressBar(init: android.widget.ProgressBar.() -> Unit = {}): android.widget.ProgressBar =
  addView(android.widget.ProgressBar(dslContext), init, this)
public fun Activity.progressBar(init: android.widget.ProgressBar.() -> Unit = {}): android.widget.ProgressBar =
  addActivityTopLevelView(android.widget.ProgressBar(this), init)
public fun Fragment.progressBar(init: android.widget.ProgressBar.() -> Unit = {}): android.widget.ProgressBar =
  addFragmentTopLevelView(android.widget.ProgressBar(getActivity()!!), init)
public fun Context.progressBar(init: android.widget.ProgressBar.() -> Unit = {}): android.widget.ProgressBar =
  addContextTopLevelView(android.widget.ProgressBar(this), init)

public fun ViewManager.space(init: android.widget.Space.() -> Unit = {}): android.widget.Space =
  addView(android.widget.Space(dslContext), init, this)
public fun Activity.space(init: android.widget.Space.() -> Unit = {}): android.widget.Space =
  addActivityTopLevelView(android.widget.Space(this), init)
public fun Fragment.space(init: android.widget.Space.() -> Unit = {}): android.widget.Space =
  addFragmentTopLevelView(android.widget.Space(getActivity()!!), init)
public fun Context.space(init: android.widget.Space.() -> Unit = {}): android.widget.Space =
  addContextTopLevelView(android.widget.Space(this), init)

public fun ViewManager.imageView(init: android.widget.ImageView.() -> Unit = {}): android.widget.ImageView =
  addView(android.widget.ImageView(dslContext), init, this)
public fun Activity.imageView(init: android.widget.ImageView.() -> Unit = {}): android.widget.ImageView =
  addActivityTopLevelView(android.widget.ImageView(this), init)
public fun Fragment.imageView(init: android.widget.ImageView.() -> Unit = {}): android.widget.ImageView =
  addFragmentTopLevelView(android.widget.ImageView(getActivity()!!), init)
public fun Context.imageView(init: android.widget.ImageView.() -> Unit = {}): android.widget.ImageView =
  addContextTopLevelView(android.widget.ImageView(this), init)

public fun ViewManager.analogClock(init: android.widget.AnalogClock.() -> Unit = {}): android.widget.AnalogClock =
  addView(android.widget.AnalogClock(dslContext), init, this)
public fun Activity.analogClock(init: android.widget.AnalogClock.() -> Unit = {}): android.widget.AnalogClock =
  addActivityTopLevelView(android.widget.AnalogClock(this), init)
public fun Fragment.analogClock(init: android.widget.AnalogClock.() -> Unit = {}): android.widget.AnalogClock =
  addFragmentTopLevelView(android.widget.AnalogClock(getActivity()!!), init)
public fun Context.analogClock(init: android.widget.AnalogClock.() -> Unit = {}): android.widget.AnalogClock =
  addContextTopLevelView(android.widget.AnalogClock(this), init)

public fun ViewManager.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit = {}): android.support.v4.widget.SwipeRefreshLayout =
  addView(android.support.v4.widget.SwipeRefreshLayout(dslContext), init, this)
public fun Activity.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit = {}): android.support.v4.widget.SwipeRefreshLayout =
  addActivityTopLevelView(android.support.v4.widget.SwipeRefreshLayout(this), init)
public fun Fragment.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit = {}): android.support.v4.widget.SwipeRefreshLayout =
  addFragmentTopLevelView(android.support.v4.widget.SwipeRefreshLayout(getActivity()!!), init)
public fun Context.swipeRefreshLayout(init: android.support.v4.widget.SwipeRefreshLayout.() -> Unit = {}): android.support.v4.widget.SwipeRefreshLayout =
  addContextTopLevelView(android.support.v4.widget.SwipeRefreshLayout(this), init)

public fun ViewManager.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit = {}): android.support.v4.view.PagerTitleStrip =
  addView(android.support.v4.view.PagerTitleStrip(dslContext), init, this)
public fun Activity.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit = {}): android.support.v4.view.PagerTitleStrip =
  addActivityTopLevelView(android.support.v4.view.PagerTitleStrip(this), init)
public fun Fragment.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit = {}): android.support.v4.view.PagerTitleStrip =
  addFragmentTopLevelView(android.support.v4.view.PagerTitleStrip(getActivity()!!), init)
public fun Context.pagerTitleStrip(init: android.support.v4.view.PagerTitleStrip.() -> Unit = {}): android.support.v4.view.PagerTitleStrip =
  addContextTopLevelView(android.support.v4.view.PagerTitleStrip(this), init)

public fun ViewManager.gLSurfaceView(init: android.opengl.GLSurfaceView.() -> Unit = {}): android.opengl.GLSurfaceView =
  addView(android.opengl.GLSurfaceView(dslContext), init, this)
public fun Activity.gLSurfaceView(init: android.opengl.GLSurfaceView.() -> Unit = {}): android.opengl.GLSurfaceView =
  addActivityTopLevelView(android.opengl.GLSurfaceView(this), init)
public fun Fragment.gLSurfaceView(init: android.opengl.GLSurfaceView.() -> Unit = {}): android.opengl.GLSurfaceView =
  addFragmentTopLevelView(android.opengl.GLSurfaceView(getActivity()!!), init)
public fun Context.gLSurfaceView(init: android.opengl.GLSurfaceView.() -> Unit = {}): android.opengl.GLSurfaceView =
  addContextTopLevelView(android.opengl.GLSurfaceView(this), init)

public fun ViewManager.videoView(init: android.widget.VideoView.() -> Unit = {}): android.widget.VideoView =
  addView(android.widget.VideoView(dslContext), init, this)
public fun Activity.videoView(init: android.widget.VideoView.() -> Unit = {}): android.widget.VideoView =
  addActivityTopLevelView(android.widget.VideoView(this), init)
public fun Fragment.videoView(init: android.widget.VideoView.() -> Unit = {}): android.widget.VideoView =
  addFragmentTopLevelView(android.widget.VideoView(getActivity()!!), init)
public fun Context.videoView(init: android.widget.VideoView.() -> Unit = {}): android.widget.VideoView =
  addContextTopLevelView(android.widget.VideoView(this), init)

public fun ViewManager.digitalClock(init: android.widget.DigitalClock.() -> Unit = {}): android.widget.DigitalClock =
  addView(android.widget.DigitalClock(dslContext), init, this)
public fun Activity.digitalClock(init: android.widget.DigitalClock.() -> Unit = {}): android.widget.DigitalClock =
  addActivityTopLevelView(android.widget.DigitalClock(this), init)
public fun Fragment.digitalClock(init: android.widget.DigitalClock.() -> Unit = {}): android.widget.DigitalClock =
  addFragmentTopLevelView(android.widget.DigitalClock(getActivity()!!), init)
public fun Context.digitalClock(init: android.widget.DigitalClock.() -> Unit = {}): android.widget.DigitalClock =
  addContextTopLevelView(android.widget.DigitalClock(this), init)

public fun ViewManager.editText(init: android.widget.EditText.() -> Unit = {}): android.widget.EditText =
  addView(android.widget.EditText(dslContext), init, this)
public fun Activity.editText(init: android.widget.EditText.() -> Unit = {}): android.widget.EditText =
  addActivityTopLevelView(android.widget.EditText(this), init)
public fun Fragment.editText(init: android.widget.EditText.() -> Unit = {}): android.widget.EditText =
  addFragmentTopLevelView(android.widget.EditText(getActivity()!!), init)
public fun Context.editText(init: android.widget.EditText.() -> Unit = {}): android.widget.EditText =
  addContextTopLevelView(android.widget.EditText(this), init)

public fun ViewManager.button(init: android.widget.Button.() -> Unit = {}): android.widget.Button =
  addView(android.widget.Button(dslContext), init, this)
public fun Activity.button(init: android.widget.Button.() -> Unit = {}): android.widget.Button =
  addActivityTopLevelView(android.widget.Button(this), init)
public fun Fragment.button(init: android.widget.Button.() -> Unit = {}): android.widget.Button =
  addFragmentTopLevelView(android.widget.Button(getActivity()!!), init)
public fun Context.button(init: android.widget.Button.() -> Unit = {}): android.widget.Button =
  addContextTopLevelView(android.widget.Button(this), init)

public fun ViewManager.chronometer(init: android.widget.Chronometer.() -> Unit = {}): android.widget.Chronometer =
  addView(android.widget.Chronometer(dslContext), init, this)
public fun Activity.chronometer(init: android.widget.Chronometer.() -> Unit = {}): android.widget.Chronometer =
  addActivityTopLevelView(android.widget.Chronometer(this), init)
public fun Fragment.chronometer(init: android.widget.Chronometer.() -> Unit = {}): android.widget.Chronometer =
  addFragmentTopLevelView(android.widget.Chronometer(getActivity()!!), init)
public fun Context.chronometer(init: android.widget.Chronometer.() -> Unit = {}): android.widget.Chronometer =
  addContextTopLevelView(android.widget.Chronometer(this), init)

public fun ViewManager.checkedTextView(init: android.widget.CheckedTextView.() -> Unit = {}): android.widget.CheckedTextView =
  addView(android.widget.CheckedTextView(dslContext), init, this)
public fun Activity.checkedTextView(init: android.widget.CheckedTextView.() -> Unit = {}): android.widget.CheckedTextView =
  addActivityTopLevelView(android.widget.CheckedTextView(this), init)
public fun Fragment.checkedTextView(init: android.widget.CheckedTextView.() -> Unit = {}): android.widget.CheckedTextView =
  addFragmentTopLevelView(android.widget.CheckedTextView(getActivity()!!), init)
public fun Context.checkedTextView(init: android.widget.CheckedTextView.() -> Unit = {}): android.widget.CheckedTextView =
  addContextTopLevelView(android.widget.CheckedTextView(this), init)

public fun ViewManager.textClock(init: android.widget.TextClock.() -> Unit = {}): android.widget.TextClock =
  addView(android.widget.TextClock(dslContext), init, this)
public fun Activity.textClock(init: android.widget.TextClock.() -> Unit = {}): android.widget.TextClock =
  addActivityTopLevelView(android.widget.TextClock(this), init)
public fun Fragment.textClock(init: android.widget.TextClock.() -> Unit = {}): android.widget.TextClock =
  addFragmentTopLevelView(android.widget.TextClock(getActivity()!!), init)
public fun Context.textClock(init: android.widget.TextClock.() -> Unit = {}): android.widget.TextClock =
  addContextTopLevelView(android.widget.TextClock(this), init)

public fun ViewManager.contentLoadingProgressBar(init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit = {}): android.support.v4.widget.ContentLoadingProgressBar =
  addView(android.support.v4.widget.ContentLoadingProgressBar(dslContext), init, this)
public fun Activity.contentLoadingProgressBar(init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit = {}): android.support.v4.widget.ContentLoadingProgressBar =
  addActivityTopLevelView(android.support.v4.widget.ContentLoadingProgressBar(this), init)
public fun Fragment.contentLoadingProgressBar(init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit = {}): android.support.v4.widget.ContentLoadingProgressBar =
  addFragmentTopLevelView(android.support.v4.widget.ContentLoadingProgressBar(getActivity()!!), init)
public fun Context.contentLoadingProgressBar(init: android.support.v4.widget.ContentLoadingProgressBar.() -> Unit = {}): android.support.v4.widget.ContentLoadingProgressBar =
  addContextTopLevelView(android.support.v4.widget.ContentLoadingProgressBar(this), init)

public fun ViewManager.imageButton(init: android.widget.ImageButton.() -> Unit = {}): android.widget.ImageButton =
  addView(android.widget.ImageButton(dslContext), init, this)
public fun Activity.imageButton(init: android.widget.ImageButton.() -> Unit = {}): android.widget.ImageButton =
  addActivityTopLevelView(android.widget.ImageButton(this), init)
public fun Fragment.imageButton(init: android.widget.ImageButton.() -> Unit = {}): android.widget.ImageButton =
  addFragmentTopLevelView(android.widget.ImageButton(getActivity()!!), init)
public fun Context.imageButton(init: android.widget.ImageButton.() -> Unit = {}): android.widget.ImageButton =
  addContextTopLevelView(android.widget.ImageButton(this), init)

public fun ViewManager.quickContactBadge(init: android.widget.QuickContactBadge.() -> Unit = {}): android.widget.QuickContactBadge =
  addView(android.widget.QuickContactBadge(dslContext), init, this)
public fun Activity.quickContactBadge(init: android.widget.QuickContactBadge.() -> Unit = {}): android.widget.QuickContactBadge =
  addActivityTopLevelView(android.widget.QuickContactBadge(this), init)
public fun Fragment.quickContactBadge(init: android.widget.QuickContactBadge.() -> Unit = {}): android.widget.QuickContactBadge =
  addFragmentTopLevelView(android.widget.QuickContactBadge(getActivity()!!), init)
public fun Context.quickContactBadge(init: android.widget.QuickContactBadge.() -> Unit = {}): android.widget.QuickContactBadge =
  addContextTopLevelView(android.widget.QuickContactBadge(this), init)

public fun ViewManager.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit = {}): android.support.v4.view.PagerTabStrip =
  addView(android.support.v4.view.PagerTabStrip(dslContext), init, this)
public fun Activity.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit = {}): android.support.v4.view.PagerTabStrip =
  addActivityTopLevelView(android.support.v4.view.PagerTabStrip(this), init)
public fun Fragment.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit = {}): android.support.v4.view.PagerTabStrip =
  addFragmentTopLevelView(android.support.v4.view.PagerTabStrip(getActivity()!!), init)
public fun Context.pagerTabStrip(init: android.support.v4.view.PagerTabStrip.() -> Unit = {}): android.support.v4.view.PagerTabStrip =
  addContextTopLevelView(android.support.v4.view.PagerTabStrip(this), init)

public fun ViewManager.zoomControls(init: android.widget.ZoomControls.() -> Unit = {}): android.widget.ZoomControls =
  addView(android.widget.ZoomControls(dslContext), init, this)
public fun Activity.zoomControls(init: android.widget.ZoomControls.() -> Unit = {}): android.widget.ZoomControls =
  addActivityTopLevelView(android.widget.ZoomControls(this), init)
public fun Fragment.zoomControls(init: android.widget.ZoomControls.() -> Unit = {}): android.widget.ZoomControls =
  addFragmentTopLevelView(android.widget.ZoomControls(getActivity()!!), init)
public fun Context.zoomControls(init: android.widget.ZoomControls.() -> Unit = {}): android.widget.ZoomControls =
  addContextTopLevelView(android.widget.ZoomControls(this), init)

public fun ViewManager.tabWidget(init: android.widget.TabWidget.() -> Unit = {}): android.widget.TabWidget =
  addView(android.widget.TabWidget(dslContext), init, this)
public fun Activity.tabWidget(init: android.widget.TabWidget.() -> Unit = {}): android.widget.TabWidget =
  addActivityTopLevelView(android.widget.TabWidget(this), init)
public fun Fragment.tabWidget(init: android.widget.TabWidget.() -> Unit = {}): android.widget.TabWidget =
  addFragmentTopLevelView(android.widget.TabWidget(getActivity()!!), init)
public fun Context.tabWidget(init: android.widget.TabWidget.() -> Unit = {}): android.widget.TabWidget =
  addContextTopLevelView(android.widget.TabWidget(this), init)

public fun ViewManager.numberPicker(init: android.widget.NumberPicker.() -> Unit = {}): android.widget.NumberPicker =
  addView(android.widget.NumberPicker(dslContext), init, this)
public fun Activity.numberPicker(init: android.widget.NumberPicker.() -> Unit = {}): android.widget.NumberPicker =
  addActivityTopLevelView(android.widget.NumberPicker(this), init)
public fun Fragment.numberPicker(init: android.widget.NumberPicker.() -> Unit = {}): android.widget.NumberPicker =
  addFragmentTopLevelView(android.widget.NumberPicker(getActivity()!!), init)
public fun Context.numberPicker(init: android.widget.NumberPicker.() -> Unit = {}): android.widget.NumberPicker =
  addContextTopLevelView(android.widget.NumberPicker(this), init)

public fun ViewManager.searchView(init: android.widget.SearchView.() -> Unit = {}): android.widget.SearchView =
  addView(android.widget.SearchView(dslContext), init, this)
public fun Activity.searchView(init: android.widget.SearchView.() -> Unit = {}): android.widget.SearchView =
  addActivityTopLevelView(android.widget.SearchView(this), init)
public fun Fragment.searchView(init: android.widget.SearchView.() -> Unit = {}): android.widget.SearchView =
  addFragmentTopLevelView(android.widget.SearchView(getActivity()!!), init)
public fun Context.searchView(init: android.widget.SearchView.() -> Unit = {}): android.widget.SearchView =
  addContextTopLevelView(android.widget.SearchView(this), init)

public fun ViewManager.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit = {}): android.widget.TwoLineListItem =
  addView(android.widget.TwoLineListItem(dslContext), init, this)
public fun Activity.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit = {}): android.widget.TwoLineListItem =
  addActivityTopLevelView(android.widget.TwoLineListItem(this), init)
public fun Fragment.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit = {}): android.widget.TwoLineListItem =
  addFragmentTopLevelView(android.widget.TwoLineListItem(getActivity()!!), init)
public fun Context.twoLineListItem(init: android.widget.TwoLineListItem.() -> Unit = {}): android.widget.TwoLineListItem =
  addContextTopLevelView(android.widget.TwoLineListItem(this), init)

public fun ViewManager.dialerFilter(init: android.widget.DialerFilter.() -> Unit = {}): android.widget.DialerFilter =
  addView(android.widget.DialerFilter(dslContext), init, this)
public fun Activity.dialerFilter(init: android.widget.DialerFilter.() -> Unit = {}): android.widget.DialerFilter =
  addActivityTopLevelView(android.widget.DialerFilter(this), init)
public fun Fragment.dialerFilter(init: android.widget.DialerFilter.() -> Unit = {}): android.widget.DialerFilter =
  addFragmentTopLevelView(android.widget.DialerFilter(getActivity()!!), init)
public fun Context.dialerFilter(init: android.widget.DialerFilter.() -> Unit = {}): android.widget.DialerFilter =
  addContextTopLevelView(android.widget.DialerFilter(this), init)

public fun ViewManager.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit = {}): android.gesture.GestureOverlayView =
  addView(android.gesture.GestureOverlayView(dslContext), init, this)
public fun Activity.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit = {}): android.gesture.GestureOverlayView =
  addActivityTopLevelView(android.gesture.GestureOverlayView(this), init)
public fun Fragment.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit = {}): android.gesture.GestureOverlayView =
  addFragmentTopLevelView(android.gesture.GestureOverlayView(getActivity()!!), init)
public fun Context.gestureOverlayView(init: android.gesture.GestureOverlayView.() -> Unit = {}): android.gesture.GestureOverlayView =
  addContextTopLevelView(android.gesture.GestureOverlayView(this), init)

public fun ViewManager.calendarView(init: android.widget.CalendarView.() -> Unit = {}): android.widget.CalendarView =
  addView(android.widget.CalendarView(dslContext), init, this)
public fun Activity.calendarView(init: android.widget.CalendarView.() -> Unit = {}): android.widget.CalendarView =
  addActivityTopLevelView(android.widget.CalendarView(this), init)
public fun Fragment.calendarView(init: android.widget.CalendarView.() -> Unit = {}): android.widget.CalendarView =
  addFragmentTopLevelView(android.widget.CalendarView(getActivity()!!), init)
public fun Context.calendarView(init: android.widget.CalendarView.() -> Unit = {}): android.widget.CalendarView =
  addContextTopLevelView(android.widget.CalendarView(this), init)

public fun ViewManager.timePicker(init: android.widget.TimePicker.() -> Unit = {}): android.widget.TimePicker =
  addView(android.widget.TimePicker(dslContext), init, this)
public fun Activity.timePicker(init: android.widget.TimePicker.() -> Unit = {}): android.widget.TimePicker =
  addActivityTopLevelView(android.widget.TimePicker(this), init)
public fun Fragment.timePicker(init: android.widget.TimePicker.() -> Unit = {}): android.widget.TimePicker =
  addFragmentTopLevelView(android.widget.TimePicker(getActivity()!!), init)
public fun Context.timePicker(init: android.widget.TimePicker.() -> Unit = {}): android.widget.TimePicker =
  addContextTopLevelView(android.widget.TimePicker(this), init)

public fun ViewManager.datePicker(init: android.widget.DatePicker.() -> Unit = {}): android.widget.DatePicker =
  addView(android.widget.DatePicker(dslContext), init, this)
public fun Activity.datePicker(init: android.widget.DatePicker.() -> Unit = {}): android.widget.DatePicker =
  addActivityTopLevelView(android.widget.DatePicker(this), init)
public fun Fragment.datePicker(init: android.widget.DatePicker.() -> Unit = {}): android.widget.DatePicker =
  addFragmentTopLevelView(android.widget.DatePicker(getActivity()!!), init)
public fun Context.datePicker(init: android.widget.DatePicker.() -> Unit = {}): android.widget.DatePicker =
  addContextTopLevelView(android.widget.DatePicker(this), init)

public fun ViewManager.tabHost(init: android.widget.TabHost.() -> Unit = {}): android.widget.TabHost =
  addView(android.widget.TabHost(dslContext), init, this)
public fun Activity.tabHost(init: android.widget.TabHost.() -> Unit = {}): android.widget.TabHost =
  addActivityTopLevelView(android.widget.TabHost(this), init)
public fun Fragment.tabHost(init: android.widget.TabHost.() -> Unit = {}): android.widget.TabHost =
  addFragmentTopLevelView(android.widget.TabHost(getActivity()!!), init)
public fun Context.tabHost(init: android.widget.TabHost.() -> Unit = {}): android.widget.TabHost =
  addContextTopLevelView(android.widget.TabHost(this), init)

public fun ViewManager.extractEditText(init: android.inputmethodservice.ExtractEditText.() -> Unit = {}): android.inputmethodservice.ExtractEditText =
  addView(android.inputmethodservice.ExtractEditText(dslContext), init, this)
public fun Activity.extractEditText(init: android.inputmethodservice.ExtractEditText.() -> Unit = {}): android.inputmethodservice.ExtractEditText =
  addActivityTopLevelView(android.inputmethodservice.ExtractEditText(this), init)
public fun Fragment.extractEditText(init: android.inputmethodservice.ExtractEditText.() -> Unit = {}): android.inputmethodservice.ExtractEditText =
  addFragmentTopLevelView(android.inputmethodservice.ExtractEditText(getActivity()!!), init)
public fun Context.extractEditText(init: android.inputmethodservice.ExtractEditText.() -> Unit = {}): android.inputmethodservice.ExtractEditText =
  addContextTopLevelView(android.inputmethodservice.ExtractEditText(this), init)

public fun ViewManager.autoCompleteTextView(init: android.widget.AutoCompleteTextView.() -> Unit = {}): android.widget.AutoCompleteTextView =
  addView(android.widget.AutoCompleteTextView(dslContext), init, this)
public fun Activity.autoCompleteTextView(init: android.widget.AutoCompleteTextView.() -> Unit = {}): android.widget.AutoCompleteTextView =
  addActivityTopLevelView(android.widget.AutoCompleteTextView(this), init)
public fun Fragment.autoCompleteTextView(init: android.widget.AutoCompleteTextView.() -> Unit = {}): android.widget.AutoCompleteTextView =
  addFragmentTopLevelView(android.widget.AutoCompleteTextView(getActivity()!!), init)
public fun Context.autoCompleteTextView(init: android.widget.AutoCompleteTextView.() -> Unit = {}): android.widget.AutoCompleteTextView =
  addContextTopLevelView(android.widget.AutoCompleteTextView(this), init)

public fun ViewManager.ratingBar(init: android.widget.RatingBar.() -> Unit = {}): android.widget.RatingBar =
  addView(android.widget.RatingBar(dslContext), init, this)
public fun Activity.ratingBar(init: android.widget.RatingBar.() -> Unit = {}): android.widget.RatingBar =
  addActivityTopLevelView(android.widget.RatingBar(this), init)
public fun Fragment.ratingBar(init: android.widget.RatingBar.() -> Unit = {}): android.widget.RatingBar =
  addFragmentTopLevelView(android.widget.RatingBar(getActivity()!!), init)
public fun Context.ratingBar(init: android.widget.RatingBar.() -> Unit = {}): android.widget.RatingBar =
  addContextTopLevelView(android.widget.RatingBar(this), init)

public fun ViewManager.seekBar(init: android.widget.SeekBar.() -> Unit = {}): android.widget.SeekBar =
  addView(android.widget.SeekBar(dslContext), init, this)
public fun Activity.seekBar(init: android.widget.SeekBar.() -> Unit = {}): android.widget.SeekBar =
  addActivityTopLevelView(android.widget.SeekBar(this), init)
public fun Fragment.seekBar(init: android.widget.SeekBar.() -> Unit = {}): android.widget.SeekBar =
  addFragmentTopLevelView(android.widget.SeekBar(getActivity()!!), init)
public fun Context.seekBar(init: android.widget.SeekBar.() -> Unit = {}): android.widget.SeekBar =
  addContextTopLevelView(android.widget.SeekBar(this), init)

public fun ViewManager.zoomButton(init: android.widget.ZoomButton.() -> Unit = {}): android.widget.ZoomButton =
  addView(android.widget.ZoomButton(dslContext), init, this)
public fun Activity.zoomButton(init: android.widget.ZoomButton.() -> Unit = {}): android.widget.ZoomButton =
  addActivityTopLevelView(android.widget.ZoomButton(this), init)
public fun Fragment.zoomButton(init: android.widget.ZoomButton.() -> Unit = {}): android.widget.ZoomButton =
  addFragmentTopLevelView(android.widget.ZoomButton(getActivity()!!), init)
public fun Context.zoomButton(init: android.widget.ZoomButton.() -> Unit = {}): android.widget.ZoomButton =
  addContextTopLevelView(android.widget.ZoomButton(this), init)

public fun ViewManager.listView(init: android.widget.ListView.() -> Unit = {}): android.widget.ListView =
  addView(android.widget.ListView(dslContext), init, this)
public fun Activity.listView(init: android.widget.ListView.() -> Unit = {}): android.widget.ListView =
  addActivityTopLevelView(android.widget.ListView(this), init)
public fun Fragment.listView(init: android.widget.ListView.() -> Unit = {}): android.widget.ListView =
  addFragmentTopLevelView(android.widget.ListView(getActivity()!!), init)
public fun Context.listView(init: android.widget.ListView.() -> Unit = {}): android.widget.ListView =
  addContextTopLevelView(android.widget.ListView(this), init)

public fun ViewManager.spinner(init: android.widget.Spinner.() -> Unit = {}): android.widget.Spinner =
  addView(android.widget.Spinner(dslContext), init, this)
public fun Activity.spinner(init: android.widget.Spinner.() -> Unit = {}): android.widget.Spinner =
  addActivityTopLevelView(android.widget.Spinner(this), init)
public fun Fragment.spinner(init: android.widget.Spinner.() -> Unit = {}): android.widget.Spinner =
  addFragmentTopLevelView(android.widget.Spinner(getActivity()!!), init)
public fun Context.spinner(init: android.widget.Spinner.() -> Unit = {}): android.widget.Spinner =
  addContextTopLevelView(android.widget.Spinner(this), init)

public fun ViewManager.stackView(init: android.widget.StackView.() -> Unit = {}): android.widget.StackView =
  addView(android.widget.StackView(dslContext), init, this)
public fun Activity.stackView(init: android.widget.StackView.() -> Unit = {}): android.widget.StackView =
  addActivityTopLevelView(android.widget.StackView(this), init)
public fun Fragment.stackView(init: android.widget.StackView.() -> Unit = {}): android.widget.StackView =
  addFragmentTopLevelView(android.widget.StackView(getActivity()!!), init)
public fun Context.stackView(init: android.widget.StackView.() -> Unit = {}): android.widget.StackView =
  addContextTopLevelView(android.widget.StackView(this), init)

public fun ViewManager.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit = {}): android.widget.AdapterViewFlipper =
  addView(android.widget.AdapterViewFlipper(dslContext), init, this)
public fun Activity.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit = {}): android.widget.AdapterViewFlipper =
  addActivityTopLevelView(android.widget.AdapterViewFlipper(this), init)
public fun Fragment.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit = {}): android.widget.AdapterViewFlipper =
  addFragmentTopLevelView(android.widget.AdapterViewFlipper(getActivity()!!), init)
public fun Context.adapterViewFlipper(init: android.widget.AdapterViewFlipper.() -> Unit = {}): android.widget.AdapterViewFlipper =
  addContextTopLevelView(android.widget.AdapterViewFlipper(this), init)

public fun ViewManager.viewFlipper(init: android.widget.ViewFlipper.() -> Unit = {}): android.widget.ViewFlipper =
  addView(android.widget.ViewFlipper(dslContext), init, this)
public fun Activity.viewFlipper(init: android.widget.ViewFlipper.() -> Unit = {}): android.widget.ViewFlipper =
  addActivityTopLevelView(android.widget.ViewFlipper(this), init)
public fun Fragment.viewFlipper(init: android.widget.ViewFlipper.() -> Unit = {}): android.widget.ViewFlipper =
  addFragmentTopLevelView(android.widget.ViewFlipper(getActivity()!!), init)
public fun Context.viewFlipper(init: android.widget.ViewFlipper.() -> Unit = {}): android.widget.ViewFlipper =
  addContextTopLevelView(android.widget.ViewFlipper(this), init)

public fun ViewManager.multiAutoCompleteTextView(init: android.widget.MultiAutoCompleteTextView.() -> Unit = {}): android.widget.MultiAutoCompleteTextView =
  addView(android.widget.MultiAutoCompleteTextView(dslContext), init, this)
public fun Activity.multiAutoCompleteTextView(init: android.widget.MultiAutoCompleteTextView.() -> Unit = {}): android.widget.MultiAutoCompleteTextView =
  addActivityTopLevelView(android.widget.MultiAutoCompleteTextView(this), init)
public fun Fragment.multiAutoCompleteTextView(init: android.widget.MultiAutoCompleteTextView.() -> Unit = {}): android.widget.MultiAutoCompleteTextView =
  addFragmentTopLevelView(android.widget.MultiAutoCompleteTextView(getActivity()!!), init)
public fun Context.multiAutoCompleteTextView(init: android.widget.MultiAutoCompleteTextView.() -> Unit = {}): android.widget.MultiAutoCompleteTextView =
  addContextTopLevelView(android.widget.MultiAutoCompleteTextView(this), init)

public fun ViewManager.checkBox(init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox =
  addView(android.widget.CheckBox(dslContext), init, this)
public fun Activity.checkBox(init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox =
  addActivityTopLevelView(android.widget.CheckBox(this), init)
public fun Fragment.checkBox(init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox =
  addFragmentTopLevelView(android.widget.CheckBox(getActivity()!!), init)
public fun Context.checkBox(init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox =
  addContextTopLevelView(android.widget.CheckBox(this), init)

public fun ViewManager.radioButton(init: android.widget.RadioButton.() -> Unit = {}): android.widget.RadioButton =
  addView(android.widget.RadioButton(dslContext), init, this)
public fun Activity.radioButton(init: android.widget.RadioButton.() -> Unit = {}): android.widget.RadioButton =
  addActivityTopLevelView(android.widget.RadioButton(this), init)
public fun Fragment.radioButton(init: android.widget.RadioButton.() -> Unit = {}): android.widget.RadioButton =
  addFragmentTopLevelView(android.widget.RadioButton(getActivity()!!), init)
public fun Context.radioButton(init: android.widget.RadioButton.() -> Unit = {}): android.widget.RadioButton =
  addContextTopLevelView(android.widget.RadioButton(this), init)

public fun ViewManager.switch(init: android.widget.Switch.() -> Unit = {}): android.widget.Switch =
  addView(android.widget.Switch(dslContext), init, this)
public fun Activity.switch(init: android.widget.Switch.() -> Unit = {}): android.widget.Switch =
  addActivityTopLevelView(android.widget.Switch(this), init)
public fun Fragment.switch(init: android.widget.Switch.() -> Unit = {}): android.widget.Switch =
  addFragmentTopLevelView(android.widget.Switch(getActivity()!!), init)
public fun Context.switch(init: android.widget.Switch.() -> Unit = {}): android.widget.Switch =
  addContextTopLevelView(android.widget.Switch(this), init)

public fun ViewManager.toggleButton(init: android.widget.ToggleButton.() -> Unit = {}): android.widget.ToggleButton =
  addView(android.widget.ToggleButton(dslContext), init, this)
public fun Activity.toggleButton(init: android.widget.ToggleButton.() -> Unit = {}): android.widget.ToggleButton =
  addActivityTopLevelView(android.widget.ToggleButton(this), init)
public fun Fragment.toggleButton(init: android.widget.ToggleButton.() -> Unit = {}): android.widget.ToggleButton =
  addFragmentTopLevelView(android.widget.ToggleButton(getActivity()!!), init)
public fun Context.toggleButton(init: android.widget.ToggleButton.() -> Unit = {}): android.widget.ToggleButton =
  addContextTopLevelView(android.widget.ToggleButton(this), init)

public fun ViewManager.expandableListView(init: android.widget.ExpandableListView.() -> Unit = {}): android.widget.ExpandableListView =
  addView(android.widget.ExpandableListView(dslContext), init, this)
public fun Activity.expandableListView(init: android.widget.ExpandableListView.() -> Unit = {}): android.widget.ExpandableListView =
  addActivityTopLevelView(android.widget.ExpandableListView(this), init)
public fun Fragment.expandableListView(init: android.widget.ExpandableListView.() -> Unit = {}): android.widget.ExpandableListView =
  addFragmentTopLevelView(android.widget.ExpandableListView(getActivity()!!), init)
public fun Context.expandableListView(init: android.widget.ExpandableListView.() -> Unit = {}): android.widget.ExpandableListView =
  addContextTopLevelView(android.widget.ExpandableListView(this), init)

public fun ViewManager.imageSwitcher(init: android.widget.ImageSwitcher.() -> Unit = {}): android.widget.ImageSwitcher =
  addView(android.widget.ImageSwitcher(dslContext), init, this)
public fun Activity.imageSwitcher(init: android.widget.ImageSwitcher.() -> Unit = {}): android.widget.ImageSwitcher =
  addActivityTopLevelView(android.widget.ImageSwitcher(this), init)
public fun Fragment.imageSwitcher(init: android.widget.ImageSwitcher.() -> Unit = {}): android.widget.ImageSwitcher =
  addFragmentTopLevelView(android.widget.ImageSwitcher(getActivity()!!), init)
public fun Context.imageSwitcher(init: android.widget.ImageSwitcher.() -> Unit = {}): android.widget.ImageSwitcher =
  addContextTopLevelView(android.widget.ImageSwitcher(this), init)

public fun ViewManager.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit = {}): android.support.v4.widget.SlidingPaneLayout =
  addView(_SlidingPaneLayout(dslContext), init, this)
public fun Activity.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit = {}): android.support.v4.widget.SlidingPaneLayout =
  addActivityTopLevelView(_SlidingPaneLayout(this), init)
public fun Fragment.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit = {}): android.support.v4.widget.SlidingPaneLayout =
  addFragmentTopLevelView(_SlidingPaneLayout(getActivity()!!), init)
public fun Context.slidingPaneLayout(init: _SlidingPaneLayout.() -> Unit = {}): android.support.v4.widget.SlidingPaneLayout =
  addContextTopLevelView(_SlidingPaneLayout(this), init)

public fun ViewManager.drawerLayout(init: _DrawerLayout.() -> Unit = {}): android.support.v4.widget.DrawerLayout =
  addView(_DrawerLayout(dslContext), init, this)
public fun Activity.drawerLayout(init: _DrawerLayout.() -> Unit = {}): android.support.v4.widget.DrawerLayout =
  addActivityTopLevelView(_DrawerLayout(this), init)
public fun Fragment.drawerLayout(init: _DrawerLayout.() -> Unit = {}): android.support.v4.widget.DrawerLayout =
  addFragmentTopLevelView(_DrawerLayout(getActivity()!!), init)
public fun Context.drawerLayout(init: _DrawerLayout.() -> Unit = {}): android.support.v4.widget.DrawerLayout =
  addContextTopLevelView(_DrawerLayout(this), init)

public fun ViewManager.viewPager(init: _ViewPager.() -> Unit = {}): android.support.v4.view.ViewPager =
  addView(_ViewPager(dslContext), init, this)
public fun Activity.viewPager(init: _ViewPager.() -> Unit = {}): android.support.v4.view.ViewPager =
  addActivityTopLevelView(_ViewPager(this), init)
public fun Fragment.viewPager(init: _ViewPager.() -> Unit = {}): android.support.v4.view.ViewPager =
  addFragmentTopLevelView(_ViewPager(getActivity()!!), init)
public fun Context.viewPager(init: _ViewPager.() -> Unit = {}): android.support.v4.view.ViewPager =
  addContextTopLevelView(_ViewPager(this), init)

public fun ViewManager.linearLayout(init: _LinearLayout.() -> Unit = {}): android.widget.LinearLayout =
  addView(_LinearLayout(dslContext), init, this)
public fun Activity.linearLayout(init: _LinearLayout.() -> Unit = {}): android.widget.LinearLayout =
  addActivityTopLevelView(_LinearLayout(this), init)
public fun Fragment.linearLayout(init: _LinearLayout.() -> Unit = {}): android.widget.LinearLayout =
  addFragmentTopLevelView(_LinearLayout(getActivity()!!), init)
public fun Context.linearLayout(init: _LinearLayout.() -> Unit = {}): android.widget.LinearLayout =
  addContextTopLevelView(_LinearLayout(this), init)

public fun ViewManager.gridLayout(init: _GridLayout.() -> Unit = {}): android.widget.GridLayout =
  addView(_GridLayout(dslContext), init, this)
public fun Activity.gridLayout(init: _GridLayout.() -> Unit = {}): android.widget.GridLayout =
  addActivityTopLevelView(_GridLayout(this), init)
public fun Fragment.gridLayout(init: _GridLayout.() -> Unit = {}): android.widget.GridLayout =
  addFragmentTopLevelView(_GridLayout(getActivity()!!), init)
public fun Context.gridLayout(init: _GridLayout.() -> Unit = {}): android.widget.GridLayout =
  addContextTopLevelView(_GridLayout(this), init)

public fun ViewManager.relativeLayout(init: _RelativeLayout.() -> Unit = {}): android.widget.RelativeLayout =
  addView(_RelativeLayout(dslContext), init, this)
public fun Activity.relativeLayout(init: _RelativeLayout.() -> Unit = {}): android.widget.RelativeLayout =
  addActivityTopLevelView(_RelativeLayout(this), init)
public fun Fragment.relativeLayout(init: _RelativeLayout.() -> Unit = {}): android.widget.RelativeLayout =
  addFragmentTopLevelView(_RelativeLayout(getActivity()!!), init)
public fun Context.relativeLayout(init: _RelativeLayout.() -> Unit = {}): android.widget.RelativeLayout =
  addContextTopLevelView(_RelativeLayout(this), init)

public fun ViewManager.frameLayout(init: _FrameLayout.() -> Unit = {}): android.widget.FrameLayout =
  addView(_FrameLayout(dslContext), init, this)
public fun Activity.frameLayout(init: _FrameLayout.() -> Unit = {}): android.widget.FrameLayout =
  addActivityTopLevelView(_FrameLayout(this), init)
public fun Fragment.frameLayout(init: _FrameLayout.() -> Unit = {}): android.widget.FrameLayout =
  addFragmentTopLevelView(_FrameLayout(getActivity()!!), init)
public fun Context.frameLayout(init: _FrameLayout.() -> Unit = {}): android.widget.FrameLayout =
  addContextTopLevelView(_FrameLayout(this), init)

public fun ViewManager.absoluteLayout(init: _AbsoluteLayout.() -> Unit = {}): android.widget.AbsoluteLayout =
  addView(_AbsoluteLayout(dslContext), init, this)
public fun Activity.absoluteLayout(init: _AbsoluteLayout.() -> Unit = {}): android.widget.AbsoluteLayout =
  addActivityTopLevelView(_AbsoluteLayout(this), init)
public fun Fragment.absoluteLayout(init: _AbsoluteLayout.() -> Unit = {}): android.widget.AbsoluteLayout =
  addFragmentTopLevelView(_AbsoluteLayout(getActivity()!!), init)
public fun Context.absoluteLayout(init: _AbsoluteLayout.() -> Unit = {}): android.widget.AbsoluteLayout =
  addContextTopLevelView(_AbsoluteLayout(this), init)

public fun ViewManager.radioGroup(init: _RadioGroup.() -> Unit = {}): android.widget.RadioGroup =
  addView(_RadioGroup(dslContext), init, this)
public fun Activity.radioGroup(init: _RadioGroup.() -> Unit = {}): android.widget.RadioGroup =
  addActivityTopLevelView(_RadioGroup(this), init)
public fun Fragment.radioGroup(init: _RadioGroup.() -> Unit = {}): android.widget.RadioGroup =
  addFragmentTopLevelView(_RadioGroup(getActivity()!!), init)
public fun Context.radioGroup(init: _RadioGroup.() -> Unit = {}): android.widget.RadioGroup =
  addContextTopLevelView(_RadioGroup(this), init)

public fun ViewManager.tableLayout(init: _TableLayout.() -> Unit = {}): android.widget.TableLayout =
  addView(_TableLayout(dslContext), init, this)
public fun Activity.tableLayout(init: _TableLayout.() -> Unit = {}): android.widget.TableLayout =
  addActivityTopLevelView(_TableLayout(this), init)
public fun Fragment.tableLayout(init: _TableLayout.() -> Unit = {}): android.widget.TableLayout =
  addFragmentTopLevelView(_TableLayout(getActivity()!!), init)
public fun Context.tableLayout(init: _TableLayout.() -> Unit = {}): android.widget.TableLayout =
  addContextTopLevelView(_TableLayout(this), init)

public fun ViewManager.tableRow(init: _TableRow.() -> Unit = {}): android.widget.TableRow =
  addView(_TableRow(dslContext), init, this)
public fun Activity.tableRow(init: _TableRow.() -> Unit = {}): android.widget.TableRow =
  addActivityTopLevelView(_TableRow(this), init)
public fun Fragment.tableRow(init: _TableRow.() -> Unit = {}): android.widget.TableRow =
  addFragmentTopLevelView(_TableRow(getActivity()!!), init)
public fun Context.tableRow(init: _TableRow.() -> Unit = {}): android.widget.TableRow =
  addContextTopLevelView(_TableRow(this), init)

public fun ViewManager.viewAnimator(init: _ViewAnimator.() -> Unit = {}): android.widget.ViewAnimator =
  addView(_ViewAnimator(dslContext), init, this)
public fun Activity.viewAnimator(init: _ViewAnimator.() -> Unit = {}): android.widget.ViewAnimator =
  addActivityTopLevelView(_ViewAnimator(this), init)
public fun Fragment.viewAnimator(init: _ViewAnimator.() -> Unit = {}): android.widget.ViewAnimator =
  addFragmentTopLevelView(_ViewAnimator(getActivity()!!), init)
public fun Context.viewAnimator(init: _ViewAnimator.() -> Unit = {}): android.widget.ViewAnimator =
  addContextTopLevelView(_ViewAnimator(this), init)

public fun ViewManager.horizontalScrollView(init: _HorizontalScrollView.() -> Unit = {}): android.widget.HorizontalScrollView =
  addView(_HorizontalScrollView(dslContext), init, this)
public fun Activity.horizontalScrollView(init: _HorizontalScrollView.() -> Unit = {}): android.widget.HorizontalScrollView =
  addActivityTopLevelView(_HorizontalScrollView(this), init)
public fun Fragment.horizontalScrollView(init: _HorizontalScrollView.() -> Unit = {}): android.widget.HorizontalScrollView =
  addFragmentTopLevelView(_HorizontalScrollView(getActivity()!!), init)
public fun Context.horizontalScrollView(init: _HorizontalScrollView.() -> Unit = {}): android.widget.HorizontalScrollView =
  addContextTopLevelView(_HorizontalScrollView(this), init)

public fun ViewManager.scrollView(init: _ScrollView.() -> Unit = {}): android.widget.ScrollView =
  addView(_ScrollView(dslContext), init, this)
public fun Activity.scrollView(init: _ScrollView.() -> Unit = {}): android.widget.ScrollView =
  addActivityTopLevelView(_ScrollView(this), init)
public fun Fragment.scrollView(init: _ScrollView.() -> Unit = {}): android.widget.ScrollView =
  addFragmentTopLevelView(_ScrollView(getActivity()!!), init)
public fun Context.scrollView(init: _ScrollView.() -> Unit = {}): android.widget.ScrollView =
  addContextTopLevelView(_ScrollView(this), init)

public fun ViewManager.appWidgetHostView(init: _AppWidgetHostView.() -> Unit = {}): android.appwidget.AppWidgetHostView =
  addView(_AppWidgetHostView(dslContext), init, this)
public fun Activity.appWidgetHostView(init: _AppWidgetHostView.() -> Unit = {}): android.appwidget.AppWidgetHostView =
  addActivityTopLevelView(_AppWidgetHostView(this), init)
public fun Fragment.appWidgetHostView(init: _AppWidgetHostView.() -> Unit = {}): android.appwidget.AppWidgetHostView =
  addFragmentTopLevelView(_AppWidgetHostView(getActivity()!!), init)
public fun Context.appWidgetHostView(init: _AppWidgetHostView.() -> Unit = {}): android.appwidget.AppWidgetHostView =
  addContextTopLevelView(_AppWidgetHostView(this), init)

public fun ViewManager.webView(init: _WebView.() -> Unit = {}): android.webkit.WebView =
  addView(_WebView(dslContext), init, this)
public fun Activity.webView(init: _WebView.() -> Unit = {}): android.webkit.WebView =
  addActivityTopLevelView(_WebView(this), init)
public fun Fragment.webView(init: _WebView.() -> Unit = {}): android.webkit.WebView =
  addFragmentTopLevelView(_WebView(getActivity()!!), init)
public fun Context.webView(init: _WebView.() -> Unit = {}): android.webkit.WebView =
  addContextTopLevelView(_WebView(this), init)

public fun ViewManager.gridView(init: _GridView.() -> Unit = {}): android.widget.GridView =
  addView(_GridView(dslContext), init, this)
public fun Activity.gridView(init: _GridView.() -> Unit = {}): android.widget.GridView =
  addActivityTopLevelView(_GridView(this), init)
public fun Fragment.gridView(init: _GridView.() -> Unit = {}): android.widget.GridView =
  addFragmentTopLevelView(_GridView(getActivity()!!), init)
public fun Context.gridView(init: _GridView.() -> Unit = {}): android.widget.GridView =
  addContextTopLevelView(_GridView(this), init)

public fun ViewManager.gallery(init: _Gallery.() -> Unit = {}): android.widget.Gallery =
  addView(_Gallery(dslContext), init, this)
public fun Activity.gallery(init: _Gallery.() -> Unit = {}): android.widget.Gallery =
  addActivityTopLevelView(_Gallery(this), init)
public fun Fragment.gallery(init: _Gallery.() -> Unit = {}): android.widget.Gallery =
  addFragmentTopLevelView(_Gallery(getActivity()!!), init)
public fun Context.gallery(init: _Gallery.() -> Unit = {}): android.widget.Gallery =
  addContextTopLevelView(_Gallery(this), init)

public fun ViewManager.fragmentTabHost(init: _FragmentTabHost.() -> Unit = {}): android.support.v4.app.FragmentTabHost =
  addView(_FragmentTabHost(dslContext), init, this)
public fun Activity.fragmentTabHost(init: _FragmentTabHost.() -> Unit = {}): android.support.v4.app.FragmentTabHost =
  addActivityTopLevelView(_FragmentTabHost(this), init)
public fun Fragment.fragmentTabHost(init: _FragmentTabHost.() -> Unit = {}): android.support.v4.app.FragmentTabHost =
  addFragmentTopLevelView(_FragmentTabHost(getActivity()!!), init)
public fun Context.fragmentTabHost(init: _FragmentTabHost.() -> Unit = {}): android.support.v4.app.FragmentTabHost =
  addContextTopLevelView(_FragmentTabHost(this), init)

public fun ViewManager.viewSwitcher(init: _ViewSwitcher.() -> Unit = {}): android.widget.ViewSwitcher =
  addView(_ViewSwitcher(dslContext), init, this)
public fun Activity.viewSwitcher(init: _ViewSwitcher.() -> Unit = {}): android.widget.ViewSwitcher =
  addActivityTopLevelView(_ViewSwitcher(this), init)
public fun Fragment.viewSwitcher(init: _ViewSwitcher.() -> Unit = {}): android.widget.ViewSwitcher =
  addFragmentTopLevelView(_ViewSwitcher(getActivity()!!), init)
public fun Context.viewSwitcher(init: _ViewSwitcher.() -> Unit = {}): android.widget.ViewSwitcher =
  addContextTopLevelView(_ViewSwitcher(this), init)

public fun ViewManager.textSwitcher(init: _TextSwitcher.() -> Unit = {}): android.widget.TextSwitcher =
  addView(_TextSwitcher(dslContext), init, this)
public fun Activity.textSwitcher(init: _TextSwitcher.() -> Unit = {}): android.widget.TextSwitcher =
  addActivityTopLevelView(_TextSwitcher(this), init)
public fun Fragment.textSwitcher(init: _TextSwitcher.() -> Unit = {}): android.widget.TextSwitcher =
  addFragmentTopLevelView(_TextSwitcher(getActivity()!!), init)
public fun Context.textSwitcher(init: _TextSwitcher.() -> Unit = {}): android.widget.TextSwitcher =
  addContextTopLevelView(_TextSwitcher(this), init)

public fun ViewManager.textView(text: CharSequence?, init: android.widget.TextView.() -> Unit = {}): android.widget.TextView {
  val v = android.widget.TextView(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.textView(text: Int, init: android.widget.TextView.() -> Unit = {}): android.widget.TextView {
  val v = android.widget.TextView(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?, init: android.widget.ImageView.() -> Unit = {}): android.widget.ImageView {
  val v = android.widget.ImageView(dslContext)
  v.setImageDrawable(imageDrawable)
  return addView(v, init, this)
}

public fun ViewManager.imageView(imageResource: Int, init: android.widget.ImageView.() -> Unit = {}): android.widget.ImageView {
  val v = android.widget.ImageView(dslContext)
  v.setImageResource(imageResource)
  return addView(v, init, this)
}

public fun ViewManager.button(text: CharSequence?, init: android.widget.Button.() -> Unit = {}): android.widget.Button {
  val v = android.widget.Button(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.button(text: Int, init: android.widget.Button.() -> Unit = {}): android.widget.Button {
  val v = android.widget.Button(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?, init: android.widget.ImageButton.() -> Unit = {}): android.widget.ImageButton {
  val v = android.widget.ImageButton(dslContext)
  v.setImageDrawable(imageDrawable)
  return addView(v, init, this)
}

public fun ViewManager.imageButton(imageResource: Int, init: android.widget.ImageButton.() -> Unit = {}): android.widget.ImageButton {
  val v = android.widget.ImageButton(dslContext)
  v.setImageResource(imageResource)
  return addView(v, init, this)
}

public fun ViewManager.checkBox(text: CharSequence?, init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox {
  val v = android.widget.CheckBox(dslContext)
  v.setText(text)
  return addView(v, init, this)
}

public fun ViewManager.checkBox(text: Int, init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox {
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

public fun ViewManager.checkBox(text: Int, checked: Boolean, init: android.widget.CheckBox.() -> Unit = {}): android.widget.CheckBox {
  val v = android.widget.CheckBox(dslContext)
  v.setText(text)
  v.setChecked(checked)
  return addView(v, init, this)
}

