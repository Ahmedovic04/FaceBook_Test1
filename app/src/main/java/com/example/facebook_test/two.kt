package com.example.facebook_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_two.*

class two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
//        var name = R.id.editTextTextPersonName2
//
//        username.text="The User Name is $name"
        logout.setOnClickListener {
            var go2 = Intent(this,MainActivity::class.java)
            startActivity(go2)
        }
    }
}