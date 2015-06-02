class __GestureOverlayView_OnGestureListener : android.gesture.GestureOverlayView.OnGestureListener {
    private var _onGestureStarted: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onGesture: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onGestureEnded: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onGestureCancelled: ((android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null

    override fun onGestureStarted(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) = _onGestureStarted?.invoke(overlay, event)

    public fun onGestureStarted(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGestureStarted = listener
    }

    override fun onGesture(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) = _onGesture?.invoke(overlay, event)

    public fun onGesture(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGesture = listener
    }

    override fun onGestureEnded(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) = _onGestureEnded?.invoke(overlay, event)

    public fun onGestureEnded(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGestureEnded = listener
    }

    override fun onGestureCancelled(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) = _onGestureCancelled?.invoke(overlay, event)

    public fun onGestureCancelled(listener: (android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit) {
        _onGestureCancelled = listener
    }

}

class __GestureOverlayView_OnGesturingListener : android.gesture.GestureOverlayView.OnGesturingListener {
    private var _onGesturingStarted: ((android.gesture.GestureOverlayView?) -> Unit)? = null
    private var _onGesturingEnded: ((android.gesture.GestureOverlayView?) -> Unit)? = null

    override fun onGesturingStarted(overlay: android.gesture.GestureOverlayView?) = _onGesturingStarted?.invoke(overlay)

    public fun onGesturingStarted(listener: (android.gesture.GestureOverlayView?) -> Unit) {
        _onGesturingStarted = listener
    }

    override fun onGesturingEnded(overlay: android.gesture.GestureOverlayView?) = _onGesturingEnded?.invoke(overlay)

    public fun onGesturingEnded(listener: (android.gesture.GestureOverlayView?) -> Unit) {
        _onGesturingEnded = listener
    }

}

class __TabLayout_OnTabSelectedListener : android.support.design.widget.TabLayout.OnTabSelectedListener {
    private var _onTabSelected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabUnselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null
    private var _onTabReselected: ((android.support.design.widget.TabLayout.Tab?) -> Unit)? = null

    override fun onTabSelected(p0: android.support.design.widget.TabLayout.Tab?) = _onTabSelected?.invoke(p0)

    public fun onTabSelected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabSelected = listener
    }

    override fun onTabUnselected(p0: android.support.design.widget.TabLayout.Tab?) = _onTabUnselected?.invoke(p0)

    public fun onTabUnselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabUnselected = listener
    }

    override fun onTabReselected(p0: android.support.design.widget.TabLayout.Tab?) = _onTabReselected?.invoke(p0)

    public fun onTabReselected(listener: (android.support.design.widget.TabLayout.Tab?) -> Unit) {
        _onTabReselected = listener
    }

}

class __ViewPagerV4_OnPageChangeListener : android.support.v4.view.ViewPager.OnPageChangeListener {
    private var _onPageScrolled: ((Int, Float, Int) -> Unit)? = null
    private var _onPageSelected: ((Int) -> Unit)? = null
    private var _onPageScrollStateChanged: ((Int) -> Unit)? = null

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = _onPageScrolled?.invoke(position, positionOffset, positionOffsetPixels)

    public fun onPageScrolled(listener: (Int, Float, Int) -> Unit) {
        _onPageScrolled = listener
    }

    override fun onPageSelected(position: Int) = _onPageSelected?.invoke(position)

    public fun onPageSelected(listener: (Int) -> Unit) {
        _onPageSelected = listener
    }

    override fun onPageScrollStateChanged(state: Int) = _onPageScrollStateChanged?.invoke(state)

    public fun onPageScrollStateChanged(listener: (Int) -> Unit) {
        _onPageScrollStateChanged = listener
    }

}

class __RecyclerViewV7_OnChildAttachStateChangeListener : android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener {
    private var _onChildViewAttachedToWindow: ((android.view.View?) -> Unit)? = null
    private var _onChildViewDetachedFromWindow: ((android.view.View?) -> Unit)? = null

    override fun onChildViewAttachedToWindow(p0: android.view.View?) = _onChildViewAttachedToWindow?.invoke(p0)

    public fun onChildViewAttachedToWindow(listener: (android.view.View?) -> Unit) {
        _onChildViewAttachedToWindow = listener
    }

    override fun onChildViewDetachedFromWindow(p0: android.view.View?) = _onChildViewDetachedFromWindow?.invoke(p0)

    public fun onChildViewDetachedFromWindow(listener: (android.view.View?) -> Unit) {
        _onChildViewDetachedFromWindow = listener
    }

}

class __RecyclerViewV7_OnItemTouchListener : android.support.v7.widget.RecyclerView.OnItemTouchListener {
    private var _onInterceptTouchEvent: ((android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Boolean)? = null
    private var _onTouchEvent: ((android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Unit)? = null
    private var _onRequestDisallowInterceptTouchEvent: ((Boolean) -> Unit)? = null

    override fun onInterceptTouchEvent(rv: android.support.v7.widget.RecyclerView?, e: android.view.MotionEvent?) = _onInterceptTouchEvent?.invoke(rv, e) ?: false

    public fun onInterceptTouchEvent(listener: (android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Boolean) {
        _onInterceptTouchEvent = listener
    }

    override fun onTouchEvent(rv: android.support.v7.widget.RecyclerView?, e: android.view.MotionEvent?) = _onTouchEvent?.invoke(rv, e)

    public fun onTouchEvent(listener: (android.support.v7.widget.RecyclerView?, android.view.MotionEvent?) -> Unit) {
        _onTouchEvent = listener
    }

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) = _onRequestDisallowInterceptTouchEvent?.invoke(p0)

    public fun onRequestDisallowInterceptTouchEvent(listener: (Boolean) -> Unit) {
        _onRequestDisallowInterceptTouchEvent = listener
    }

}

class __RecyclerViewV7_OnScrollListener : android.support.v7.widget.RecyclerView.OnScrollListener() {
    private var _onScrollStateChanged: ((android.support.v7.widget.RecyclerView?, Int) -> Unit)? = null
    private var _onScrolled: ((android.support.v7.widget.RecyclerView?, Int, Int) -> Unit)? = null

    override fun onScrollStateChanged(recyclerView: android.support.v7.widget.RecyclerView?, newState: Int) = _onScrollStateChanged?.invoke(recyclerView, newState)

    public fun onScrollStateChanged(listener: (android.support.v7.widget.RecyclerView?, Int) -> Unit) {
        _onScrollStateChanged = listener
    }

    override fun onScrolled(recyclerView: android.support.v7.widget.RecyclerView?, dx: Int, dy: Int) = _onScrolled?.invoke(recyclerView, dx, dy)

    public fun onScrolled(listener: (android.support.v7.widget.RecyclerView?, Int, Int) -> Unit) {
        _onScrolled = listener
    }

}

class __SearchViewV7_OnQueryTextListener : android.support.v7.widget.SearchView.OnQueryTextListener {
    private var _onQueryTextSubmit: ((String?) -> Boolean)? = null
    private var _onQueryTextChange: ((String?) -> Boolean)? = null

    override fun onQueryTextSubmit(query: String?) = _onQueryTextSubmit?.invoke(query) ?: false

    public fun onQueryTextSubmit(listener: (String?) -> Boolean) {
        _onQueryTextSubmit = listener
    }

    override fun onQueryTextChange(newText: String?) = _onQueryTextChange?.invoke(newText) ?: false

    public fun onQueryTextChange(listener: (String?) -> Boolean) {
        _onQueryTextChange = listener
    }

}

class __SearchViewV7_OnSuggestionListener : android.support.v7.widget.SearchView.OnSuggestionListener {
    private var _onSuggestionSelect: ((Int) -> Boolean)? = null
    private var _onSuggestionClick: ((Int) -> Boolean)? = null

    override fun onSuggestionSelect(position: Int) = _onSuggestionSelect?.invoke(position) ?: false

    public fun onSuggestionSelect(listener: (Int) -> Boolean) {
        _onSuggestionSelect = listener
    }

    override fun onSuggestionClick(position: Int) = _onSuggestionClick?.invoke(position) ?: false

    public fun onSuggestionClick(listener: (Int) -> Boolean) {
        _onSuggestionClick = listener
    }

}

class __View_OnAttachStateChangeListener : android.view.View.OnAttachStateChangeListener {
    private var _onViewAttachedToWindow: ((android.view.View) -> Unit)? = null
    private var _onViewDetachedFromWindow: ((android.view.View) -> Unit)? = null

    override fun onViewAttachedToWindow(v: android.view.View) = _onViewAttachedToWindow?.invoke(v)

    public fun onViewAttachedToWindow(listener: (android.view.View) -> Unit) {
        _onViewAttachedToWindow = listener
    }

    override fun onViewDetachedFromWindow(v: android.view.View) = _onViewDetachedFromWindow?.invoke(v)

    public fun onViewDetachedFromWindow(listener: (android.view.View) -> Unit) {
        _onViewDetachedFromWindow = listener
    }

}

class __ViewGroup_OnHierarchyChangeListener : android.view.ViewGroup.OnHierarchyChangeListener {
    private var _onChildViewAdded: ((android.view.View?, android.view.View?) -> Unit)? = null
    private var _onChildViewRemoved: ((android.view.View?, android.view.View?) -> Unit)? = null

    override fun onChildViewAdded(parent: android.view.View?, child: android.view.View?) = _onChildViewAdded?.invoke(parent, child)

    public fun onChildViewAdded(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewAdded = listener
    }

    override fun onChildViewRemoved(parent: android.view.View?, child: android.view.View?) = _onChildViewRemoved?.invoke(parent, child)

    public fun onChildViewRemoved(listener: (android.view.View?, android.view.View?) -> Unit) {
        _onChildViewRemoved = listener
    }

}

class __AbsListView_OnScrollListener : android.widget.AbsListView.OnScrollListener {
    private var _onScrollStateChanged: ((android.widget.AbsListView?, Int) -> Unit)? = null
    private var _onScroll: ((android.widget.AbsListView, Int, Int, Int) -> Unit)? = null

    override fun onScrollStateChanged(view: android.widget.AbsListView?, scrollState: Int) = _onScrollStateChanged?.invoke(view, scrollState)

    public fun onScrollStateChanged(listener: (android.widget.AbsListView?, Int) -> Unit) {
        _onScrollStateChanged = listener
    }

    override fun onScroll(view: android.widget.AbsListView, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) = _onScroll?.invoke(view, firstVisibleItem, visibleItemCount, totalItemCount)

    public fun onScroll(listener: (android.widget.AbsListView, Int, Int, Int) -> Unit) {
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

    override fun onQueryTextSubmit(query: String?) = _onQueryTextSubmit?.invoke(query) ?: false

    public fun onQueryTextSubmit(listener: (String?) -> Boolean) {
        _onQueryTextSubmit = listener
    }

    override fun onQueryTextChange(newText: String?) = _onQueryTextChange?.invoke(newText) ?: false

    public fun onQueryTextChange(listener: (String?) -> Boolean) {
        _onQueryTextChange = listener
    }

}

class __SearchView_OnSuggestionListener : android.widget.SearchView.OnSuggestionListener {
    private var _onSuggestionSelect: ((Int) -> Boolean)? = null
    private var _onSuggestionClick: ((Int) -> Boolean)? = null

    override fun onSuggestionSelect(position: Int) = _onSuggestionSelect?.invoke(position) ?: false

    public fun onSuggestionSelect(listener: (Int) -> Boolean) {
        _onSuggestionSelect = listener
    }

    override fun onSuggestionClick(position: Int) = _onSuggestionClick?.invoke(position) ?: false

    public fun onSuggestionClick(listener: (Int) -> Boolean) {
        _onSuggestionClick = listener
    }

}

class __SeekBar_OnSeekBarChangeListener : android.widget.SeekBar.OnSeekBarChangeListener {
    private var _onProgressChanged: ((android.widget.SeekBar, Int, Boolean) -> Unit)? = null
    private var _onStartTrackingTouch: ((android.widget.SeekBar?) -> Unit)? = null
    private var _onStopTrackingTouch: ((android.widget.SeekBar) -> Unit)? = null

    override fun onProgressChanged(seekBar: android.widget.SeekBar, progress: Int, fromUser: Boolean) = _onProgressChanged?.invoke(seekBar, progress, fromUser)

    public fun onProgressChanged(listener: (android.widget.SeekBar, Int, Boolean) -> Unit) {
        _onProgressChanged = listener
    }

    override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) = _onStartTrackingTouch?.invoke(seekBar)

    public fun onStartTrackingTouch(listener: (android.widget.SeekBar?) -> Unit) {
        _onStartTrackingTouch = listener
    }

    override fun onStopTrackingTouch(seekBar: android.widget.SeekBar) = _onStopTrackingTouch?.invoke(seekBar)

    public fun onStopTrackingTouch(listener: (android.widget.SeekBar) -> Unit) {
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
    private var _onTextChanged: ((CharSequence, Int, Int, Int) -> Unit)? = null
    private var _afterTextChanged: ((android.text.Editable?) -> Unit)? = null

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = _beforeTextChanged?.invoke(s, start, count, after)

    public fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _beforeTextChanged = listener
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = _onTextChanged?.invoke(s, start, before, count)

    public fun onTextChanged(listener: (CharSequence, Int, Int, Int) -> Unit) {
        _onTextChanged = listener
    }

    override fun afterTextChanged(s: android.text.Editable?) = _afterTextChanged?.invoke(s)

    public fun afterTextChanged(listener: (android.text.Editable?) -> Unit) {
        _afterTextChanged = listener
    }

}

