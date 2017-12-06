Since v0.10.4 there is a DSL for ConstraintLayout in Anko. To use it you should add this dependency to your build script:
```
compile "org.jetbrains.anko:anko-constraint-layout:$anko_version"
```
It is based on `constraint-layout:1.1.0-beta4` so make sure you also have this dependency:
```
compile "com.android.support.constraint:constraint-layout:1.1.0-beta4"
```

## Usage

You can configure constraints in two different ways, by defining `ConstraintSet` or by defining `lparams` for views like you do for other Anko layouts. The recommended way is to use `ConstraintSet`, since it was designed for defining constraints programmatically. 

### Defining `ConstraintSet`

There are `constraintSet` and `applyConstraintSet` DSL blocks available. `constraintSet` creates `ConstraintSet` from the `ConstraintLayout` which can be applied later. `applyConstraintSet` creates and applies `ConstraintSet` to the `ConstraintLayout`.

```kotlin
constraintLayout {

    val sessionStart = textView {
        id = R.id.session_start
        textSize = 18f
        textColor = theme.getColor(R.attr.colorAccent)
    }

    val sessionTitle = textView {
        id = R.id.session_title
        textSize = 18f
        textColor = Color.BLACK
    }.lparams(0, wrapContent)

    textView {
        id = R.id.session_details
        textSize = 16f
    }.lparams(0, wrapContent)

    applyConstraintSet {
        // Connect without block
        // You may use view id or view itself to define connections
        connect(
                START of R.id.session_start to START of PARENT_ID margin dip(10),
                TOP of sessionStart to TOP of PARENT_ID margin dip(10)
        )

        // constraint configuration on view
        sessionTitle {
            connect(
                    START to START of PARENT_ID margin dip(SESSION_LIST_HEADER_MARGIN),
                    TOP to TOP of PARENT_ID margin dip(10),
                    END to END of PARENT_ID margin dip(10),
                    BOTTOM to TOP of R.id.session_details
            )

            horizontalBias = 0.0f
            defaultWidth = MATCH_CONSTRAINT_WRAP
        }

        // constraint configuration on view Id
        R.id.session_details {
            connect(
                    START to START of PARENT_ID margin dip(SESSION_LIST_HEADER_MARGIN),
                    TOP to BOTTOM of sessionTitle margin dip(2),
                    END to END of PARENT_ID margin dip(10),
                    BOTTOM to BOTTOM of PARENT_ID margin dip(2)
            )

            horizontalBias = 0.0f
            defaultWidth = MATCH_CONSTRAINT_WRAP
        }
    }
}
```

Take a look at more complex layout: [codelabs sample reimplemented with anko](https://github.com/4u7/constraint-layout/blob/master/constraint-layout-start/app/src/main/java/com/google/googleio/MainActivity.kt#L37).

### Defining `lparams` for views

```kotlin
constraintLayout {

    textView {
        id = R.id.session_start
        textSize = 18f
        textColor = theme.getColor(R.attr.colorAccent)
    }.lparams(width = wrapContent, height = wrapContent) {
        margin = dip(10)
        leftToLeft = PARENT_ID
        topToTop = PARENT_ID
    }

    textView {
        id = R.id.session_title
        textSize = 18f
        textColor = Color.BLACK
    }.lparams(width = 0, height = wrapContent) {
        leftMargin = dip(SESSION_LIST_HEADER_MARGIN)
        topMargin = dip(10)
        rightMargin = dip(10)
        bottomMargin = dip(2)
        leftToLeft = PARENT_ID
        topToTop = PARENT_ID
        rightToRight = PARENT_ID
        bottomToTop = R.id.session_details
        horizontalBias = 0.0f
        matchConstraintDefaultWidth = MATCH_CONSTRAINT_WRAP
    }

    textView {
        id = R.id.session_details
        textSize = 16f
    }.lparams(width = 0, height = wrapContent) {
        leftMargin = dip(SESSION_LIST_HEADER_MARGIN)
        rightMargin = dip(10)
        bottomMargin = dip(10)
        leftToLeft = PARENT_ID
        topToBottom = R.id.session_title
        bottomToBottom = PARENT_ID
        rightToRight = PARENT_ID
        horizontalBias = 0.0f
        matchConstraintDefaultWidth = MATCH_CONSTRAINT_WRAP
    }
}
```