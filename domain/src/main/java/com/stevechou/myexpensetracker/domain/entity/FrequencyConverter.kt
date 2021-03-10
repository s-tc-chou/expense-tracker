package com.stevechou.myexpensetracker.domain.entity

import androidx.room.TypeConverter

class FrequencyConverter {

    @TypeConverter
    fun frequencyToString(frequency: Frequency): String = frequency.toString()

    @TypeConverter
    fun stringToFrequency(input: String): Frequency = enumValueOf(input)
}