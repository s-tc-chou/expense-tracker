package com.stevechou.myexpensetracker.account

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevechou.myexpensetracker.Utils.IdHelper
import com.stevechou.myexpensetracker.data.account.AccountsRepository
import com.stevechou.myexpensetracker.domain.entity.Account
import com.stevechou.myexpensetracker.domain.usecase.CreateAccount
import com.stevechou.myexpensetracker.domain.usecase.DeleteAccount
import com.stevechou.myexpensetracker.domain.usecase.FetchAllAccounts
import com.stevechou.myexpensetracker.domain.usecase.FindAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class AccountsViewModel @Inject constructor(
    private val createAccount: CreateAccount,
    private val findAccount: FindAccount,
    private val deleteAccount: DeleteAccount,
    private val fetchAllAccounts: FetchAllAccounts
) : ViewModel() {

    private val _accounts = MutableLiveData<List<Account>>()
    val accounts get() = _accounts

    fun createAccount(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createAccount.execute(name)
        }
    }

    fun fetchAccounts() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAllAccounts.execute()
                .also { _accounts.postValue(it) }

        }
    }

    //fun findAccountById(id : String) : Account {
    //TODO
    //}

//    fun deleteAccount() {
    // TODO
//    }

    /*fun getTestAccount() {
        lateinit var result : Account
        GlobalScope.launch {
            result = accountsRepository.findAccountById("test123")
            Log.d("STEVE", result.name)
        }
    }*/
}