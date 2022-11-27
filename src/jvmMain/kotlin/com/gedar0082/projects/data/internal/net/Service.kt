package com.gedar0082.projects.data.internal.net

import com.gedar0082.projects.data.internal.net.location.LocationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object Service {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val locationApi: LocationApi = retrofit.create(LocationApi::class.java)
}