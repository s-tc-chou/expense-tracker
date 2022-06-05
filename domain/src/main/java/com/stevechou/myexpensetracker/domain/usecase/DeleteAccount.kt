package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.AccountImpl

class DeleteAccount(private val accountsDataSource: AccountsDataSource) :
    UseCase<AccountImpl, Unit>() {

    override suspend fun execute(account: AccountImpl) {
        accountsDataSource.deleteAccount(account)
        // todo: also delete summary related items.
    }
}