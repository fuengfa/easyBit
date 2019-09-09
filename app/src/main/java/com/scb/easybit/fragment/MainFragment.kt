package com.scb.easybit.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.scb.easybit.R
import com.scb.easybit.adapter.SliderFirstPageAdapter
import com.scb.easybit.model.Data
import kotlinx.android.synthetic.main.fragment_main.view.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.io.DataInput
import java.io.IOException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */


class MainFragment : Fragment() {

    var postUrl = "http://192.168.101.157:8088/api/v2/easybid/bids"

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    private lateinit var mAdapter: CustomAdapter
    private lateinit var imageSlider: ViewPager
    private var imgArray: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_main, container, false)
        imgArray?.add("https://www.xn--12c1bij4d1a0fza6gi5c.com/wp-content/uploads/2019/07/iphone-xr-2019-concept-1280x720.jpg")
        imgArray?.add("https://1.bp.blogspot.com/-x6ar420f2sA/XFmWj_fX2OI/AAAAAAAADiE/X1wdpbJDYkwDDdc-6EkofeneJtAO4vCfQCLcBGAs/s1600/1469069-20190205110021-ba01ac6.jpg")
        imgArray?.add("https://www.appdisqus.com/wp-content/uploads/2018/10/iphone-xr-select-static-201809_GEO_EMEA-1280x720.jpg")

        imageSlider = _view.findViewById(R.id.viewpagerFirstPage)
        imageSlider?.adapter = SliderFirstPageAdapter(this@MainFragment.fragmentManager!!, imgArray)

        _view.recyclerView.let {
            //            it.adapter = mAdapter

            //IMPORTANT ! ! ! ! ! !
//            it.layoutManager = LinearLayoutManager(activity)

            it.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL,false)
//            it.layoutManager = GridLayoutManager(activity,2)
            it.adapter = CustomAdapter(context!!)
        }
        getAllBid()
        return _view


    }
    private fun getAllBid() {
    val client = OkHttpClient()
    val request = Request.Builder()
            .url(postUrl)
        .get()
        .build()

    client.newCall(request).enqueue(object : Callback{
        override fun onFailure(call: okhttp3.Call, e: IOException) {
            Log.d("response", e.toString())
        }

        override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
            val res:String = response.body()!!.string()
            Log.d("response", res)


            val jsonObj: JSONObject = JSONObject(res)
            val data:JSONArray = jsonObj.getJSONArray("data")
            if (data.length() != 0 || data.length()!= null){
                for (i in 0 until data.length()){
                    val json:JSONObject = data.getJSONObject(i)
                    val id: String? = json.getString("id").toString()
                    val topic:String? = json.getString("topic").toString()
                    val price:String? = json.getString("price").toString()
                    val seller:String? = json.getString("seller").toString()
                    val bidUser:String? = json.getString("bidUser").toString()
                    val detail:String? = json.getString("detail").toString()
                    val priceGrape:String = json.getString("priceGrape").toString()
                    val picture: JSONArray = json.getJSONArray("pictures")
                    val image:String = picture.getString(0)
                    val tags:JSONArray = json.getJSONArray("tags")
                    val tagName:String = tags.getString(0)
                    val startTime:String = json.getString("startTime")
                    val endTime:String = json.getString("endTime")

//                Log.d("tag",id + topic + price + seller + bidUser + detail + priceGrape + image + tagName + startTime + endTime)
                }
            }



        }

    })
    }

    inner class CustomAdapter(val context: Context) : RecyclerView.Adapter<CustomHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

            return CustomHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.bidnow_layout,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int = 6

        override fun onBindViewHolder(holder: CustomHolder, position: Int) {
            holder.imageView.let {
                Glide
                    .with(context!!)
                    .load(R.drawable.p1)
                    .into(it)
            }
            holder.productName.text = "iPhone x"
        }
    }

    inner class CustomHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img)
        val productName: TextView = view.findViewById(R.id.productName)
        val hourText: TextView = view.findViewById(R.id.hour)
        val minuteText: TextView = view.findViewById(R.id.minute)
        val secondText: TextView = view.findViewById(R.id.second)

    }

}
