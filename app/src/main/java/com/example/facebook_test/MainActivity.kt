package com.example.facebook_test


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.core.view.isVisible
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileInputStream


class MainActivity : AppCompatActivity() {
    var callbackManager: CallbackManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView1.animate().rotation(360f).duration=3000
        btn2.setOnClickListener {
            //cookies
            var shard = getSharedPreferences("MyUserName",Context.MODE_PRIVATE)
            var editor = shard.edit()
            editor.putString("user",email.text.toString())
            editor.apply()
            ///
            var shard1 = getSharedPreferences("pass",Context.MODE_PRIVATE)
            var editor1 = shard1.edit()
            editor1.putString("pass",pass.text.toString())
            editor1.apply()
            // Saved Cookies
            var go =Intent(this,two::class.java)
            startActivity(go)
        }


        callbackManager = CallbackManager.Factory.create()
        login_button.setOnClickListener {
            btn2.isVisible=false
            email.isVisible=false
            pass.isVisible=false

        }
        login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                textView.text = "Log in Successful ${result?.accessToken?.userId}"


            }

            override fun onCancel() {
                textView.text = "Ohh It's Cancled"

            }

            override fun onError(error: FacebookException?) {
                textView.text="${error?.message}"

            }

        })


        var shard2 = getSharedPreferences("MyUserName",Context.MODE_PRIVATE)
        var username = shard2.getString("user","Null")
        email.setText(username)
        ///
        var shard22 = getSharedPreferences("pass",Context.MODE_PRIVATE)
        var username2 = shard22.getString("pass","Null")
        pass.setText(username2)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode,resultCode,data)
    }

    override fun onBackPressed() {
        btn2.isVisible=true
        email.isVisible=true
        pass.isVisible=true
        super.onBackPressed()
    }


}