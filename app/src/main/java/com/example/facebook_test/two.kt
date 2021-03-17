package com.example.facebook_test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_two.*
import kotlin.concurrent.timer

class two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        imageView2.animate().rotation(360f).duration=3000
//        var name = R.id.editTextTextPersonName2
//
//        username.text="The User Name is $name"

        var shard2 = getSharedPreferences("MyUserName",Context.MODE_PRIVATE)
        var username1 = shard2.getString("user","Null")
        username.setText(username1)
        logout.setOnClickListener {
            var go2 = Intent(this,MainActivity::class.java)
            startActivity(go2)
        }
        val timerr = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                textView2.setText(username1+ ", seconds remaining: " + millisUntilFinished / 1000+" and you will logout")


            }

            override fun onFinish() {
                //startActivity(go2)
                var logout = Intent(this@two,MainActivity::class.java)
                startActivity(logout)

            }
        }

            timerr.start()




    }
}