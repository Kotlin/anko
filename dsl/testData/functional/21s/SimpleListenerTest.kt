public fun android.gesture.GestureOverlayView.onGesturePerformed(l: (android.gesture.GestureOverlayView?, android.gesture.Gesture?) -> Unit): Unit =
  addOnGesturePerformedListener(l)

public fun android.media.tv.TvView.onUnhandledInputEvent(l: (android.view.InputEvent?) -> Boolean): Unit =
  setOnUnhandledInputEventListener(l)

public fun android.support.v4.app.FragmentTabHost.onTabChanged(l: (String?) -> Unit): Unit =
  setOnTabChangedListener(l)

public fun android.support.v4.widget.SwipeRefreshLayout.onRefresh(l: () -> Unit): Unit =
  setOnRefreshListener(l)

public fun android.view.View.onLayoutChange(l: (android.view.View?, Int, Int, Int, Int, Int, Int, Int, Int) -> Unit): Unit =
  addOnLayoutChangeListener(l)

public fun android.view.View.onApplyWindowInsets(l: (android.view.View?, android.view.WindowInsets?) -> android.view.WindowInsets?): Unit =
  setOnApplyWindowInsetsListener(l)

public fun android.view.View.onClick(l: (android.view.View?) -> Unit): Unit =
  setOnClickListener(l)

public fun android.view.View.onCreateContextMenu(l: (android.view.ContextMenu?, android.view.View?, android.view.ContextMenu.ContextMenuInfo?) -> Unit): Unit =
  setOnCreateContextMenuListener(l)

public fun android.view.View.onDrag(l: (android.view.View?, android.view.DragEvent?) -> Boolean): Unit =
  setOnDragListener(l)

public fun android.view.View.onFocusChange(l: (android.view.View?, Boolean) -> Unit): Unit =
  setOnFocusChangeListener(l)

public fun android.view.View.onGenericMotion(l: (android.view.View?, android.view.MotionEvent?) -> Boolean): Unit =
  setOnGenericMotionListener(l)

public fun android.view.View.onHover(l: (android.view.View?, android.view.MotionEvent?) -> Boolean): Unit =
  setOnHoverListener(l)

public fun android.view.View.onKey(l: (android.view.View?, Int, android.view.KeyEvent?) -> Boolean): Unit =
  setOnKeyListener(l)

public fun android.view.View.onLongClick(l: (android.view.View?) -> Boolean): Unit =
  setOnLongClickListener(l)

public fun android.view.View.onSystemUiVisibilityChange(l: (Int) -> Unit): Unit =
  setOnSystemUiVisibilityChangeListener(l)

public fun android.view.View.onTouch(l: (android.view.View?, android.view.MotionEvent?) -> Boolean): Unit =
  setOnTouchListener(l)

public fun android.view.ViewStub.onInflate(l: (android.view.ViewStub?, android.view.View?) -> Unit): Unit =
  setOnInflateListener(l)

public fun android.widget.ActionMenuView.onMenuItemClick(l: (android.view.MenuItem?) -> Boolean): Unit =
  setOnMenuItemClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onClick(l: (android.view.View?) -> Unit): Unit =
  setOnClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemLongClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Boolean): Unit =
  setOnItemLongClickListener(l)

public fun android.widget.AutoCompleteTextView.onClick(l: (android.view.View?) -> Unit): Unit =
  setOnClickListener(l)

public fun android.widget.AutoCompleteTextView.onDismiss(l: () -> Unit): Unit =
  setOnDismissListener(l)

public fun android.widget.AutoCompleteTextView.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.CalendarView.onDateChange(l: (android.widget.CalendarView?, Int, Int, Int) -> Unit): Unit =
  setOnDateChangeListener(l)

public fun android.widget.Chronometer.onChronometerTick(l: (android.widget.Chronometer?) -> Unit): Unit =
  setOnChronometerTickListener(l)

public fun android.widget.CompoundButton.onCheckedChange(l: (android.widget.CompoundButton?, Boolean) -> Unit): Unit =
  setOnCheckedChangeListener(l)

public fun android.widget.ExpandableListView.onChildClick(l: (android.widget.ExpandableListView?, android.view.View?, Int, Int, Long) -> Boolean): Unit =
  setOnChildClickListener(l)

public fun android.widget.ExpandableListView.onGroupClick(l: (android.widget.ExpandableListView?, android.view.View?, Int, Long) -> Boolean): Unit =
  setOnGroupClickListener(l)

public fun android.widget.ExpandableListView.onGroupCollapse(l: (Int) -> Unit): Unit =
  setOnGroupCollapseListener(l)

public fun android.widget.ExpandableListView.onGroupExpand(l: (Int) -> Unit): Unit =
  setOnGroupExpandListener(l)

public fun android.widget.ExpandableListView.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.NumberPicker.onScroll(l: (android.widget.NumberPicker?, Int) -> Unit): Unit =
  setOnScrollListener(l)

public fun android.widget.NumberPicker.onValueChanged(l: (android.widget.NumberPicker?, Int, Int) -> Unit): Unit =
  setOnValueChangedListener(l)

public fun android.widget.RadioGroup.onCheckedChange(l: (android.widget.RadioGroup?, Int) -> Unit): Unit =
  setOnCheckedChangeListener(l)

public fun android.widget.RatingBar.onRatingBarChange(l: (android.widget.RatingBar?, Float, Boolean) -> Unit): Unit =
  setOnRatingBarChangeListener(l)

public fun android.widget.SearchView.onClose(l: () -> Boolean): Unit =
  setOnCloseListener(l)

public fun android.widget.SearchView.onQueryTextFocusChange(l: (android.view.View?, Boolean) -> Unit): Unit =
  setOnQueryTextFocusChangeListener(l)

public fun android.widget.SearchView.onSearchClick(l: (android.view.View?) -> Unit): Unit =
  setOnSearchClickListener(l)

public fun android.widget.SlidingDrawer.onDrawerClose(l: () -> Unit): Unit =
  setOnDrawerCloseListener(l)

public fun android.widget.SlidingDrawer.onDrawerOpen(l: () -> Unit): Unit =
  setOnDrawerOpenListener(l)

public fun android.widget.Spinner.onItemClick(l: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit): Unit =
  setOnItemClickListener(l)

public fun android.widget.TabHost.onTabChanged(l: (String?) -> Unit): Unit =
  setOnTabChangedListener(l)

public fun android.widget.TextView.onEditorAction(l: (android.widget.TextView?, Int, android.view.KeyEvent?) -> Boolean): Unit =
  setOnEditorActionListener(l)

public fun android.widget.TimePicker.onTimeChanged(l: (android.widget.TimePicker?, Int, Int) -> Unit): Unit =
  setOnTimeChangedListener(l)

public fun android.widget.Toolbar.onMenuItemClick(l: (android.view.MenuItem?) -> Boolean): Unit =
  setOnMenuItemClickListener(l)

public fun android.widget.VideoView.onCompletion(l: (android.media.MediaPlayer?) -> Unit): Unit =
  setOnCompletionListener(l)

public fun android.widget.VideoView.onError(l: (android.media.MediaPlayer?, Int, Int) -> Boolean): Unit =
  setOnErrorListener(l)

public fun android.widget.VideoView.onInfo(l: (android.media.MediaPlayer?, Int, Int) -> Boolean): Unit =
  setOnInfoListener(l)

public fun android.widget.VideoView.onPrepared(l: (android.media.MediaPlayer?) -> Unit): Unit =
  setOnPreparedListener(l)

public fun android.widget.ZoomControls.onZoomInClick(l: (android.view.View?) -> Unit): Unit =
  setOnZoomInClickListener(l)

public fun android.widget.ZoomControls.onZoomOutClick(l: (android.view.View?) -> Unit): Unit =
  setOnZoomOutClickListener(l)

