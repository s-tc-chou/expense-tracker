package com.stevechou.myexpensetracker.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class AccountImpl(
    val id: String,
    val name: String,
    val createdTime: Date = Date(System.currentTimeMillis()),
    val modifiedTime: Date = Date(System.currentTimeMillis())
) : Parcelable
