package com.stevechou.myexpensetracker.domain.entity

fun AccountImpl.toAccount(): Account {
    return Account(this.id, this.name, this.createdTime, this.modifiedTime)
}

fun Account.toAccountImpl(): AccountImpl {
    return AccountImpl(this.id, this.name, this.createdTime, this.modifiedTime)
}

// note: don't need impl for line items since I don't plan to pass it around, but for consistency sake we'll use it.
fun LineItemImpl.toLineItem(): LineItem {
    return LineItem(
        id = this.id,
        name = this.name,
        amount = this.amount,
        frequency = this.frequency,
        accountId = this.accountId,
        categoryId = this.categoryId,
        note = this.note,
        occurrenceDate = this.occurrenceDate
    )
}

fun LineItem.toLineItemImpl(): LineItemImpl {
    return LineItemImpl(
        id = this.id,
        name = this.name,
        amount = this.amount,
        frequency = this.frequency,
        accountId = this.accountId,
        categoryId = this.categoryId,
        note = this.note,
        occurrenceDate = this.occurrenceDate
    )
}