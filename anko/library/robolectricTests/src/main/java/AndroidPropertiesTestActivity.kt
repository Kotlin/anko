package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*

open class AndroidPropertiesTestActivity() : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            linearLayout {
                baseline
                baselineAlignedChildIndex = 0
                dividerPadding = 1
                orientation = -1
                showDividers = 0
                weightSum = 2.4f
                textSwitcher {}
                calendarView {
                    date = 123456
                    showWeekNumber = true
                }
                zoomButton {}
                viewSwitcher {}
                digitalClock {}
                multiAutoCompleteTextView {}
                checkBox {
                    isChecked = true
                }
                imageButton {}
                videoView {
                    val vv_currentPosition = currentPosition
                }
                horizontalScrollView {}
                numberPicker {
                    val np_displayedValues = displayedValues
                    maxValue = 3
                    value = 2134
                }
                analogClock {}
                scrollView {}
                textView {
                    compoundDrawablePadding = 23
                    customSelectionActionModeCallback = null
                    error = "error"
                    freezesText = false
                    imeOptions = 0
                    linksClickable = true
                }
                tabWidget {
                    val tw_tabCount = tabCount
                }
                radioButton {}
                toggleButton {
                    textOff = "12354"
                    textOn = "qwerty"
                }
                seekBar {}
                datePicker {
                    val dp_calendarView = calendarView
                    val dp_month = month
                    val dp_year = year
                }
                timePicker {
                    currentHour = 3
                }
                zoomControls {}
                imageView {
                    baseline = 234
                    imageMatrix = android.graphics.Matrix()
                }
                autoCompleteTextView {
                    dropDownAnchor = 0
                    dropDownHeight = 0
                    dropDownHorizontalOffset = 2
                    threshold = 2
                    validator = null
                }
                switch {
                    textOff = "918237"
                }
                progressBar {
                    progress = 34
                    secondaryProgress = 9
                }
                space {}
                listView {
                    val lv_checkItemIds = checkItemIds
                    itemsCanFocus = true
                    overscrollHeader = null
                }
                gridView {
                    gravity = 68
                    numColumns = 3
                }
                spinner {}
                gallery {}
                imageSwitcher {}
                checkedTextView {}
                chronometer {
                    base = 9
                    format = "%d%Y%m"

                }
                button {}
                editText {}
                ratingBar {
                    numStars = 3
                    rating = 3.4f
                    stepSize = 0.7f
                }
                stackView {}
                quickContactBadge {}
                twoLineListItem {}
                dialerFilter {
                    val df_digits = digits
                }
                tabHost {
                    currentTab = 2
                    val th_currentTabView = currentTabView

                }
                viewAnimator {}
                expandableListView {
                    adapter = null
                    val elv_selectedPosition = selectedPosition
                }
                viewFlipper {}
            }
        }
    }


}
