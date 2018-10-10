package org.jetbrains.anko

import android.view.Menu
import android.view.MenuItem
import android.view.SubMenu


/**
 * Create a plain menu item
 */
inline fun Menu.item(title: CharSequence, /*@DrawableRes*/ icon: Int = 0, checkable: Boolean = false): MenuItem =
        add(title).apply {
            setIcon(icon)
            isCheckable = checkable
        }

/**
 * Create a menu item and configure it
 */
inline fun Menu.item(title: CharSequence, /*@DrawableRes*/ icon: Int = 0, checkable: Boolean = false, configure: MenuItem.() -> Unit): MenuItem =
        add(title).apply {
            setIcon(icon)
            isCheckable = checkable
            configure()
        }

/**
 * Create a menu item with title from resources
 */
inline fun Menu.item(/*@StringRes*/ titleRes: Int, /*@DrawableRes*/ icon: Int = 0, checkable: Boolean = false): MenuItem =
        add(titleRes).apply {
            setIcon(icon)
            isCheckable = checkable
        }

/**
 * Create a menu item with title from resources and configure it
 */
inline fun Menu.item(/*@StringRes*/ titleRes: Int, /*@DrawableRes*/ icon: Int = 0, checkable: Boolean = false, configure: MenuItem.() -> Unit): MenuItem =
        add(titleRes).apply {
            setIcon(icon)
            isCheckable = checkable
            configure()
        }


/**
 * Create a submenu
 */
inline fun Menu.subMenu(title: CharSequence): SubMenu =
        addSubMenu(title)

/**
 * Create a submenu and configure it
 */
inline fun Menu.subMenu(title: CharSequence, configure: SubMenu.() -> Unit): SubMenu =
        addSubMenu(title).apply { configure() }

/**
 * Create a submenu with title from resources
 */
inline fun Menu.subMenu(/*@StringRes*/ titleRes: Int): SubMenu =
        addSubMenu(titleRes)

/**
 * Create a submenu with title from resources and configure it
 */
inline fun Menu.subMenu(/*@StringRes*/ titleRes: Int, configure: SubMenu.() -> Unit): SubMenu =
        addSubMenu(titleRes).apply { configure() }


/**
 * Create a checkable menu item for use in NavigationView
 */
inline fun Menu.navigationItem(title: CharSequence, /*@DrawableRes*/ icon: Int = 0): Unit {
    add(title).apply {
        setIcon(icon)
        isCheckable = true
    }
}

/**
 * Create a navigation item with OnClickListener
 */
inline fun Menu.navigationItem(title: CharSequence, /*@DrawableRes*/ icon: Int = 0, crossinline onClick: () -> Unit) {
    add(title).apply {
        setIcon(icon)
        isCheckable = true
        setOnMenuItemClickListener {
            onClick()
            false
        }
    }
}

/**
 * Create a navigation item with title from resources
 */
inline fun Menu.navigationItem(/*@StringRes*/ titleRes: Int, /*@DrawableRes*/ icon: Int = 0) {
    add(titleRes).apply {
        setIcon(icon)
        isCheckable = true
    }
}

/**
 * Create a navigation item with title from resources and onClick listener
 */
inline fun Menu.navigationItem(/*@StringRes*/ titleRes: Int, /*@DrawableRes*/ icon: Int = 0, crossinline onClick: () -> Unit) {
    add(titleRes).apply {
        setIcon(icon)
        isCheckable = true
        setOnMenuItemClickListener {
            onClick()
            false
        }
    }
}


/**
 * Set OnClickListener on a menu item
 */
inline fun MenuItem.onClick(consume: Boolean = true, crossinline action: () -> Unit): Unit {
    setOnMenuItemClickListener { action(); consume }
}