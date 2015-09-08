package org.jetbrains.anko

import android.view.*
import java.util.*

public fun View.childrenSequence(): Sequence<View> = ViewChildrenSequence(this)

public fun View.childrenRecursiveSequence(): Sequence<View> = ViewChildrenRecursiveSequence(this)

private class ViewChildrenSequence(private val view: View) : Sequence<View> {
    override fun iterator(): Iterator<View> {
        if (view !is ViewGroup) return emptyList<View>().iterator()
        return ViewIterator(view)
    }

    private class ViewIterator(private val view: ViewGroup) : Iterator<View> {
        private var index = 0
        private val count = view.childCount

        override fun next(): View {
            if (!hasNext()) throw NoSuchElementException()
            return view.getChildAt(index++)
        }

        override fun hasNext(): Boolean {
            checkCount()
            return index < count
        }

        private fun checkCount() {
            if (count != view.childCount) throw ConcurrentModificationException()
        }
    }
}

private class ViewChildrenRecursiveSequence(private val view: View) : Sequence<View> {
    override fun iterator() = RecursiveViewIterator(view)

    private class RecursiveViewIterator(private val view: View) : Iterator<View> {
        private val sequences = arrayListOf(sequenceOf(view))
        private var itemIterator: Iterator<View>? = null

        override fun next(): View {
            initItemIterator()
            val iterator = itemIterator ?: throw NoSuchElementException()

            val view = iterator.next()
            if (view is ViewGroup && view.childCount > 0) {
                sequences.add(view.childrenSequence())
            }
            return view
        }

        override fun hasNext(): Boolean {
            initItemIterator()
            val iterator = itemIterator ?: return false
            return iterator.hasNext()
        }

        private fun initItemIterator() {
            val seqs = sequences
            val iterator = itemIterator

            if (iterator == null || (!iterator.hasNext() && seqs.isNotEmpty())) {
                itemIterator = seqs.removeLast()?.iterator()
            } else {
                itemIterator = null
            }
        }

        @Suppress("NOTHING_TO_INLINE")
        private inline fun <T: Any> MutableList<T>.removeLast(): T? {
            if (isEmpty()) return null
            return remove(size() - 1)
        }
    }
}

