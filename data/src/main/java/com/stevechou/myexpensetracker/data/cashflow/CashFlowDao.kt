package com.stevechou.myexpensetracker.data.cashflow

import androidx.annotation.Keep
import androidx.room.*
import com.stevechou.myexpensetracker.domain.entity.CashFlow
import com.stevechou.myexpensetracker.domain.entity.Category

@Dao
@Keep
interface CashFlowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cashFlow: CashFlow)

    @Query("SELECT * FROM cashFlow WHERE id = :id")
    fun findCashFlowById(id : String) : CashFlow

    @Query("SELECT * FROM cashFlow WHERE id = :id")
    fun findCashFlowByCategoryId(id : String) : CashFlow

    @Query("SELECT * FROM cashFlow WHERE recurring = 1")
    fun findRecurringCashFlows() : List<CashFlow>

    @Query("SELECT * FROM cashFlow WHERE recurring != 1")
    fun findOneTimeCashFlows() : List<CashFlow>

    @Delete
    fun delete(cashFlow: CashFlow)
}