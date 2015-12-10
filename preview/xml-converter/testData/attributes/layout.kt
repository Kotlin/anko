frameLayout {
    textView("Text") {
        backgroundColor = 0xff0000.opaque
        enabled = false
        hint = "Hint"
        id = Ids.textView1
        lines = 5
        paddingBottom = dip(4)
        paddingLeft = dip(1)
        paddingRight = dip(3)
        paddingTop = dip(2)
        tag = "Tag"
        textColor = 0x00ff00.opaque
        textSize = 17f
        visibility = View.INVISIBLE
    }.lparams(width = wrapContent, height = wrapContent)
    textView {
        backgroundColor = 0xeeffff00.toInt()
        textSize = 17f
    }.lparams(width = wrapContent, height = wrapContent)
    textView {
        backgroundResource = android.R.color.background_light
        textSize = 17f
    }.lparams(width = wrapContent, height = wrapContent)
}