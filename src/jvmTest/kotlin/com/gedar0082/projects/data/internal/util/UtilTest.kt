package com.gedar0082.projects.data.internal.util

import com.gedar0082.projects.data.api.location.LocationFilter
import com.gedar0082.projects.data.internal.net.location.LocationFilterNames
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class UtilTest {

    //    region mapIdsToPath

    @Test
    fun `test several ids array`() {
        val testArray = arrayOf(12, 31).toIntArray()
        val resString = "12,31"
        assertEquals("", resString, testArray.mapIdsToPath())
    }

    @Test
    fun `test one id array`() {
        val testArray = arrayOf(12).toIntArray()
        val resString = "12"
        assertEquals("", resString, testArray.mapIdsToPath())
    }

    @Test
    fun `test zero ids array`() {
        val testArray = emptyArray<Int>().toIntArray()
        val resString = ""
        assertEquals("", resString, testArray.mapIdsToPath())
    }

//    endregion
//    region mapToFilterQuery

    @Test
    fun `test with full filled`() {
        val filter = LocationFilter(
            name = "x", type = "y", dimension = "z"
        )
        val map = mapOf(
            LocationFilterNames.NAME to "x",
            LocationFilterNames.TYPE to "y",
            LocationFilterNames.DIMENSION to "z"
        )
        assertEquals("", map, filter.mapToFilterQuery())
    }

    @Test
    fun `test with one null field`() {
        val filter = LocationFilter(
            name = "x", type = null, dimension = "z"
        )
        val map = mapOf(
            LocationFilterNames.NAME to "x", LocationFilterNames.DIMENSION to "z"
        )
        assertEquals("", map, filter.mapToFilterQuery())
    }

    @Test
    fun `test with one empty field`() {
        val filter = LocationFilter(
            name = "x", type = "y", dimension = ""
        )
        val map = mapOf(
            LocationFilterNames.NAME to "x",
            LocationFilterNames.TYPE to "y",
        )
        assertEquals("", map, filter.mapToFilterQuery())
    }

}