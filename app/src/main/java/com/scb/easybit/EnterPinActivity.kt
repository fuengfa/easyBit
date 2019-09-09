package com.scb.easybit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanks.passcodeview.PasscodeView
import kotlinx.android.synthetic.main.activity_enter_pin.*
import kotlinx.android.synthetic.main.activity_enter_pin.view.*
import javax.security.auth.callback.Callback

class EnterPinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_pin)

        passCodeView.setPasscodeLength(4)
            .setLocalPasscode("1234").listener = object : PasscodeView.PasscodeViewListener {
            override fun onSuccess(number: String?) {
                val intent = Intent(this@EnterPinActivity,MainMenuActivity::class.java)
                startActivity(intent)
            }

            override fun onFail() {

                Toast.makeText(this@EnterPinActivity,"Enter a correct password!",Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onBackPressed() {
        this.finishAffinity()
    }
}


