package com.stevechou.myexpensetracker.data.expense

import androidx.annotation.Keep
import androidx.room.*
import com.stevechou.myexpensetracker.domain.entity.Expense

@Dao
@Keep
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createExpense(vararg expense: Expense)

    @Query("SELECT * FROM expense WHERE id = :id")
    fun findCashFlowById(id : String) : Expense

    @Delete
    fun delete(expense: Expense)
}