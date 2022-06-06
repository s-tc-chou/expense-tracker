package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.ExpenseDataSource
import com.stevechou.myexpensetracker.domain.entity.ExpenseImpl

class DeleteExpense(private val dataSource: ExpenseDataSource) : UseCase<ExpenseImpl, Unit>() {

    override suspend fun execute(request: ExpenseImpl) {
        dataSource.deleteExpense(request)
    }
}
