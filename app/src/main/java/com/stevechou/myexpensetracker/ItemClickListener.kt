package com.stevechou.myexpensetracker

interface ItemClickListener<T> {
    fun onItemClicked(item: T)
}