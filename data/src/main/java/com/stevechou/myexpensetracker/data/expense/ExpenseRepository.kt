package com.stevechou.myexpensetracker.data.expense

import javax.inject.Inject

class ExpenseRepository @Inject constructor(
    private val expenseDao: ExpenseDao
) {

    fun test() : String {
        return "hello expense repo test"
    }
}