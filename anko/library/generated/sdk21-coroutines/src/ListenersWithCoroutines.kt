@file:JvmName("Sdk21CoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.sdk21.coroutines


import kotlin.coroutines.experimental.CoroutineContext
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import android.view.WindowInsets

fun android.view.View.onLayoutChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) -> Unit
) {
    addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
        launch(context) {
            handler(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom)
        }
    }
}

fun android.view.View.onAttachStateChangeListener(
        context: CoroutineContext = UI,
        init: __View_OnAttachStateChangeListener.() -> Unit
) {
    val listener = __View_OnAttachStateChangeListener(context)
    listener.init()
    addOnAttachStateChangeListener(listener)
}

class __View_OnAttachStateChangeListener(private val context: CoroutineContext) : android.view.View.OnAttachStateChangeListener {

    private var _onViewAttachedToWindow: (suspend CoroutineScope.(android.view.View) -> Unit)? = null
    

    override fun onViewAttachedToWindow(v: android.view.View) {
        val handler = _onViewAttachedToWindow ?: return
        launch(context) {
            handler(v)
        }
    }

    fun onViewAttachedToWindow(
            listener: suspend CoroutineScope.(android.view.View) -> Unit
    ) {
        _onViewAttachedToWindow = listener
    }

    private var _onViewDetachedFromWindow: (suspend CoroutineScope.(android.view.View) -> Unit)? = null
    

    override fun onViewDetachedFromWindow(v: android.view.View) {
        val handler = _onViewDetachedFromWindow ?: return
        launch(context) {
            handler(v)
        }
    }

    fun onViewDetachedFromWindow(
            listener: suspend CoroutineScope.(android.view.View) -> Unit
    ) {
        _onViewDetachedFromWindow = listener
    }

}fun android.widget.TextView.textChangedListener(
        context: CoroutineContext = UI,
        init: __TextWatcher.() -> Unit
) {
    val listener = __TextWatcher(context)
    listener.init()
    addTextChangedListener(listener)
}

class __TextWatcher(private val context: CoroutineContext) : android.text.TextWatcher {

    private var _beforeTextChanged: (suspend CoroutineScope.(CharSequence?, Int, Int, Int) -> Unit)? = null
    

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        val handler = _beforeTextChanged ?: return
        launch(context) {
            handler(s, start, count, after)
        }
    }

    fun beforeTextChanged(
            listener: suspend CoroutineScope.(CharSequence?, Int, Int, Int) -> Unit
    ) {
        _beforeTextChanged = listener
    }

    private var _onTextChanged: (suspend CoroutineScope.(CharSequence?, Int, Int, Int) -> Unit)? = null
    

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val handler = _onTextChanged ?: return
        launch(context) {
            handler(s, start, before, count)
        }
    }

    fun onTextChanged(
            listener: suspend CoroutineScope.(CharSequence?, Int, Int, Int) -> Unit
    ) {
        _onTextChanged = listener
    }

    private var _afterTextChanged: (suspend CoroutineScope.(android.text.Editable?) -> Unit)? = null
    

    override fun afterTextChanged(s: android.text.Editable?) {
        val handler = _afterTextChanged ?: return
        launch(context) {
            handler(s)
        }
    }

    fun afterTextChanged(
            listener: suspend CoroutineScope.(android.text.Editable?) -> Unit
    ) {
        _afterTextChanged = listener
    }

}fun android.gesture.GestureOverlayView.onGestureListener(
        context: CoroutineContext = UI,
        init: __GestureOverlayView_OnGestureListener.() -> Unit
) {
    val listener = __GestureOverlayView_OnGestureListener(context)
    listener.init()
    addOnGestureListener(listener)
}

class __GestureOverlayView_OnGestureListener(private val context: CoroutineContext) : android.gesture.GestureOverlayView.OnGestureListener {

    private var _onGestureStarted: (suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    

    override fun onGestureStarted(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) {
        val handler = _onGestureStarted ?: return
        launch(context) {
            handler(overlay, event)
        }
    }

    fun onGestureStarted(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit
    ) {
        _onGestureStarted = listener
    }

    private var _onGesture: (suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    

    override fun onGesture(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) {
        val handler = _onGesture ?: return
        launch(context) {
            handler(overlay, event)
        }
    }

    fun onGesture(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit
    ) {
        _onGesture = listener
    }

    private var _onGestureEnded: (suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    

    override fun onGestureEnded(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) {
        val handler = _onGestureEnded ?: return
        launch(context) {
            handler(overlay, event)
        }
    }

    fun onGestureEnded(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit
    ) {
        _onGestureEnded = listener
    }

    private var _onGestureCancelled: (suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit)? = null
    

    override fun onGestureCancelled(overlay: android.gesture.GestureOverlayView?, event: android.view.MotionEvent?) {
        val handler = _onGestureCancelled ?: return
        launch(context) {
            handler(overlay, event)
        }
    }

    fun onGestureCancelled(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit
    ) {
        _onGestureCancelled = listener
    }

}fun android.gesture.GestureOverlayView.onGesturePerformed(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(overlay: android.gesture.GestureOverlayView?, gesture: android.gesture.Gesture?) -> Unit
) {
    addOnGesturePerformedListener { overlay, gesture ->
        launch(context) {
            handler(overlay, gesture)
        }
    }
}

fun android.gesture.GestureOverlayView.onGesturingListener(
        context: CoroutineContext = UI,
        init: __GestureOverlayView_OnGesturingListener.() -> Unit
) {
    val listener = __GestureOverlayView_OnGesturingListener(context)
    listener.init()
    addOnGesturingListener(listener)
}

class __GestureOverlayView_OnGesturingListener(private val context: CoroutineContext) : android.gesture.GestureOverlayView.OnGesturingListener {

    private var _onGesturingStarted: (suspend CoroutineScope.(android.gesture.GestureOverlayView?) -> Unit)? = null
    

    override fun onGesturingStarted(overlay: android.gesture.GestureOverlayView?) {
        val handler = _onGesturingStarted ?: return
        launch(context) {
            handler(overlay)
        }
    }

    fun onGesturingStarted(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?) -> Unit
    ) {
        _onGesturingStarted = listener
    }

    private var _onGesturingEnded: (suspend CoroutineScope.(android.gesture.GestureOverlayView?) -> Unit)? = null
    

    override fun onGesturingEnded(overlay: android.gesture.GestureOverlayView?) {
        val handler = _onGesturingEnded ?: return
        launch(context) {
            handler(overlay)
        }
    }

    fun onGesturingEnded(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?) -> Unit
    ) {
        _onGesturingEnded = listener
    }

}fun android.media.tv.TvView.onUnhandledInputEvent(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(event: android.view.InputEvent?) -> Unit
) {
    setOnUnhandledInputEventListener { event ->
        launch(context) {
            handler(event)
        }
        returnValue
    }
}

fun android.view.View.onApplyWindowInsets(
        context: CoroutineContext = UI,
        returnValue: WindowInsets,
        handler: suspend CoroutineScope.(v: android.view.View?, insets: android.view.WindowInsets?) -> Unit
) {
    setOnApplyWindowInsetsListener { v, insets ->
        launch(context) {
            handler(v, insets)
        }
        returnValue
    }
}

fun android.view.View.onClick(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnClickListener { v ->
        launch(context) {
            handler(v)
        }
    }
}

fun android.view.View.onCreateContextMenu(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(menu: android.view.ContextMenu?, v: android.view.View?, menuInfo: android.view.ContextMenu.ContextMenuInfo?) -> Unit
) {
    setOnCreateContextMenuListener { menu, v, menuInfo ->
        launch(context) {
            handler(menu, v, menuInfo)
        }
    }
}

fun android.view.View.onDrag(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.DragEvent) -> Unit
) {
    setOnDragListener { v, event ->
        launch(context) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.View.onFocusChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View, hasFocus: Boolean) -> Unit
) {
    setOnFocusChangeListener { v, hasFocus ->
        launch(context) {
            handler(v, hasFocus)
        }
    }
}

fun android.view.View.onGenericMotion(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.MotionEvent) -> Unit
) {
    setOnGenericMotionListener { v, event ->
        launch(context) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.View.onHover(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.MotionEvent) -> Unit
) {
    setOnHoverListener { v, event ->
        launch(context) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.View.onKey(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, keyCode: Int, event: android.view.KeyEvent?) -> Unit
) {
    setOnKeyListener { v, keyCode, event ->
        launch(context) {
            handler(v, keyCode, event)
        }
        returnValue
    }
}

fun android.view.View.onLongClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnLongClickListener { v ->
        launch(context) {
            handler(v)
        }
        returnValue
    }
}

fun android.view.View.onSystemUiVisibilityChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(visibility: Int) -> Unit
) {
    setOnSystemUiVisibilityChangeListener { visibility ->
        launch(context) {
            handler(visibility)
        }
    }
}

fun android.view.View.onTouch(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.MotionEvent) -> Unit
) {
    setOnTouchListener { v, event ->
        launch(context) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.ViewGroup.onHierarchyChangeListener(
        context: CoroutineContext = UI,
        init: __ViewGroup_OnHierarchyChangeListener.() -> Unit
) {
    val listener = __ViewGroup_OnHierarchyChangeListener(context)
    listener.init()
    setOnHierarchyChangeListener(listener)
}

class __ViewGroup_OnHierarchyChangeListener(private val context: CoroutineContext) : android.view.ViewGroup.OnHierarchyChangeListener {

    private var _onChildViewAdded: (suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit)? = null
    

    override fun onChildViewAdded(parent: android.view.View?, child: android.view.View?) {
        val handler = _onChildViewAdded ?: return
        launch(context) {
            handler(parent, child)
        }
    }

    fun onChildViewAdded(
            listener: suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit
    ) {
        _onChildViewAdded = listener
    }

    private var _onChildViewRemoved: (suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit)? = null
    

    override fun onChildViewRemoved(parent: android.view.View?, child: android.view.View?) {
        val handler = _onChildViewRemoved ?: return
        launch(context) {
            handler(parent, child)
        }
    }

    fun onChildViewRemoved(
            listener: suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit
    ) {
        _onChildViewRemoved = listener
    }

}fun android.view.ViewStub.onInflate(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(stub: android.view.ViewStub?, inflated: android.view.View?) -> Unit
) {
    setOnInflateListener { stub, inflated ->
        launch(context) {
            handler(stub, inflated)
        }
    }
}

fun android.widget.AbsListView.onScrollListener(
        context: CoroutineContext = UI,
        init: __AbsListView_OnScrollListener.() -> Unit
) {
    val listener = __AbsListView_OnScrollListener(context)
    listener.init()
    setOnScrollListener(listener)
}

class __AbsListView_OnScrollListener(private val context: CoroutineContext) : android.widget.AbsListView.OnScrollListener {

    private var _onScrollStateChanged: (suspend CoroutineScope.(android.widget.AbsListView?, Int) -> Unit)? = null
    

    override fun onScrollStateChanged(view: android.widget.AbsListView?, scrollState: Int) {
        val handler = _onScrollStateChanged ?: return
        launch(context) {
            handler(view, scrollState)
        }
    }

    fun onScrollStateChanged(
            listener: suspend CoroutineScope.(android.widget.AbsListView?, Int) -> Unit
    ) {
        _onScrollStateChanged = listener
    }

    private var _onScroll: (suspend CoroutineScope.(android.widget.AbsListView?, Int, Int, Int) -> Unit)? = null
    

    override fun onScroll(view: android.widget.AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
        val handler = _onScroll ?: return
        launch(context) {
            handler(view, firstVisibleItem, visibleItemCount, totalItemCount)
        }
    }

    fun onScroll(
            listener: suspend CoroutineScope.(android.widget.AbsListView?, Int, Int, Int) -> Unit
    ) {
        _onScroll = listener
    }

}fun android.widget.ActionMenuView.onMenuItemClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        launch(context) {
            handler(item)
        }
        returnValue
    }
}

fun android.widget.AdapterView<out android.widget.Adapter>.onItemClick(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit
) {
    setOnItemClickListener { p0, p1, p2, p3 ->
        launch(context) {
            handler(p0, p1, p2, p3)
        }
    }
}

fun android.widget.AdapterView<out android.widget.Adapter>.onItemLongClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit
) {
    setOnItemLongClickListener { p0, p1, p2, p3 ->
        launch(context) {
            handler(p0, p1, p2, p3)
        }
        returnValue
    }
}

fun android.widget.AdapterView<out android.widget.Adapter>.onItemSelectedListener(
        context: CoroutineContext = UI,
        init: __AdapterView_OnItemSelectedListener.() -> Unit
) {
    val listener = __AdapterView_OnItemSelectedListener(context)
    listener.init()
    setOnItemSelectedListener(listener)
}

class __AdapterView_OnItemSelectedListener(private val context: CoroutineContext) : android.widget.AdapterView.OnItemSelectedListener {

    private var _onItemSelected: (suspend CoroutineScope.(android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit)? = null
    

    override fun onItemSelected(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) {
        val handler = _onItemSelected ?: return
        launch(context) {
            handler(p0, p1, p2, p3)
        }
    }

    fun onItemSelected(
            listener: suspend CoroutineScope.(android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit
    ) {
        _onItemSelected = listener
    }

    private var _onNothingSelected: (suspend CoroutineScope.(android.widget.AdapterView<*>?) -> Unit)? = null
    

    override fun onNothingSelected(p0: android.widget.AdapterView<*>?) {
        val handler = _onNothingSelected ?: return
        launch(context) {
            handler(p0)
        }
    }

    fun onNothingSelected(
            listener: suspend CoroutineScope.(android.widget.AdapterView<*>?) -> Unit
    ) {
        _onNothingSelected = listener
    }

}fun android.widget.AutoCompleteTextView.onDismiss(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDismissListener {  ->
        launch(context, block = handler)
    }
}

fun android.widget.CalendarView.onDateChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(view: android.widget.CalendarView?, year: Int, month: Int, dayOfMonth: Int) -> Unit
) {
    setOnDateChangeListener { view, year, month, dayOfMonth ->
        launch(context) {
            handler(view, year, month, dayOfMonth)
        }
    }
}

fun android.widget.Chronometer.onChronometerTick(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(chronometer: android.widget.Chronometer?) -> Unit
) {
    setOnChronometerTickListener { chronometer ->
        launch(context) {
            handler(chronometer)
        }
    }
}

fun android.widget.CompoundButton.onCheckedChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(buttonView: android.widget.CompoundButton?, isChecked: Boolean) -> Unit
) {
    setOnCheckedChangeListener { buttonView, isChecked ->
        launch(context) {
            handler(buttonView, isChecked)
        }
    }
}

fun android.widget.ExpandableListView.onChildClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, childPosition: Int, id: Long) -> Unit
) {
    setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
        launch(context) {
            handler(parent, v, groupPosition, childPosition, id)
        }
        returnValue
    }
}

fun android.widget.ExpandableListView.onGroupClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, id: Long) -> Unit
) {
    setOnGroupClickListener { parent, v, groupPosition, id ->
        launch(context) {
            handler(parent, v, groupPosition, id)
        }
        returnValue
    }
}

fun android.widget.ExpandableListView.onGroupCollapse(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(groupPosition: Int) -> Unit
) {
    setOnGroupCollapseListener { groupPosition ->
        launch(context) {
            handler(groupPosition)
        }
    }
}

fun android.widget.ExpandableListView.onGroupExpand(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(groupPosition: Int) -> Unit
) {
    setOnGroupExpandListener { groupPosition ->
        launch(context) {
            handler(groupPosition)
        }
    }
}

fun android.widget.NumberPicker.onScroll(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(view: android.widget.NumberPicker?, scrollState: Int) -> Unit
) {
    setOnScrollListener { view, scrollState ->
        launch(context) {
            handler(view, scrollState)
        }
    }
}

fun android.widget.NumberPicker.onValueChanged(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(picker: android.widget.NumberPicker?, oldVal: Int, newVal: Int) -> Unit
) {
    setOnValueChangedListener { picker, oldVal, newVal ->
        launch(context) {
            handler(picker, oldVal, newVal)
        }
    }
}

fun android.widget.RadioGroup.onCheckedChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(group: android.widget.RadioGroup?, checkedId: Int) -> Unit
) {
    setOnCheckedChangeListener { group, checkedId ->
        launch(context) {
            handler(group, checkedId)
        }
    }
}

fun android.widget.RatingBar.onRatingBarChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(ratingBar: android.widget.RatingBar?, rating: Float, fromUser: Boolean) -> Unit
) {
    setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
        launch(context) {
            handler(ratingBar, rating, fromUser)
        }
    }
}

fun android.widget.SearchView.onClose(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnCloseListener {  ->
        launch(context, block = handler)
        returnValue
    }
}

fun android.widget.SearchView.onQueryTextFocusChange(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View, hasFocus: Boolean) -> Unit
) {
    setOnQueryTextFocusChangeListener { v, hasFocus ->
        launch(context) {
            handler(v, hasFocus)
        }
    }
}

fun android.widget.SearchView.onQueryTextListener(
        context: CoroutineContext = UI,
        init: __SearchView_OnQueryTextListener.() -> Unit
) {
    val listener = __SearchView_OnQueryTextListener(context)
    listener.init()
    setOnQueryTextListener(listener)
}

class __SearchView_OnQueryTextListener(private val context: CoroutineContext) : android.widget.SearchView.OnQueryTextListener {

    private var _onQueryTextSubmit: (suspend CoroutineScope.(String?) -> Boolean)? = null
    private var _onQueryTextSubmit_returnValue: Boolean = false

    override fun onQueryTextSubmit(query: String?) : Boolean {
        val returnValue = _onQueryTextSubmit_returnValue
        val handler = _onQueryTextSubmit ?: return returnValue
        launch(context) {
            handler(query)
        }
        return returnValue
    }

    fun onQueryTextSubmit(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(String?) -> Boolean
    ) {
        _onQueryTextSubmit = listener
        _onQueryTextSubmit_returnValue = returnValue
    }

    private var _onQueryTextChange: (suspend CoroutineScope.(String?) -> Boolean)? = null
    private var _onQueryTextChange_returnValue: Boolean = false

    override fun onQueryTextChange(newText: String?) : Boolean {
        val returnValue = _onQueryTextChange_returnValue
        val handler = _onQueryTextChange ?: return returnValue
        launch(context) {
            handler(newText)
        }
        return returnValue
    }

    fun onQueryTextChange(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(String?) -> Boolean
    ) {
        _onQueryTextChange = listener
        _onQueryTextChange_returnValue = returnValue
    }

}fun android.widget.SearchView.onSearchClick(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnSearchClickListener { v ->
        launch(context) {
            handler(v)
        }
    }
}

fun android.widget.SearchView.onSuggestionListener(
        context: CoroutineContext = UI,
        init: __SearchView_OnSuggestionListener.() -> Unit
) {
    val listener = __SearchView_OnSuggestionListener(context)
    listener.init()
    setOnSuggestionListener(listener)
}

class __SearchView_OnSuggestionListener(private val context: CoroutineContext) : android.widget.SearchView.OnSuggestionListener {

    private var _onSuggestionSelect: (suspend CoroutineScope.(Int) -> Boolean)? = null
    private var _onSuggestionSelect_returnValue: Boolean = false

    override fun onSuggestionSelect(position: Int) : Boolean {
        val returnValue = _onSuggestionSelect_returnValue
        val handler = _onSuggestionSelect ?: return returnValue
        launch(context) {
            handler(position)
        }
        return returnValue
    }

    fun onSuggestionSelect(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(Int) -> Boolean
    ) {
        _onSuggestionSelect = listener
        _onSuggestionSelect_returnValue = returnValue
    }

    private var _onSuggestionClick: (suspend CoroutineScope.(Int) -> Boolean)? = null
    private var _onSuggestionClick_returnValue: Boolean = false

    override fun onSuggestionClick(position: Int) : Boolean {
        val returnValue = _onSuggestionClick_returnValue
        val handler = _onSuggestionClick ?: return returnValue
        launch(context) {
            handler(position)
        }
        return returnValue
    }

    fun onSuggestionClick(
            returnValue: Boolean = false,
            listener: suspend CoroutineScope.(Int) -> Boolean
    ) {
        _onSuggestionClick = listener
        _onSuggestionClick_returnValue = returnValue
    }

}fun android.widget.SeekBar.onSeekBarChangeListener(
        context: CoroutineContext = UI,
        init: __SeekBar_OnSeekBarChangeListener.() -> Unit
) {
    val listener = __SeekBar_OnSeekBarChangeListener(context)
    listener.init()
    setOnSeekBarChangeListener(listener)
}

class __SeekBar_OnSeekBarChangeListener(private val context: CoroutineContext) : android.widget.SeekBar.OnSeekBarChangeListener {

    private var _onProgressChanged: (suspend CoroutineScope.(android.widget.SeekBar?, Int, Boolean) -> Unit)? = null
    

    override fun onProgressChanged(seekBar: android.widget.SeekBar?, progress: Int, fromUser: Boolean) {
        val handler = _onProgressChanged ?: return
        launch(context) {
            handler(seekBar, progress, fromUser)
        }
    }

    fun onProgressChanged(
            listener: suspend CoroutineScope.(android.widget.SeekBar?, Int, Boolean) -> Unit
    ) {
        _onProgressChanged = listener
    }

    private var _onStartTrackingTouch: (suspend CoroutineScope.(android.widget.SeekBar?) -> Unit)? = null
    

    override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {
        val handler = _onStartTrackingTouch ?: return
        launch(context) {
            handler(seekBar)
        }
    }

    fun onStartTrackingTouch(
            listener: suspend CoroutineScope.(android.widget.SeekBar?) -> Unit
    ) {
        _onStartTrackingTouch = listener
    }

    private var _onStopTrackingTouch: (suspend CoroutineScope.(android.widget.SeekBar?) -> Unit)? = null
    

    override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {
        val handler = _onStopTrackingTouch ?: return
        launch(context) {
            handler(seekBar)
        }
    }

    fun onStopTrackingTouch(
            listener: suspend CoroutineScope.(android.widget.SeekBar?) -> Unit
    ) {
        _onStopTrackingTouch = listener
    }

}fun android.widget.SlidingDrawer.onDrawerClose(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDrawerCloseListener {  ->
        launch(context, block = handler)
    }
}

fun android.widget.SlidingDrawer.onDrawerOpen(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDrawerOpenListener {  ->
        launch(context, block = handler)
    }
}

fun android.widget.SlidingDrawer.onDrawerScrollListener(
        context: CoroutineContext = UI,
        init: __SlidingDrawer_OnDrawerScrollListener.() -> Unit
) {
    val listener = __SlidingDrawer_OnDrawerScrollListener(context)
    listener.init()
    setOnDrawerScrollListener(listener)
}

class __SlidingDrawer_OnDrawerScrollListener(private val context: CoroutineContext) : android.widget.SlidingDrawer.OnDrawerScrollListener {

    private var _onScrollStarted: (suspend CoroutineScope.() -> Unit)? = null
    

    override fun onScrollStarted() {
        val handler = _onScrollStarted ?: return
        launch(context, block = handler)
    }

    fun onScrollStarted(
            listener: suspend CoroutineScope.() -> Unit
    ) {
        _onScrollStarted = listener
    }

    private var _onScrollEnded: (suspend CoroutineScope.() -> Unit)? = null
    

    override fun onScrollEnded() {
        val handler = _onScrollEnded ?: return
        launch(context, block = handler)
    }

    fun onScrollEnded(
            listener: suspend CoroutineScope.() -> Unit
    ) {
        _onScrollEnded = listener
    }

}fun android.widget.TabHost.onTabChanged(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(tabId: String?) -> Unit
) {
    setOnTabChangedListener { tabId ->
        launch(context) {
            handler(tabId)
        }
    }
}

fun android.widget.TextView.onEditorAction(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.widget.TextView?, actionId: Int, event: android.view.KeyEvent?) -> Unit
) {
    setOnEditorActionListener { v, actionId, event ->
        launch(context) {
            handler(v, actionId, event)
        }
        returnValue
    }
}

fun android.widget.TimePicker.onTimeChanged(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) -> Unit
) {
    setOnTimeChangedListener { view, hourOfDay, minute ->
        launch(context) {
            handler(view, hourOfDay, minute)
        }
    }
}

fun android.widget.Toolbar.onMenuItemClick(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        launch(context) {
            handler(item)
        }
        returnValue
    }
}

fun android.widget.VideoView.onCompletion(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?) -> Unit
) {
    setOnCompletionListener { mp ->
        launch(context) {
            handler(mp)
        }
    }
}

fun android.widget.VideoView.onError(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Unit
) {
    setOnErrorListener { mp, what, extra ->
        launch(context) {
            handler(mp, what, extra)
        }
        returnValue
    }
}

fun android.widget.VideoView.onInfo(
        context: CoroutineContext = UI,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Unit
) {
    setOnInfoListener { mp, what, extra ->
        launch(context) {
            handler(mp, what, extra)
        }
        returnValue
    }
}

fun android.widget.VideoView.onPrepared(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?) -> Unit
) {
    setOnPreparedListener { mp ->
        launch(context) {
            handler(mp)
        }
    }
}

fun android.widget.ZoomControls.onZoomInClick(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnZoomInClickListener { v ->
        launch(context) {
            handler(v)
        }
    }
}

fun android.widget.ZoomControls.onZoomOutClick(
        context: CoroutineContext = UI,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnZoomOutClickListener { v ->
        launch(context) {
            handler(v)
        }
    }
}

