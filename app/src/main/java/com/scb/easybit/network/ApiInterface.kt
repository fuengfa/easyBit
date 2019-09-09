package com.scb.easybit.network;


import com.scb.easybit.model.AllBids
import com.scb.easybit.model.Data
import com.scb.easybit.model.UserResponse
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*






interface ApiInterface {

    @GET("api/v2/easybid/bids")
    fun getAllBid(): Call<List<Data>>

    companion object Factory {
        private val BASE_URL = "http://192.168.101.157:8088/"
        //private val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private var retrofit: Retrofit? = null



        fun getClient(): ApiInterface {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(ApiInterface::class.java)
        }
    }
    }


