package com.stevechou.myexpensetracker.domain.entity

import java.util.*

data class LineItemImpl(
    val id: String,
    val name: String,
    val amount : Float,
    val frequency: Frequency,
    val accountId: String,
    val categoryId : String? = null,
    val note: String? = null,
    val occurrenceDate : Date
    // ignore create/modify time for now
)
