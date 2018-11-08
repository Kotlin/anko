@file:JvmName("Sdk23CoroutinesListenersWithCoroutinesKt")
package org.jetbrains.anko.sdk23.coroutines


import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineStart
import android.view.WindowInsets

fun android.view.View.onLayoutChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) -> Unit
) {
    addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom)
        }
    }
}

fun android.view.View.onAttachStateChangeListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(v)
        }
    }

    fun onViewDetachedFromWindow(
            listener: suspend CoroutineScope.(android.view.View) -> Unit
    ) {
        _onViewDetachedFromWindow = listener
    }

}fun android.widget.TextView.textChangedListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(s)
        }
    }

    fun afterTextChanged(
            listener: suspend CoroutineScope.(android.text.Editable?) -> Unit
    ) {
        _afterTextChanged = listener
    }

}fun android.gesture.GestureOverlayView.onGestureListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(overlay, event)
        }
    }

    fun onGestureCancelled(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?, android.view.MotionEvent?) -> Unit
    ) {
        _onGestureCancelled = listener
    }

}fun android.gesture.GestureOverlayView.onGesturePerformed(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(overlay: android.gesture.GestureOverlayView?, gesture: android.gesture.Gesture?) -> Unit
) {
    addOnGesturePerformedListener { overlay, gesture ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(overlay, gesture)
        }
    }
}

fun android.gesture.GestureOverlayView.onGesturingListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(overlay)
        }
    }

    fun onGesturingEnded(
            listener: suspend CoroutineScope.(android.gesture.GestureOverlayView?) -> Unit
    ) {
        _onGesturingEnded = listener
    }

}fun android.media.tv.TvView.onUnhandledInputEvent(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(event: android.view.InputEvent?) -> Unit
) {
    setOnUnhandledInputEventListener { event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(event)
        }
        returnValue
    }
}

fun android.view.View.onApplyWindowInsets(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: WindowInsets,
        handler: suspend CoroutineScope.(v: android.view.View?, insets: android.view.WindowInsets?) -> Unit
) {
    setOnApplyWindowInsetsListener { v, insets ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, insets)
        }
        returnValue
    }
}

fun android.view.View.onClick(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
    }
}

fun android.view.View.onContextClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnContextClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
        returnValue
    }
}

fun android.view.View.onCreateContextMenu(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(menu: android.view.ContextMenu?, v: android.view.View?, menuInfo: android.view.ContextMenu.ContextMenuInfo?) -> Unit
) {
    setOnCreateContextMenuListener { menu, v, menuInfo ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(menu, v, menuInfo)
        }
    }
}

fun android.view.View.onDrag(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.DragEvent) -> Unit
) {
    setOnDragListener { v, event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.View.onFocusChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View, hasFocus: Boolean) -> Unit
) {
    setOnFocusChangeListener { v, hasFocus ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, hasFocus)
        }
    }
}

fun android.view.View.onGenericMotion(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.MotionEvent) -> Unit
) {
    setOnGenericMotionListener { v, event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.View.onHover(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.MotionEvent) -> Unit
) {
    setOnHoverListener { v, event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.View.onKey(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, keyCode: Int, event: android.view.KeyEvent?) -> Unit
) {
    setOnKeyListener { v, keyCode, event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, keyCode, event)
        }
        returnValue
    }
}

fun android.view.View.onLongClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnLongClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
        returnValue
    }
}

fun android.view.View.onScrollChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) -> Unit
) {
    setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, scrollX, scrollY, oldScrollX, oldScrollY)
        }
    }
}

fun android.view.View.onSystemUiVisibilityChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(visibility: Int) -> Unit
) {
    setOnSystemUiVisibilityChangeListener { visibility ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(visibility)
        }
    }
}

fun android.view.View.onTouch(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.view.View, event: android.view.MotionEvent) -> Unit
) {
    setOnTouchListener { v, event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, event)
        }
        returnValue
    }
}

fun android.view.ViewGroup.onHierarchyChangeListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(parent, child)
        }
    }

    fun onChildViewRemoved(
            listener: suspend CoroutineScope.(android.view.View?, android.view.View?) -> Unit
    ) {
        _onChildViewRemoved = listener
    }

}fun android.view.ViewStub.onInflate(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(stub: android.view.ViewStub?, inflated: android.view.View?) -> Unit
) {
    setOnInflateListener { stub, inflated ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(stub, inflated)
        }
    }
}

fun android.widget.AbsListView.onScrollListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(view, firstVisibleItem, visibleItemCount, totalItemCount)
        }
    }

    fun onScroll(
            listener: suspend CoroutineScope.(android.widget.AbsListView?, Int, Int, Int) -> Unit
    ) {
        _onScroll = listener
    }

}fun android.widget.ActionMenuView.onMenuItemClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(item)
        }
        returnValue
    }
}

fun android.widget.AdapterView<out android.widget.Adapter>.onItemClick(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit
) {
    setOnItemClickListener { p0, p1, p2, p3 ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(p0, p1, p2, p3)
        }
    }
}

fun android.widget.AdapterView<out android.widget.Adapter>.onItemLongClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(p0: android.widget.AdapterView<*>?, p1: android.view.View?, p2: Int, p3: Long) -> Unit
) {
    setOnItemLongClickListener { p0, p1, p2, p3 ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(p0, p1, p2, p3)
        }
        returnValue
    }
}

fun android.widget.AdapterView<out android.widget.Adapter>.onItemSelectedListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(p0)
        }
    }

    fun onNothingSelected(
            listener: suspend CoroutineScope.(android.widget.AdapterView<*>?) -> Unit
    ) {
        _onNothingSelected = listener
    }

}fun android.widget.AutoCompleteTextView.onDismiss(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDismissListener {  ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT, block = handler)
    }
}

fun android.widget.CalendarView.onDateChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(view: android.widget.CalendarView?, year: Int, month: Int, dayOfMonth: Int) -> Unit
) {
    setOnDateChangeListener { view, year, month, dayOfMonth ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(view, year, month, dayOfMonth)
        }
    }
}

fun android.widget.Chronometer.onChronometerTick(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(chronometer: android.widget.Chronometer?) -> Unit
) {
    setOnChronometerTickListener { chronometer ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(chronometer)
        }
    }
}

fun android.widget.CompoundButton.onCheckedChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(buttonView: android.widget.CompoundButton?, isChecked: Boolean) -> Unit
) {
    setOnCheckedChangeListener { buttonView, isChecked ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(buttonView, isChecked)
        }
    }
}

fun android.widget.ExpandableListView.onChildClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, childPosition: Int, id: Long) -> Unit
) {
    setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(parent, v, groupPosition, childPosition, id)
        }
        returnValue
    }
}

fun android.widget.ExpandableListView.onGroupClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(parent: android.widget.ExpandableListView?, v: android.view.View?, groupPosition: Int, id: Long) -> Unit
) {
    setOnGroupClickListener { parent, v, groupPosition, id ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(parent, v, groupPosition, id)
        }
        returnValue
    }
}

fun android.widget.ExpandableListView.onGroupCollapse(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(groupPosition: Int) -> Unit
) {
    setOnGroupCollapseListener { groupPosition ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(groupPosition)
        }
    }
}

fun android.widget.ExpandableListView.onGroupExpand(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(groupPosition: Int) -> Unit
) {
    setOnGroupExpandListener { groupPosition ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(groupPosition)
        }
    }
}

fun android.widget.NumberPicker.onScroll(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(view: android.widget.NumberPicker?, scrollState: Int) -> Unit
) {
    setOnScrollListener { view, scrollState ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(view, scrollState)
        }
    }
}

fun android.widget.NumberPicker.onValueChanged(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(picker: android.widget.NumberPicker?, oldVal: Int, newVal: Int) -> Unit
) {
    setOnValueChangedListener { picker, oldVal, newVal ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(picker, oldVal, newVal)
        }
    }
}

fun android.widget.RadioGroup.onCheckedChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(group: android.widget.RadioGroup?, checkedId: Int) -> Unit
) {
    setOnCheckedChangeListener { group, checkedId ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(group, checkedId)
        }
    }
}

fun android.widget.RatingBar.onRatingBarChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(ratingBar: android.widget.RatingBar?, rating: Float, fromUser: Boolean) -> Unit
) {
    setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(ratingBar, rating, fromUser)
        }
    }
}

fun android.widget.SearchView.onClose(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnCloseListener {  ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT, block = handler)
        returnValue
    }
}

fun android.widget.SearchView.onQueryTextFocusChange(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View, hasFocus: Boolean) -> Unit
) {
    setOnQueryTextFocusChangeListener { v, hasFocus ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, hasFocus)
        }
    }
}

fun android.widget.SearchView.onQueryTextListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
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
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnSearchClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
    }
}

fun android.widget.SearchView.onSuggestionListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
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
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
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
        GlobalScope.launch(context) {
            handler(seekBar)
        }
    }

    fun onStopTrackingTouch(
            listener: suspend CoroutineScope.(android.widget.SeekBar?) -> Unit
    ) {
        _onStopTrackingTouch = listener
    }

}fun android.widget.SlidingDrawer.onDrawerClose(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDrawerCloseListener {  ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT, block = handler)
    }
}

fun android.widget.SlidingDrawer.onDrawerOpen(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.() -> Unit
) {
    setOnDrawerOpenListener {  ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT, block = handler)
    }
}

fun android.widget.SlidingDrawer.onDrawerScrollListener(
        context: CoroutineContext = Dispatchers.Main,
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
        GlobalScope.launch(context, block = handler)
    }

    fun onScrollStarted(
            listener: suspend CoroutineScope.() -> Unit
    ) {
        _onScrollStarted = listener
    }

    private var _onScrollEnded: (suspend CoroutineScope.() -> Unit)? = null
    

    override fun onScrollEnded() {
        val handler = _onScrollEnded ?: return
        GlobalScope.launch(context, block = handler)
    }

    fun onScrollEnded(
            listener: suspend CoroutineScope.() -> Unit
    ) {
        _onScrollEnded = listener
    }

}fun android.widget.TabHost.onTabChanged(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(tabId: String?) -> Unit
) {
    setOnTabChangedListener { tabId ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(tabId)
        }
    }
}

fun android.widget.TextView.onEditorAction(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(v: android.widget.TextView?, actionId: Int, event: android.view.KeyEvent?) -> Unit
) {
    setOnEditorActionListener { v, actionId, event ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v, actionId, event)
        }
        returnValue
    }
}

fun android.widget.TimePicker.onTimeChanged(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) -> Unit
) {
    setOnTimeChangedListener { view, hourOfDay, minute ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(view, hourOfDay, minute)
        }
    }
}

fun android.widget.Toolbar.onMenuItemClick(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(item: android.view.MenuItem?) -> Unit
) {
    setOnMenuItemClickListener { item ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(item)
        }
        returnValue
    }
}

fun android.widget.VideoView.onCompletion(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?) -> Unit
) {
    setOnCompletionListener { mp ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(mp)
        }
    }
}

fun android.widget.VideoView.onError(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Unit
) {
    setOnErrorListener { mp, what, extra ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(mp, what, extra)
        }
        returnValue
    }
}

fun android.widget.VideoView.onInfo(
        context: CoroutineContext = Dispatchers.Main,
        returnValue: Boolean = false,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?, what: Int, extra: Int) -> Unit
) {
    setOnInfoListener { mp, what, extra ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(mp, what, extra)
        }
        returnValue
    }
}

fun android.widget.VideoView.onPrepared(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(mp: android.media.MediaPlayer?) -> Unit
) {
    setOnPreparedListener { mp ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(mp)
        }
    }
}

fun android.widget.ZoomControls.onZoomInClick(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnZoomInClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
    }
}

fun android.widget.ZoomControls.onZoomOutClick(
        context: CoroutineContext = Dispatchers.Main,
        handler: suspend CoroutineScope.(v: android.view.View?) -> Unit
) {
    setOnZoomOutClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }
    }
}

