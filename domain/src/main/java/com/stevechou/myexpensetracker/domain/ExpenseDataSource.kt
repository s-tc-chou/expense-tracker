package com.stevechou.myexpensetracker.domain

import com.stevechou.myexpensetracker.domain.entity.Expense
import com.stevechou.myexpensetracker.domain.entity.ExpenseImpl
import com.stevechou.myexpensetracker.domain.entity.Frequency
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ExpenseDataSource {
    suspend fun createExpense(ExpenseImpl: ExpenseImpl)
    suspend fun fetchExpense(type: Frequency, startDate: Date?, endDate: Date?)
    suspend fun fetchExpense(startDate: Date, endDate : Date): ExpenseImpl
    suspend fun fetchAllExpenses(accountId: String): Flow<List<ExpenseImpl>>
    suspend fun fetchRecurringExpenses(accountId: String, startDate: Date?, endDate: Date?): Flow<List<ExpenseImpl>>
    suspend fun updateExpense(expense: Expense)
    suspend fun deleteExpense(ExpenseImpl: ExpenseImpl)
    suspend fun deleteExpenseById(accountId: String)
}