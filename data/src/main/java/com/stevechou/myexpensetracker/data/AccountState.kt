package com.stevechou.myexpensetracker.data

import com.stevechou.myexpensetracker.domain.entity.Account

sealed class AccountState {
    object Loading : AccountState()
    object Idle : AccountState()
    object Finish : AccountState()
    data class Error(val error: String?) : AccountState()
    data class UserSelect(val users: List<Account>) : AccountState()
    data class AddNewAccount(val account: Account) : AccountState()
}