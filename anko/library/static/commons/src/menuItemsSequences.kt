/*
 * Copyright 2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")
package org.jetbrains.anko

import android.view.Menu
import android.view.MenuItem
import java.util.ConcurrentModificationException
import java.util.NoSuchElementException

@Deprecated(message = "Use the Android KTX version", replaceWith = ReplaceWith("children", "androidx.core.view.children"))
fun Menu.itemsSequence(): Sequence<MenuItem> = MenuItemsSequence(this)

private class MenuItemsSequence(private val menu: Menu) : Sequence<MenuItem> {
    override fun iterator(): Iterator<MenuItem> = MenuItemIterator(menu)

    private class MenuItemIterator(private val menu: Menu) : Iterator<MenuItem> {
        private var index = 0
        private val count = menu.size()

        override fun next(): MenuItem {
            if (!hasNext()) {
                throw NoSuchElementException()
            }

            return menu.getItem(index++)
        }

        override fun hasNext(): Boolean {
            if (count != menu.size()) {
                throw ConcurrentModificationException()
            }

            return index < count
        }
    }
}
