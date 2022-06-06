package com.stevechou.myexpensetracker.data.account

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stevechou.myexpensetracker.data.expense.ExpenseDao
import com.stevechou.myexpensetracker.domain.entity.Account
import com.stevechou.myexpensetracker.domain.entity.Expense

@Database(entities = [Account::class, Expense::class], version = 1)
abstract class MasterDatabase : RoomDatabase() {
    abstract fun accountDao() : AccountDao
    abstract fun expenseDao() : ExpenseDao
}