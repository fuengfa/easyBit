package com.scb.easybit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MobileListApiService {

    @GET("/api/v2/easybid/bid/{bid_id}")
    fun bid(
        @Path("bid_id") mobile_Id :Int?
    ): Call<List<Userbid>>


}
