package com.scb.easybit

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class SellerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)

        showPopup()
    }

    private fun showPopup() {
        val builder = AlertDialog.Builder(this@SellerActivity)

        builder.setTitle("ยืนยันตัวตนสำหรับผู้ขาย")
        builder.setMessage("ผู้ที่จะทำการขายสินค้าจะต้องทำการยืนยันตัวตนในหน้ายืนยันตัวตนผู้ขายก่อน ต้องการยืนยัน?")
        builder.setPositiveButton("ตกลง"){dialog, which ->
            Toast.makeText(applicationContext,"โปรดกรอกข้อมูลให้ครบถ้วน",Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SellerActivity,VerifyActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton("ไว้ก่อน"){dialog,which ->
            dialog.dismiss()
        }
        builder.setNeutralButton("ยกเลิก"){_,_ ->
            val intent = Intent(this@SellerActivity,UserActivity::class.java)
            startActivity(intent)
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
