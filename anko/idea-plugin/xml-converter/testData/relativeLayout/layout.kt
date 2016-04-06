relativeLayout {
    button {
        id = Ids.button1
    }.lparams(width = matchParent, height = wrapContent) {
        toLeftOf(Ids.textView2)
        centerInParent()
    }
    textView {
        id = Ids.textView2
    }.lparams(width = wrapContent, height = matchParent) {
        below(Ids.button1)
        sameRight(Ids.button1)
        alignParentRight()
    }
}