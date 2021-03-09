package com.stevechou.myexpensetracker.di

import android.content.Context
import androidx.room.Room
import com.stevechou.myexpensetracker.data.account.AccountDatabase
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
    fun provideAccountDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AccountDatabase::class.java,
        "myexpensetracker.db"
    ).build()

    @Singleton
    @Provides
    fun provideAccountDao(db: AccountDatabase) = db.accountDao()

}