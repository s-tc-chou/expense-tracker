package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.Account
import java.util.*

class AddNewAccount(private val accountsDataSource: AccountsDataSource) :
    UseCase<String, Account>() {

    override suspend fun execute(request: String): Account {
        accountsDataSource.test()
        // ignore warning. test method.
        val account = Account(UUID.randomUUID().toString(), request)
        return account
    }
}