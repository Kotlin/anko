public fun android.support.v7.widget.SearchView.onQueryTextListener(init: __SearchViewSupport_OnQueryTextListener.() -> Unit) {
    val listener = __SearchViewSupport_OnQueryTextListener()
    listener.init()
    setOnQueryTextListener(listener)
}

public fun android.support.v7.widget.SearchView.onSuggestionListener(init: __SearchViewSupport_OnSuggestionListener.() -> Unit) {
    val listener = __SearchViewSupport_OnSuggestionListener()
    listener.init()
    setOnSuggestionListener(listener)
}