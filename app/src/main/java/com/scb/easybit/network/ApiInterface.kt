package com.scb.easybit.network;


import com.scb.easybit.model.UserResponse
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*






interface ApiInterface {

    //http://codemobiles.com/adhoc/youtubes/index_new.php
    @Headers( "Content-Type: application/json;charset=UTF-8")
    @POST("api/v2/customer/login")
    fun getUser(@Field("userName") userName:JSONObject , @Field("password") password:JSONObject):Call<UserResponse>
//        fun postJson(@Body requestBody: RequestBody): Call<List<UserResponse>>
//    fun getUser(@Body user: UserBody): Call<List<UserResponse>>
//    fun login(@Path("login") postfix: String, @Body params: RequestBody): Call<List<UserResponse>>
//    fun getUser(@Body body: JSONObject): Call<List<UserResponse>>
//    fun postJson(@Body body: HashMap<String, Any>): Call<List<UserResponse>>
//    fun getUser(@Body jsonObject: JSONObject):Call<List<UserResponse>>


    companion object Factory {
        private val BASE_URL = "http://192.168.101.178:8088/"
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


