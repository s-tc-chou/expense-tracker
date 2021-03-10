package com.stevechou.myexpensetracker.domain.entity

import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class DateConvertersTest : TestCase() {

    private val converter = DateConverters()
    private val dateString = "1615336231"
    private val date = Date(1615336231)

    @Test
    fun longToDate() {
        // given
        val test = converter.dateToString(date)

        // then
        assertThat(test, `is`("1615336231"))
    }

    @Test
    fun dateToLong() {
        // given
        val test = converter.stringToDate(dateString)

        // when
        val expectedDate = Date(1615336231)

        // then
        assertEquals(test, expectedDate)
    }
}





