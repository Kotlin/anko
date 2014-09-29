package kotlinx.android.koan

public fun android.view.View.onFocusChange(l: (android.view.View?, Boolean) -> Unit): Unit =
  setOnFocusChangeListener(l)

public fun android.view.View.onClick(l: (android.view.View?) -> Unit): Unit =
  setOnClickListener(l)

public fun android.view.View.onLongClick(l: (android.view.View?) -> Boolean): Unit =
  setOnLongClickListener(l)

public fun android.view.View.onCreateContextMenu(l: (android.view.ContextMenu?, android.view.View?, android.view.ContextMenu.ContextMenuInfo?) -> Unit): Unit =
  setOnCreateContextMenuListener(l)

public fun android.view.View.onKey(l: (android.view.View?, Int, android.view.KeyEvent?) -> Boolean): Unit =
  setOnKeyListener(l)

public fun android.view.View.onTouch(l: (android.view.View?, android.view.MotionEvent?) -> Boolean): Unit =
  setOnTouchListener(l)

public fun android.view.View.onGenericMotion(l: (android.view.View?, android.view.MotionEvent?) -> Boolean): Unit =
  setOnGenericMotionListener(l)

public fun android.view.View.onHover(l: (android.view.View?, android.view.MotionEvent?) -> Boolean): Unit =
  setOnHoverListener(l)

public fun android.view.View.onDrag(l: (android.view.View?, android.view.DragEvent?) -> Boolean): Unit =
  setOnDragListener(l)

public fun android.view.View.onSystemUiVisibilityChange(l: (Int) -> Unit): Unit =
  setOnSystemUiVisibilityChangeListener(l)

public fun android.view.ViewStub.onInflate(l: (android.view.ViewStub?, android.view.View?) -> Unit): Unit =
  setOnInflateListener(l)

public fun android.widget.TextView.onEditorAction(l: (android.widget.TextView?, Int, android.view.KeyEvent?) -> Boolean): Unit =
  setOnEditorActionListener(l)

public fun android.support.v4.widget.SwipeRefreshLayout.onRefresh(l: () -> Unit): Unit =
  setOnRefreshListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemLongClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Boolean): Unit =
  setOnItemLongClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onClick(l: (android.view.View?) -> Unit): Unit =
  setOnClickListener(l)

public fun android.widget.SlidingDrawer.onDrawerOpen(l: () -> Unit): Unit =
  setOnDrawerOpenListener(l)

public fun android.widget.SlidingDrawer.onDrawerClose(l: () -> Unit): Unit =
  setOnDrawerCloseListener(l)

public fun android.widget.VideoView.onPrepared(l: (android.media.MediaPlayer?) -> Unit): Unit =
  setOnPreparedListener(l)

public fun android.widget.VideoView.onCompletion(l: (android.media.MediaPlayer?) -> Unit): Unit =
  setOnCompletionListener(l)

public fun android.widget.VideoView.onError(l: (android.media.MediaPlayer?, Int, Int) -> Boolean): Unit =
  setOnErrorListener(l)

public fun android.widget.VideoView.onInfo(l: (android.media.MediaPlayer?, Int, Int) -> Boolean): Unit =
  setOnInfoListener(l)

public fun android.widget.Chronometer.onChronometerTick(l: (android.widget.Chronometer?) -> Unit): Unit =
  setOnChronometerTickListener(l)

public fun android.widget.ZoomControls.onZoomInClick(l: (android.view.View?) -> Unit): Unit =
  setOnZoomInClickListener(l)

public fun android.widget.ZoomControls.onZoomOutClick(l: (android.view.View?) -> Unit): Unit =
  setOnZoomOutClickListener(l)

public fun android.widget.RadioGroup.onCheckedChange(l: (android.widget.RadioGroup?, Int) -> Unit): Unit =
  setOnCheckedChangeListener(l)

public fun android.widget.NumberPicker.onValueChanged(l: (android.widget.NumberPicker?, Int, Int) -> Unit): Unit =
  setOnValueChangedListener(l)

public fun android.widget.NumberPicker.onScroll(l: (android.widget.NumberPicker?, Int) -> Unit): Unit =
  setOnScrollListener(l)

public fun android.widget.SearchView.onClose(l: () -> Boolean): Unit =
  setOnCloseListener(l)

public fun android.widget.SearchView.onQueryTextFocusChange(l: (android.view.View?, Boolean) -> Unit): Unit =
  setOnQueryTextFocusChangeListener(l)

public fun android.widget.SearchView.onSearchClick(l: (android.view.View?) -> Unit): Unit =
  setOnSearchClickListener(l)

public fun android.widget.CalendarView.onDateChange(l: (android.widget.CalendarView?, Int, Int, Int) -> Unit): Unit =
  setOnDateChangeListener(l)

public fun android.widget.TimePicker.onTimeChanged(l: (android.widget.TimePicker?, Int, Int) -> Unit): Unit =
  setOnTimeChangedListener(l)

public fun android.widget.TabHost.onTabChanged(l: (String?) -> Unit): Unit =
  setOnTabChangedListener(l)

public fun android.widget.AutoCompleteTextView.onClick(l: (android.view.View?) -> Unit): Unit =
  setOnClickListener(l)

public fun android.widget.AutoCompleteTextView.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.AutoCompleteTextView.onDismiss(l: () -> Unit): Unit =
  setOnDismissListener(l)

public fun android.widget.CompoundButton.onCheckedChange(l: (android.widget.CompoundButton?, Boolean) -> Unit): Unit =
  setOnCheckedChangeListener(l)

public fun android.widget.RatingBar.onRatingBarChange(l: (android.widget.RatingBar?, Float, Boolean) -> Unit): Unit =
  setOnRatingBarChangeListener(l)

public fun android.widget.Spinner.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.support.v4.app.FragmentTabHost.onTabChanged(l: (String?) -> Unit): Unit =
  setOnTabChangedListener(l)

public fun android.widget.ExpandableListView.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.ExpandableListView.onGroupCollapse(l: (Int) -> Unit): Unit =
  setOnGroupCollapseListener(l)

public fun android.widget.ExpandableListView.onGroupExpand(l: (Int) -> Unit): Unit =
  setOnGroupExpandListener(l)

public fun android.widget.ExpandableListView.onGroupClick(l: (android.widget.ExpandableListView?, android.view.View?, Int, Long) -> Boolean): Unit =
  setOnGroupClickListener(l)

public fun android.widget.ExpandableListView.onChildClick(l: (android.widget.ExpandableListView?, android.view.View?, Int, Int, Long) -> Boolean): Unit =
  setOnChildClickListener(l)

public class __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(val v: android.inputmethodservice.KeyboardView): ListenerHelper {
  var _onPress: ((Int) -> Unit) = { p0 ->  }
  var _onRelease: ((Int) -> Unit) = { p0 ->  }
  var _onKey: ((Int, IntArray?) -> Unit) = { p0, p1 ->  }
  var _onText: ((CharSequence?) -> Unit) = { p0 ->  }
  var _swipeLeft: (() -> Unit) = {}
  var _swipeRight: (() -> Unit) = {}
  var _swipeDown: (() -> Unit) = {}
  var _swipeUp: (() -> Unit) = {}

  override fun apply() {
    v.setOnKeyboardActionListener(object: android.inputmethodservice.KeyboardView.OnKeyboardActionListener {
      override fun onPress(p0: Int) = _onPress(p0)
      override fun onRelease(p0: Int) = _onRelease(p0)
      override fun onKey(p0: Int, p1: IntArray?) = _onKey(p0, p1)
      override fun onText(p0: CharSequence?) = _onText(p0)
      override fun swipeLeft() = _swipeLeft()
      override fun swipeRight() = _swipeRight()
      override fun swipeDown() = _swipeDown()
      override fun swipeUp() = _swipeUp()
    })
  }
}

public class __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(val v: android.view.ViewGroup): ListenerHelper {
  var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }
  var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }

  override fun apply() {
    v.setOnHierarchyChangeListener(object: android.view.ViewGroup.OnHierarchyChangeListener {
      override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) = _onChildViewAdded(p0, p1)
      override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) = _onChildViewRemoved(p0, p1)
    })
  }
}

public class __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener(val v: android.support.v4.view.ViewPager): ListenerHelper {
  var _onPageScrolled: ((Int, Float, Int) -> Unit) = { p0, p1, p2 ->  }
  var _onPageSelected: ((Int) -> Unit) = { p0 ->  }
  var _onPageScrollStateChanged: ((Int) -> Unit) = { p0 ->  }

  override fun apply() {
    v.setOnPageChangeListener(object: android.support.v4.view.ViewPager.OnPageChangeListener {
      override fun onPageScrolled(p0: Int, p1: Float, p2: Int) = _onPageScrolled(p0, p1, p2)
      override fun onPageSelected(p0: Int) = _onPageSelected(p0)
      override fun onPageScrollStateChanged(p0: Int) = _onPageScrollStateChanged(p0)
    })
  }
}

public class __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(val v: android.widget.AdapterView<out android.widget.Adapter?>): ListenerHelper {
  var _onItemSelected: ((android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) = { p0, p1, p2, p3 ->  }
  var _onNothingSelected: ((android.widget.AdapterView<*>?) -> Unit) = { p0 ->  }

  override fun apply() {
    v.setOnItemSelectedListener(object: android.widget.AdapterView.OnItemSelectedListener {
      override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) = _onItemSelected(p0, p1, p2, p3)
      override fun onNothingSelected(p0: android.widget.AdapterView<*>?) = _onNothingSelected(p0)
    })
  }
}

public class __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener(val v: android.widget.SlidingDrawer): ListenerHelper {
  var _onScrollStarted: (() -> Unit) = {}
  var _onScrollEnded: (() -> Unit) = {}

  override fun apply() {
    v.setOnDrawerScrollListener(object: android.widget.SlidingDrawer.OnDrawerScrollListener {
      override fun onScrollStarted() = _onScrollStarted()
      override fun onScrollEnded() = _onScrollEnded()
    })
  }
}

public class __AbsListView_setOnScrollListener_AbsListView_OnScrollListener(val v: android.widget.AbsListView): ListenerHelper {
  var _onScrollStateChanged: ((android.widget.AbsListView?, Int) -> Unit) = { p0, p1 ->  }
  var _onScroll: ((android.widget.AbsListView?, Int, Int, Int) -> Unit) = { p0, p1, p2, p3 ->  }

  override fun apply() {
    v.setOnScrollListener(object: android.widget.AbsListView.OnScrollListener {
      override fun onScrollStateChanged(p0: android.widget.AbsListView?, p1: Int) = _onScrollStateChanged(p0, p1)
      override fun onScroll(p0: android.widget.AbsListView, p1: Int, p2: Int, p3: Int) = _onScroll(p0, p1, p2, p3)
    })
  }
}

public class __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(val v: android.widget.RadioGroup): ListenerHelper {
  var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }
  var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }

  override fun apply() {
    v.setOnHierarchyChangeListener(object: android.view.ViewGroup.OnHierarchyChangeListener {
      override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) = _onChildViewAdded(p0, p1)
      override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) = _onChildViewRemoved(p0, p1)
    })
  }
}

public class __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(val v: android.widget.TableLayout): ListenerHelper {
  var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }
  var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }

  override fun apply() {
    v.setOnHierarchyChangeListener(object: android.view.ViewGroup.OnHierarchyChangeListener {
      override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) = _onChildViewAdded(p0, p1)
      override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) = _onChildViewRemoved(p0, p1)
    })
  }
}

public class __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(val v: android.widget.TableRow): ListenerHelper {
  var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }
  var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit) = { p0, p1 ->  }

  override fun apply() {
    v.setOnHierarchyChangeListener(object: android.view.ViewGroup.OnHierarchyChangeListener {
      override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) = _onChildViewAdded(p0, p1)
      override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) = _onChildViewRemoved(p0, p1)
    })
  }
}

public class __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener(val v: android.widget.SearchView): ListenerHelper {
  var _onQueryTextSubmit: ((String?) -> Boolean) = { p0 -> false }
  var _onQueryTextChange: ((String?) -> Boolean) = { p0 -> false }

  override fun apply() {
    v.setOnQueryTextListener(object: android.widget.SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0: String?) = _onQueryTextSubmit(p0)
      override fun onQueryTextChange(p0: String?) = _onQueryTextChange(p0)
    })
  }
}

public class __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener(val v: android.widget.SearchView): ListenerHelper {
  var _onSuggestionSelect: ((Int) -> Boolean) = { p0 -> false }
  var _onSuggestionClick: ((Int) -> Boolean) = { p0 -> false }

  override fun apply() {
    v.setOnSuggestionListener(object: android.widget.SearchView.OnSuggestionListener {
      override fun onSuggestionSelect(p0: Int) = _onSuggestionSelect(p0)
      override fun onSuggestionClick(p0: Int) = _onSuggestionClick(p0)
    })
  }
}

public class __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(val v: android.widget.AutoCompleteTextView): ListenerHelper {
  var _onItemSelected: ((android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) = { p0, p1, p2, p3 ->  }
  var _onNothingSelected: ((android.widget.AdapterView<*>?) -> Unit) = { p0 ->  }

  override fun apply() {
    v.setOnItemSelectedListener(object: android.widget.AdapterView.OnItemSelectedListener {
      override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) = _onItemSelected(p0, p1, p2, p3)
      override fun onNothingSelected(p0: android.widget.AdapterView<*>?) = _onNothingSelected(p0)
    })
  }
}

public class __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(val v: android.widget.SeekBar): ListenerHelper {
  var _onProgressChanged: ((android.widget.SeekBar?, Int, Boolean) -> Unit) = { p0, p1, p2 ->  }
  var _onStartTrackingTouch: ((android.widget.SeekBar?) -> Unit) = { p0 ->  }
  var _onStopTrackingTouch: ((android.widget.SeekBar?) -> Unit) = { p0 ->  }

  override fun apply() {
    v.setOnSeekBarChangeListener(object: android.widget.SeekBar.OnSeekBarChangeListener {
      override fun onProgressChanged(p0: android.widget.SeekBar, p1: Int, p2: Boolean) = _onProgressChanged(p0, p1, p2)
      override fun onStartTrackingTouch(p0: android.widget.SeekBar?) = _onStartTrackingTouch(p0)
      override fun onStopTrackingTouch(p0: android.widget.SeekBar) = _onStopTrackingTouch(p0)
    })
  }
}

public fun android.inputmethodservice.KeyboardView.onPress(act: (Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onPress = act
  }
}

public fun android.inputmethodservice.KeyboardView.onRelease(act: (Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onRelease = act
  }
}

public fun android.inputmethodservice.KeyboardView.onKey(act: (Int, IntArray?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onKey = act
  }
}

public fun android.inputmethodservice.KeyboardView.onText(act: (CharSequence?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onText = act
  }
}

public fun android.inputmethodservice.KeyboardView.swipeLeft(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeLeft = act
  }
}

public fun android.inputmethodservice.KeyboardView.swipeRight(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeRight = act
  }
}

public fun android.inputmethodservice.KeyboardView.swipeDown(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeDown = act
  }
}

public fun android.inputmethodservice.KeyboardView.swipeUp(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l==null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeUp = act
  }
}

public fun android.view.ViewGroup.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.view.ViewGroup_setOnHierarchyChangeListener") as? __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.view.ViewGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
  }
}

public fun android.view.ViewGroup.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.view.ViewGroup_setOnHierarchyChangeListener") as? __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.view.ViewGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
  }
}

public fun android.support.v4.view.ViewPager.onPageScrolled(act: (Int, Float, Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener? =
      props.listeners.get("android.support.v4.view.ViewPager_setOnPageChangeListener") as? __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener
    if (l==null) {
      l = __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener(this)
      props.listeners.put("android.support.v4.view.ViewPager_setOnPageChangeListener", l!!)
    }
    l!!._onPageScrolled = act
  }
}

public fun android.support.v4.view.ViewPager.onPageSelected(act: (Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener? =
      props.listeners.get("android.support.v4.view.ViewPager_setOnPageChangeListener") as? __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener
    if (l==null) {
      l = __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener(this)
      props.listeners.put("android.support.v4.view.ViewPager_setOnPageChangeListener", l!!)
    }
    l!!._onPageSelected = act
  }
}

public fun android.support.v4.view.ViewPager.onPageScrollStateChanged(act: (Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener? =
      props.listeners.get("android.support.v4.view.ViewPager_setOnPageChangeListener") as? __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener
    if (l==null) {
      l = __ViewPager_setOnPageChangeListener_ViewPager_OnPageChangeListener(this)
      props.listeners.put("android.support.v4.view.ViewPager_setOnPageChangeListener", l!!)
    }
    l!!._onPageScrollStateChanged = act
  }
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemSelected(act: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener") as? __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l==null) {
      l = __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener", l!!)
    }
    l!!._onItemSelected = act
  }
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onNothingSelected(act: (android.widget.AdapterView<*>?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener") as? __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l==null) {
      l = __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener", l!!)
    }
    l!!._onNothingSelected = act
  }
}

public fun android.widget.SlidingDrawer.onScrollStarted(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener? =
      props.listeners.get("android.widget.SlidingDrawer_setOnDrawerScrollListener") as? __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener
    if (l==null) {
      l = __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener(this)
      props.listeners.put("android.widget.SlidingDrawer_setOnDrawerScrollListener", l!!)
    }
    l!!._onScrollStarted = act
  }
}

public fun android.widget.SlidingDrawer.onScrollEnded(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener? =
      props.listeners.get("android.widget.SlidingDrawer_setOnDrawerScrollListener") as? __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener
    if (l==null) {
      l = __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener(this)
      props.listeners.put("android.widget.SlidingDrawer_setOnDrawerScrollListener", l!!)
    }
    l!!._onScrollEnded = act
  }
}

public fun android.widget.AbsListView.onScrollStateChanged(act: (android.widget.AbsListView?, Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __AbsListView_setOnScrollListener_AbsListView_OnScrollListener? =
      props.listeners.get("android.widget.AbsListView_setOnScrollListener") as? __AbsListView_setOnScrollListener_AbsListView_OnScrollListener
    if (l==null) {
      l = __AbsListView_setOnScrollListener_AbsListView_OnScrollListener(this)
      props.listeners.put("android.widget.AbsListView_setOnScrollListener", l!!)
    }
    l!!._onScrollStateChanged = act
  }
}

public fun android.widget.AbsListView.onScroll(act: (android.widget.AbsListView?, Int, Int, Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __AbsListView_setOnScrollListener_AbsListView_OnScrollListener? =
      props.listeners.get("android.widget.AbsListView_setOnScrollListener") as? __AbsListView_setOnScrollListener_AbsListView_OnScrollListener
    if (l==null) {
      l = __AbsListView_setOnScrollListener_AbsListView_OnScrollListener(this)
      props.listeners.put("android.widget.AbsListView_setOnScrollListener", l!!)
    }
    l!!._onScroll = act
  }
}

public fun android.widget.RadioGroup.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.RadioGroup_setOnHierarchyChangeListener") as? __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.RadioGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
  }
}

public fun android.widget.RadioGroup.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.RadioGroup_setOnHierarchyChangeListener") as? __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.RadioGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
  }
}

public fun android.widget.TableLayout.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableLayout_setOnHierarchyChangeListener") as? __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableLayout_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
  }
}

public fun android.widget.TableLayout.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableLayout_setOnHierarchyChangeListener") as? __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableLayout_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
  }
}

public fun android.widget.TableRow.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableRow_setOnHierarchyChangeListener") as? __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableRow_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
  }
}

public fun android.widget.TableRow.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableRow_setOnHierarchyChangeListener") as? __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l==null) {
      l = __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableRow_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
  }
}

public fun android.widget.SearchView.onQueryTextSubmit(act: (String?) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener? =
      props.listeners.get("android.widget.SearchView_setOnQueryTextListener") as? __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener
    if (l==null) {
      l = __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener(this)
      props.listeners.put("android.widget.SearchView_setOnQueryTextListener", l!!)
    }
    l!!._onQueryTextSubmit = act
  }
}

public fun android.widget.SearchView.onQueryTextChange(act: (String?) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener? =
      props.listeners.get("android.widget.SearchView_setOnQueryTextListener") as? __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener
    if (l==null) {
      l = __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener(this)
      props.listeners.put("android.widget.SearchView_setOnQueryTextListener", l!!)
    }
    l!!._onQueryTextChange = act
  }
}

public fun android.widget.SearchView.onSuggestionSelect(act: (Int) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener? =
      props.listeners.get("android.widget.SearchView_setOnSuggestionListener") as? __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener
    if (l==null) {
      l = __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener(this)
      props.listeners.put("android.widget.SearchView_setOnSuggestionListener", l!!)
    }
    l!!._onSuggestionSelect = act
  }
}

public fun android.widget.SearchView.onSuggestionClick(act: (Int) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener? =
      props.listeners.get("android.widget.SearchView_setOnSuggestionListener") as? __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener
    if (l==null) {
      l = __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener(this)
      props.listeners.put("android.widget.SearchView_setOnSuggestionListener", l!!)
    }
    l!!._onSuggestionClick = act
  }
}

public fun android.widget.AutoCompleteTextView.onItemSelected(act: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AutoCompleteTextView_setOnItemSelectedListener") as? __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l==null) {
      l = __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AutoCompleteTextView_setOnItemSelectedListener", l!!)
    }
    l!!._onItemSelected = act
  }
}

public fun android.widget.AutoCompleteTextView.onNothingSelected(act: (android.widget.AdapterView<*>?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AutoCompleteTextView_setOnItemSelectedListener") as? __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l==null) {
      l = __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AutoCompleteTextView_setOnItemSelectedListener", l!!)
    }
    l!!._onNothingSelected = act
  }
}

public fun android.widget.SeekBar.onProgressChanged(act: (android.widget.SeekBar?, Int, Boolean) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener? =
      props.listeners.get("android.widget.SeekBar_setOnSeekBarChangeListener") as? __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener
    if (l==null) {
      l = __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(this)
      props.listeners.put("android.widget.SeekBar_setOnSeekBarChangeListener", l!!)
    }
    l!!._onProgressChanged = act
  }
}

public fun android.widget.SeekBar.onStartTrackingTouch(act: (android.widget.SeekBar?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener? =
      props.listeners.get("android.widget.SeekBar_setOnSeekBarChangeListener") as? __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener
    if (l==null) {
      l = __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(this)
      props.listeners.put("android.widget.SeekBar_setOnSeekBarChangeListener", l!!)
    }
    l!!._onStartTrackingTouch = act
  }
}

public fun android.widget.SeekBar.onStopTrackingTouch(act: (android.widget.SeekBar?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props!=null) {
    var l: __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener? =
      props.listeners.get("android.widget.SeekBar_setOnSeekBarChangeListener") as? __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener
    if (l==null) {
      l = __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(this)
      props.listeners.put("android.widget.SeekBar_setOnSeekBarChangeListener", l!!)
    }
    l!!._onStopTrackingTouch = act
  }
}

