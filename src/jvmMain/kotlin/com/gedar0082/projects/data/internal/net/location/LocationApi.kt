package com.gedar0082.projects.data.internal.net.location

import com.gedar0082.projects.data.api.location.Location
import com.gedar0082.projects.data.internal.util.Compound
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

internal interface LocationApi {

    companion object {
        private const val BASE_LOCATION_PATH = "location"
    }

    @GET("$BASE_LOCATION_PATH/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Location

    @GET("$BASE_LOCATION_PATH/{ids}")
    suspend fun getMultipleLocations(@Path("ids") ids: String): List<Location>

    @GET(BASE_LOCATION_PATH)
    suspend fun getLocationsWithFilter(@QueryMap filters: Map<String, String>): Compound<Location>?

}