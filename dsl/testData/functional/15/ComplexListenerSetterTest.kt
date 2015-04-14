public fun android.gesture.GestureOverlayView.onGestureListener(init: __GestureOverlayView_OnGestureListener.() -> Unit) {
    val listener = __GestureOverlayView_OnGestureListener()
    listener.init()
    addOnGestureListener(listener)
}

public fun android.gesture.GestureOverlayView.onGesturingListener(init: __GestureOverlayView_OnGesturingListener.() -> Unit) {
    val listener = __GestureOverlayView_OnGesturingListener()
    listener.init()
    addOnGesturingListener(listener)
}

public fun android.inputmethodservice.KeyboardView.onKeyboardActionListener(init: __KeyboardView_OnKeyboardActionListener.() -> Unit) {
    val listener = __KeyboardView_OnKeyboardActionListener()
    listener.init()
    setOnKeyboardActionListener(listener)
}

public fun android.view.View.onAttachStateChangeListener(init: __View_OnAttachStateChangeListener.() -> Unit) {
    val listener = __View_OnAttachStateChangeListener()
    listener.init()
    addOnAttachStateChangeListener(listener)
}

public fun android.view.ViewGroup.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

public fun android.widget.AbsListView.onScrollListener(init: __AbsListView_OnScrollListener.() -> Unit) {
    val listener = __AbsListView_OnScrollListener()
    listener.init()
    setOnScrollListener(listener)
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemSelectedListener(init: __AdapterView_OnItemSelectedListener.() -> Unit) {
    val listener = __AdapterView_OnItemSelectedListener()
    listener.init()
    setOnItemSelectedListener(listener)
}

public fun android.widget.AutoCompleteTextView.onItemSelectedListener(init: __AdapterView_OnItemSelectedListener.() -> Unit) {
    val listener = __AdapterView_OnItemSelectedListener()
    listener.init()
    setOnItemSelectedListener(listener)
}

public fun android.widget.RadioGroup.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

public fun android.widget.SearchView.onQueryTextListener(init: __SearchView_OnQueryTextListener.() -> Unit) {
    val listener = __SearchView_OnQueryTextListener()
    listener.init()
    setOnQueryTextListener(listener)
}

public fun android.widget.SearchView.onSuggestionListener(init: __SearchView_OnSuggestionListener.() -> Unit) {
    val listener = __SearchView_OnSuggestionListener()
    listener.init()
    setOnSuggestionListener(listener)
}

public fun android.widget.SeekBar.onSeekBarChangeListener(init: __SeekBar_OnSeekBarChangeListener.() -> Unit) {
    val listener = __SeekBar_OnSeekBarChangeListener()
    listener.init()
    setOnSeekBarChangeListener(listener)
}

public fun android.widget.SlidingDrawer.onDrawerScrollListener(init: __SlidingDrawer_OnDrawerScrollListener.() -> Unit) {
    val listener = __SlidingDrawer_OnDrawerScrollListener()
    listener.init()
    setOnDrawerScrollListener(listener)
}

public fun android.widget.TableLayout.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

public fun android.widget.TableRow.onHierarchyChangeListener(init: __ViewGroup_OnHierarchyChangeListener.() -> Unit) {
    val listener = __ViewGroup_OnHierarchyChangeListener()
    listener.init()
    setOnHierarchyChangeListener(listener)
}

public fun android.widget.TextView.textChangedListener(init: __TextWatcher.() -> Unit) {
    val listener = __TextWatcher()
    listener.init()
    addTextChangedListener(listener)
}

