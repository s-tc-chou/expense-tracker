package com.stevechou.myexpensetracker.data.account

import com.stevechou.myexpensetracker.domain.entity.Account
import javax.inject.Inject

// implementation of AccountsDataSource.  Maybe rename with impl suffix?
class AccountsRepository @Inject constructor(
    private val accountDao: AccountDao
) {

    fun createAccount(account: Account) {
        accountDao.createAccount(account)
    }

    fun deleteAccount(account: Account) {
        accountDao.delete(account)
    }

    fun deleteAccountById(accountId: String) {
        accountDao.deleteById(accountId)
    }

    fun findAccountById(id : String) : Account {
        return accountDao.findAccountById(id)
    }

    fun findAccount(account: Account) : Account {
        return accountDao.findAccountById(account.id)
    }

    fun test() : String {
        return "hello account repo test"
    }
}