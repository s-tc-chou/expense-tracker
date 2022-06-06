package com.stevechou.myexpensetracker.domain.entity

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(
    tableName = "expense",
    indices = [Index(value = ["id", "name", "expense_date", "account_id", "category_id"])]
)
@TypeConverters(DateConverters::class, FrequencyConverter::class)
data class Expense(
    @PrimaryKey @ColumnInfo(name = "id") @NonNull val id: String,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "amount") @NonNull val amount: Float,
    @ColumnInfo(name = "frequency") @NonNull val frequency: Frequency,
    @ColumnInfo(name = "account_id") @NonNull val accountId: String, //x-ref to account
    @ColumnInfo(name = "category_id") @NonNull val categoryId: String? = null, //x-ref to category.  by default uncategorized.
    @ColumnInfo(name = "notes") @NonNull val note: String? = null,
    @ColumnInfo(name = "expense_date") @NonNull val expenseDate: Date,
    @ColumnInfo(name = "created_time") @NonNull val createdTime: Date = Date(System.currentTimeMillis()),
    @ColumnInfo(name = "modified_time") @NonNull val modifiedTime: Date = Date(System.currentTimeMillis())
)