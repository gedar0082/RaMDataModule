package com.gedar0082.projects.data.internal.util

import com.gedar0082.projects.data.api.location.LocationFilter
import com.gedar0082.projects.data.internal.net.location.LocationFilterNames

internal fun IntArray.mapIdsToPath(): String = this.fold("") {
    acc: String, i: Int -> "$acc,$i"
}.replaceFirst(",", "")

internal fun LocationFilter.mapToFilterQuery(): Map<String, String> {
    val queryMap = mutableMapOf<String, String>()
    if (!name.isNullOrEmpty())
        queryMap += LocationFilterNames.NAME to name
    if (!type.isNullOrEmpty())
        queryMap += LocationFilterNames.TYPE to type
    if (!dimension.isNullOrEmpty())
        queryMap += LocationFilterNames.DIMENSION to dimension
    queryMap += LocationFilterNames.PAGE to page.toString()
    if (queryMap.isEmpty()) throw IllegalArgumentException("Argument with all null fields.")
    return queryMap
}