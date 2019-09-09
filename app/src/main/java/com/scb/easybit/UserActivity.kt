package com.scb.easybit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        auctionMenu.setOnClickListener {
            clickAuctionMenu()
        }
    }

    private fun clickAuctionMenu() {
        val intent = Intent(this@UserActivity,SellerActivity::class.java)
        startActivity(intent)
    }
}
