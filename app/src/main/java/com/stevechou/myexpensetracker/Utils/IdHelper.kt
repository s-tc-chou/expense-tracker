package com.stevechou.myexpensetracker.Utils


object IdHelper {

    @JvmStatic
    fun generateId(): String {
        val allowedChars = ('A'..'Z') + ('0'..'9')
        return (1..13)
            .map { allowedChars.random() }
            .joinToString("")
    }

}