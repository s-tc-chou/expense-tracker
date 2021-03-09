package com.stevechou.myexpensetracker.data.account

import androidx.annotation.Keep
import androidx.room.*
import com.stevechou.myexpensetracker.domain.entity.Account

@Dao
@Keep
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg account: Account)

    @Query("SELECT * FROM accounts WHERE id = :id")
    fun findAccountById(id : String) : Account

    @Delete
    fun delete(account: Account)
}