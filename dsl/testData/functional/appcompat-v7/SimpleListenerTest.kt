public fun android.support.v7.widget.ActionMenuView.onMenuItemClick(l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}

public fun android.support.v7.widget.SearchView.onClose(l: () -> Boolean) {
    setOnCloseListener(l)
}

public fun android.support.v7.widget.SearchView.onQueryTextFocusChange(l: (v: android.view.View, hasFocus: Boolean) -> Unit) {
    setOnQueryTextFocusChangeListener(l)
}

public fun android.support.v7.widget.SearchView.onSearchClick(l: (v: android.view.View?) -> Unit) {
    setOnSearchClickListener(l)
}

public fun android.support.v7.widget.Toolbar.onMenuItemClick(l: (item: android.view.MenuItem?) -> Boolean) {
    setOnMenuItemClickListener(l)
}