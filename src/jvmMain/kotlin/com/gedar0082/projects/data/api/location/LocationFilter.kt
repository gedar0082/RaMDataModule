package com.gedar0082.projects.data.api.location

import com.gedar0082.projects.data.api.common.Filter


data class LocationFilter(
    val name: String? = null,
    val type: String? = null,
    val dimension: String? = null,
    override val page: Int = 1
) : Filter