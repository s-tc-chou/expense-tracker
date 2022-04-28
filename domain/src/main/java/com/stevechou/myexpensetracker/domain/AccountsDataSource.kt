package com.stevechou.myexpensetracker.domain

import android.accounts.Account

// interface that defines accounts operations
interface AccountsDataSource {
    suspend fun addNewAccount(account: Account)

    suspend fun test()

    //todo: add more methods
}