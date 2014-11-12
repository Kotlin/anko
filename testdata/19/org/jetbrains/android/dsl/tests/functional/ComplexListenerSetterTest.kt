public fun android.inputmethodservice.KeyboardView.onPress(act: (Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onPress = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.onRelease(act: (Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onRelease = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.onKey(act: (Int, IntArray?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onKey = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.onText(act: (CharSequence?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._onText = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.swipeLeft(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeLeft = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.swipeRight(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeRight = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.swipeDown(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeDown = act
    l!!.apply()
  }
}

public fun android.inputmethodservice.KeyboardView.swipeUp(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener? =
      props.listeners.get("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener") as? __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener
    if (l == null) {
      l = __KeyboardView_setOnKeyboardActionListener_KeyboardView_OnKeyboardActionListener(this)
      props.listeners.put("android.inputmethodservice.KeyboardView_setOnKeyboardActionListener", l!!)
    }
    l!!._swipeUp = act
    l!!.apply()
  }
}

public fun android.view.ViewGroup.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.view.ViewGroup_setOnHierarchyChangeListener") as? __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.view.ViewGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
    l!!.apply()
  }
}

public fun android.view.ViewGroup.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.view.ViewGroup_setOnHierarchyChangeListener") as? __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __ViewGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.view.ViewGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
    l!!.apply()
  }
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onItemSelected(act: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener") as? __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l == null) {
      l = __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener", l!!)
    }
    l!!._onItemSelected = act
    l!!.apply()
  }
}

public fun android.widget.AdapterView<out android.widget.Adapter?>.onNothingSelected(act: (android.widget.AdapterView<*>?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener") as? __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l == null) {
      l = __AdapterView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AdapterView<out android.widget.Adapter?>_setOnItemSelectedListener", l!!)
    }
    l!!._onNothingSelected = act
    l!!.apply()
  }
}

public fun android.widget.SlidingDrawer.onScrollStarted(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener? =
      props.listeners.get("android.widget.SlidingDrawer_setOnDrawerScrollListener") as? __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener
    if (l == null) {
      l = __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener(this)
      props.listeners.put("android.widget.SlidingDrawer_setOnDrawerScrollListener", l!!)
    }
    l!!._onScrollStarted = act
    l!!.apply()
  }
}

public fun android.widget.SlidingDrawer.onScrollEnded(act: () -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener? =
      props.listeners.get("android.widget.SlidingDrawer_setOnDrawerScrollListener") as? __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener
    if (l == null) {
      l = __SlidingDrawer_setOnDrawerScrollListener_SlidingDrawer_OnDrawerScrollListener(this)
      props.listeners.put("android.widget.SlidingDrawer_setOnDrawerScrollListener", l!!)
    }
    l!!._onScrollEnded = act
    l!!.apply()
  }
}

public fun android.widget.AbsListView.onScrollStateChanged(act: (android.widget.AbsListView?, Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __AbsListView_setOnScrollListener_AbsListView_OnScrollListener? =
      props.listeners.get("android.widget.AbsListView_setOnScrollListener") as? __AbsListView_setOnScrollListener_AbsListView_OnScrollListener
    if (l == null) {
      l = __AbsListView_setOnScrollListener_AbsListView_OnScrollListener(this)
      props.listeners.put("android.widget.AbsListView_setOnScrollListener", l!!)
    }
    l!!._onScrollStateChanged = act
    l!!.apply()
  }
}

public fun android.widget.AbsListView.onScroll(act: (android.widget.AbsListView?, Int, Int, Int) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __AbsListView_setOnScrollListener_AbsListView_OnScrollListener? =
      props.listeners.get("android.widget.AbsListView_setOnScrollListener") as? __AbsListView_setOnScrollListener_AbsListView_OnScrollListener
    if (l == null) {
      l = __AbsListView_setOnScrollListener_AbsListView_OnScrollListener(this)
      props.listeners.put("android.widget.AbsListView_setOnScrollListener", l!!)
    }
    l!!._onScroll = act
    l!!.apply()
  }
}

public fun android.widget.RadioGroup.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.RadioGroup_setOnHierarchyChangeListener") as? __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.RadioGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
    l!!.apply()
  }
}

public fun android.widget.RadioGroup.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.RadioGroup_setOnHierarchyChangeListener") as? __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __RadioGroup_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.RadioGroup_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
    l!!.apply()
  }
}

public fun android.widget.TableLayout.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableLayout_setOnHierarchyChangeListener") as? __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableLayout_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
    l!!.apply()
  }
}

public fun android.widget.TableLayout.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableLayout_setOnHierarchyChangeListener") as? __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __TableLayout_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableLayout_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
    l!!.apply()
  }
}

public fun android.widget.TableRow.onChildViewAdded(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableRow_setOnHierarchyChangeListener") as? __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableRow_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewAdded = act
    l!!.apply()
  }
}

public fun android.widget.TableRow.onChildViewRemoved(act: (android.view.View?, android.view.View?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener? =
      props.listeners.get("android.widget.TableRow_setOnHierarchyChangeListener") as? __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener
    if (l == null) {
      l = __TableRow_setOnHierarchyChangeListener_ViewGroup_OnHierarchyChangeListener(this)
      props.listeners.put("android.widget.TableRow_setOnHierarchyChangeListener", l!!)
    }
    l!!._onChildViewRemoved = act
    l!!.apply()
  }
}

public fun android.widget.SearchView.onQueryTextSubmit(act: (String?) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener? =
      props.listeners.get("android.widget.SearchView_setOnQueryTextListener") as? __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener
    if (l == null) {
      l = __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener(this)
      props.listeners.put("android.widget.SearchView_setOnQueryTextListener", l!!)
    }
    l!!._onQueryTextSubmit = act
    l!!.apply()
  }
}

public fun android.widget.SearchView.onQueryTextChange(act: (String?) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener? =
      props.listeners.get("android.widget.SearchView_setOnQueryTextListener") as? __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener
    if (l == null) {
      l = __SearchView_setOnQueryTextListener_SearchView_OnQueryTextListener(this)
      props.listeners.put("android.widget.SearchView_setOnQueryTextListener", l!!)
    }
    l!!._onQueryTextChange = act
    l!!.apply()
  }
}

public fun android.widget.SearchView.onSuggestionSelect(act: (Int) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener? =
      props.listeners.get("android.widget.SearchView_setOnSuggestionListener") as? __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener
    if (l == null) {
      l = __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener(this)
      props.listeners.put("android.widget.SearchView_setOnSuggestionListener", l!!)
    }
    l!!._onSuggestionSelect = act
    l!!.apply()
  }
}

public fun android.widget.SearchView.onSuggestionClick(act: (Int) -> Boolean) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener? =
      props.listeners.get("android.widget.SearchView_setOnSuggestionListener") as? __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener
    if (l == null) {
      l = __SearchView_setOnSuggestionListener_SearchView_OnSuggestionListener(this)
      props.listeners.put("android.widget.SearchView_setOnSuggestionListener", l!!)
    }
    l!!._onSuggestionClick = act
    l!!.apply()
  }
}

public fun android.widget.AutoCompleteTextView.onItemSelected(act: (android.widget.AdapterView<*>?, android.view.View?, Int, Long) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AutoCompleteTextView_setOnItemSelectedListener") as? __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l == null) {
      l = __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AutoCompleteTextView_setOnItemSelectedListener", l!!)
    }
    l!!._onItemSelected = act
    l!!.apply()
  }
}

public fun android.widget.AutoCompleteTextView.onNothingSelected(act: (android.widget.AdapterView<*>?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener? =
      props.listeners.get("android.widget.AutoCompleteTextView_setOnItemSelectedListener") as? __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener
    if (l == null) {
      l = __AutoCompleteTextView_setOnItemSelectedListener_AdapterView_OnItemSelectedListener(this)
      props.listeners.put("android.widget.AutoCompleteTextView_setOnItemSelectedListener", l!!)
    }
    l!!._onNothingSelected = act
    l!!.apply()
  }
}

public fun android.widget.SeekBar.onProgressChanged(act: (android.widget.SeekBar?, Int, Boolean) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener? =
      props.listeners.get("android.widget.SeekBar_setOnSeekBarChangeListener") as? __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener
    if (l == null) {
      l = __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(this)
      props.listeners.put("android.widget.SeekBar_setOnSeekBarChangeListener", l!!)
    }
    l!!._onProgressChanged = act
    l!!.apply()
  }
}

public fun android.widget.SeekBar.onStartTrackingTouch(act: (android.widget.SeekBar?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener? =
      props.listeners.get("android.widget.SeekBar_setOnSeekBarChangeListener") as? __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener
    if (l == null) {
      l = __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(this)
      props.listeners.put("android.widget.SeekBar_setOnSeekBarChangeListener", l!!)
    }
    l!!._onStartTrackingTouch = act
    l!!.apply()
  }
}

public fun android.widget.SeekBar.onStopTrackingTouch(act: (android.widget.SeekBar?) -> Unit) {
  val props = getTag() as? ViewProps
  if (props != null) {
    var l: __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener? =
      props.listeners.get("android.widget.SeekBar_setOnSeekBarChangeListener") as? __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener
    if (l == null) {
      l = __SeekBar_setOnSeekBarChangeListener_SeekBar_OnSeekBarChangeListener(this)
      props.listeners.put("android.widget.SeekBar_setOnSeekBarChangeListener", l!!)
    }
    l!!._onStopTrackingTouch = act
    l!!.apply()
  }
}

