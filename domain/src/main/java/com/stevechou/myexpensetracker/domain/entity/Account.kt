package com.stevechou.myexpensetracker.domain.entity

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "accounts", indices = [Index(value = ["id", "name"])])
@TypeConverters(DateConverters::class)
data class Account(
    @PrimaryKey @ColumnInfo(name = "id") @NonNull val id: String,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "created_time") @NonNull val createdTime: Date,
    @ColumnInfo(name = "modified_time") @NonNull val modifiedTime: Date,
)
