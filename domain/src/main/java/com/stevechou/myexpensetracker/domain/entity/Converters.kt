package com.stevechou.myexpensetracker.domain.entity

fun AccountImpl.toAccount(): Account {
    return Account(this.id, this.name, this.createdTime, this.modifiedTime)
}

fun Account.toAccountImpl() : AccountImpl {
    return AccountImpl(this.id, this.name, this.createdTime, this.modifiedTime)
}