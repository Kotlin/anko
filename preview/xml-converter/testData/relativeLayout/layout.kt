relativeLayout {
    button {
        id = Ids.button1
    }.layoutParams(width = matchParent, height = wrapContent) {
        toLeftOf(Ids.textView2)
        centerInParent()
    }
    textView {
        id = Ids.textView2
    }.layoutParams(width = wrapContent, height = matchParent) {
        below(Ids.button1)
        sameRight(Ids.button1)
        alignParentRight()
    }
}