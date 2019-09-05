package com.scb.easybit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {

    private lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
