package com.stevechou.myexpensetracker.data.expense

import com.stevechou.myexpensetracker.domain.LineItemDataSource
import com.stevechou.myexpensetracker.domain.entity.Frequency
import com.stevechou.myexpensetracker.domain.entity.LineItem
import com.stevechou.myexpensetracker.domain.entity.LineItemImpl
import com.stevechou.myexpensetracker.domain.entity.toLineItem
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

// implementation of ExpenseDataSource
class LineItemRepository @Inject constructor(private val lineItemDao: LineItemDao) :
    LineItemDataSource {
    override suspend fun createLineItem(lineItemImpl: LineItemImpl) {
        lineItemDao.createLineItem(lineItemImpl.toLineItem())
    }

    override suspend fun fetchLineItem(type: Frequency, startDate: Date?, endDate: Date?) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchLineItem(startDate: Date, endDate: Date): LineItemImpl {
        TODO("Not yet implemented")
    }

    override suspend fun fetchAllLineItems(accountId: String): Flow<List<LineItemImpl>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchRecurringLineItems(
        accountId: String,
        startDate: Date?,
        endDate: Date?
    ): Flow<List<LineItemImpl>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateLineItem(lineItem: LineItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLineItem(lineItemImpl: LineItemImpl) {
        lineItemDao.deleteLineItem(lineItemImpl.toLineItem())
    }

    override suspend fun deleteLineItemById(accountId: String) {
        TODO("Not yet implemented")
    }
}