package com.stevechou.myexpensetracker.data.expense

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stevechou.myexpensetracker.domain.entity.Expense

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao() : ExpenseDao
}
