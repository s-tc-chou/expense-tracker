package com.stevechou.myexpensetracker.data.cashflow

import com.stevechou.myexpensetracker.domain.entity.CashFlow
import javax.inject.Inject

class CashFlowRepository @Inject constructor(
    private val cashFlowDao: CashFlowDao
) {
    fun insert(cashFlow: CashFlow) {
        cashFlowDao.insertAll(cashFlow)
    }

    fun deleteCashFlow(cashFlow: CashFlow) {
        cashFlowDao.delete(cashFlow)
    }

    fun findCashFlowById(id : String) : CashFlow {
        return cashFlowDao.findCashFlowById(id)
    }

    fun findCashFlow(cashFlow: CashFlow) : CashFlow {
        return cashFlowDao.findCashFlowById(cashFlow.id)
    }

    fun findRecurringCashFlow() : List<CashFlow> {
        return cashFlowDao.findRecurringCashFlows()
    }

    fun test() : String {
        return "hello account repo test"
    }
}