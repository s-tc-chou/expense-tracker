package com.stevechou.myexpensetracker.di

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.ExpenseDataSource
import com.stevechou.myexpensetracker.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideCreateAccount(accountsDataSource: AccountsDataSource): CreateAccount {
        return CreateAccount(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteAccount(accountsDataSource: AccountsDataSource): DeleteAccount {
        return DeleteAccount(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideFindAccount(accountsDataSource: AccountsDataSource): FindAccount {
        return FindAccount(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideFetchAllAccounts(accountsDataSource: AccountsDataSource): FetchAllAccounts {
        return FetchAllAccounts(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideCreateExpense(lineItemDataSource: ExpenseDataSource): CreateExpense {
        return CreateExpense(lineItemDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteExpense(lineItemDataSource: ExpenseDataSource): DeleteExpense {
        return DeleteExpense(lineItemDataSource)
    }
}