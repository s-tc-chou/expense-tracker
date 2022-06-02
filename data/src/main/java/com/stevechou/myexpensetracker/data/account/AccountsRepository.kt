package com.stevechou.myexpensetracker.data.account

import android.util.Log
import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.Account
import javax.inject.Inject

// implementation of AccountsDataSource.  Maybe rename with impl suffix?
class AccountsRepository @Inject constructor(private val accountDao: AccountDao) : AccountsDataSource {

    override suspend fun createAccount(account: Account) {
        accountDao.createAccount(account)
    }

    override suspend fun findAccount(account: Account): Account {
        return accountDao.findAccountById(account.id)
    }

    override suspend fun findAccountById(accountId: String): Account {
        return accountDao.findAccountById(accountId)
    }

    override suspend fun deleteAccount(account: Account) {
        accountDao.delete(account)
    }

    override suspend fun deleteAccountById(accountId: String) {
        accountDao.deleteById(accountId)
    }

    override suspend fun fetchAllAccounts(): List<Account> {
        return accountDao.fetchAllAccounts()
    }

    override suspend fun test() {
        Log.d("Steve", "Test ")
    }
}