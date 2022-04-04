package com.stevechou.myexpensetracker.domain

import android.accounts.Account
import com.stevechou.myexpensetracker.domain.entity.Category

interface CategoryDataSource {
    suspend fun addNewCategory(category: Category)

    fun test()
}