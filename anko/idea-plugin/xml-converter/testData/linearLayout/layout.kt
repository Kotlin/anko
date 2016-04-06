linearLayout {
    button.lparams(width = matchParent, height = wrapContent) {
        gravity = Gravity.END
        bottomMargin = dip(5)
    }
    textView.lparams(width = wrapContent, height = matchParent) {
        gravity = Gravity.CENTER
        weight = 5
        margin = dip(10)
    }
}