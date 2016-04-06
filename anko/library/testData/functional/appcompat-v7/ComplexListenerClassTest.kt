class __SearchView_OnQueryTextListener : android.support.v7.widget.SearchView.OnQueryTextListener {
    private var _onQueryTextSubmit: ((String?) -> Boolean)? = null
    private var _onQueryTextChange: ((String?) -> Boolean)? = null

    override fun onQueryTextSubmit(query: String?) = _onQueryTextSubmit?.invoke(query) ?: false

    fun onQueryTextSubmit(listener: (String?) -> Boolean) {
        _onQueryTextSubmit = listener
    }

    override fun onQueryTextChange(newText: String?) = _onQueryTextChange?.invoke(newText) ?: false

    fun onQueryTextChange(listener: (String?) -> Boolean) {
        _onQueryTextChange = listener
    }

}

class __SearchView_OnSuggestionListener : android.support.v7.widget.SearchView.OnSuggestionListener {
    private var _onSuggestionSelect: ((Int) -> Boolean)? = null
    private var _onSuggestionClick: ((Int) -> Boolean)? = null

    override fun onSuggestionSelect(position: Int) = _onSuggestionSelect?.invoke(position) ?: false

    fun onSuggestionSelect(listener: (Int) -> Boolean) {
        _onSuggestionSelect = listener
    }

    override fun onSuggestionClick(position: Int) = _onSuggestionClick?.invoke(position) ?: false

    fun onSuggestionClick(listener: (Int) -> Boolean) {
        _onSuggestionClick = listener
    }

}