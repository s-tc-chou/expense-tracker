package com.stevechou.myexpensetracker.domain.usecase

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.Account
import java.util.*

class CreateAccount(private val accountsDataSource: AccountsDataSource) :
    UseCase<String, Unit>() {

    override suspend fun execute(request: String){
        accountsDataSource.createAccount(Account(UUID.randomUUID().toString(), request))
    }
}