inline fun android.view.View.onLayoutChange(noinline l: (v: android.view.View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) -> Unit) {
    addOnLayoutChangeListener(l)
}

inline fun android.gesture.GestureOverlayView.onGesturePerformed(noinline l: (overlay: android.gesture.GestureOverlayView?, gesture: android.gesture.Gesture?) -> Unit) {
    addOnGesturePerformedListener(l)
}

inline fun android.media.tv.TvView.onUnhandledInputEvent(noinline l: (event: android.view.InputEvent?) -> Boolean) {
    setOnUnhandledInputEventListener(l)
}

inline fun android.view.View.onApplyWindowInsets(noinline l: (v: android.view.View?, insets: android.view.WindowInsets?) -> android.view.WindowInsets?) {
    setOnApplyWindowInsetsListener(l)
}

inline fun android.view.View.onClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}

inline fun android.view.View.onContextClick(noinline l: (v: android.view.View?) -> Boolean) {
    setOnContextClickListener(l)
}

inline fun android.view.View.onCreateContextMenu(noinline l: (menu: android.view.ContextMenu?, v: android.view.View?, menuInfo: android.view.ContextMenu.ContextMenuInfo?) -> Unit) {
    setOnCreateContextMenuListener(l)
}

inline fun android.view.View.onDrag(noinline l: (v: android.view.View, event: android.view.DragEvent) -> Boolean) {
    setOnDragListener(l)
}

inline fun android.view.View.onFocusChange(noinline l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnFocusChangeListener(l)
}

inline fun android.view.View.onGenericMotion(noinline l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean) {
    setOnGenericMotionListener(l)
}

inline fun android.view.View.onHover(noinline l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean) {
    setOnHoverListener(l)
}

inline fun android.view.View.onKey(noinline l: (v: android.view.View, keyCode: Int, event: android.view.KeyEvent?) -> Boolean) {
    setOnKeyListener(l)
}

inline fun android.view.View.onLongClick(noinline l: (v: android.view.View?) -> Boolean) {
    setOnLongClickListener(l)
}

inline fun android.view.View.onScrollChange(noinline l: (v: android.view.View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) -> Unit) {
    setOnScrollChangeListener(l)
}

inline fun android.view.View.onSystemUiVisibilityChange(noinline l: (visibility: Int) -> Unit) {
    setOnSystemUiVisibilityChangeListener(l)
}

inline fun android.view.View.onTouch(noinline l: (v: android.view.View, event: android.view.MotionEvent) -> Boolean) {
    setOnTouchListener(l)
}

inline fun android.view.ViewStub.onInflate(noinline l: (stub: android.view.ViewStub?, inflated: android.view.View?) -> Unit) {
    setOnInflateListener(l)
}

inline fun android.widget.ActionMenuView.onMenuItemClick(noinline l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

inline fun android.widget.AdapterView<out android.widget.Adapter?>.onClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}

inline fun android.widget.AdapterView<out android.widget.Adapter?>.onItemClick(noinline l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

inline fun android.widget.AdapterView<out android.widget.Adapter?>.onItemLongClick(noinline l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Boolean) {
    setOnItemLongClickListener(l)
}

inline fun android.widget.AutoCompleteTextView.onClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}

inline fun android.widget.AutoCompleteTextView.onDismiss(noinline l: () -> Unit) {
    setOnDismissListener(l)
}

inline fun android.widget.AutoCompleteTextView.onItemClick(noinline l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

inline fun android.widget.CalendarView.onDateChange(noinline l: (view: android.widget.CalendarView?, year: Int, month: Int, dayOfMonth: Int) -> Unit) {
    setOnDateChangeListener(l)
}

inline fun android.widget.Chronometer.onChronometerTick(noinline l: (chronometer: android.widget.Chronometer?) -> Unit) {
    setOnChronometerTickListener(l)
}

inline fun android.widget.CompoundButton.onCheckedChange(noinline l: (buttonView: android.widget.CompoundButton?, isChecked: Boolean) -> Unit) {
    setOnCheckedChangeListener(l)
}

inline fun android.widget.ExpandableListView.onChildClick(noinline l: (parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, childPosition: Int, id: Long) -> Boolean) {
    setOnChildClickListener(l)
}

inline fun android.widget.ExpandableListView.onGroupClick(noinline l: (parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, id: Long) -> Boolean) {
    setOnGroupClickListener(l)
}

inline fun android.widget.ExpandableListView.onGroupCollapse(noinline l: (groupPosition: Int) -> Unit) {
    setOnGroupCollapseListener(l)
}

inline fun android.widget.ExpandableListView.onGroupExpand(noinline l: (groupPosition: Int) -> Unit) {
    setOnGroupExpandListener(l)
}

inline fun android.widget.ExpandableListView.onItemClick(noinline l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

inline fun android.widget.NumberPicker.onScroll(noinline l: (view: android.widget.NumberPicker?, scrollState: Int) -> Unit) {
    setOnScrollListener(l)
}

inline fun android.widget.NumberPicker.onValueChanged(noinline l: (picker: android.widget.NumberPicker?, oldVal: Int, newVal: Int) -> Unit) {
    setOnValueChangedListener(l)
}

inline fun android.widget.RadioGroup.onCheckedChange(noinline l: (group: android.widget.RadioGroup?, checkedId: Int) -> Unit) {
    setOnCheckedChangeListener(l)
}

inline fun android.widget.RatingBar.onRatingBarChange(noinline l: (ratingBar: android.widget.RatingBar?, rating: Float, fromUser: Boolean) -> Unit) {
    setOnRatingBarChangeListener(l)
}

inline fun android.widget.SearchView.onClose(noinline l: () -> Boolean) {
    setOnCloseListener(l)
}

inline fun android.widget.SearchView.onQueryTextFocusChange(noinline l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnQueryTextFocusChangeListener(l)
}

inline fun android.widget.SearchView.onSearchClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnSearchClickListener(l)
}

inline fun android.widget.SlidingDrawer.onDrawerClose(noinline l: () -> Unit) {
    setOnDrawerCloseListener(l)
}

inline fun android.widget.SlidingDrawer.onDrawerOpen(noinline l: () -> Unit) {
    setOnDrawerOpenListener(l)
}

inline fun android.widget.Spinner.onItemClick(noinline l: (p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit) {
    setOnItemClickListener(l)
}

inline fun android.widget.TabHost.onTabChanged(noinline l: (tabId: String?) -> Unit) {
    setOnTabChangedListener(l)
}

inline fun android.widget.TextView.onEditorAction(noinline l: (v: android.widget.TextView?, actionId: Int, event: android.view.KeyEvent?) -> Boolean) {
    setOnEditorActionListener(l)
}

inline fun android.widget.TimePicker.onTimeChanged(noinline l: (view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) -> Unit) {
    setOnTimeChangedListener(l)
}

inline fun android.widget.Toolbar.onMenuItemClick(noinline l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

inline fun android.widget.VideoView.onCompletion(noinline l: (mp: android.media.MediaPlayer?) -> Unit) {
    setOnCompletionListener(l)
}

inline fun android.widget.VideoView.onError(noinline l: (mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Boolean) {
    setOnErrorListener(l)
}

inline fun android.widget.VideoView.onInfo(noinline l: (mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Boolean) {
    setOnInfoListener(l)
}

inline fun android.widget.VideoView.onPrepared(noinline l: (mp: android.media.MediaPlayer?) -> Unit) {
    setOnPreparedListener(l)
}

inline fun android.widget.ZoomControls.onZoomInClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnZoomInClickListener(l)
}

inline fun android.widget.ZoomControls.onZoomOutClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnZoomOutClickListener(l)
}