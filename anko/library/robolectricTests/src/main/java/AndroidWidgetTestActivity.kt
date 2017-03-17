package com.example.android_test

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.*

open class AndroidWidgetTestActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        UI {
            verticalLayout {
                textSwitcher {}
                calendarView {}
                zoomButton {}
                viewSwitcher {}
                digitalClock {}
                multiAutoCompleteTextView {}
                checkBox {}
                imageButton {}
                videoView {}
                horizontalScrollView {}
                numberPicker {}
                analogClock {}
                scrollView {}
                textView {}
                tabWidget {}
                radioButton {}
                toggleButton {}
                seekBar {}
                datePicker {}
                radioGroup {}
                timePicker {}
                zoomControls {}
                imageView {}
                searchView {}
                autoCompleteTextView {}
                switch {}
                progressBar {}
                space {}
                listView {}
                gridView {}
                spinner {}
                gallery {}
                imageSwitcher {}
                checkedTextView {}
                chronometer {}
                button {}
                editText {}
                ratingBar {}
                stackView {}
                quickContactBadge {}
                twoLineListItem {}
                dialerFilter {}
                tabHost {}
                viewAnimator {}
                expandableListView {}
                viewFlipper {}
            }
        }
    }


}
