package com.stevechou.myexpensetracker.data.account

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stevechou.myexpensetracker.data.expense.LineItemDao
import com.stevechou.myexpensetracker.domain.entity.Account
import com.stevechou.myexpensetracker.domain.entity.LineItem

@Database(entities = [Account::class, LineItem::class], version = 1)
abstract class MasterDatabase : RoomDatabase() {
    abstract fun accountDao() : AccountDao
    abstract fun expenseDao() : LineItemDao
}