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

