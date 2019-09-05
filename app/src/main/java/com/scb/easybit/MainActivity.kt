package com.scb.easybit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    lateinit var db: DocumentReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance().document("bitroom/4aqtAqVa9RujsDZYgZYI")

        val store = findViewById<View>(R.id.bit1) as Button

        store.setOnClickListener {
                view: View? -> store ()
        }

    }

    private fun store () {
        val highBit = findViewById<View>(R.id.hightBit) as TextView
        val username = findViewById<View>(R.id.username) as TextView
        val money = findViewById<View>(R.id.money) as TextView

        var high = highBit.text.toString().trim()
        val user = username.text.toString().trim()
        val mone = money.text.toString().trim()

        if (!high.isEmpty() && !user.isEmpty() && !mone.isEmpty()) {
            try {
                val items = HashMap<String, Any>()
                items.put("bit_cost", high)
                items.put("user_id", user)
                items.put("user_name", mone)
                db.collection("bitroom")
                    .add(items)
                    .addOnSuccessListener { documentReference ->
                        Log.d("Hi ", "DocumentSnapshot added with ID: " + documentReference.id)
                    }
                    .addOnFailureListener { e ->
                        Log.w("Hi ", "Error adding document", e)
                        //Show Dialog with a failure message
                    }
            }catch (e:Exception) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }
        }else {
            Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
        }
    }


}
