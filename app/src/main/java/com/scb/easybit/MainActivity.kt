package com.scb.easybit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity() {

    private var imageSlider: ViewPager? = null
    private var imgArray: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgArray?.add("https://1.bp.blogspot.com/-x6ar420f2sA/XFmWj_fX2OI/AAAAAAAADiE/X1wdpbJDYkwDDdc-6EkofeneJtAO4vCfQCLcBGAs/s1600/1469069-20190205110021-ba01ac6.jpg")
        imgArray?.add("https://www.appdisqus.com/wp-content/uploads/2018/10/iphone-xr-select-static-201809_GEO_EMEA-1280x720.jpg")
        imgArray?.add("https://www.xn--12c1bij4d1a0fza6gi5c.com/wp-content/uploads/2019/07/iphone-xr-2019-concept-1280x720.jpg")

        imageSlider = findViewById(R.id.viewpager)
        imageSlider?.adapter = PhotoPagerAdapter(supportFragmentManager,imgArray)


//        val database = FirebaseDatabase.getInstance()
//        myRef = database.reference
//
//        // Read from the database
//        myRef.addValueEventListener(object : ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val map = dataSnapshot.value as Map<*, *>
//                val value = map["bitroom"].toString()
//
//
//                Toast.makeText(this@MainActivity, "addValueEventListener", Toast.LENGTH_SHORT).show()
//
//                hightBit.text = value
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                hightBit.text = error.message
//            }
//        })


//        val store = findViewById<View>(R.id.bit1) as Button
//
//        store.setOnClickListener {
//                view: View? -> store ()
//        }

    }

//    private fun store () {
//        val highBit = findViewById<View>(R.id.hightBit) as TextView
//        val username = findViewById<View>(R.id.username) as TextView
//        val money = findViewById<View>(R.id.money) as TextView
//
//        var high = highBit.text.toString().trim()
//        val user = username.text.toString().trim()
//        val mone = money.text.toString().trim()
//
//        if (!high.isEmpty() && !user.isEmpty() && !mone.isEmpty()) {
//            try {
//                val items = HashMap<String, Any>()
//                items.put("bit_cost", high)
//                items.put("user_id", user)
//                items.put("user_name", mone)
//                db.collection("bitroom")
//                    .add(items)
//                    .addOnSuccessListener { documentReference ->
//                        Log.d("Hi ", "DocumentSnapshot added with ID: " + documentReference.id)
//                    }
//                    .addOnFailureListener { e ->
//                        Log.w("Hi ", "Error adding document", e)
//                        //Show Dialog with a failure message
//                    }
//            }catch (e:Exception) {
//                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
//            }
//        }else {
//            Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
//        }
//    }


}
