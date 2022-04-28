package com.stevechou.myexpensetracker.data.category

import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryDao: CategoryDao
) {

    fun test() : String {
        return "hello category repo test"
    }
}