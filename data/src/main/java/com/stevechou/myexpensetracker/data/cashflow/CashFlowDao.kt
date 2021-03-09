package com.stevechou.myexpensetracker.data.cashflow

import androidx.annotation.Keep
import androidx.room.*
import com.stevechou.myexpensetracker.domain.entity.CashFlow

@Dao
@Keep
interface CashFlowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cashFlow: CashFlow)

    @Query("SELECT * FROM cashflow WHERE id = :id")
    fun findCashFlowById(id : String) : CashFlow

    @Query("SELECT * FROM cashflow WHERE recurring = 1")
    fun findRecurringCashFlows() : List<CashFlow>

    @Delete
    fun delete(cashFlow: CashFlow)
}