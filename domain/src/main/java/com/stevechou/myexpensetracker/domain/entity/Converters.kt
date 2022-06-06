package com.stevechou.myexpensetracker.domain.entity

fun AccountImpl.toAccount(): Account {
    return Account(this.id, this.name, this.createdTime, this.modifiedTime)
}

fun Account.toAccountImpl(): AccountImpl {
    return AccountImpl(this.id, this.name, this.createdTime, this.modifiedTime)
}

// note: don't need impl for expense since I don't plan to pass it around, but for consistency sake we'll use it.
fun ExpenseImpl.toExpense(): Expense {
    return Expense(
        id = this.id,
        name = this.name,
        amount = this.amount,
        frequency = this.frequency,
        accountId = this.accountId,
        categoryId = this.categoryId,
        note = this.note,
        expenseDate = this.expenseDate
    )
}

fun Expense.toExpenseImpl(): ExpenseImpl {
    return ExpenseImpl(
        id = this.id,
        name = this.name,
        amount = this.amount,
        frequency = this.frequency,
        accountId = this.accountId,
        categoryId = this.categoryId,
        note = this.note,
        expenseDate = this.expenseDate
    )
}