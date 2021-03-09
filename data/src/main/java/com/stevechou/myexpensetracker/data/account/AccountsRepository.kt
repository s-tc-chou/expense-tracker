package com.stevechou.myexpensetracker.data.account

import com.stevechou.myexpensetracker.domain.entity.Account
import javax.inject.Inject

class AccountsRepository @Inject constructor(
    private val accountDao: AccountDao
) {

    //also need methods to return stuff, like account.  Should match at least some pieces of the Dao
    fun insert(account: Account) {
        accountDao.insertAll(account)
    }

    fun deleteAccount(account: Account) {
        accountDao.delete(account)
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