package com.stevechou.myexpensetracker.domain

import com.stevechou.myexpensetracker.domain.entity.Frequency
import com.stevechou.myexpensetracker.domain.entity.LineItem
import com.stevechou.myexpensetracker.domain.entity.LineItemImpl
import kotlinx.coroutines.flow.Flow
import java.util.*

interface LineItemDataSource {
    suspend fun createLineItem(LineItemImpl: LineItemImpl)
    suspend fun fetchLineItem(type: Frequency, startDate: Date?, endDate: Date?)
    suspend fun fetchLineItem(startDate: Date, endDate: Date): LineItemImpl
    suspend fun fetchAllLineItems(accountId: String): Flow<List<LineItemImpl>>
    suspend fun fetchRecurringLineItems(
        accountId: String,
        startDate: Date?,
        endDate: Date?
    ): Flow<List<LineItemImpl>>

    suspend fun updateLineItem(lineItem: LineItem)
    suspend fun deleteLineItem(LineItemImpl: LineItemImpl)
    suspend fun deleteLineItemById(accountId: String)
}