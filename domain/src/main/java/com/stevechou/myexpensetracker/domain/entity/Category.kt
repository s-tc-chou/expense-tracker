package com.stevechou.myexpensetracker.domain.entity

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "Category", indices = [Index(value = ["id", "name"])])
@TypeConverters(DateConverters::class, FrequencyConverter::class)
data class Category(
    @PrimaryKey @ColumnInfo(name = "id") @NonNull val id: String,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "type") @NonNull val amount: String,
    @ColumnInfo(name = "account_id") @NonNull val accountId: String, //x-ref to account
    @ColumnInfo(name = "created_time") @NonNull val createdTime: Date,
    @ColumnInfo(name = "modified_time") @NonNull val modifiedTime: Date,
)