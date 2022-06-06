package com.stevechou.myexpensetracker.domain

import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import kotlinx.coroutines.flow.Flow


// interface that defines accounts operations
interface AccountsDataSource {
    // todo: add option to rename account.
    suspend fun createAccount(AccountImpl: AccountImpl)
    suspend fun findAccount(AccountImpl: AccountImpl): AccountImpl
    suspend fun findAccountById(accountId: String): AccountImpl
    suspend fun deleteAccount(AccountImpl: AccountImpl)
    suspend fun deleteAccountById(accountId: String)
    suspend fun fetchAllAccounts(): Flow<List<AccountImpl>>
}