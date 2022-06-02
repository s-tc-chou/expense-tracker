package com.stevechou.myexpensetracker.domain

import com.stevechou.myexpensetracker.domain.entity.Account


// interface that defines accounts operations
interface AccountsDataSource {
    suspend fun createAccount(account: Account)
    suspend fun findAccount(account: Account) : Account
    suspend fun findAccountById(accountId: String) : Account
    suspend fun deleteAccount(account: Account)
    suspend fun deleteAccountById(accountId: String)
    suspend fun fetchAllAccounts() : List<Account>

    // test method
    suspend fun test()
}