package com.scb.easybit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {

    private var imageSlider: ViewPager? = null
    private var imgArray: ArrayList<String> = ArrayList()

    private val pictureCallback = object : Callback<List<Userbid>> {
        override fun onFailure(call: Call<List<Userbid>>, t: Throwable) {
//            context?.showToast("Can not call country list $t")
            Log.d("fuengfa",t.message)
        }

        override fun onResponse(call: Call<List<Userbid>>, response: Response<List<Userbid>>) {
//            context?.showToast("Success")
          var data = response.body()!!
            Log.d("dataApoi", data.toString())
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgArray?.add("https://www.xn--12c1bij4d1a0fza6gi5c.com/wp-content/uploads/2019/07/iphone-xr-2019-concept-1280x720.jpg")
        imgArray?.add("https://1.bp.blogspot.com/-x6ar420f2sA/XFmWj_fX2OI/AAAAAAAADiE/X1wdpbJDYkwDDdc-6EkofeneJtAO4vCfQCLcBGAs/s1600/1469069-20190205110021-ba01ac6.jpg")
        imgArray?.add("https://www.appdisqus.com/wp-content/uploads/2018/10/iphone-xr-select-static-201809_GEO_EMEA-1280x720.jpg")

        imageSlider = findViewById(R.id.viewpager)
        imageSlider?.adapter = PhotoPagerAdapter(supportFragmentManager, imgArray)

        val db = FirebaseFirestore.getInstance()


        ApiManager.mobileService.bid(10).enqueue(pictureCallback)

        Timer("SettingUp", false).schedule(1000) {

        }

        addBidButton.setOnClickListener {

        }

//        val bithigh = db.collection("room2/userbit")
//            .get()
//
//
//        db.collection("bitroom/room2/userbit").addSnapshotListener { snapshot, e ->
//            if(e != null){
//                Log.w("errorlisten", "listen:error", e)
//                return@addSnapshotListener
//            }
//            if (snapshot != null){
//                for (dc in snapshot.documentChanges){
//                    if (dc.type == DocumentChange.Type.ADDED) {
//                        Log.d("listenSuccess", "New city: ${dc.document.data}")
//                        hightBit.text = "${dc.document.data.get("bitcost")}"
//                        username.text = "${dc.document.data.get("username")}"
//                        money.text = "${dc.document.data.get("bitcost")}"
//                    }
//                }
//            }
//        }


//        bit1.setOnClickListener {
//            val data1 = mutableMapOf<String,Any>(
//                "bitcost" to "2000",
//                "username" to "fuengfa",
//                "userid" to "3"
//            )
//            val cities = db.collection("bitroom/room2/userbit")
//                .add(data1)
//                .addOnSuccessListener { documentReference ->
//                    Log.d("fuengfa", "DocumentSnapshot written with ID: ${documentReference.id.get(1)}")
//                }
//                .addOnFailureListener { e ->
//                    Log.w("fuengfa", "Error adding document", e)
//                }
//        }
    }
}
