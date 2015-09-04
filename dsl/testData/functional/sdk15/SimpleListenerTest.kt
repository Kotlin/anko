public fun android.view.View.onLayoutChange(l: (v: android.view.View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) -> Unit) {
    addOnLayoutChangeListener(l)
}

public fun android.gesture.GestureOverlayView.onGesturePerformed(l: (overlay: android.gesture.GestureOverlayView?, gesture: android.gesture.Gesture?) -> Unit) {
    addOnGesturePerformedListener(l)
}

public fun android.view.View.onClick(l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}

public fun android.view.View.onCreateContextMenu(l: (menu: android.view.ContextMenu?, v: android.view.View?, menuInfo: android.view.ContextMenu.ContextMenuInfo?) -> Unit) {
    setOnCreateContextMenuListener(l)
}

public fun android.view.View.onDrag(l: (v: android.view.View, event: android.view.DragEvent) -> Boolean) {
    setOnDragListener(l)
}

public fun android.view.View.onFocusChange(l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnFocusChangeListener(l)
}

public fun android.view.View.onGenericMotion(l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean) {
    setOnGenericMotionListener(l)
}

public fun android.view.View.onHover(l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean) {
    setOnHoverListener(l)
}

public fun android.view.View.onKey(l: (v: android.view.View, keyCode: Int, event: android.view.KeyEvent?) -> Boolean) {
    setOnKeyListener(l)
}

public fun android.view.View.onLongClick(l: (v: android.view.View?) -> Boolean) {
    setOnLongClickListener(l)
}

public fun android.view.View.onSystemUiVisibilityChange(l: (visibility: Int) -> Unit) {
    setOnSystemUiVisibilityChangeListener(l)
}

public fun android.view.View.onTouch(l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean) {
    setOnTouchListener(l)
}

public fun android.view.ViewStub.onInflate(l: (stub: android.view.ViewStub?, inflated: android.view.View?) -> Unit) {
    setOnInflateListener(l)
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onClick(l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemLongClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Boolean) {
    setOnItemLongClickListener(l)
}

public fun android.widget.AutoCompleteTextView.onClick(l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}

public fun android.widget.AutoCompleteTextView.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

public fun android.widget.CalendarView.onDateChange(l: (view: android.widget.CalendarView?, year: Int, month: Int, dayOfMonth: Int) -> Unit) {
    setOnDateChangeListener(l)
}

public fun android.widget.Chronometer.onChronometerTick(l: (chronometer: android.widget.Chronometer?) -> Unit) {
    setOnChronometerTickListener(l)
}

public fun android.widget.CompoundButton.onCheckedChange(l: (buttonView: android.widget.CompoundButton?, isChecked: Boolean) -> Unit) {
    setOnCheckedChangeListener(l)
}

public fun android.widget.ExpandableListView.onChildClick(l: (parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, childPosition: Int, id: Long) -> Boolean) {
    setOnChildClickListener(l)
}

public fun android.widget.ExpandableListView.onGroupClick(l: (parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, id: Long) -> Boolean) {
    setOnGroupClickListener(l)
}

public fun android.widget.ExpandableListView.onGroupCollapse(l: (groupPosition: Int) -> Unit) {
    setOnGroupCollapseListener(l)
}

public fun android.widget.ExpandableListView.onGroupExpand(l: (groupPosition: Int) -> Unit) {
    setOnGroupExpandListener(l)
}

public fun android.widget.ExpandableListView.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

public fun android.widget.NumberPicker.onScroll(l: (view: android.widget.NumberPicker?, scrollState: Int) -> Unit) {
    setOnScrollListener(l)
}

public fun android.widget.NumberPicker.onValueChanged(l: (picker: android.widget.NumberPicker?, oldVal: Int, newVal: Int) -> Unit) {
    setOnValueChangedListener(l)
}

public fun android.widget.RadioGroup.onCheckedChange(l: (group: android.widget.RadioGroup?, checkedId: Int) -> Unit) {
    setOnCheckedChangeListener(l)
}

public fun android.widget.RatingBar.onRatingBarChange(l: (ratingBar: android.widget.RatingBar?, rating: Float, fromUser: Boolean) -> Unit) {
    setOnRatingBarChangeListener(l)
}

public fun android.widget.SearchView.onClose(l: () -> Boolean) {
    setOnCloseListener(l)
}

public fun android.widget.SearchView.onQueryTextFocusChange(l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnQueryTextFocusChangeListener(l)
}

public fun android.widget.SearchView.onSearchClick(l: (v: android.view.View?) -> Unit) {
    setOnSearchClickListener(l)
}

public fun android.widget.SlidingDrawer.onDrawerClose(l: () -> Unit) {
    setOnDrawerCloseListener(l)
}

public fun android.widget.SlidingDrawer.onDrawerOpen(l: () -> Unit) {
    setOnDrawerOpenListener(l)
}

public fun android.widget.Spinner.onItemClick(l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

public fun android.widget.TabHost.onTabChanged(l: (tabId: String?) -> Unit) {
    setOnTabChangedListener(l)
}

public fun android.widget.TextView.onEditorAction(l: (v: android.widget.TextView?, actionId: Int, event: android.view.KeyEvent?) -> Boolean) {
    setOnEditorActionListener(l)
}

public fun android.widget.TimePicker.onTimeChanged(l: (view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) -> Unit) {
    setOnTimeChangedListener(l)
}

public fun android.widget.VideoView.onCompletion(l: (mp: android.media.MediaPlayer?) -> Unit) {
    setOnCompletionListener(l)
}

public fun android.widget.VideoView.onError(l: (mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Boolean) {
    setOnErrorListener(l)
}

public fun android.widget.VideoView.onPrepared(l: (mp: android.media.MediaPlayer?) -> Unit) {
    setOnPreparedListener(l)
}

public fun android.widget.ZoomControls.onZoomInClick(l: (v: android.view.View?) -> Unit) {
    setOnZoomInClickListener(l)
}

public fun android.widget.ZoomControls.onZoomOutClick(l: (v: android.view.View?) -> Unit) {
    setOnZoomOutClickListener(l)
}