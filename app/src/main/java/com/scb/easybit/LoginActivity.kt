package com.scb.easybit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scb.easybit.model.UserResponse
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import kotlin.collections.ArrayList
import okhttp3.*
import java.io.IOException
import java.lang.Exception


class LoginActivity : AppCompatActivity() {

    val JSON = MediaType.parse("application/json; charset=utf-8")
    private var mDataArray: ArrayList<ResponseBody> = ArrayList<ResponseBody>()
    var postUrl = "http://192.168.101.157:8088/api/v2/customer/login"
    var postBody = "{\n" +
            "    \"userName\": \"user1\",\n" +
            "    \"password\": \"1234\"\n" +
            "}"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogin.setOnClickListener {
            try {
                postRequest(postUrl, postBody)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

    }


    @Throws(IOException::class)
    fun postRequest(postUrl: String, postBody: String) {

        val client = OkHttpClient()

        val body = RequestBody.create(JSON, postBody)

        Log.d("body: ", body.toString())

        val request = Request.Builder()
            .url(postUrl)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.d("response", e.toString())
            }


            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val res:String = response.body()!!.string()
                mDataArray.clear()
//                mDataArray.addAll(response.body()!!)

                Log.d("response", res)
                val jsonObj:JSONObject = JSONObject(res)
                val resourceOwnerId:String = jsonObj.getString("resourceOwnerId")
                val firstName:String = jsonObj.getString("firstName")
                val lastName:String = jsonObj.getString("lastName")
                val image:String = jsonObj.getString("image")
                val seller:String = jsonObj.getString("seller")
                gotoMainMenuPage(resourceOwnerId,firstName,lastName,image,seller)
            }

        })

        try {
            val client:OkHttpClient = OkHttpClient()
            val body = RequestBody.create(JSON, postBody)

            val request:Request = Request.Builder()
                .url(postUrl).post(body)
                .build()
            val responses:okhttp3.Response = client.newCall(request).execute()

            val jsonData:String = responses.body().toString()
            val jsonObj:JSONObject = JSONObject(jsonData)


        } catch (e:Exception) {

        }
    }

    private fun gotoMainMenuPage(
        resourceOwnerId: String,
        firstName: String,
        lastName: String,
        image: String,
        seller: String
    ) {
        val intent = Intent(this@LoginActivity, MainMenuActivity::class.java)
        intent.putExtra("resId",resourceOwnerId)
        intent.putExtra("fName",firstName)
        intent.putExtra("lName",lastName)
        intent.putExtra("img",image)
        intent.putExtra("sell",seller)
        startActivity(intent)
    }
}
