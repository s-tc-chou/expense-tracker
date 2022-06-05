package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.AccountImpl

// kinda useless.  But we need something that can fetch a singular account by ID.
class FindAccount(private val accountsDataSource: AccountsDataSource) :
    UseCase<AccountImpl, AccountImpl>() {

    override suspend fun execute(request: AccountImpl): AccountImpl {
        return accountsDataSource.findAccount(request)
    }
}