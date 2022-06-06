package com.stevechou.myexpensetracker.summary

import com.stevechou.myexpensetracker.domain.entity.CashFlow
import com.stevechou.myexpensetracker.domain.entity.LineItem

data class Summary(val cashFlows: List<CashFlow>, val expens: List<LineItem>)
