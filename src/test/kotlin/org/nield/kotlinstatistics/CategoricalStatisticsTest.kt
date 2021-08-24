package org.nield.kotlinstatistics

import org.junit.Test
import kotlin.test.assertEquals

class CategoricalStatisticsTest {

    val strings = sequenceOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    @Test
    fun testMode1() {
        assertEquals(setOf(2),
            listOf(2,54,67,3,4,5,2,2).mode().toSet())
    }
    @Test
    fun testMode2() {
        assertEquals(setOf(2,4),
            listOf(2,4,54,4,67,3,4,5,2,2).mode().toSet())
    }
    @Test
    fun testGroupApply() {
        assertEquals(mapOf(5 to 15, 4 to 4, 7 to 7),
            strings.groupApply( {it.length}, { it.asSequence().flatMap { it.split("").asSequence() }.filter { it.isNotEmpty() }.count() })
        )
    }

    @Test
    fun countBy() {

        assertEquals(mapOf(5 to 3, 4 to 1, 7 to 1),
            strings.map { it.length }.countBy())

        assertEquals(mapOf(5 to 3, 4 to 1, 7 to 1),
            strings.countBy { it.length })
    }
}