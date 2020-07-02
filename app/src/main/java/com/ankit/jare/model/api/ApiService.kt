package com.ankit.jare.model.api

import com.ankit.jare.model.ListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/alt-fuel-stations/v1.json?api_key=DEMO_KEY&fuel_type=E85,ELEC&state=CA&limit=50")
    fun getList(): Call<ListResponse>
}