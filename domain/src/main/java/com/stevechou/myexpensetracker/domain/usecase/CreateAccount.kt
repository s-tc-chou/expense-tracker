package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import java.util.*

class CreateAccount(private val accountsDataSource: AccountsDataSource) :
    UseCase<String, Unit>() {

    override suspend fun execute(name: String) {
        accountsDataSource.createAccount(AccountImpl(UUID.randomUUID().toString(), name))
    }
}