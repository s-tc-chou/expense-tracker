package com.stevechou.myexpensetracker.domain.entity

import androidx.room.TypeConverter
import java.util.*

class DateConverters {
    @TypeConverter
    fun dateToString(date: Date): String = date.time.toString()

    @TypeConverter
    fun stringToDate(millis: String): Date = Date(millis.toLong())
}