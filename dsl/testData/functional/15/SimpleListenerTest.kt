public fun android.gesture.GestureOverlayView.onGesturePerformed(l: (overlay: android.gesture.GestureOverlayView?, gesture: android.gesture.Gesture?) -> Unit): Unit = addOnGesturePerformedListener(l)

public fun android.view.View.onLayoutChange(l: (v: android.view.View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) -> Unit): Unit = addOnLayoutChangeListener(l)

public fun android.view.View.onClick(l: (v: android.view.View) -> Unit): Unit = setOnClickListener(l)

public fun android.view.View.onCreateContextMenu(l: (menu: android.view.ContextMenu?, v: android.view.View?, menuInfo: android.view.ContextMenu.ContextMenuInfo?) -> Unit): Unit = setOnCreateContextMenuListener(l)

public fun android.view.View.onDrag(l: (v: android.view.View, event: android.view.DragEvent) -> Boolean): Unit = setOnDragListener(l)

public fun android.view.View.onFocusChange(l: (v: android.view.View, hasFocus: Boolean) -> Unit): Unit = setOnFocusChangeListener(l)

public fun android.view.View.onGenericMotion(l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean): Unit = setOnGenericMotionListener(l)

public fun android.view.View.onHover(l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean): Unit = setOnHoverListener(l)

public fun android.view.View.onKey(l: (v: android.view.View, keyCode: Int, event: android.view.KeyEvent) -> Boolean): Unit = setOnKeyListener(l)

public fun android.view.View.onLongClick(l: (v: android.view.View) -> Boolean): Unit = setOnLongClickListener(l)

public fun android.view.View.onSystemUiVisibilityChange(l: (visibility: Int) -> Unit): Unit = setOnSystemUiVisibilityChangeListener(l)

public fun android.view.View.onTouch(l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean): Unit = setOnTouchListener(l)

public fun android.view.ViewStub.onInflate(l: (stub: android.view.ViewStub?, inflated: android.view.View?) -> Unit): Unit = setOnInflateListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onClick(l: (v: android.view.View) -> Unit): Unit = setOnClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit): Unit = setOnItemClickListener(l)

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemLongClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Boolean): Unit = setOnItemLongClickListener(l)

public fun android.widget.AutoCompleteTextView.onClick(l: (v: android.view.View) -> Unit): Unit = setOnClickListener(l)

public fun android.widget.AutoCompleteTextView.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit): Unit = setOnItemClickListener(l)

public fun android.widget.CalendarView.onDateChange(l: (view: android.widget.CalendarView?, year: Int, month: Int, dayOfMonth: Int) -> Unit): Unit = setOnDateChangeListener(l)

public fun android.widget.Chronometer.onChronometerTick(l: (chronometer: android.widget.Chronometer?) -> Unit): Unit = setOnChronometerTickListener(l)

public fun android.widget.CompoundButton.onCheckedChange(l: (buttonView: android.widget.CompoundButton?, isChecked: Boolean) -> Unit): Unit = setOnCheckedChangeListener(l)

public fun android.widget.ExpandableListView.onChildClick(l: (parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, childPosition: Int, id: Long) -> Boolean): Unit = setOnChildClickListener(l)

public fun android.widget.ExpandableListView.onGroupClick(l: (parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, id: Long) -> Boolean): Unit = setOnGroupClickListener(l)

public fun android.widget.ExpandableListView.onGroupCollapse(l: (groupPosition: Int) -> Unit): Unit = setOnGroupCollapseListener(l)

public fun android.widget.ExpandableListView.onGroupExpand(l: (groupPosition: Int) -> Unit): Unit = setOnGroupExpandListener(l)

public fun android.widget.ExpandableListView.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit): Unit = setOnItemClickListener(l)

public fun android.widget.NumberPicker.onScroll(l: (view: android.widget.NumberPicker?, scrollState: Int) -> Unit): Unit = setOnScrollListener(l)

public fun android.widget.NumberPicker.onValueChanged(l: (picker: android.widget.NumberPicker, oldVal: Int, newVal: Int) -> Unit): Unit = setOnValueChangedListener(l)

public fun android.widget.RadioGroup.onCheckedChange(l: (group: android.widget.RadioGroup?, checkedId: Int) -> Unit): Unit = setOnCheckedChangeListener(l)

public fun android.widget.RatingBar.onRatingBarChange(l: (ratingBar: android.widget.RatingBar?, rating: Float, fromUser: Boolean) -> Unit): Unit = setOnRatingBarChangeListener(l)

public fun android.widget.SearchView.onClose(l: () -> Boolean): Unit = setOnCloseListener(l)

public fun android.widget.SearchView.onQueryTextFocusChange(l: (v: android.view.View, hasFocus: Boolean) -> Unit): Unit = setOnQueryTextFocusChangeListener(l)

public fun android.widget.SearchView.onSearchClick(l: (v: android.view.View) -> Unit): Unit = setOnSearchClickListener(l)

public fun android.widget.SlidingDrawer.onDrawerClose(l: () -> Unit): Unit = setOnDrawerCloseListener(l)

public fun android.widget.SlidingDrawer.onDrawerOpen(l: () -> Unit): Unit = setOnDrawerOpenListener(l)

public fun android.widget.Spinner.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit): Unit = setOnItemClickListener(l)

public fun android.widget.TabHost.onTabChanged(l: (tabId: String?) -> Unit): Unit = setOnTabChangedListener(l)

public fun android.widget.TextView.onEditorAction(l: (v: android.widget.TextView?, actionId: Int, event: android.view.KeyEvent?) -> Boolean): Unit = setOnEditorActionListener(l)

public fun android.widget.TimePicker.onTimeChanged(l: (view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) -> Unit): Unit = setOnTimeChangedListener(l)

public fun android.widget.VideoView.onCompletion(l: (mp: android.media.MediaPlayer?) -> Unit): Unit = setOnCompletionListener(l)

public fun android.widget.VideoView.onError(l: (mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Boolean): Unit = setOnErrorListener(l)

public fun android.widget.VideoView.onPrepared(l: (mp: android.media.MediaPlayer) -> Unit): Unit = setOnPreparedListener(l)

public fun android.widget.ZoomControls.onZoomInClick(l: (v: android.view.View) -> Unit): Unit = setOnZoomInClickListener(l)

public fun android.widget.ZoomControls.onZoomOutClick(l: (v: android.view.View) -> Unit): Unit = setOnZoomOutClickListener(l)