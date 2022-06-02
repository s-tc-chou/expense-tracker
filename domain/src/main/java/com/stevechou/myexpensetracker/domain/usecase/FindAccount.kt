package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.Account

// kinda useless.  But we need something that can fetch a singular account by ID.
class FindAccount(private val accountsDataSource: AccountsDataSource) :
    UseCase<Account, Account>() {

    override suspend fun execute(request: Account): Account {
        return accountsDataSource.findAccount(request)
    }
}