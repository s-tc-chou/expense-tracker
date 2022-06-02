package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.Account
import kotlinx.coroutines.flow.Flow

class FetchAllAccounts(private val accountsDataSource: AccountsDataSource) :
    UseCase<Unit, Flow<List<Account>>>() {

    override suspend fun execute() : Flow<List<Account>> {
        return accountsDataSource.fetchAllAccounts();
    }

}