package com.stevechou.myexpensetracker.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevechou.myexpensetracker.domain.entity.AccountImpl
import com.stevechou.myexpensetracker.domain.usecase.CreateAccount
import com.stevechou.myexpensetracker.domain.usecase.DeleteAccount
import com.stevechou.myexpensetracker.domain.usecase.FetchAllAccounts
import com.stevechou.myexpensetracker.domain.usecase.FindAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountsViewModel @Inject constructor(
    private val createAccount: CreateAccount,
    private val findAccount: FindAccount,
    private val deleteAccount: DeleteAccount,
    private val fetchAllAccounts: FetchAllAccounts
) : ViewModel() {

    private val _accounts = MutableLiveData<List<AccountImpl>>()
    val accounts get() = _accounts

    fun createAccount(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createAccount.execute(name)
        }
    }

    fun fetchAccounts() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAllAccounts.execute()
                .distinctUntilChanged()
                .collect {
                    _accounts.postValue(it)
                }
        }
    }
}