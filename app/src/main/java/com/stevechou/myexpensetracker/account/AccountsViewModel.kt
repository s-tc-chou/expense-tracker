package com.stevechou.myexpensetracker.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevechou.myexpensetracker.Utils.IdHelper
import com.stevechou.myexpensetracker.data.account.AccountsRepository
import com.stevechou.myexpensetracker.domain.entity.Account
import com.stevechou.myexpensetracker.domain.usecase.CreateAccount
import com.stevechou.myexpensetracker.domain.usecase.DeleteAccount
import com.stevechou.myexpensetracker.domain.usecase.FindAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountsViewModel @Inject constructor(
    createAccount: CreateAccount,
    findAccount: FindAccount,
    deleteAccount: DeleteAccount
) : ViewModel() {

    /*fun addAccount(): String {
        val account = Account(id = IdHelper.generateId(), name = "test")
        viewModelScope.launch {
            createAccount
        }
        return accountsRepository.test()
    }*/


    /*fun getTestAccount() {
        lateinit var result : Account
        GlobalScope.launch {
            result = accountsRepository.findAccountById("test123")
            Log.d("STEVE", result.name)
        }
    }*/


}