class __GestureOverlayView_OnGestureListener : android.gesture.GestureOverlayView.OnGestureListener {
    private var _onGestureStarted: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onGesture: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onGestureEnded: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onGestureCancelled: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null

    override fun onGestureStarted(p0: android.gesture.GestureOverlayView?, p1: android.view.MotionEvent?) = _onGestureStarted?.invoke(p0, p1)

    public fun onGestureStarted(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGestureStarted = listener
    }
    override fun onGesture(p0: android.gesture.GestureOverlayView?, p1: android.view.MotionEvent?) = _onGesture?.invoke(p0, p1)

    public fun onGesture(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGesture = listener
    }
    override fun onGestureEnded(p0: android.gesture.GestureOverlayView?, p1: android.view.MotionEvent?) = _onGestureEnded?.invoke(p0, p1)

    public fun onGestureEnded(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGestureEnded = listener
    }
    override fun onGestureCancelled(p0: android.gesture.GestureOverlayView?, p1: android.view.MotionEvent?) = _onGestureCancelled?.invoke(p0, p1)

    public fun onGestureCancelled(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGestureCancelled = listener
    }
}

class __GestureOverlayView_OnGesturingListener : android.gesture.GestureOverlayView.OnGesturingListener {
    private var _onGesturingStarted: ((android.gesture.GestureOverlayView?) -> Unit)? = null
    private var _onGesturingEnded: ((android.gesture.GestureOverlayView?) -> Unit)? = null

    override fun onGesturingStarted(p0: android.gesture.GestureOverlayView?) = _onGesturingStarted?.invoke(p0)

    public fun onGesturingStarted(listener: (android.gesture.GestureOverlayView?) -> Unit) {
        _onGesturingStarted = listener
    }
    override fun onGesturingEnded(p0: android.gesture.GestureOverlayView?) = _onGesturingEnded?.invoke(p0)

    public fun onGesturingEnded(listener: (android.gesture.GestureOverlayView?) -> Unit) {
        _onGesturingEnded = listener
    }
}

class __ViewPager_OnPageChangeListener : android.support.v4.view.ViewPager.OnPageChangeListener {
    private var _onPageScrolled: ((Int, Float, Int) -> Unit)? = null
    private var _onPageSelected: ((Int) -> Unit)? = null
    private var _onPageScrollStateChanged: ((Int) -> Unit)? = null

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) = _onPageScrolled?.invoke(p0, p1, p2)

    public fun onPageScrolled(listener: (Int, Float, Int) -> Unit) {
        _onPageScrolled = listener
    }
    override fun onPageSelected(p0: Int) = _onPageSelected?.invoke(p0)

    public fun onPageSelected(listener: (Int) -> Unit) {
        _onPageSelected = listener
    }
    override fun onPageScrollStateChanged(p0: Int) = _onPageScrollStateChanged?.invoke(p0)

    public fun onPageScrollStateChanged(listener: (Int) -> Unit) {
        _onPageScrollStateChanged = listener
    }
}

class __SearchViewSupport_OnQueryTextListener : android.support.v7.widget.SearchView.OnQueryTextListener {
    private var _onQueryTextSubmit: ((String?) -> Boolean)? = null
    private var _onQueryTextChange: ((String?) -> Boolean)? = null

    override fun onQueryTextSubmit(p0: String?) = _onQueryTextSubmit?.invoke(p0) ?: false

    public fun onQueryTextSubmit(listener: (String?) -> Boolean) {
        _onQueryTextSubmit = listener
    }
    override fun onQueryTextChange(p0: String?) = _onQueryTextChange?.invoke(p0) ?: false

    public fun onQueryTextChange(listener: (String?) -> Boolean) {
        _onQueryTextChange = listener
    }
}

class __SearchViewSupport_OnSuggestionListener : android.support.v7.widget.SearchView.OnSuggestionListener {
    private var _onSuggestionSelect: ((Int) -> Boolean)? = null
    private var _onSuggestionClick: ((Int) -> Boolean)? = null

    override fun onSuggestionSelect(p0: Int) = _onSuggestionSelect?.invoke(p0) ?: false

    public fun onSuggestionSelect(listener: (Int) -> Boolean) {
        _onSuggestionSelect = listener
    }
    override fun onSuggestionClick(p0: Int) = _onSuggestionClick?.invoke(p0) ?: false

    public fun onSuggestionClick(listener: (Int) -> Boolean) {
        _onSuggestionClick = listener
    }
}

class __View_OnAttachStateChangeListener : android.view.View.OnAttachStateChangeListener {
    private var _onViewAttachedToWindow: ((android.view.View?) -> Unit)? = null
    private var _onViewDetachedFromWindow: ((android.view.View?) -> Unit)? = null

    override fun onViewAttachedToWindow(p0: android.view.View?) = _onViewAttachedToWindow?.invoke(p0)

    public fun onViewAttachedToWindow(listener: (android.view.View?) -> Unit) {
        _onViewAttachedToWindow = listener
    }
    override fun onViewDetachedFromWindow(p0: android.view.View?) = _onViewDetachedFromWindow?.invoke(p0)

    public fun onViewDetachedFromWindow(listener: (android.view.View?) -> Unit) {
        _onViewDetachedFromWindow = listener
    }
}

class __ViewGroup_OnHierarchyChangeListener : android.view.ViewGroup.OnHierarchyChangeListener {
    private var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit)? = null
    private var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit)? = null

    override fun onChildViewAdded(p0: android.view.View?, p1: android.view.View?) = _onChildViewAdded?.invoke(p0, p1)

    public fun onChildViewAdded(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewAdded = listener
    }
    override fun onChildViewRemoved(p0: android.view.View?, p1: android.view.View?) = _onChildViewRemoved?.invoke(p0, p1)

    public fun onChildViewRemoved(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewRemoved = listener
    }
}

class __AbsListView_OnScrollListener : android.widget.AbsListView.OnScrollListener {
    private var _onScrollStateChanged: ((android.widget.AbsListView?, Int) -> Unit)? = null
    private var _onScroll: ((android.widget.AbsListView?, Int, Int, Int) -> Unit)? = null

    override fun onScrollStateChanged(p0: android.widget.AbsListView?, p1: Int) = _onScrollStateChanged?.invoke(p0, p1)

    public fun onScrollStateChanged(listener: (android.widget.AbsListView?, Int) -> Unit) {
        _onScrollStateChanged = listener
    }
    override fun onScroll(p0: android.widget.AbsListView, p1: Int, p2: Int, p3: Int) = _onScroll?.invoke(p0, p1, p2, p3)

    public fun onScroll(listener: (android.widget.AbsListView?, Int, Int, Int) -> Unit) {
        _onScroll = listener
    }
}

class __AdapterView_OnItemSelectedListener : android.widget.AdapterView.OnItemSelectedListener {
    private var _onItemSelected: ((android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit)? = null
    private var _onNothingSelected: ((android.widget.AdapterView<*>?) -> Unit)? = null

    override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) = _onItemSelected?.invoke(p0, p1, p2, p3)

    public fun onItemSelected(listener: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) {
        _onItemSelected = listener
    }
    override fun onNothingSelected(p0: android.widget.AdapterView<*>?) = _onNothingSelected?.invoke(p0)

    public fun onNothingSelected(listener: (android.widget.AdapterView<*>?) -> Unit) {
        _onNothingSelected = listener
    }
}

class __SearchView_OnQueryTextListener : android.widget.SearchView.OnQueryTextListener {
    private var _onQueryTextSubmit: ((String?) -> Boolean)? = null
    private var _onQueryTextChange: ((String?) -> Boolean)? = null

    override fun onQueryTextSubmit(p0: String?) = _onQueryTextSubmit?.invoke(p0) ?: false

    public fun onQueryTextSubmit(listener: (String?) -> Boolean) {
        _onQueryTextSubmit = listener
    }
    override fun onQueryTextChange(p0: String?) = _onQueryTextChange?.invoke(p0) ?: false

    public fun onQueryTextChange(listener: (String?) -> Boolean) {
        _onQueryTextChange = listener
    }
}

class __SearchView_OnSuggestionListener : android.widget.SearchView.OnSuggestionListener {
    private var _onSuggestionSelect: ((Int) -> Boolean)? = null
    private var _onSuggestionClick: ((Int) -> Boolean)? = null

    override fun onSuggestionSelect(p0: Int) = _onSuggestionSelect?.invoke(p0) ?: false

    public fun onSuggestionSelect(listener: (Int) -> Boolean) {
        _onSuggestionSelect = listener
    }
    override fun onSuggestionClick(p0: Int) = _onSuggestionClick?.invoke(p0) ?: false

    public fun onSuggestionClick(listener: (Int) -> Boolean) {
        _onSuggestionClick = listener
    }
}

class __SeekBar_OnSeekBarChangeListener : android.widget.SeekBar.OnSeekBarChangeListener {
    private var _onProgressChanged: ((android.widget.SeekBar?, Int, Boolean) -> Unit)? = null
    private var _onStartTrackingTouch: ((android.widget.SeekBar?) -> Unit)? = null
    private var _onStopTrackingTouch: ((android.widget.SeekBar?) -> Unit)? = null

    override fun onProgressChanged(p0: android.widget.SeekBar, p1: Int, p2: Boolean) = _onProgressChanged?.invoke(p0, p1, p2)

    public fun onProgressChanged(listener: (android.widget.SeekBar?, Int, Boolean) -> Unit) {
        _onProgressChanged = listener
    }
    override fun onStartTrackingTouch(p0: android.widget.SeekBar?) = _onStartTrackingTouch?.invoke(p0)

    public fun onStartTrackingTouch(listener: (android.widget.SeekBar?) -> Unit) {
        _onStartTrackingTouch = listener
    }
    override fun onStopTrackingTouch(p0: android.widget.SeekBar) = _onStopTrackingTouch?.invoke(p0)

    public fun onStopTrackingTouch(listener: (android.widget.SeekBar?) -> Unit) {
        _onStopTrackingTouch = listener
    }
}

class __SlidingDrawer_OnDrawerScrollListener : android.widget.SlidingDrawer.OnDrawerScrollListener {
    private var _onScrollStarted: (() -> Unit)? = null
    private var _onScrollEnded: (() -> Unit)? = null

    override fun onScrollStarted() = _onScrollStarted?.invoke()

    public fun onScrollStarted(listener: () -> Unit) {
        _onScrollStarted = listener
    }
    override fun onScrollEnded() = _onScrollEnded?.invoke()

    public fun onScrollEnded(listener: () -> Unit) {
        _onScrollEnded = listener
    }
}

class __TextWatcher : android.text.TextWatcher {
    private var _beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var _onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var _afterTextChanged: ((android.text.Editable?) -> Unit)? = null

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = _beforeTextChanged?.invoke(p0, p1, p2, p3)

    public fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _beforeTextChanged = listener
    }
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = _onTextChanged?.invoke(p0, p1, p2, p3)

    public fun onTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _onTextChanged = listener
    }
    override fun afterTextChanged(p0: android.text.Editable?) = _afterTextChanged?.invoke(p0)

    public fun afterTextChanged(listener: (android.text.Editable?) -> Unit) {
        _afterTextChanged = listener
    }
}

