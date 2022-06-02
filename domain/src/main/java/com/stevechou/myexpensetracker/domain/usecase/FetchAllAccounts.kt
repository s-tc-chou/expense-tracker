package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.Account

class FetchAllAccounts(private val accountsDataSource: AccountsDataSource) :
    UseCase<Unit, List<Account>>() {

    override suspend fun execute() : List<Account> {
        return accountsDataSource.fetchAllAccounts();
    }

}