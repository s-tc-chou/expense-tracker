package com.stevechou.myexpensetracker.data.expense

import com.stevechou.myexpensetracker.data.category.CategoryDao
import javax.inject.Inject

class ExpenseRepository @Inject constructor(
    private val expenseDao: ExpenseDao
) {

    fun test() : String {
        return "hello expense repo test"
    }
}