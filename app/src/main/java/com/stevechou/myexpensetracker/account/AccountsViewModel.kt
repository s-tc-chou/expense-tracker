package com.stevechou.myexpensetracker.account

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.stevechou.myexpensetracker.data.account.AccountsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountsViewModel @Inject constructor(
    private val accountsRepository: AccountsRepository
) : ViewModel() {


    fun test(): String {
        return accountsRepository.test()
    }

}