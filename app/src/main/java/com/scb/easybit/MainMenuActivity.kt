package com.scb.easybit

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.scb.easybit.fragment.HistoryFragment
import com.scb.easybit.fragment.MainFragment
import com.scb.easybit.fragment.NotificationFragment
import com.scb.easybit.fragment.UserFragment
import kotlinx.android.synthetic.main.fragment_user.*
import kotlin.system.measureNanoTime

class MainMenuActivity : AppCompatActivity() {



    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText("หน้าหลัก")
                val mainFragment = MainFragment.newInstance()
                openFragment(mainFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                textMessage.setText("ประวัติ")
                val historyFragment = HistoryFragment.newInstance()
                openFragment(historyFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                textMessage.setText("ฉัน")
                val userFragment = UserFragment.newInstance()
                openFragment(userFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText("การแจ้งเตือน")
                val notificationFragment = NotificationFragment.newInstance()
                openFragment(notificationFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val mainFragment = MainFragment.newInstance()
        openFragment(mainFragment)

        resId = intent.getStringExtra("resId")
        fName = intent.getStringExtra("fName")
        lName = intent.getStringExtra("lName")
        img = intent.getStringExtra("img")
        sell = intent.getStringExtra("sell")


    }



    companion object{
        lateinit var resId:String
        lateinit var fName:String
        lateinit var lName:String
        lateinit var img:String
        lateinit var sell:String
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
