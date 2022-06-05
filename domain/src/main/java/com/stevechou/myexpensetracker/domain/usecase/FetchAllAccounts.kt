package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import kotlinx.coroutines.flow.Flow

class FetchAllAccounts(private val accountsDataSource: AccountsDataSource) :
    UseCase<Unit, Flow<List<AccountImpl>>>() {

    // make this into accountImpl. Usecase should provide the correct data type and/or conversion.
    override suspend fun execute(): Flow<List<AccountImpl>> {
        return accountsDataSource.fetchAllAccounts();
    }
}