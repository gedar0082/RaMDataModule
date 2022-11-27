package com.gedar0082.projects.data.api.location

import com.gedar0082.projects.data.internal.net.Service
import com.gedar0082.projects.data.internal.util.mapIdsToPath
import com.gedar0082.projects.data.internal.util.mapToFilterQuery

class LocationRepository {

    suspend fun getLocationById(id: Int): Location =
        Service.locationApi.getLocationById(id)

    suspend fun getMultipleLocations(vararg ids: Int): List<Location> =
        Service.locationApi.getMultipleLocations(ids.mapIdsToPath())

    suspend fun getLocationsWithFilter(filter: LocationFilter): List<Location>? =
        Service.locationApi.getLocationsWithFilter(filter.mapToFilterQuery())?.results

}