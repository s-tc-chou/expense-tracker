package com.stevechou.myexpensetracker.data.cashflow

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stevechou.myexpensetracker.domain.entity.CashFlow

@Database(entities = [CashFlow::class], version = 1)
abstract class CashFlowDatabase : RoomDatabase() {
    abstract fun cashFlowDao() : CashFlowDao
}