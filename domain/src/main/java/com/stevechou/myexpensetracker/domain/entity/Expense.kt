package com.stevechou.myexpensetracker.domain.entity

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "expense", indices = [Index(value = ["id", "name"])])
@TypeConverters(DateConverters::class, FrequencyConverter::class)
data class Expense(
    @PrimaryKey @ColumnInfo(name = "id") @NonNull val id: String,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "amount") @NonNull val amount: Int,
    @ColumnInfo(name = "recurring") @NonNull val recurs: Boolean,
    @ColumnInfo(name = "frequency") @NonNull val frequency: Frequency,
    @ColumnInfo(name = "account_id") @NonNull val accountId: String, //x-ref to account
    @ColumnInfo(name = "category_id") @NonNull val categoryId: String, //x-ref to category
    @ColumnInfo(name = "notes") @NonNull val note: String,
    @ColumnInfo(name = "created_time") @NonNull val createdTime: Date,
    @ColumnInfo(name = "modified_time") @NonNull val modifiedTime: Date,
)