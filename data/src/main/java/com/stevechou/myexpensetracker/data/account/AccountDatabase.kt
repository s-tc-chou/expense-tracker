package com.stevechou.myexpensetracker.data.account

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stevechou.myexpensetracker.domain.entity.Account

@Database(entities = [Account::class], version = 1)
abstract class AccountDatabase : RoomDatabase() {
    abstract fun accountDao() : AccountDao
}