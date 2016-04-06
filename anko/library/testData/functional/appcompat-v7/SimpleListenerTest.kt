fun android.support.v7.widget.ActionMenuView.onMenuItemClick(l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

fun android.support.v7.widget.SearchView.onClose(l: () -> Boolean) {
    setOnCloseListener(l)
}

fun android.support.v7.widget.SearchView.onQueryTextFocusChange(l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnQueryTextFocusChangeListener(l)
}

fun android.support.v7.widget.SearchView.onSearchClick(l: (v: android.view.View?) -> Unit) {
    setOnSearchClickListener(l)
}

fun android.support.v7.widget.Toolbar.onMenuItemClick(l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}