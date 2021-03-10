package com.stevechou.myexpensetracker.domain.entity

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "cashflow", indices = [Index(value = ["id", "name"])])
@TypeConverters(DateConverters::class, FrequencyConverter::class)
data class CashFlow(
    @PrimaryKey @ColumnInfo(name = "id") @NonNull val id: String,
    @ColumnInfo(name = "name") @NonNull val name: String,
    @ColumnInfo(name = "amount") @NonNull val amount: Int,
    @ColumnInfo(name = "recurring") @NonNull val recurs: Boolean,
    @ColumnInfo(name = "frequency") @NonNull val frequency: Frequency,
    @ColumnInfo(name = "account_id") @NonNull val accountId: String, //x-ref to account
    @ColumnInfo(name = "created_time") @NonNull val createdTime: Date,
    @ColumnInfo(name = "modified_time") @NonNull val modifiedTime: Date,
)

enum class Frequency {
    ONE_TIME, MONTHLY, ANNUALLY, SEMI_ANNUALLY, BI_MONTHLY
}
