package com.stevechou.myexpensetracker.data.expense

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExpenseDao::class], version = 1)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao() : ExpenseDao
}
