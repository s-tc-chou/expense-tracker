package com.stevechou.myexpensetracker

import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class IdHelperTest : TestCase() {

    @Test
    fun testGenerateId() {
        // given
        val test = IdHelper.generateId()

        // assert
        assertThat(test.length, `is`(13))
        assertThat(test.filter { it in 'A'..'Z' || it in '0'..'9' }.length, `is`(test.length))
    }
}