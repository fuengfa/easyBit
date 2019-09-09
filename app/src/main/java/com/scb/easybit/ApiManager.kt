package com.scb.easybit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
//    https://scb-test-mobile.herokuapp.com/api/mobiles/
    val mobileService by lazy { createService<MobileListApiService>("http://192.168.101.178:8088/") }

    private inline fun <reified T> createService(baseUrl: String): T =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .run { create(T::class.java) }

}
