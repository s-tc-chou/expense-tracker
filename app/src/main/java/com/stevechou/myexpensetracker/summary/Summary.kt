package com.stevechou.myexpensetracker.summary

import com.stevechou.myexpensetracker.domain.entity.CashFlow
import com.stevechou.myexpensetracker.domain.entity.Expense

data class Summary(val cashFlows: List<CashFlow>, val expenses: List<Expense>)
