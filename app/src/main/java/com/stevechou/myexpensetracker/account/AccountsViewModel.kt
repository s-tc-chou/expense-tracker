package com.stevechou.myexpensetracker.account

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stevechou.myexpensetracker.data.account.AccountsRepository
import com.stevechou.myexpensetracker.domain.entity.Account
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountsViewModel @Inject constructor(
    private val accountsRepository: AccountsRepository
) : ViewModel() {


    fun test(): String {
//        val account = Account(id = IdHelper.generateId(), name = "test")
        val account = Account(id = "test123", name = "testlolol")
        //move into usecase, and do on background thread.
        GlobalScope.launch {
            accountsRepository.insert(account)
        }
        return accountsRepository.test()
    }

    fun getTestAccount() {
        lateinit var result : Account
        GlobalScope.launch {
            result = accountsRepository.findAccountById("test123")
            Log.d("STEVE", result.name)
        }

    }


}