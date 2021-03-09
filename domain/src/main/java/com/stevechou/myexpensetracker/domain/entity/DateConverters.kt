package com.stevechou.myexpensetracker.domain.entity

import androidx.room.TypeConverter
import java.util.*

class DateConverters {
    @TypeConverter
    public fun dateToString(date: Date): String {
        return date.toString()
    }

    @TypeConverter
    public fun stringToDate(millis: String) : Date {
        return Date(millis.toLong())
    }
}