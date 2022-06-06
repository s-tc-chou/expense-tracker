package com.stevechou.myexpensetracker.data.expense

import androidx.annotation.Keep
import androidx.room.*
import com.stevechou.myexpensetracker.domain.entity.LineItem

@Dao
@Keep
interface LineItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createLineItem(vararg lineItem: LineItem)

    @Query("SELECT * FROM lineItem WHERE id = :id")
    fun findCashFlowById(id : String) : LineItem

    @Delete
    fun deleteLineItem(lineItem: LineItem)
}