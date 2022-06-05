package com.stevechou.myexpensetracker.data.account

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import com.stevechou.myexpensetracker.domain.entity.toAccount
import com.stevechou.myexpensetracker.domain.entity.toAccountImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

// implementation of AccountsDataSource
class AccountsRepository @Inject constructor(private val accountDao: AccountDao) :
    AccountsDataSource {

    override suspend fun createAccount(account: AccountImpl) {
        accountDao.createAccount(account.toAccount())
    }

    override suspend fun findAccount(account: AccountImpl): AccountImpl {
        return accountDao.findAccountById(account.id).toAccountImpl()
    }

    override suspend fun findAccountById(accountId: String): AccountImpl {
        return accountDao.findAccountById(accountId).toAccountImpl()
    }

    override suspend fun deleteAccount(account: AccountImpl) {
        accountDao.delete(account.toAccount())
    }

    override suspend fun deleteAccountById(accountId: String) {
        accountDao.deleteById(accountId)
    }

    override suspend fun fetchAllAccounts(): Flow<List<AccountImpl>> {
        return flowOf(accountDao.fetchAllAccounts().map { it.toAccountImpl() })
    }
}