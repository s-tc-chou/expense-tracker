package com.stevechou.myexpensetracker.domain

import com.stevechou.myexpensetracker.domain.entity.Category

interface CategoryDataSource {
    suspend fun addNewCategory(category: Category)

    fun test()
}