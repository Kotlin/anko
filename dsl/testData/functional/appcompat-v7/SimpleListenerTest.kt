inline fun android.support.v7.widget.ActionMenuView.onMenuItemClick(noinline l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

inline fun android.support.v7.widget.SearchView.onClose(noinline l: () -> Boolean) {
    setOnCloseListener(l)
}

inline fun android.support.v7.widget.SearchView.onQueryTextFocusChange(noinline l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnQueryTextFocusChangeListener(l)
}

inline fun android.support.v7.widget.SearchView.onSearchClick(noinline l: (v: android.view.View?) -> Unit) {
    setOnSearchClickListener(l)
}

inline fun android.support.v7.widget.Toolbar.onMenuItemClick(noinline l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}