package com.stevechou.myexpensetracker.data.expense

import com.stevechou.myexpensetracker.domain.ExpenseDataSource
import com.stevechou.myexpensetracker.domain.entity.Expense
import com.stevechou.myexpensetracker.domain.entity.ExpenseImpl
import com.stevechou.myexpensetracker.domain.entity.Frequency
import com.stevechou.myexpensetracker.domain.entity.toExpense
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

// implementation of ExpenseDataSource
class ExpenseRepository @Inject constructor(private val expenseDao: ExpenseDao) :
    ExpenseDataSource {
    override suspend fun createExpense(expense: ExpenseImpl) {
        expenseDao.createExpense(expense.toExpense())
    }

    override suspend fun fetchExpense(type: Frequency, startDate: Date?, endDate: Date?) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchExpense(startDate: Date, endDate: Date): ExpenseImpl {
        TODO("Not yet implemented")
    }

    override suspend fun fetchAllExpenses(accountId: String): Flow<List<ExpenseImpl>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchRecurringExpenses(
        accountId: String,
        startDate: Date?,
        endDate: Date?
    ): Flow<List<ExpenseImpl>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateExpense(expense: Expense) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteExpense(expenseImpl: ExpenseImpl) {
        expenseDao.delete(expenseImpl.toExpense())
    }

    override suspend fun deleteExpenseById(id: String) {
        TODO("Not yet implemented")
    }


}