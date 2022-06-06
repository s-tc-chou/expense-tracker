package com.stevechou.myexpensetracker.di

import android.content.Context
import androidx.room.Room
import com.stevechou.myexpensetracker.data.account.AccountDao
import com.stevechou.myexpensetracker.data.account.AccountsRepository
import com.stevechou.myexpensetracker.data.account.MasterDatabase
import com.stevechou.myexpensetracker.data.expense.LineItemDao
import com.stevechou.myexpensetracker.data.expense.LineItemRepository
import com.stevechou.myexpensetracker.domain.AccountsDataSource
import com.stevechou.myexpensetracker.domain.LineItemDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        MasterDatabase::class.java,
        "myexpensetracker.db"
    ).build()

    @Singleton
    @Provides
    fun provideAccountDao(db: MasterDatabase) = db.accountDao()

    @Singleton
    @Provides
    fun provideExpenseDao(db: MasterDatabase) = db.expenseDao()

    @Provides
    @Singleton
    fun providesAccountsDatasource(accountsDao: AccountDao): AccountsDataSource {
        return AccountsRepository(accountsDao)
    }

    @Provides
    @Singleton
    fun providesLineItemDatasource(lineItemDao: LineItemDao): LineItemDataSource {
        return LineItemRepository(lineItemDao)
    }
}
