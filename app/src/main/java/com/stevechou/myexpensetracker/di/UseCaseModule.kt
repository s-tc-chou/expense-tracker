package com.stevechou.myexpensetracker.di

import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.usecase.CreateAccount
import com.stevechou.myexpensetracker.domain.usecase.DeleteAccount
import com.stevechou.myexpensetracker.domain.usecase.FetchAllAccounts
import com.stevechou.myexpensetracker.domain.usecase.FindAccount
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
    fun provideCreateAccount(accountsDataSource: AccountsDataSource) : CreateAccount {
        return CreateAccount(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteAccount(accountsDataSource: AccountsDataSource) : DeleteAccount {
        return DeleteAccount(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideFindAccount(accountsDataSource: AccountsDataSource) : FindAccount {
        return FindAccount(accountsDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideFetchAllAccounts(accountsDataSource: AccountsDataSource) : FetchAllAccounts {
        return FetchAllAccounts(accountsDataSource)
    }
}