package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.ExpenseDataSource
import com.stevechou.myexpensetracker.domain.entity.LineItemImpl

class DeleteExpense(private val dataSource: ExpenseDataSource) : UseCase<LineItemImpl, Unit>() {

    override suspend fun execute(request: LineItemImpl) {
        dataSource.deleteExpense(request)
    }
}
